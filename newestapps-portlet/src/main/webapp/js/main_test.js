/*
 * #%L
 * govapps_newestapps
 * $Id:$
 * %%
 * Copyright (C) 2013 - 2014 Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT
 * %%
 * Copyright (c) 2,013, Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer.
 * 
 * 2) Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution.
 * 
 * 3) All advertising materials mentioning features or use of this software must 
 *    display the following acknowledgement: 
 *    This product includes software developed by Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT.
 * 
 * 4) Neither the name of the organization nor the names of its contributors may 
 *    be used to endorse or promote products derived from this software without 
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY COPYRIGHT HOLDER ''AS IS'' AND ANY EXPRESS OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL 
 * Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */
_.templateSettings = {
		interpolate : /\{\{(.+?)\}\}/g
};

	//set to true for debug
	var accessed_by_mobile_device = true;


	$('#newest_app_list').ready(function() {
		
		if(accessedBySmartphone()) {
			console.log("newest app portlet: accessed by mobile device with small screen");
			//debug purposes for tablet 
			accessed_by_mobile_device = true;
		}
		
		var wasSuccessful=new Boolean(false);
		var response='';
		
		loadingBarStart();
		
		$.ajax( {
			
			type: 'GET',
			url: "/VmAmG-portlet/api/jsonws/application/get-new-applications/companyId/10154/year/2012/month/7/day/1/count/24",
			success: function(data) {
				
				response = jQuery.parseJSON(data);
				var uniqueApps = [];
				if(response.length>0) {
					
					var relatedAppsNotToScan = [];
					
					var lastLengthUniqueApps = 0;
					var sliderItem='<div class="active item"><div class="row-fluid"><div class="span1"></div><div class="span10">';
					var numberOfSliderItems = 3;
					var span_app = "span4";
					var swipe_nav_list = '<ul class="slides" id="newest_app_swiper">';
					
					if(accessed_by_mobile_device) {
						numberOfSliderItems = 1;
						span_app = "small_app_details";
						sliderItem = '<div class="active item"><div class="row-fluid"><div class="span12">';
					}
					
					for(var i=0;i<response.length;i++) {
						
				
						
						if(uniqueApps.length%numberOfSliderItems==0 && i>=1) {
							if(uniqueApps.length>lastLengthUniqueApps) {
								if(accessed_by_mobile_device) {
									sliderItem+='</div></div></div>';
									$('#newest_apps').append(sliderItem);
									sliderItem='<div class="item"><div class="row-fluid"><div class="span12">';
									lastLengthUniqueApps = uniqueApps.length;
								} else {
									sliderItem+='</div><div class="span1"></div></div></div>';
									$('#newest_apps').append(sliderItem);
									sliderItem='<div class="item"><div class="row-fluid"><div class="span1"></div><div class="span10">';
									lastLengthUniqueApps = uniqueApps.length;
								}
								
							}
						} 
						
						var currentResponse = response[i][0];
						var OSs ='';
						var app_icon_url='';
						
						if(relatedAppsNotToScan.indexOf(''+currentResponse.applicationId+'') == -1 && uniqueApps.length<=6) {
							
							//console.log("current app with id "+currentResponse.applicationId+" is unique; scan related apps");
							var currentRelatedApps=currentResponse.relatedApplicationId.split(';');
							//console.log("App with id "+currentResponse.applicationId+", related apps: "+currentRelatedApps);
							var relatedAppsToScanForOs=[];
							uniqueApps.push(currentResponse.applicationId);
							
							var relatedAppIds = currentResponse.applicationId;
							
							if(currentResponse.relatedApplicationId.length>0) {
								relatedAppIds+=';'+currentResponse.relatedApplicationId;					
							}
						
							/*
							 * if current app is related to other, add their IDs so that they do not get
							 * inspected again
							 * Furthermore: keep relations of apps
							 */
							
							
							if(currentRelatedApps.length>0) {
								for(var j=0;j<currentRelatedApps.length;j++) {
									//add related app to list of apps that need no inspection anymore
									relatedAppsNotToScan.push(currentRelatedApps[j]);
									//add related app to list to scan for respective OS
									relatedAppsToScanForOs.push(currentRelatedApps[j]);
								}

							}
							
							//get app-icon
							
							app_icon_url = response[i][1];
							if(app_icon_url!=undefined) {
								app_icon_url = app_icon_url.replace("http://localhost", "");
							}
							
							

							
							//get OSs
							var tag = '';
							var webapp='', android='', ios='', windows='';
							

							
							switch(currentResponse.targetOS) {
								case "Android":
									android = "-Aktiv";
									break;
								case "Windows":
									windows = "-Aktiv";
									break;
								case "iOS":
									ios = "-Aktiv";
									break;
								case "Webapp":
									webapp = "-Aktiv";
									break;
								default:
									osTag+='OS';
									break;
							}
																					
							for (var j=i; j<response.length;j++) {
								if(_.include(relatedAppsToScanForOs, ''+response[j][0].applicationId+'')) {
									
									var osTag='';
									console.log("app OS: \""+response[j][0].targetOS+"\", "+response[j][0].name);
									switch(response[j][0].targetOS) {
										case "Android":
											android = "-Aktiv";
											break;
										case "Windows":
											windows = "-Aktiv";
											break;
										case "iOS":
											ios = "-Aktiv";
											break;
										case "Webapp":
											webapp = "-Aktiv";
											break;
										default:
											osTag+='OS';
										
										break;
									}
									tag+=osTag;
								}
							}
							
							var template_variables = {webapp:webapp, android:android, apple:ios, windows:windows};
							tag+= _.template( $("#os_template").html(), template_variables);
							
							var icon_class = '', span_icon="span4", span_details="span8";
							
							if(accessed_by_mobile_device) {
								
								
								icon_class = 'width="100%"';	
								span_icon='small_span_icon';
								span_details='small_span_details';
							}
							
							var variables = {span_icon:span_icon, span_details:span_details, icon_class : icon_class, span_app: span_app, app_name: currentResponse.name,
									app_id: currentResponse.applicationId,
									app_icon: app_icon_url, app_oss: tag, newappids:relatedAppIds};
							
							var template = _.template( $("#newest_app_template").html(), variables);
							swipe_nav_list += "<li>"+template+"</li>"; 
							sliderItem+=template;
					
							if(i==(response.length-1)) {
								swipe_nav_list+="</ul>";
								console.log("last item...");
								if(accessedBySmartphone()) {
									console.log("accessed by mobile device - customize respective css");
									sliderItem+='</div></div></div>';
									$('#newest_apps').append(sliderItem);
									
								} else {
									console.log("not accessed by mobile device - customize respective css");
									sliderItem+='</div><div class="span1"></div></div></div>';
									$('#newest_apps').html(sliderItem);
									
								}
								
								$('#newest_app_swipe_nav').html(swipe_nav_list);

							}
							
						} else {
							if(i==(response.length-1)) {
								
								swipe_nav_list+="</ul>";
								console.log("last item...");
								if(accessedBySmartphone()) {
									console.log("accessed by mobile device - customize respective css");
									sliderItem+='</div></div></div>';
									$('#newest_apps').append(sliderItem);
									
								} else {
									console.log("not accessed by mobile device - customize respective css");
									sliderItem+='</div><div class="span1"></div></div></div>';
									$('#newest_apps').append(sliderItem);
								}

							}
							
							$('#newest_app_swipe_nav').html(swipe_nav_list);
						}
						

					};

					
				} else {
					console.log("no newest apps");
					
				}

				
				if(uniqueApps.length==0) {
					$('#newest_apps_navigation_container').empty().append("<h2> Leider keine neuesten Apps verf�gbar </h2>");
				}
				
				if(uniqueApps.length<=3 && !accessed_by_mobile_device) {
					$('#newest_apps_navigation_container').empty();
				}

				$('.new_app_link').click(function(event) {
					
					console.log("clicked newest apps link!");
					$('#form'+event.target.id).submit();
					
				});
				
				console.log("finished newest apps");
				
				console.log("Initializing swiper");
				
				$('#newest_app_swipe_nav').ready(function() {
					$('#newest_app_swipe_nav').flexslider({
						animation: "slide",
						useCSS:false,
			            itemWidth: 250,
			            itemMargin: 0,
			            minItems: 1,
			            maxItems: 3,
			            move:1,
			            slideshow:false,
			            controlNav:false		            
					});
				});
				
				$('#teaser_flexslider').flexslider({
					slideshow:false
				});
				
				loadingBarStop();

			}, 
			error: function (jqXHR, textStatus, errorThrown) {
				console.log("newest-apps-portlet, error textStatus: "+textStatus);
				console.log("newest-apps-portlet, error errorThrown: "+errorThrown);
				location.href="web/umfrage/fehler";
			}
			
			
		});
		


	});
	
