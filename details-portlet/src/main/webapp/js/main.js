/*
 * #%L
 * govapps_details
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
var overlayVisFilter = false;
var filledRelatedIds = false;
var wsurl = location.host+"/VmAmG-portlet/api/jsonws/";
$(document).ready(function() {
	getStaticCatRegEnt();
	getAppDetails(appIdToLoad);
});

_.templateSettings = {
		interpolate : /\{\{(.+?)\}\}/g
};

/*
 * enable social media two-click solution
 */

$('#socialshareprivacy').socialSharePrivacy(); 


function getStaticCatRegEnt() {
			/*
			 * load categories, entitlements and regions
			 */
			
			console.log(isWin8mobDevice());
			
			var isToucheable = false;
			
			if(accessedByMobileTouchDevice()) {
				isToucheable = true;
			}
			
			//no matter of localstorage, initialize fee and platform checkbox / multiselect
			
			if(isToucheable) {
				//fee
				$('#accordion3').empty().removeClass("accordion").append('<select size="1" id="filter_fees" class="multiselect_touch_filter" multiple="multiple">'+
						'<option value="--null--" selected>Kosten</option>'+
						'<option id="no_fee" value="fee_0" class="filter-checkbox">Kostenlos</option>'+
						'<option id="with_fee" value="fee_1" class="filter-checkbox">Kostenpflichtig</option>'+
						'</select>');
				
				//plattform
				
				$('#accordion4').empty().removeClass("accordion").append('<select size="1" id="filter_platforms" class="multiselect_touch_filter" multiple="multiple">'+
						'<option value="--null--" selected>Plattform</option>'+
//						'<optgroup label="Betriebssystem">'+
						'<option class="filter-checkbox" id="os_webapp" value="platform_webapp">WebApp</option>'+
						'<option class="filter-checkbox" id="os_android" value="platform_android">Android</option>'+
						'<option class="filter-checkbox" id="os_apple" value="platform_ios">Apple iOS</option>'+
						'<option class="filter-checkbox" id="os_blackberry" value="platform_blackberry">Blackberry</option>'+
						'<option class="filter-checkbox" id="os_ubuntu" value="platform_ubuntu">Ubuntu iOS</option>'+
						'<option class="filter-checkbox" id="os_win" value="platform_windows">Windows</option>'+
//						'</optgroup>'+
//						'<optgroup label="Ger�t">'+
//						'<option class="filter-checkbox" id="device_Smartphone" value="device_Smartphone">Smartphone</option>'+
//						'<option class="filter-checkbox" id="device_Tablet" value="device_Tablet">Tablet</option>'+
//						'</optgroup>'+
						'</select>');
				
			}
			
			if(!noCookiesAllowed()) {
				if(localStorage["localStoragePrepared"]=="true") {
				/* getCategories */
					var obj = JSON.parse(localStorage["allCategories"]);
					if(isToucheable) {
						$('#accordion2').empty().removeClass("accordion").append('<select size="1" id="categories" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Themen</option>');
					}
					
				    for (var i = 0; i < obj.length; i++) {
				    	if(isToucheable) {
				    		$('#categories').append("<option class='filter-checkbox' value='category_"+ obj[i].categoryId +"' id='category"+obj[i].categoryId+"'>" + obj[i].categoryName + "</option>");
				    	} else {
				    		
				    		var categoryIcon = '';
				    		

							switch(obj[i].categoryId) {							
							case 1:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Bildung.png" width="19">';
								break;
							case 2:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Familie.png" width="19">';
								break;
							case 3:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Gesundheit.png" width="19">';
								break;
							case 4:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Nachrichten.png" width="19">';
								break;
							case 5:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Lexika.png" width="19">';
								break;
							case 6:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Verkehr.png" width="19">';
								break;
							case 7:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Politik.png" width="19">';
								break;
							case 8:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Organisation.png" width="19">';
								break;
							case 9:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Tourismus.png" width="19">';
								break;
							case 10:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-2-Soziale-Netzwerke.png" width="19">';
								break;
							case 11:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Sport.png" width="19">';
								break;
							case 12:
								categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Wetter.png" width="19">';
								break;								
							}
				    		
				    		
				    		$('#categories').append("<li><label class='checkbox inline'><input type='checkbox' class='filter-checkbox' value='category_"+ obj[i].categoryId +"' id='category"+obj[i].categoryId+"'>"
				    				+categoryIcon+" "
				    				+ obj[i].categoryName + "</label></li>");
				    	}
				    }
				    
				    if(isToucheable) {
				    	$('#accordion2').append('</select>');
					}
				    
				    /* getRegions */
				    obj = JSON.parse(localStorage["allRegions"]);
					if(isToucheable) {
						$('#accordion6').empty().removeClass("accordion").append('<select size="1" id="regions" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Regionen</option>');
					}
					for (var i = 0; i < obj.length; i++) { 
						if(isToucheable) {
							$('#regions').append("<option class='filter-checkbox' value='region_"+ obj[i].regionId +"' id='region"+obj[i].regionId+"'>" + obj[i].name + "</option>");
						} else {
							var regionIcon = '';
							
							switch(obj[i].regionId) {
							
								case 1:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Deutschland.png" width="19"  alt="Mobile Apps aus Deutschland">';
									break;
								case 2:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Baden-Wuerttemberg.png" width="19"  alt="Mobile Apps aus Baden-Wuerttemberg">';
									break;
								case 3:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Bayern.png" width="19"  alt="Mobile Apps aus Bayern">';
									break;
								case 4:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Berlin.png" width="19"  alt="Mobile Apps aus Berlin">';
									break;
								case 5:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Brandenburg.png" width="19"  alt="Mobile Apps aus Brandenburg">';
									break;
								case 6:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Bremen.png" width="19"  alt="Mobile Apps aus Bremen">';
									break;
								case 7:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hamburg.png" width="19"  alt="Mobile Apps aus Hamburg">';
									break;
								case 8:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hessen.png" width="19"  alt="Mobile Apps aus Hessen">';
									break;
								case 9:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Mecklenburg-Vorpommern.png" width="19"  alt="Mobile Apps aus Mecklenburg-Vorpommern"> ';
									break;
								case 10:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Niedersachsen.png" width="19"  alt="Mobile Apps aus Niedersachsen"> ';
									break;
								case 11:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Nordrhein-Westfalen.png" width="19"  alt="Mobile Apps aus Nordrhein-Westfalen"> ';
									break;
								case 12:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Rheinland-Pfalz.png" width="19"  alt="Mobile Apps aus Rheinland-Pfalz"> ';
									break;
								case 13:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Saarland.png" width="19"  alt="Mobile Apps aus dem Saarland"> ';
									break;
								case 14:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen.png" width="19"  alt="Mobile Apps aus Sachsen"> ';
									break;
								case 15:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Anhalt.png" width="19"  alt="Mobile Apps aus Sachsen-Anhalt"> ';
									break;
								case 16:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Schleswig-Holstein.png" width="19"  alt="Mobile Apps aus Schleswig-Holstein"> ';
									break;
								case 17:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Thueringen.png" width="19"  alt="Mobile Apps aus Thueringen"> ';
									break;
							}
							
							$('#regions').append("<li><label class='checkbox inline'><input type='checkbox' class='filter-checkbox' value='region_"+ obj[i].regionId +"' id='region"+obj[i].regionId+"'>" +
									regionIcon+" "+	obj[i].name + "</label></li>");
						}
					}
					
					if(isToucheable) {
						$('#accordion6').append('</select>');
					}
					
					/* get Entitlements */
					
					if(isToucheable) {
						$('#accordion5').empty().removeClass("accordion").append('<select size="1" id="filter_entitlements" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Berechtigungen</option>');
					}
					obj = JSON.parse(localStorage["allEntitlements"]);
					for(var i=0; i<obj.length; i++) {
						var entitlementTag='';
						if(!isToucheable) {
							
							switch (obj[i].entitlementId) {
			            	   case 1:
									//network communication
									//entitlementTag+=obj[i].explanation+'">';
									entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Netzwerkkommunikation.png"> ';
									break;
								case 2:
									//access media (cam, mic, vid)
									//entitlementTag+=obj[i].explanation+'">';
									entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Medienzugriff.png">';
									break;
								case 3:
									//access /vepa-theme/images/vepa-icons/Plattform/Icon-Web-App-Aktiv.png
									//entitlementTag+=obj[i].explanation+'">'
									entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Ortungsdienste.png"> ';
									break;
								case 4:
									//system settings
									//entitlementTag+=obj[i].explanation+'">';
									entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Systemeinstellung.png">';
									break;
								case 5:
									//requires money
									//entitlementTag+=obj[i].explanation+'">';
									entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-kostenpflichtige-Dienste.png"> ';
									break;
								case 6:
									//personal data
									//entitlementTag+=obj[i].explanation+'">';
									entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-persoenliche-Daten.png">';
									break;
								default:	
									//entitlementTag+=obj[i].explanation+'">';
									entitlementTag+=' <i class="icon-remove">';
									break;
		         	   		}
		                   $('#filter_entitlements').append("<li><label class='checkbox inline'><input type='checkbox' checked='true' class='filter-checkbox' value='entitlement_"+ obj[i].entitlementId +"' id='entitlement"+obj[i].entitlementId+"'>" + entitlementTag + ' ' +obj[i].entitlementName + "</label></li>");
						} else {
						   $('#filter_entitlements').append("<option class='filter-checkbox' selected='true' value='entitlement_"+ obj[i].entitlementId +"' id='entitlement"+obj[i].entitlementId+"'>" + entitlementTag + ' ' +obj[i].entitlementName + "</option>");
						}
					}
					
					if(isToucheable) {
						$('#accordion5').append('</select>');
						$("#filter_entitlements option[value='--null--'],#regions option[value='--null--'],#categories option[value='--null--'],#filter_fees option[value='--null--'], #filter_platforms option[value='--null--']").attr("disabled", true);
					}
									
				} else {
					doAjaxForFilterBuild();
				}
			} else {
				doAjaxForFilterBuild();
			}
			
			function doAjaxForFilterBuild() {
				console.log("H");
			}
			
			$(".filter_for_fee input:checkbox").change(function() {
				if($(this).attr("checked")!="true") {
					$(".filter_for_fee input:checkbox").attr("checked", false);
				    $(this).attr("checked", true);
				} 
			});
			
			
		}


function getAppDetails(related) {
	

	//show details tab
	
	
	loadingBarStartFilter();

	
	/*
	 * reset tab settings:
	 */
	
	$('#app_detail_tabs').empty();
	$('#app_detail_tabs').append('<li><a href="#tab0" data-toggle="tab" class="disabled_ent osTab"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Web-App-Aktiv.png" title="Als Web-App"> Webapp</a></li>'
			+'<li><a href="#tab1" data-toggle="tab" class="disabled_ent osTab"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Android-Aktiv.png" title="Als Android App"> Android</a></li>'
			+'<li><a href="#tab2" data-toggle="tab" class="disabled_ent osTab"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-iOS-Aktiv.png" title="Als iOS App"> iOS</a></li>'
			+'<li><a href="#tab3" data-toggle="tab" class="disabled_ent osTab"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Blackberry-Aktiv.png" title="Als Blackberry App"> Blackberry</a></li>'
			+'<li><a href="#tab4" data-toggle="tab" class="disabled_ent osTab"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon_Ubuntu_Aktiv.png" title="Als Ubuntu App"> Ubuntu</a></li>'
			+'<li><a href="#tab5" data-toggle="tab" class="disabled_ent osTab"><img src="/vepa-theme/images/vepa-icons/Plattform/Icon-Windows-Aktiv.png" title="Als Windows mobile App"> Windows</a></li>');
	
	scrollTo(0, 0);

	$('.back_to_results').show();
	//TODO - customize for mobile view
	var appIds = new Array();
	var relatedApps = related.split(';');
	//alert("related apps: \""+related+"\"");
	var foundSimilarApps = true;
	
	var screensAvailable = false, simAppsAvailable = false;
	
	for(var y=0; y<relatedApps.length; y++) {

		appIds.push(relatedApps[y]);
		
	}
	
	for (var i=0; i<appIds.length; i++) {
		
		//alert("round "+i);
		/*
		 * each additional app details will be added within a tab;
		 * on mobile platform only respective details for current OS will be loaded
		 */
		$.ajax({		
			type: 'GET',
			url: "/VmAmG-portlet/api/jsonws/application/get-full-application-details-eiscrlla/applicationId/"+appIds[i],
			async: false,
			success: function(data) {
				
				/*
				 * 1. for tab content pane, fill template and put it into content pane
				 * 
				 * [0] -> list of entitlements
				 * [1] -> icon-URL
				 * [2] -> Screen shots
				 * [3] -> categories
				 * [4] -> regions
				 * [5] -> languages
				 * [6] -> application links (store, developer)
				 * [7] -> app_details like description, costs, last mod etc. 
				 * [8] -> email address of the person that added this app to GOVAPPs
				 */
				
				var app_details = jQuery.parseJSON(data);
				
		
				
				
				
				//1. add tab button and content pane
				/*
				 * tabs are pre assigned:
				 * 0: Web-App
				 * 1: Android
				 * 2: iOS
				 * 3: Windows
				 */
				
				var app_icon_url='', app_screenshots='', app_categories='',
				app_regions='', app_langs='', app_sim_apps='',
				app_fee='', app_last_mod, app_description='', app_name='', app_size='', app_developer='',
				app_store_link='',app_screenshots_nav='', app_developer_link='',
				 multiple_screens='s', multiple_apps='s', app_publisher_link='', app_sim_apps_mobile='',
				app_screenshots_swipe='', app_creator_email_address = '', uses_open_data='';
				
				
				
				//get app costs and store name and targetdevice
				
				/*
				 * if app was directly accessed, look for related applicationIDs
				 */
				
				
				if(!filledRelatedIds) {
					var relatedAppIds = app_details[7].relatedApplicationId.split(";");
					for(var e=0; e<relatedAppIds.length; e++) {
						if(relatedAppIds[e].length>0) {
							console.log("related app id for ("+appIds[i]+"): "+relatedAppIds[e]);
							appIds.push(relatedAppIds[e]);
						}
					}
					filledRelatedIds = true;
				}

				

				app_fee = app_details[7].fee;
				
				if(app_fee == "0") {
					app_fee = "kostenlos";
				} else {
					app_fee = "kostenpflichtig";
				}
				switch(app_details[7].targetOS) {
				
					case "Android":
						app_target_os_storename = "Google Play Store";
						app_store_link ="http://play.google.com";
						break;
					case "Windows":
						app_target_os_storename = "Windows Phone Marketplace";
						app_store_link ="http://www.windowsphone.com/store";
						break;
					case "iOS":
						app_target_os_storename = "Apple App Store";
						app_store_link ="http://itunes.apple.com/de/genre/ios/id36?mt=8";
						break;
					case "Ubuntu":
						app_target_os_storename = "Ubuntu Apps Directory";
						app_store_link ="https://apps.ubuntu.com/cat/";
						break;	
					case "BlackBerry":
						app_target_os_storename = "Blackberry Apps World";
						app_store_link ="http://de.blackberry.com/apps/app-world.html";
						break;	
					default:
						app_target_os_storename = "Visit Web App...";
						break;
				}
				
				
				
				for(var q=0; q<app_details[6].length;q++) {
					switch(app_details[6][q].type) {
					case 2:
						//store link
						app_store_link = app_details[6][q].url;
						break;
					case 4:
						//site of publisher
						app_publisher_link = app_details[6][q].url;
						break;
					case 5:
						//site of developers
						app_developer_link = app_details[6][q].url;
						break;
					}
					
				}
				
				if(app_store_link.length==0) {
					$('.app_store_link_button').addClass("disabled");
				}
				
				//integrate click counter
				
				$('.app_store_link_button').unbind("click").click(function(event) {
					var appId = $(this).attr("value");
					
					Liferay.Service(
					  '/VmAmG-portlet#application/click-application-link',
					  {
					    applicationId: appId
					  },
					  function(obj) {
					    console.log("logged click on appstore");
					  }
					);
				});
				
				//get last modified date
				
				app_last_mod = new Date(app_details[7].lastModifiedDate).toLocaleDateString();
				
				//get app description
				
				/*
				 * process description: if < 300 chars -> OK, else: take 300 chars and make rest collapseable (TODO)
				 */
				
				app_description ='<div id="app_description_container">'+app_details[7].description+'</div>';
				
				//get app name
				
				app_name = app_details[7].name;
				
				
				//get app size
				
				app_size = (""+app_details[7].size/1024+"").replace('.', ',').substring(0,5);
				
				
				//get developer
				
				app_creator_email_address = app_details[8];
				
				//
				var app_publisherText = '';
				
				if(app_details[7].legalDetails!=undefined && app_details[7].legalDetails.length>0) {
					app_publisherText = app_details[7].legalDetails;
				} else {
					app_publisherText = 'Es liegen keine Informationen zum Herausgeber vor';
				}
				
				
				if(app_creator_email_address!=undefined && app_creator_email_address.length>0) {
					app_creator_email_address=app_creator_email_address.replace("@", "[at]"); 
					app_developer = app_publisherText+'<br><br><a value="[mail]'+app_creator_email_address+'" class="btn btn-primary safe_mail_button">Feedback senden</a>';
				} else {
					app_developer = app_publisherText+'<br><br><a class="btn btn-primary disabled safe_mail_button" title="Feedback senden">Feedback senden</a>';
				}
				
				
				//assign icon url
				app_icon_url = app_details[1].substring(0, app_details[1].length).replace("http://localhost", "");

				//set icon and name
				
				if(accessedBySmartphone()) {
					$('#app_details_heading').html('<img src="'+app_icon_url+'" width="25%" align="middle" alt="'+app_name+'">&nbsp;&nbsp;<h1>'+app_name+'</h1>');
				} else {
					$('#app_details_heading').html('<img src="'+app_icon_url+'" width="10%" align="middle" alt="'+app_name+'">&nbsp;&nbsp;<h1>'+app_name+'</h1>');
				}
				
				//assign screenshot urls
				var count_screenshots = app_details[2].length;
				if(count_screenshots>0) {
					screensAvailable = true;
				}

				for(var l=0; l<app_details[2].length; l++) {
					
					var screenshot_url = app_details[2][l].replace("http://localhost", "");
					
					if(l==0) {
						app_screenshots_swipe += '<li>'+'<img src="'+screenshot_url+'" alt="Screenshot '+app_name+'"></li>';
					} else {
						app_screenshots_swipe +='<li>'+'<img src="'+screenshot_url+'" alt="Screenshot '+app_name+'"></li>';
					}
				}

	
				
				if(app_screenshots_swipe.length==0) {
					app_screenshots_swipe="<h5>Zu dieser App sind keine Screenshots vorhanden</h5>";
				}
				
				if(app_screenshots_swipe.length==1) {
					multiple_screens="";
				}
				//app categories
				
				for(var m=0; m<app_details[3].length; m++) {
												
					switch(app_details[3][m].categoryId) {
					
					case 1:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Bildung.png" alt="Bildung"> ';
						break;
					case 2:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Familie.png" alt="Familie"> ';
						break;
					case 3:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Gesundheit.png" alt="Gesundheit"> ';
						break;
					case 4:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Nachrichten.png" alt="Nachrichten"> ';
						break;
					case 5:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Lexika.png" alt="Lexika"> ';
						break;
					case 6:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Verkehr.png" alt="Verkehr"> ';
						break;
					case 7:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Politik.png" alt="Politik"> ';
						break;
					case 8:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Organisation.png" alt="Organisation"> ';
						break;
					case 9:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Tourismus.png" alt="Tourismus"> ';
						break;
					case 10:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-2-Soziale-Netzwerke.png" alt="Soziale Netzwerke"> ';
						break;
					case 11:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Sport.png" alt="Sport"> ';
						break;
					case 12:
						app_categories+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Wetter.png" alt="Wetter"> ';
						break;							
					}
					
					if(m==0) {
						app_categories+=app_details[3][m].categoryName;
					} else {
						app_categories+=' '+app_details[3][m].categoryName;
					}
						
				}
				
				//app regions
				
				for(var n=0; n<app_details[4].length; n++) {
					
					if(n!=0) {
						app_regions+=', ';
					}
					
					switch(app_details[4][n].regionId) {
					
					case 1:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Deutschland-Aktiv.png" alt="mobile Apps der Bundesrepublik Deutschland">';
						break;
					case 2:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Baden-Wuerttemberg-Aktiv.png" alt="Mobile Apps aus Baden-Wuerttemberg">';
						break;
					case 3:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Bayern-Aktiv.png"  alt="Mobile Apps aus Bayern">';
						break;
					case 4:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Berlin-Aktiv.png"  alt="Mobile Apps aus Berlin">';
						break;
					case 5:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Brandenburg-Aktiv.png"  alt="Mobile Apps aus Brandenburg">';
						break;
					case 6:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Bremen-Aktiv.png"  alt="Mobile Apps aus Bremen">';
						break;
					case 7:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hamburg-Aktiv.png"  alt="Mobile Apps aus Hamburg">';
						break;
					case 8:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hessen-Aktiv.png"  alt="Mobile Apps aus Hessen>';
						break;
					case 9:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Mecklenburg-Vorpommern-Aktiv.png"  alt="Mobile Apps aus Mecklenburg-Vorpommern">';
						break;
					case 10:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Niedersachsen-Aktiv.png"  alt="Mobile Apps aus Niedersachsen">';
						break;
					case 11:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Nordrhein-Westfalen-Aktiv.png"  alt="Mobile Apps ausNordrhein-Westfalen">';
						break;
					case 12:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Rheinland-Pfalz-Aktiv.png"  alt="Mobile Apps aus Rheinland-Pfalz">';
						break;
					case 13:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Saarland-Aktiv.png"  alt="Mobile Apps aus dem Saarland">';
						break;
					case 14:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Aktiv.png"  alt="Mobile Apps aus Sachsen" >';
						break;
					case 15:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Anhalt-Aktiv.png"  alt="Mobile Apps aus Sachsen-Anhalt">';
						break;
					case 16:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Schleswig-Holstein-Aktiv.png"  alt="Mobile Apps aus Schleswig-Holstein">';
						break;
					case 17:
						app_regions+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Thueringen-Aktiv.png"  alt="Mobile Apps aus Thueringen">';
						break;
						
					}
					if(n==0) {
						app_regions+='<a class="region_link" href="#" id="region_'+app_details[4][n].regionId+'" title="Weitere Apps aus '+app_details[4][n].name+'"> '+app_details[4][n].name+'</a>';
					} else {
						app_regions+='<a class="region_link" href="#" id="region_'+app_details[4][n].regionId+'" title="Weitere Apps aus '+app_details[4][n].name+'"> '+app_details[4][n].name+'</a>';
					}
					
				}
				
				//app languages
				
				for(var o=0; o<app_details[5].length; o++) {
					app_langs+=app_details[5][o].languageName+' ';
				}
				
				//get similar apps
				var uniqueApps = [];
				//alert("get similar apps for: \""+appIds[i]+"\"; i="+i);
				$.ajax( {
					
					type: 'GET',
					//change to url for similar apps
					url: "/VmAmG-portlet/api/jsonws/application/get-similar-applications/companyId/10154/applicationId/"+appIds[i]+"/byCategory/false/byRegion/true",
					async:false,
					success: function(data) {
						
						sim_apps_response = jQuery.parseJSON(data);
						
						//alert('There are '+sim_apps_response.length+' similar apps');
						
						if(sim_apps_response.length>0) {
							
							var relatedAppsNotToScan = [];
							
							var lastLengthUniqueApps = 0;
							
							var numberOfSliderItems = 4;
							var span_size = "span12";

							

							for(var p=0;p<sim_apps_response.length;p++) {
								
								var OSs ='';
								var app_icon_url='';
								
								
								if(relatedAppsNotToScan.indexOf(''+sim_apps_response[p][0].applicationId+'') == -1) {
									
									
									
									//alert('App  with ID#: '+sim_apps_response[p].applicationId+' is root app!');
									var currentRelatedApps=sim_apps_response[p][0].relatedApplicationId.split(';').sort();
									var related_appIds = ''+sim_apps_response[p][0].applicationId+'';
									if(sim_apps_response[p][0].relatedApplicationId.length>0) {
										related_appIds+=';'+''+sim_apps_response[p][0].relatedApplicationId+'';
									}

									//alert('Related apps from ID#: '+sim_apps_response[p].applicationId+':'+currentRelatedApps);
									var relatedAppsToScanForOs=[];
									uniqueApps.push(sim_apps_response[p][0].applicationId);

									/*
									 * if current app is related to other, add their IDs so that they do not get
									 * inspected again
									 * Furthermore: keep relations of apps
									 */
									
									
									if(currentRelatedApps.length>0) {
										for(var q=0;q<currentRelatedApps.length;q++) {
											//add related app to list of apps that need no inspection anymore
											relatedAppsNotToScan.push(currentRelatedApps[q]);
											//add related app to list to scan for respective OS
											relatedAppsToScanForOs.push(currentRelatedApps[q]);
										}
										
									}
									
									//get app-icon
									
									app_icon_url = sim_apps_response[p][1];
									app_icon_url = app_icon_url.replace("http://localhost", "");
									
									//alert('successfully got app_icon');
									
									//get OSs
									var webapp='', android='', ios='',blackberry='',ubuntu='', windows='';
									var tooltip_webapp='', tooltip_and='', tooltip_ios='',tooltip_blackberry='',tooltip_ubuntu='', tooltip_win='';
									
									
									switch(sim_apps_response[p][0].targetOS) {
										case "Android":
											android = "-Aktiv";
									
											break;
										case "Windows":
											windows = "-Aktiv";
								
											break;
										case "iOS":
											ios = "-Aktiv";
									
											break;
										case "BlackBerry":
											blackberry = "-Aktiv";
								
											break;
										case "Ubuntu":
											ubuntu = "-Aktiv";
								
											break;
										case "Webapp":
											webapp = "-Aktiv";
							
											break;
											default:
											osTag='OS';
											break;
									}
									
								
									//alert('Related apps from ID#: '+sim_apps_response[p].applicationId+' : '+relatedAppsToScanForOs+', length: '+relatedAppsToScanForOs.length);
									
									var alreadyScannedApps =[];
									
									var osWhichExistAsApp='';
									
									for (var r=0; r<sim_apps_response.length;r++) {
										
										if(_.include(relatedAppsToScanForOs, ''+sim_apps_response[r][0].applicationId+'') && (_.include(alreadyScannedApps, ''+sim_apps_response[r][0].applicationId+'')==false)) {
										//	alert('App  with ID#: '+sim_apps_response[r].applicationId+' has to be scanned!');
											alreadyScannedApps.push(''+sim_apps_response[r][0].applicationId+'');
											
											var osTag='';
											
											switch(sim_apps_response[r][0].targetOS) {
											case "Android":
												android = "-Aktiv";
		
												break;
											case "Windows":
												windows = "-Aktiv";
									
												break;
											case "iOS":
												ios = "-Aktiv";
									
												break;
											case "BlackBerry":
												blackberry = "-Aktiv";
									
												break;
											case "Ubuntu":
												ubuntu = "-Aktiv";
									
												break;
											case "Webapp":
												webapp = "-Aktiv";
											
												break;
												default:
											osTag='OS';
													break;
											}
										} else {
									//		alert(sim_apps_response[r].applicationId+' in alreadyScanned: '+_.include(alreadyScannedApps, ''+sim_apps_response[r].applicationId+''));
									//		alert(sim_apps_response[r].applicationId+' in appsToScanForOS: '+_.include(relatedAppsToScanForOs, ''+sim_apps_response[r].applicationId+''));
										}
									}
									
									//alert('successfully got OSes');
									
									//build template and append to list
									
									span_icon="span4", span_details="span8";
									
									if(accessedBySmartphone()) {
//										span_size = 'small_app_details';
										//icon_class = 'width="100%"';	
										span_icon='small_span_icon';
										span_details='small_span_details';
									}
																				
									var template_variables = {webapp:webapp,
											android:android,
											apple:ios,
											ubuntu:ubuntu,
											blackberry:blackberry,
											windows:windows,
											tooltip_win:tooltip_win,
											tooltip_and:tooltip_and,
											tooltip_ios:tooltip_ios,
											tooltip_blackberry:tooltip_blackberry,
											tooltip_ubuntu:tooltip_ubuntu,
											tooltip_webapp:tooltip_webapp,
											app_id: "detail_"+appIds[i]};
									OSs = _.template( $("#os_template").html(), template_variables);
									
									var variables = {span_icon:span_icon, span_details:span_details, span_size:span_size, app_name:sim_apps_response[p][0].name,
											app_id: sim_apps_response[p][0].applicationId,
											app_icon: app_icon_url, app_target_oss: OSs, related_ids:related_appIds};
									
									var template = _.template( $("#similar_app_template").html(), variables);
									app_sim_apps_mobile += '<li>'+template+'</li>';
									app_sim_apps+=template;
									relatedAppsNotToScan.push(''+sim_apps_response[p][0].applicationId+'');
								}
							};
			
						} else {
							foundSimilarApps = false;
						}
						

					}, 
					error: function(jqXHR, textStatus, errorThrown) {
						console.log("details-portlet, error textStatus: "+textStatus);
						console.log("details-portlet, error errorThrown: "+errorThrown);
					//	location.href="/fehler";
					}
				});
				
				if(!foundSimilarApps) {
					app_sim_apps_mobile = "<h2>Zur Zeit gibt es keine weiteren Apps aus der Region</h2>"; 
				}

				if(app_description.length>=300) {
					$('#description_accordion').unbind("click").click(function(event){
						$('#app_description_container').css("height", "auto");
					}) ;
				}
				
				var count_similar_apps = uniqueApps.length;
				if(count_similar_apps>0) {
					simAppsAvailable = true;
					if(count_similar_apps==1) {
						multiple_apps = '';
					}
				}
				
				//check for open data
				
				uses_open_data = '';
				if(app_details[7].useOpenData="1") {
					//Look for license
					var licenseName = app_details[7].license;
					console.log("look for equivalent to: "+licenseName);
					switch (app_details[7].license) {
					case "bsd-license":
						licenseName = "BSD Lizenz";
						break;
					case "apache":
						licenseName = "Apache Lizenz";
						break;
					case "app_commercial":
						licenseName = "Andere kommerzielle Lizenz";
						break;
					case "app_freeware":
						licenseName = "Andere kostenfreie Lizenz";
						break;
					case "app_opensource":
						licenseName = "Andere Open Source Lizenz";
						break;
					case "gpl-3.0":
						licenseName = "GNU General Public License version 3.0 (GPLv3)";
						break;
					case "mozilla":
						licenseName = "Mozilla Public License 1.0 (MPL)";
						break;
					case "other-open":
						licenseName = "Andere freie Lizenz";
						break;
					case "other-closed":
						licenseName = "Andere eingeschr&auml;nkte Lizenz";
						break;
					default:
						licenseName ="Nicht definierte Lizenz";
						break;
					}
					// uses_open_data = '<li><img class="opendata_image_details" alt="Mobile Open Data Apps" src="/Vepla-Details-Portlet-portlet/images/opendata.png"/> Nutzt offene Daten<br/><span class="od_license"> '+licenseName+' </span></li>';
				}
				
				
				var template_variables = {app_name: app_name,
						count_similar_apps: count_similar_apps,
						count_screenshots: count_screenshots,
						app_screenshots_swipe : app_screenshots_swipe,
						app_screenshots_nav : app_screenshots_nav,
						app_sim_apps_mobile : app_sim_apps_mobile,
						app_id: appIds[i],
						app_icon: app_icon_url,
						app_screenshots: app_screenshots,
						app_fee: app_fee,
						app_description: app_description,
						app_target_os_storename: app_target_os_storename,
						app_category: app_categories,
						app_update: app_last_mod,
						app_size: app_size,
						app_languages: app_langs,
						app_regions:app_regions,
						app_developer: app_developer ,
						multiple_screens: multiple_screens,
						multiple_apps: multiple_apps,
						app_store_link: app_store_link,
						app_version : app_details[7].targetOS,
						uses_open_data : uses_open_data
				};
				
				var template = _.template( $("#search_result_template").html(), template_variables);
		
				//append fully loaded html and react on different versions
				switch(app_details[7].targetOS) {
				
					case "Webapp":
						$('#app_detail_tabs a[href="#tab0"]').removeClass("disabled_ent").addClass("enabled");
						$('#tab0').html(template);
						$('#app_detail_tabs a[href="#tab0"]').attr("value", appIds[i]);
						break;
					case "Android":

							$('#app_detail_tabs a[href="#tab1"]').removeClass("disabled_ent").addClass("enabled");
							$('#tab1').html(template);
							$('#app_detail_tabs a[href="#tab1"]').attr("value", appIds[i]);

						break;
					case "iOS":

							$('#app_detail_tabs a[href="#tab2"]').removeClass("disabled_ent").addClass("enabled");
							$('#tab2').html(template);
							$('#app_detail_tabs a[href="#tab2"]').attr("value", appIds[i]);
							
						break;
					case "BlackBerry":

						$('#app_detail_tabs a[href="#tab3"]').removeClass("disabled_ent").addClass("enabled");
						$('#tab3').html(template);
						$('#app_detail_tabs a[href="#tab3"]').attr("value", appIds[i]);
						
					break;
					case "Ubuntu":

						$('#app_detail_tabs a[href="#tab4"]').removeClass("disabled_ent").addClass("enabled");
						$('#tab4').html(template);
						$('#app_detail_tabs a[href="#tab4"]').attr("value", appIds[i]);
						
					break;
					case "Windows":
							$('#app_detail_tabs a[href="#tab5"]').removeClass("disabled_ent").addClass("enabled");
							$('#tab5').html(template);
							$('#app_detail_tabs a[href="#tab5"]').attr("value", appIds[i]);
						break;
				}
				
				if(app_details[2].length<=1) {
					$('#screenshot_navigation'+appIds[i]).empty();
				}
							
				$('.region_link').unbind("click").click(function(event) {
					filter = "entitlement_1;entitlement_2;entitlement_3;entitlement_4;entitlement_5;entitlement_6;"+event.target.id;
					console.log('clear previous search results');
					
					/*
					 * modify form declared in suche-portlet and submit!
					 */
					document.getElementById('filter').value=filter;
					document.setFilter.submit();
					
				});
				
				$('.safe_mail_button').unbind("click").click(function(event) {
					if(!$('.safe_mail_button').hasClass("disabled")) {
						var theMailAddress = $(this).attr("value");
						theMailAddress = theMailAddress.replace("[mail]", "mailto:").replace("[at]", "@");
						location.href = theMailAddress;
					}
				});
				
				//fill entitlements
				for (var k = 0; k < app_details[0].length; k++) {

					
					switch (app_details[0][k].entitlementId) {
						case 1:
							//alert('remove opacitiy from ent: '+app_details[0][k].entitlementId);
							$('#det_ent_network'+appIds[i]).removeClass('disabled_ent');
							$('#ent_net_tooltip'+appIds[i]).attr("title", app_details[0][k].motivation);
							break;
						case 2:
							//access media (cam, mic, vid)

							$('#det_ent_media_access'+appIds[i]).removeClass('disabled_ent');
							$('#ent_med_tooltip'+appIds[i]).attr("title", app_details[0][k].motivation);
							break;
						case 3:
							//access /vepa-theme/images/vepa-icons/Plattform/Icon-Web-App-Aktiv.png

							$('#det_ent_directions'+appIds[i]).removeClass('disabled_ent');
							$('#ent_pla_tooltip'+appIds[i]).attr("title", app_details[0][k].motivation);
							break;
						case 4:
							//system settings

							$('#det_ent_system_settings'+appIds[i]).removeClass('disabled_ent');
							$('#ent_sys_tooltip'+appIds[i]).attr("title", app_details[0][k].motivation);
							break;
						case 5:
							//requires money

							$('#det_ent_money'+appIds[i]).removeClass('disabled_ent');
							$('#ent_fee_tooltip'+appIds[i]).attr("title", app_details[0][k].motivation);
							break;
						case 6:
							//personal data

							$('#det_ent_personal'+appIds[i]).removeClass('disabled_ent');
							$('#ent_per_tooltip'+appIds[i]).attr("title", app_details[0][k].motivation);
							break;
						default:	
							break;
					}
				}
				
				//alert('successfully filled template');
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("details-portlet, error textStatus: "+textStatus);
				console.log("details-portlet, error errorThrown: "+errorThrown);
				//location.href="/fehler";
			}
		});
	}
	


	
	//activate first tab and deactivate other tabs
		
	var chosenAppIdToShow = 0;
	
	if(!accessedByMobileTouchDevice() && !isIpad()) {
		$('.ent_tooltip').tooltip();
	
		$('#app_detail_tabs .enabled:first').tab('show');
	
		chosenAppIdToShow = $('#app_detail_tabs .enabled:first').attr("value");
	} else {


		$('.ent_tooltip').tooltip({
			trigger:'manual',
			delay: { show: 100, hide: 100 }
		});
		
		$('.ent_tooltip').each(function(index) {
			var currTooltip = $(this);
			currTooltip.toggle(function (){
				currTooltip.tooltip('show');
				$('body').on('touchend', function(e) {
					currTooltip.click();
					e.stopPropagation();
				});
			}, function() {
				currTooltip.tooltip('hide');
				$('body').unbind('touchend');
			});
		});
			
		
		var deviceList = ["iphone", "ipod", "ipad",
		                  	"android","windows ce","windows phone"];

		var i=0;
		var osFoundForTab = false;
			
		while(i<deviceList.length && !osFoundForTab) {
			
			var userAgentIndex = navigator.userAgent.toLowerCase().search(deviceList[i]); 
			if(userAgentIndex!=-1) {
				switch(i) {
					case 0:
						if($('#app_detail_tabs a[href="#tab2"]').hasClass("enabled")) {
							
							$('#app_detail_tabs a[href="#tab2"]').tab('show');
							chosenAppIdToShow = $('#app_detail_tabs a[href="#tab2"]').attr("value");
							osFoundForTab = true;
						}
						break;
					case 1:
						if($('#app_detail_tabs a[href="#tab2"]').hasClass("enabled")) {
							
							$('#app_detail_tabs a[href="#tab2"]').tab('show');
							chosenAppIdToShow = $('#app_detail_tabs a[href="#tab2"]').attr("value");
							osFoundForTab = true;
						}
						break;
					case 2:
						if($('#app_detail_tabs a[href="#tab2"]').hasClass("enabled")) {
							$('#app_detail_tabs a[href="#tab2"]').tab('show');
							chosenAppIdToShow = $('#app_detail_tabs a[href="#tab2"]').attr("value");
							osFoundForTab = true;
						}
						break;
					case 3:
						if($('#app_detail_tabs a[href="#tab1"]').hasClass("enabled")) {
							$('#app_detail_tabs a[href="#tab1"]').tab('show');
						
							chosenAppIdToShow = $('#app_detail_tabs a[href="#tab1"]').attr("value");
							osFoundForTab = true;
						}
						break;
					case 4:
					if($('#app_detail_tabs a[href="#tab3"]').hasClass("enabled")) {
							$('#app_detail_tabs a[href="#tab3"]').tab('show');
							
							chosenAppIdToShow = $('#app_detail_tabs a[href="#tab3"]').attr("value");
							osFoundForTab = true;
						}
						break;
					case 5:
					if($('#app_detail_tabs a[href="#tab3"]').hasClass("enabled")) {
							$('#app_detail_tabs a[href="#tab3"]').tab('show');
						
							chosenAppIdToShow = $('#app_detail_tabs a[href="#tab3"]').attr("value");
							osFoundForTab = true;
						}
						break;
					default:
						$('#app_detail_tabs .enabled:first').tab('show');
						
						chosenAppIdToShow = $('#app_detail_tabs .enabled:first').attr("value");
						break;
				}
			} else {
				$('#app_detail_tabs .enabled:first').tab('show');
			
				chosenAppIdToShow = $('#app_detail_tabs .enabled:first').attr("value");
			}
			i++;
		}
		

		
		

	}
	
	if(simAppsAvailable) {
		$('#sim-apps-slider'+chosenAppIdToShow).ready(function() {
			$('#sim-apps-slider'+chosenAppIdToShow).flexslider({
				animation: "slide",
			//	useCSS:false,
	            itemWidth: 245,
	            itemMargin: 0,
	            minItems: 1,
	            maxItems: 4,
	            move:1,
	            slideshow:false,
	            controlNav:false
			});
		});

	}
	
	if(screensAvailable) {
		$('#screens-slider'+chosenAppIdToShow).ready(function() {
			$('#screens-slider'+chosenAppIdToShow).flexslider({
				animation: "slide",
				//useCSS:false,
	            itemWidth: 250,
	            itemMargin: 5,
	            minItems: 1,
	            maxItems: 2,
	            move:1,
	            slideshow:false
			});
		});
		
	}
	
	console.log("added screenshot/simapps slider");
	
	if(screensAvailable || simAppsAvailable) {
		if(isWin8mobDevice()) {
			$(".flex-direction-nav li").show();	
			$(".flex-direction-nav li a").css('opacity','1');
		}
	}
	
	

	$('.osTab').unbind("click").click(function(event) {
		console.log("clicked tab for Id: "+ $(this).attr("value") );
		if(screensAvailable) {
				$('#screens-slider'+$(this).attr("value")).flexslider({
					animation: "slide",
					//useCSS:false,
		            itemWidth: 250,
		            itemMargin: 5,
		            minItems: 1,
		            maxItems: 2,
		            move:1,
		            slideshow:false
				});
		}
		if(simAppsAvailable) {
			$('#sim-apps-slider'+$(this).attr("value")).flexslider({
					animation: "slide",
					//useCSS:false,
		            itemWidth: 245,
		            itemMargin: 0,
		            minItems: 1,
		            maxItems: 4,
		            move:1,
		            slideshow:false,
		            controlNav:false
				});
		}
		
		if(isWin8mobDevice()) {
			$(".flex-direction-nav li").show();	
			$(".flex-direction-nav li a").css('opacity','1');
		}
		
		
	});
	

	console.log("enabled sliders for all app version pages");

	$('#app_detail_tabs .disabled_ent').removeAttr("href");
	
	loadingBarStopFilter();
		
	
};

function loadingBarStartFilter() {
    if (overlayVisFilter == false) {
           console.log("SHOWING Filter SPINNER");
           $("#app-details").css("visibility","hidden");
           $("#app-details-container").append("<div id='overlay_filter'><span class='center'> <img src='/vepa-theme/images/ajax-loader.gif'><br><br>Inhalte werden geladen ...</span></div>");
           overlayVisFilter = true;
    }
}

function loadingBarStopFilter() {
    if (overlayVisFilter == true) {
 	   	console.log("REMOVING Filter SPINNER");
 	   	 $("#app-details").css("visibility","visible");
         $("#overlay_filter").remove();
         if($("#app-details").css("visibility")!="visible") {
        	 $("#app-details").css("visibility", "visible");
         }
        
         
         overlayVisFilter = false;
    }
}
