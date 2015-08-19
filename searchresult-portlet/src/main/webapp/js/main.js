/*
 * #%L
 * govapps_searchresult
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
/* JS
 *  Fraunhofer FOKUS 2012, Berlin
 */

		var wsurl = "/VmAmG-portlet/api/jsonws/";
		var iconURL="";
		var searchResultFilterToggledCount = 0;
		var lastToggledListFilter = 'initial';
		
		var overlayVisFilter = false;
		var tooltipShowing = false;
		var lastTooltip = '';
		var isDirectlyAccessed = false;
		var gotDetailsViaRegionLink = false;
		var addedPopstateListener = false;
		var goBackToOtherAppDetails = false;

		loadingBarStartFilter();

		$(document).ready(function() {
			
			/*
			 * trigger category, region and entitlement loading 
			 */

        	getStaticCatRegEnt();

			/*
			 * check for smartphone to enable filter button
			 */
			
			
			if(accessedBySmartphone()) {
				
				
				//initially prepare all optionElements

				$('#filter_toggle_mobile').css("display", "block");
				$('#filters_for_result').css("display", "none");
				$('#filter_toggle_mobile').on("touchend", function(event) {
					
					if($('#filters_for_result').css("display")!="none") {
						$('#filters_for_result').css("display", "none");
					} else {
						$('#filters_for_result').css("display", "block");
					}
				

					
					
				});
				
				$('.filter_searchresult').css("display", "none");
			} else {
				$('#filter_toggle_mobile').css("display", "none");
			}
			
			
			/*
			 * enable social media two-click solution
			 */
			
			$('#socialshareprivacy').socialSharePrivacy(); 
			
			/*
			 * first determine, if user accesses page from mobile device and make respective changes
			 */
			
			$('.toggle_filter_mobile').on('touchend',function(event) {
			    event.preventDefault();
		        $(this).collapse({ //manually add collapse to the targeted button
		            toggle:true
		        });
			});


			/*
			 * trigger search process 
			 */
        	prepareSearch();

		});	
		
		_.templateSettings = {
				interpolate : /\{\{(.+?)\}\}/g
		};
		
		
		function redirectToAppDetailsPage(appIds,appName) {

			var allAppIds = appIds.split(";");
			if(allAppIds.length>1) {
				document.getElementById('appid').value = ""+allAppIds[0];
				document.getElementById('appname').value = ""+appName;
			} else {
				document.getElementById('appid').value = ""+appIds;
				document.getElementById('appname').value = ""+appName;
			}
			
			document.setAppIdForm.submit();
		}
		
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
				
				
				//opendata
				
				$('#accordion_opendata').empty().removeClass("accordion").append(
						'<select size="1" id="filter_opendata" class="multiselect_touch_filter" multiple="multiple">'
						+'<option value="--null--" selected>Offene Daten</option>'
						+'<option class="filter-checkbox" id="uses_opendata" value="uses_opendata">Nutzt offene Daten</option>'
						+'</select>');
				
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
						'<option class="filter-checkbox" id="os_ubuntu" value="platform_ubuntu">Ubuntu</option>'+
						'<option class="filter-checkbox" id="os_win" value="platform_windows">Windows</option>'+
//						'</optgroup>'+
//						'<optgroup label="Gerät">'+
//						'<option class="filter-checkbox" id="device_Smartphone" value="device_Smartphone">Smartphone</option>'+
//						'<option class="filter-checkbox" id="device_Tablet" value="device_Tablet">Tablet</option>'+
//						'</optgroup>'+
						'</select>');
				
			}
			
			if(!noCookiesAllowed()) {
				if(localStorage["localStoragePrepared"]=="true") {
					console.log("Search-Result-Portlet: regions / categories / entitlements are loaded, no ajax!");
					
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
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Deutschland.png" width="19" alt="Apps aus Deutschland">';
									break;
								case 2:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Baden-Wuerttemberg.png" width="19" alt="Apps aus Baden-Wuerttemberg">';
									break;
								case 3:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Bayern.png" width="19" alt="Apps aus Bayern" >';
									break;
								case 4:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Berlin.png" width="19" alt="Apps aus BerliN" >';
									break;
								case 5:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Brandenburg.png" width="19" alt="Apps aus Brandenburg" >';
									break;
								case 6:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Bremen.png" width="19" alt="Apps aus Bremen">';
									break;
								case 7:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hamburg.png" width="19" alt="Apps aus Hamburg">';
									break;
								case 8:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hessen.png" width="19" alt="Apps aus Hessen" >';
									break;
								case 9:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Mecklenburg-Vorpommern.png" width="19" alt="Apps aus Mecklenburg-Vorpommern" > ';
									break;
								case 10:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Niedersachsen.png" width="19" alt="Apps aus Niedersachsen"> ';
									break;
								case 11:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Nordrhein-Westfalen.png" width="19" alt="Apps aus Nordrhein-Westfalen"> ';
									break;
								case 12:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Rheinland-Pfalz.png" width="19" alt="Apps aus Rheinland-Pfalz"> ';
									break;
								case 13:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Saarland.png" width="19" alt="Apps aus dem Saarland"> ';
									break;
								case 14:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen.png" width="19" alt="Apps aus Sachsen" > ';
									break;
								case 15:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Anhalt.png" width="19" alt="Apps aus Sachsen-Anhalt"> ';
									break;
								case 16:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Schleswig-Holstein.png" width="19" alt="Apps aus Schleswig-Holstein"> ';
									break;
								case 17:
									regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Thueringen.png" width="19" alt="Apps aus Thueringen"> ';
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
			//	console.log("Search-Result-Portlet: regions / categories / entitlements are not loaded, do ajax!");
				$.ajax({
					'url': wsurl + "entitlement/get-regions-categories-entitlements/company-id/10154",
					success: function(result) {
						var obj = typeof JSON !='undefined' ?  JSON.parse(result) : eval('('+result+')');
						/* getCategories */
						if(isToucheable) {
							$('#accordion2').empty().removeClass("accordion").append('<select size="1" id="categories" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Themen</option>');
						}
					    for (var i = 0; i < obj[1].length; i++) { 
					    	if(isToucheable) {
					    		$('#categories').append("<option class='filter-checkbox' value='category_"+ obj[1][i].categoryId +"' id='category"+obj[1][i].categoryId+"'>" + obj[1][i].categoryName + "</option>");
					    	} else {
					    		
					    		var categoryIcon = '';
								switch(obj[1][i].categoryId) {							
								case 1:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Bildung.png" width="19" alt="Bildung">';
									break;
								case 2:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Familie.png" width="19" alt="Familie">';
									break;
								case 3:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Gesundheit.png" width="19" alt="Gesundheit">';
									break;
								case 4:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Nachrichten.png" width="19" alt="Nachrichten">';
									break;
								case 5:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Lexika.png" width="19" alt="Lexika">';
									break;
								case 6:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Verkehr.png" width="19" alt="Verkehr">';
									break;
								case 7:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Politik.png" width="19" alt="Politik">';
									break;
								case 8:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Organisation.png" width="19" alt="Organisation">';
									break;
								case 9:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Tourismus.png" width="19" alt="Tourismus">';
									break;
								case 10:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-2-Soziale-Netzwerke.png" width="19" alt="Soziale Netzwerke">';
									break;
								case 11:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Sport.png" width="19" alt="Sport">';
									break;
								case 12:
									categoryIcon+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Wetter.png" width="19" alt="Wetter">';
									break;								
								}
					    		
					    		
					    		$('#categories').append("<li><label class='checkbox inline'><input type='checkbox' class='filter-checkbox' value='category_"+ obj[1][i].categoryId +"' id='category"+obj[1][i].categoryId+"'>" +
					    				categoryIcon+" "+obj[1][i].categoryName + "</label></li>");
					    	}
					    }
					    
					    if(isToucheable) {
					    	$('#accordion2').append('</select>');
						}
					    
					    /* getRegions */
					  
						if(isToucheable) {
							$('#accordion6').empty().removeClass("accordion").append('<select size="1" id="regions" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Regionen</option>');
						}
						for (var i = 0; i < obj[0].length; i++) { 
							if(isToucheable) {
								$('#regions').append("<option class='filter-checkbox' value='region_"+ obj[0][i].regionId +"' id='region"+obj[0][i].regionId+"'>" + obj[0][i].name + "</option>");
							} else {
								var regionIcon = '';
								
								switch(obj[0][i].regionId) {
								
									case 1:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Deutschland.png" width="19" alt="Apps aus Deutschland">';
										break;
									case 2:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Baden-Wuerttemberg.png" width="19" alt="Apps aus Baden-Wuerttemberg">';
										break;
									case 3:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Bayern.png" width="19" alt="Apps aus Bayern">';
										break;
									case 4:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Berlin.png" width="19" alt="Apps aus Berlin">';
										break;
									case 5:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Brandenburg.png" width="19" alt="Apps aus Brandenburg">';
										break;
									case 6:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Bremen.png" width="19" alt="Apps aus Bremen">';
										break;
									case 7:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hamburg.png" width="19" alt="Apps aus Hamburg">';
										break;
									case 8:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hessen.png" width="19" alt="Apps aus Hessen">';
										break;
									case 9:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Mecklenburg-Vorpommern.png" width="19" alt="Apps aus Mecklenburg-Vorpommern">';
										break;
									case 10:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Niedersachsen.png" width="19" alt="Apps aus Niedersachsen">';
										break;
									case 11:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Nordrhein-Westfalen.png" width="19" alt="Apps aus Nordrhein-Westfalen">';
										break;
									case 12:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Rheinland-Pfalz.png" width="19" alt="Apps aus Rheinland-Pfalz">';
										break;
									case 13:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Saarland.png" width="19" alt="Apps aus dem Saarland">';
										break;
									case 14:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen.png" width="19" alt="Apps aus Sachsen">';
										break;
									case 15:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Anhalt.png" width="19" alt="Apps aus Sachsen Anhalt"> ';
										break;
									case 16:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Schleswig-Holstein.png" width="19" alt="Apps aus Schleswig Holstein">';
										break;
									case 17:
										regionIcon+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Thueringen.png" width="19" alt="Apps aus Thueringen">';
										break;
								}
								
								
								$('#regions').append("<li><label class='checkbox inline'><input type='checkbox' class='filter-checkbox' value='region_"+ obj[0][i].regionId +"' id='region"+obj[0][i].regionId+"'>" +
										regionIcon+" "+obj[0][i].name + "</label></li>");
							}
						}
						
						if(isToucheable) {
							$('#accordion6').append('</select>');
						}
						/* get Entitlements */
						
						if(isToucheable) {
							$('#accordion5').empty().removeClass("accordion").append('<select size="1" id="filter_entitlements" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Berechtigungen</option>');
						}
						
						
						
						for(var i=0; i<obj[2].length; i++) {
							var entitlementTag='';
							if(!isToucheable) {
								
								   switch (obj[2][i].entitlementId) {
					            	   case 1:
											//network communication
											//entitlementTag+=obj[2][i].explanation+'">';
											entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Netzwerkkommunikation.png">';
											break;
										case 2:
											//access media (cam, mic, vid)
											//entitlementTag+=obj[2][i].explanation+'">';
											entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Medienzugriff.png">';
											break;
										case 3:
											//access /vepa-theme/images/vepa-icons/Plattform/Icon-Web-App-Aktiv.png
											//entitlementTag+=obj[2][i].explanation+'">';
											entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Ortungsdienste.png">' ;
											break;
										case 4:
											//system settings
											//entitlementTag+=obj[2][i].explanation+'">';
											entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Systemeinstellung.png">';
											break;
										case 5:
											//requires money
										//	entitlementTag+=obj[2][i].explanation+'">';
											entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-kostenpflichtige-Dienste.png">';
											break;
										case 6:
											//personal data
											//entitlementTag+=obj[2][i].explanation+'">';
											entitlementTag+='<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-persoenliche-Daten.png">';
											break;
										default:	
											//entitlementTag+=obj[2][i].explanation+'">';
											entitlementTag+=' <i class="icon-remove">';
											break;
				         	   		}
				                   $('#filter_entitlements').append("<li><label class='checkbox inline'><input type='checkbox' checked='true' class='filter-checkbox' value='entitlement_"+ obj[2][i].entitlementId +"' id='entitlement"+obj[2][i].entitlementId+"'>" + entitlementTag + ' ' +obj[2][i].entitlementName + "</label></li>");
							} else {
								 $('#filter_entitlements').append("<option class='filter-checkbox' selected='true' value='entitlement_"+ obj[2][i].entitlementId +"' id='entitlement"+obj[2][i].entitlementId+"'>" + entitlementTag + ' ' +obj[2][i].entitlementName + "</option>");
							}
							
							if(isToucheable) {
								$('#accordion5').append('</select>');
							}
						}
						
						if(isToucheable) {
							$("#filter_entitlements option[value='--null--'],#regions option[value='--null--'],#categories option[value='--null--'],#filter_fees option[value='--null--'], #filter_platforms option[value='--null--']").attr("disabled", true);
						}
						

						

						
					}, error: function(error) {
						//TODO ajax call did not work -> redirect to global error page
						location.href="/fehler";
					}
				});
			
			}
			
			$(".filter_for_fee input:checkbox").change(function() {
			//	console.log("filter for fee changed");
				if($(this).attr("checked")!="true") {
					$(".filter_for_fee input:checkbox").attr("checked", false);
				    $(this).attr("checked", true);
				} 
			});
			
			
		}
        
        function prepareSearch() {
			
			//clear previous results;
        	$('#lastSearchStringRegion').text("");
        	clearPreviousResults();
        	loadingBarStartFilter();
			
			var appIds = new Array();
			var obj;
			
			if(searchStr.length==0 || searchStr=="null") {
			//	console.log("no search string entered - set to all categories");
				$('#lastSearchString').text("Alle Themen");
				$('#searchStr2').attr("placeholder","Alle Themen");
			} else {
			//	console.log("search string entered - set respective texts!");
				$('#lastSearchString').text(searchStr);
				$('#searchStr2').attr("placeholder",searchStr);
			}
			
			
			if(filter.length==0) {
			//	console.log("Filter length = 0; get all apps, that do not use any entitlements");
	
				Liferay.Service(
						'/VmAmG-portlet#application/get-full-search-applications',
						  {
						    co: 10154,
						    ke: searchStr,
						    ca: '',
						    re: '',
						    ap: '',
						    to: '',
						    fe: -1,
						    es: 1,
						    tc:'',
						    od: 0
						  },
						  function(result) {
							  buildSearchResults(result, searchStr);
						 }
				);
	
			} else {
						
				var filterItems = filter.split(';');
				var entitlementParam = '', categoryParam='', regionParam='', platformParam='', feeParam='', devParam='',odParam=0;
				var allChosenCategories = '';
				var allChosenRegions = '';
				for(var i=0; i<filterItems.length; i++) {
					//filter for entitlements
					var checkedAttribute = "checked";
					if(accessedByMobileTouchDevice()) {
						checkedAttribute = "selected";
					}
					if(filterItems[i].length>0) {
						currentTypeOfFilter = filterItems[i].split('_')[0];
						currentFilterId = filterItems[i].split('_')[1];
						
						switch (currentTypeOfFilter) {
							case 'category':
								console.log('toogle checkbox category based on:'+currentFilterId);
								$('#category'+currentFilterId).attr(checkedAttribute, true);
								if(categoryParam.length==0) {
									categoryParam+=currentFilterId;
									allChosenCategories+=currentFilterId;
								} else {
									categoryParam+='_'+currentFilterId;
									allChosenCategories+=','+currentFilterId;
								}
								
								break;
							case 'entitlement':
								console.log('toogle checkbox entitlement based on:'+currentFilterId);
								$('#entitlement'+currentFilterId).attr(checkedAttribute, true);
								if(entitlementParam.length==0) {
									entitlementParam+=currentFilterId;
								} else {
									entitlementParam+='_'+currentFilterId;
								}
								break;
							case 'region':
								console.log('toogle checkbox region based on:'+currentFilterId);
								$('#region'+currentFilterId).attr(checkedAttribute, true);
								if(regionParam.length==0) {
									regionParam+=currentFilterId;
									allChosenRegions+=+currentFilterId;
								} else {
									regionParam+='_'+currentFilterId;
									allChosenRegions+=','+currentFilterId;
								}
								break;
							case 'platform':
								//console.log('toogle checkbox platform based on:'+currentFilterId);
								switch(currentFilterId) {
									case "android":
										$('#os_android').attr(checkedAttribute, true);
										break;
									case "windows":
										$('#os_win').attr(checkedAttribute, true);
										break;
									case "ios":
										$('#os_apple').attr(checkedAttribute, true);
										break;
									case "blackberry":
										$('#os_blackberry').attr(checkedAttribute, true);
										break;
									case "ubuntu":
										$('#os_ubuntu').attr(checkedAttribute, true);
										break;
									case "webapp":
										$('#os_webapp').attr(checkedAttribute, true);
									default:
										console.log('unknown os checked');
									break;
								}
								if(platformParam.length==0) {
									platformParam+=currentFilterId;
								} else {
									platformParam+='_'+currentFilterId;
								}
								break;
							case 'fee':
								if(currentFilterId==1) {
									$('#with_fee').attr('checked', true);
								} else {
									$('#no_fee').attr('checked', true);
								}
								if(feeParam.length!=0) {
									//was set before, both filters set
									console.log("both filters were set..");
									feeParam = -1;
								} else {
									feeParam = currentFilterId;
								}
								
								break;
							case 'device':
								console.log('toogle checkbox device based on:'+currentFilterId);
								$(filterItems[i]).attr("checked", "true");
								if(devParam.length==0) {
									devParam+=currentFilterId;
								} else {
									devParam+='_'+currentFilterId;
								}
							case 'uses':
								console.log('toggle opendata checkbox based on:'+currentFilterId);
								$('#uses_opendata').attr("checked", "true");
								odParam=1;
								break;
							default:
								console.log('not possible!');
								break;
						}
					}
				}
				
				if(feeParam.length==0) {
					console.log("No fee filter set, : "+feeParam);
					feeParam=-1;
				} 
				
							
				if(regionParam.length>0) {

					var allChosenRegionIds = allChosenRegions.split(',');

					console.log("all region ids for search string: "+allChosenRegionIds);
					allChosenRegions='in: ';
					for(var v=0; v<allChosenRegionIds.length; v++) {
						console.log("current region id: \""+allChosenRegionIds[v]+"\"");
						switch(allChosenRegionIds[v]) {
						case "1":
							allChosenRegions+='Bundesrepublik Deutschland';
							break;
						case "2":
							allChosenRegions+='Baden-Württemberg';
							break;
						case "3":
							allChosenRegions+='Bayern';
							break;
						case "4":
							allChosenRegions+='Berlin';
							break;
						case "5":
							allChosenRegions+='Brandenburg';
							break;
						case "6":
							allChosenRegions+='Bremen';
								break;
						case "7":
							allChosenRegions+='Hamburg';
							break;
						case "8":
							allChosenRegions+='Hessen';
							break;
						case "9":
							allChosenRegions+='Mecklenburg-Vorpommern';
							break;
						case "10":
							allChosenRegions+='Niedersachsen';
							break;
						case "11":
							allChosenRegions+='Nordrhein-Westfalen';
							break;
						case "12":
							allChosenRegions+='Rheinland-Pfalz';
							break;
						case "13":
							allChosenRegions+='Saarland';
							break;
						case "14":
							allChosenRegions+='Sachsen';
							break;
						case "15":
							allChosenRegions+='Sachsen-Anhalt';
							break;
						case "16":
							allChosenRegions+='Schleswig-Holstein';
							break;
						case "17":
							allChosenRegions+='Thüringen';
							break;

						}
						
						if((v+1)!=allChosenRegionIds.length && (allChosenRegionIds[v]!=undefined && allChosenRegionIds[v].length>0)) {
							allChosenRegions+=', ';
						}
					}
					
				//	console.log("changing current search region String to: "+allChosenRegions);
					$('#lastSearchStringRegion').text(allChosenRegions);
				}
				
				if(categoryParam.length>0) {
					var allChosenCategoryIds = allChosenCategories.split(',');
					allChosenCategories='';
					for(var v=0; v<allChosenCategoryIds.length;v++) {
						console.log("current category ID \""+allChosenCategoryIds[v]+"\"");
						switch(allChosenCategoryIds[v]) {							
						case "1":
							allChosenCategories+='Bildung';
							break;
						case "2":
							allChosenCategories+='Familie';
							break;
						case "3":
							allChosenCategories+='Gesundheit';
							break;
						case "4":
							allChosenCategories+='Nachrichten';
							break;
						case "5":
							allChosenCategories+='Nachschlagewerke';
							break;
						case "6":
							allChosenCategories+='Navigation';
							break;
						case "7":
							allChosenCategories+='Politik';
							break;
						case "8":
							allChosenCategories+='Organisation';
							break;
						case "9":
							allChosenCategories+='Reisen';
							break;
						case "10":
							allChosenCategories+='Soziale Netze';
							break;
						case "11":
							allChosenCategories+='Sport';
							break; 
						case "12":
							allChosenCategories+='Wetter';
							break;								
						}
						
						if((v+1)!=allChosenCategoryIds.length) {
							allChosenCategories+=', ';
						}
					}
					
				//	console.log("changing current search String to: "+allChosenCategories);
					$('#lastSearchString').text(allChosenCategories);
					$('#searchStr2').attr("placeholder",allChosenCategories);
				}			
				
				Liferay.Service(
						'/VmAmG-portlet#application/get-full-search-applications',
						  {
						    co: 10154,
						    ke: searchStr,
						    ca: categoryParam,
						    re: regionParam,
						    ap: entitlementParam,
						    to: platformParam,
						    fe: feeParam,
						    es: 1,
						    tc: devParam,
						    od: odParam
						  },
						  function(result) {
								  buildSearchResults(result, searchStr);
						 }
				);
				
				
				
				}
			
		}
//        
//        function showDropdown(element) {
//            var event;
//            event = document.createEvent('MouseEvents');
//            event.initMouseEvent('mousedown', true, true, window);
//            element.dispatchEvent(event);
//        };
	
		function buildSearchResults(obj, searchString) {
			
			loadingBarStartFilter();
			
			var isUndefined = true;
			
			document.title = "GovApps | App-Suche";
			
			if(noCookiesAllowed()) {
				$('.filter_searchresult').css("display","none");
			}
			
			//only sort by date if initial page view
			if(lastToggledListFilter=="initial" && (searchString!=undefined && searchString=="null")) {
				//console.log("sort after date initially");
				lastToggledListFilter = "date";
				sortFollowingDate(obj, "initial");
			}
			
			console.log("length after sorting: "+obj.length);
			
			var obj = obj;

			clearPreviousResults();
			
			
			$('#mainSearchStringContainer').css("display", "inherit");
			
			/*
			 * 0 entitlements
			 * 1 Icon
			 * 2 appdetails
			 * 3 motivations
			 * 4 categoryIds
			 * 5 regionIds
			 */
			
			//wait for result
			while(isUndefined==true) {
				if(obj!=undefined) isUndefined=false;
			}
			
			

			var apps_per_result_page = 10;
			var paginationTag = '<div class="pagination pagination-right"><ul><li class="pagination_link disabled"><a href="#" id="pagination_backward">Zur&uuml;ck</a></li><li class="pagination_link active"><a href="#" id="pagination_0">1</a></li>';
			var numberOfPages = 1;
			var paginationIndex = 0;
			var lastUniqueAppsLength=0;
			var newResultListOpened = false;
			var classNameOfSearchResultDiv = '.searchresult';
			var classNameOfPaginationDiv = '#pagination_resultpage';
			//prepare pagination (pages // links)

			//determine div to which results will be appended. Depends on respective root:
			//1: search / filter; 3: direct entitlement click

			
			if(obj.length>0) {
				console.log("appending first pagination page");
				$(classNameOfSearchResultDiv).ready(function() {
					$(classNameOfSearchResultDiv).append('<ul id="searchresult_'+paginationIndex+'"></ul>');
				});
			}
		
			
			var relatedAppsNotToScan = [];
			var uniqueApps = [];
			var currentSearchListToAppend = 0;
			var countAndroid="0", countWebApp="0", countUbuntu="0", countBlackberry="0", CountIOS="0", countWindows="0";
			
		//	console.log("begin working on search result apps, length of apps:"+obj.length);
			for (var i = 0; i < obj.length; i++) {
			
				
				iconURL = obj[i][1];
				iconURL = iconURL.replace("http://localhost", "");
	
				var relatedAppsArray='', costsFee='', osTag='', entitlementTag='', categoriesTag='',
				motivationTag='', regionsTag='';

				if(obj[i][2].relatedApplicationId.length>0) {
					relatedAppsArray = obj[i][2].applicationId+";"+obj[i][2].relatedApplicationId;
				} else {
					relatedAppsArray = obj[i][2].applicationId;
				}
				
				if(obj[i][2].fee>0) {
					costsFee = '<p class="text-error">&euro;</p>';
				}
				
				var entitlementIds = obj[i][0].split(',');
				var motivations = obj[i][3];
				
				var imageWidth = 75;
				
				if(accessedBySmartphone()) {
					imageWidth = 25;
				}
				
				entitlementTag = '<a id="ent_result_net_tooltip'+obj[i][2].applicationId+'" class="res_ent_tooltip" rel="tooltip" data-placement="bottom">'
					+'<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Netzwerkkommunikation-Aktiv.png" id="ent_network'+obj[i][2].applicationId+'" class="disabled_ent"></a> '
					+'<a id="ent_result_med_tooltip'+obj[i][2].applicationId+'" class="res_ent_tooltip" rel="tooltip" data-placement="bottom">'
					+'<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Medienzugriff-Aktiv.png" id="ent_media_access'+obj[i][2].applicationId+'" class="disabled_ent"></a> '
					+'<a id="ent_result_pla_tooltip'+obj[i][2].applicationId+'" class="res_ent_tooltip" rel="tooltip" data-placement="bottom">'
					+'<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Ortungsdienste-Aktiv.png" id="ent_directions'+obj[i][2].applicationId+'" class="disabled_ent"></a> '
					+'<a id="ent_result_sys_tooltip'+obj[i][2].applicationId+'" class="res_ent_tooltip" rel="tooltip" data-placement="bottom">'
					+'<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Systemeinstellung-Aktiv.png" id="ent_system_settings'+obj[i][2].applicationId+'" class="disabled_ent"></a> '
					+'<a id="ent_result_fee_tooltip'+obj[i][2].applicationId+'" class="res_ent_tooltip" rel="tooltip" data-placement="bottom">'
					+'<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-kostenpflichtige-Dienste-Aktiv.png" id="ent_money'+obj[i][2].applicationId+'" class="disabled_ent"></a> '
					+'<a id="ent_result_per_tooltip'+obj[i][2].applicationId+'" class="res_ent_tooltip" rel="tooltip" data-placement="bottom">'
					+'<img src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-persoenliche-Daten-Aktiv.png" id="ent_personal'+obj[i][2].applicationId+'" class="disabled_ent"></a> ';
				
				
				var osTemplateHtml = '';
				var webapp='', android='', ios='', blackberry='', ubuntu='', windows='';
				var tooltip_webapp='', tooltip_and='', tooltip_ios='',tooltip_blackberry='', tooltip_ubuntu='', tooltip_win='';
				
		
				switch(obj[i][2].targetOS) {
					case "Android":
						countAndroid++;
						android = "-Aktiv";
						tooltip_and = "class='res_ent_tooltip' title='Als Android-App verf&uuml;gbar' rel='tooltip'";
						break;
					case "Windows":
						countWindows++;
						windows = "-Aktiv";
						tooltip_win = "class='res_ent_tooltip' title='Als Windows-App verf&uuml;gbar' rel='tooltip'";
						break;
					case "iOS":
						CountIOS++;
						ios = "-Aktiv";
						tooltip_ios = "class='res_ent_tooltip' title='Als iOS-App verf&uuml;gbar' rel='tooltip'";
						break;
					case "BlackBerry":
						countBlackberry++;
						blackberry = "-Aktiv";
						tooltip_blackberry = "class='res_ent_tooltip' title='Als Blackberry-App verf&uuml;gbar' rel='tooltip'";
						break;
					case "Ubuntu":
						countUbuntu++;
						ubuntu = "-Aktiv";
						tooltip_ubuntu = "class='res_ent_tooltip' title='Als Ubuntu-App verf&uuml;gbar' rel='tooltip'";
						break;
					case "Webapp":
						countWebApp++;
						webapp = "-Aktiv";
						tooltip_webapp = "class='res_ent_tooltip' title='Als WebApp verf&uuml;gbar' rel='tooltip'";
					default:
						osTag='OS';
					break;
				}
				$('.badge.android').text(countAndroid);
				$('.badge.windows').text(countWindows);
				$('.badge.ios').text(CountIOS);
				$('.badge.blackberry').text(countBlackberry);
				$('.badge.webapp').text(countWebApp);
				$('.badge.ubuntu').text(countUbuntu);
							
				var openData = '';
					if(obj[i][2].useOpenData!="0") {
					openData = '<span class="uses_govdata">Nutzt GovData Datens&auml;tze</span>';
				}
				
				
				if(relatedAppsNotToScan.indexOf(''+obj[i][2].applicationId+'')==-1 && uniqueApps.indexOf(''+obj[i][2].applicationId+'')==-1) {
					//app has not been scanned yet, is root app
					uniqueApps.push(obj[i][2].applicationId);
					//alert('is root app');
					/*
					 * things, that happen now: if current search result app has related app,
					 * add respective OS version to presentation and do NOT show them as different apps!
					 * In the case, that the have different fees or entitlements -> show them as different!
					 */
					
					if(obj[i][2].relatedApplicationId.length>0) {
						var relatedApplicationIds = obj[i][2].relatedApplicationId.split(';');
						
						for(var z=0; z<relatedApplicationIds.length; z++) {
							
							//alert('check related apps');
							
							/*
							 * inspect all related apps, if respective details are equal or not
							 * add relatedApplicationId to apps that have to be skipped
							 * 
							 */
																
							//find related app in remaining part of search results and inspect as mentioned
							
							for(var y=i; y<obj.length;y++) {
								if(obj[y][2].applicationId == relatedApplicationIds[z]) {
									//alert('found related app');
									
									if(((obj[y][2].fee == 0) && (obj[y][2].fee==obj[i][2].fee)) || ((obj[y][2].fee!=0)&&(obj[i][2].fee!=0))) {
										//fee and entitlements are the same ==> add OS to tag
										//alert('all details are equal -> add OS tag');
										switch(obj[y][2].targetOS) {
										case "Android":
											android = "-Aktiv";
											tooltip_and = "class='res_ent_tooltip' title='Als Android-App verf&uuml;gbar' rel='tooltip'";
											break;
										case "Windows":
											windows = "-Aktiv";
											tooltip_win = "class='res_ent_tooltip' title='Als Windows-App verf&uuml;gbar' rel='tooltip'";
											break;
										case "iOS":
											ios = "-Aktiv";
											tooltip_ios = "class='res_ent_tooltip' title='Als iOS-App verf&uuml;gbar' rel='tooltip'";
											break;
										case "BlackBerry":
											blackberry = "-Aktiv";
											tooltip_blackberry = "class='res_ent_tooltip' title='Als Blackberry-App verf&uuml;gbar' rel='tooltip'";
											break;
										case "Ubuntu":
											ubuntu = "-Aktiv";
											tooltip_ubuntu = "class='res_ent_tooltip' title='Als Ubuntu-App verf&uuml;gbar' rel='tooltip'";
											break;
										case "Webapp":
											webapp = "-Aktiv";
											tooltip_webapp = "class='res_ent_tooltip' title='Als WebApp verf&uuml;gbar' rel='tooltip'";
											default:
												osTag+='OS';
											break;
										}
										
										relatedAppsNotToScan.push(relatedApplicationIds[z]);
									} else {
										//something is different -> add as single app
										uniqueApps.push(relatedApplicationIds[z]);
										//alert('all details are not equal -> mark version');
									}
								}
							}
	
						}
						
					}

					var template_variables = {webapp:webapp,
							android:android,
							apple:ios,
							blackberry:blackberry,
							ubuntu:ubuntu,
							windows:windows,
							tooltip_win:tooltip_win,
							tooltip_and:tooltip_and,
							tooltip_ios:tooltip_ios,
							tooltip_blackberry:tooltip_blackberry,
							tooltip_ubuntu:tooltip_ubuntu,
							tooltip_webapp:tooltip_webapp,
							app_id: "search_"+obj[i][2].applicationId};
					
					var osTag = _.template( $("#os_template").html(), template_variables);
	
					$('#searchresult_'+paginationIndex).append(
													"<li><div class='span9' id='searchresult_icon_desc'><div class='span3'><a href='?nr="+obj[i][2].applicationId+"&app="+obj[i][2].name+"' title='"+obj[i][2].name+"' data-toggle=\"tab\" ><img src='"
															+ iconURL
															+ "' width='"+imageWidth+"%'  alt='"+obj[i][2].name+"' onClick='javascript:redirectToAppDetailsPage(\""
															+ relatedAppsArray
															+ "\",\"" + obj[i][2].name
															+ "\")'/></a></div><div class='span9'> <h2 onClick='javascript:redirectToAppDetailsPage(\""
															+ relatedAppsArray
															+ "\",\"" + obj[i][2].name
															+ "\")'><a href='?nr="+obj[i][2].applicationId+"&app="+obj[i][2].name+"' title='"+obj[i][2].name+"' data-toggle=\"tab\">"
															+ obj[i][2].name +" " + costsFee +" "+openData
															+ "</a></h2>"
															+ "<div class='app_description_container'>"+obj[i][2].description.substring(0,125)+'...</div>'
															+ "</div></div>"							
															+ "<div class='span3 searchresult_entitlement_preview'>"
//															+ "<div class='row-fluid'>"+categoriesTag+"</div>"
//															+ "<div class='row-fluid'>"+regionsTag+"</div>"
															+ "<div class='row-fluid'>"+osTag+"</div>"
															+ "<div class='row-fluid'>"+entitlementTag+"</div>"
															+ "</div>"
															+ "</li>");	
					appIds = [];
				
				} else {
					if(uniqueApps.indexOf(''+obj[i][2].applicationId+'')!=-1) {
						
						var template_variables = {webapp:webapp,
								android:android,
								apple:ios,
								blackberry:blackberry,
								ubuntu:ubuntu,
								windows:windows,
								tooltip_win:tooltip_win,
								tooltip_and:tooltip_and,
								tooltip_ios:tooltip_ios,
								tooltip_blackberry:tooltip_blackberry,
								tooltip_ubuntu:tooltip_ubuntu,
								tooltip_webapp:tooltip_webapp,
								app_id: "search_"+obj[i][2].applicationId};
						var osTag = _.template( $("#os_template").html(), template_variables);
						
						$('#searchresult_'+paginationIndex).append(
								"<li><div class='span9' id='searchresult_icon_desc'><div class='span3'><a href='?nr="+obj[i][2].applicationId+"&app="+obj[i][2].name+"'  title='"+obj[i][2].name+"' data-toggle=\"tab\"><img src='"
										+ iconURL
										+ "' width='"+imageWidth+"%'  alt='"+obj[i][2].name+"' onClick='javascript:redirectToAppDetailsPage(\""
										+ relatedAppsArray
										+ "\",\"" + obj[i][2].name
										+ "\")'/></a></div><div class='span9'><h2 onClick='javascript:redirectToAppDetailsPage(\""
										+ relatedAppsArray
										+ "\",\"" + obj[i][2].name
										+ "\")'><a href='?nr="+obj[i][2].applicationId+"&app="+obj[i][2].name+"' title='"+obj[i][2].name+"' data-toggle=\"tab\">"
										+ obj[i][2].name +" "+ costsFee +" "+openData
										+"</a></h2>"
										+"<div class='app_description_container'>"+ obj[i][2].description.substring(0,125)+"...</div>"
										+ "</div></div>"
										+ "<div class='span3 searchresult_entitlement_preview'>"
//										+ "<div class='row-fluid'>"+categoriesTag+"</div>"
//										+ "<div class='row-fluid'>"+regionsTag+"</div>"
										+ "<div class='row-fluid'>"+osTag+"</div>"
										+ "<div class='row-fluid'>"+entitlementTag+"</div>"
										+ "</div>"
										+ "</li>");	
						appIds = [];
					}
				}
				
			
				for (var k = 0; k < entitlementIds.length-1; k++) {
	
					
					switch (entitlementIds[k]) {
						case '1':
							$('#ent_network'+obj[i][2].applicationId).removeClass('disabled_ent');
							$('#ent_result_net_tooltip'+obj[i][2].applicationId).attr("title", obj[i][3][k]);
							break;
						case '2':
							//access media (cam, mic, vid)
							//alert('remove opacitiy from ent: '+app_details[0][k].entitlementId);
							$('#ent_media_access'+obj[i][2].applicationId).removeClass('disabled_ent');
							$('#ent_result_med_tooltip'+obj[i][2].applicationId).attr("title", obj[i][3][k]);
							break;
						case '3':
							//access /vepa-theme/images/vepa-icons/Plattform/Icon-Web-App-Aktiv.png
							//alert('remove opacitiy from ent: '+app_details[0][k].entitlementId);
							$('#ent_directions'+obj[i][2].applicationId).removeClass('disabled_ent');
							$('#ent_result_pla_tooltip'+obj[i][2].applicationId).attr("title", obj[i][3][k]);
							break;
						case '4':
							//system settings
							//alert('remove opacitiy from ent: '+app_details[0][k].entitlementId);
							$('#ent_system_settings'+obj[i][2].applicationId).removeClass('disabled_ent');
							$('#ent_result_sys_tooltip'+obj[i][2].applicationId).attr("title", obj[i][3][k]);
							break;
						case '5':
							//requires money
						//	alert('remove opacitiy from ent: '+app_details[0][k].entitlementId);
							$('#ent_money'+obj[i][2].applicationId).removeClass('disabled_ent');
							$('#ent_result_fee_tooltip'+obj[i][2].applicationId).attr("title", obj[i][3][k]);
							break;
						case '6':
							//personal data
							//alert('remove opacitiy from ent: '+app_details[0][k].entitlementId);
							$('#ent_personal'+obj[i][2].applicationId).removeClass('disabled_ent');
							$('#ent_result_per_tooltip'+obj[i][2].applicationId).attr("title", obj[i][3][k]);
							break;
						default:	
							break;
					}
				}
				
				var i2 = i+1;
				
				//console.log("i: "+i+", i2 (i+1):"+i2+" ;obj.length="+obj.length+" i2 == obj.length"+ (i2==obj.length));

				var increasePagination = false;
				
				
				if(uniqueApps.length%apps_per_result_page==0 && uniqueApps.length>0 && (i2<obj.length) &&lastUniqueAppsLength<uniqueApps.length) {
					lastUniqueAppsLength = uniqueApps.length;
					paginationIndex+=1;
		//	console.log(apps_per_result_page+" apps added successfully, creating new page with index: "+paginationIndex);
					$(classNameOfSearchResultDiv).append('</ul><ul id="searchresult_'+paginationIndex+'">');
					$('#searchresult_'+paginationIndex).css("display", "none");
					newResultListOpened = true;
					paginationTag+='<li class="pagination_link"><a href="#" id="pagination_'+paginationIndex+'">'+(paginationIndex+1)+'</a>';
				} else {
				//	console.log("Number of Pages: "+numberOfPages);
					if((i+1)==obj.length) {
						
						
						if(uniqueApps.length>apps_per_result_page) {
							//either list opened but not closed or list to short for reaching apps_per_page
							console.log("closing list!");
							console.log("Number of Pages: "+numberOfPages+" has to be increased, as new apps were added but paginationIndex not!");
							increasePagination=true;
							$(classNameOfSearchResultDiv).append('</ul>').trigger("create");
						} else {
							// no new apps have been added after last creation of pagination
							// remove changes
							//remove new list

							console.log("no new apps after last addition of new page, remove empty page");
							paginationTag = '<div class="pagination pagination-right"><ul><li class="pagination_link disabled"><a href="#" id="pagination_backward">Zur&uuml;ck</a></li><li class="pagination_link active"><a href="#" id="pagination_0">1</a></li>';
							for(var w = 1; w<paginationIndex.length; w++) {
								paginationTag+='<li class="pagination_link"><a href="#" id="pagination_'+paginationIndex+'">'+(paginationIndex+1)+'</a>';
							}
						}
					}
				}
				
				numberOfPages = paginationIndex;
				
				if(increasePagination) numberOfPages++;
				
				var lastPaginationIndex = 0;
				$('#searchresult_0').trigger("create");
				
			}
			
			if(obj.length==0) {
			//	console.log("No search results!");
				$(classNameOfSearchResultDiv).addClass("span12").html('<div class="alert alert-info alert-block"><h4>Leider konnten keine Apps gefunden werden.</h4><p><small>Suchen Sie erneut und &auml;ndern Sie eventuell Ihre Suchkriterien.</small></p></div>');
				$('#hitCount').html('Keine');
				$('.badge.android').text('0');
				$('.badge.windows').text('0');
				$('.badge.ios').text(CountIOS);
				$('.badge.blackberry').text('0');
				$('.badge.webapp').text('0');
				$('.badge.ubuntu').text('0');
			} else {

				$('#hitCount').html(uniqueApps.length);
				
				$(classNameOfPaginationDiv).append(paginationTag+'<li class="pagination_link"><a href="#" id="pagination_forward">Vor</a></li>');
				
				//disable pagination as there is only one page
			//	console.log("number of pages: "+numberOfPages);
				if(numberOfPages <= 1){ 
					console.log("disable pagination");
					$(classNameOfPaginationDiv).css("visibility", "hidden");
				} else {
					console.log("enable pagination, if disabled before");
					$(classNameOfPaginationDiv).css("visibility", "visible");
				}
				
				$('.pagination_link').unbind("click").click(function(event){
					
					
					console.log("clicked page: "+event.target.id);
					console.log("number of pages: "+numberOfPages);
					
					console.log("old page index: "+lastPaginationIndex);
					$('#pagination_'+lastPaginationIndex).parent().removeClass("active");
					var searchResultListToActivate = event.target.id.split('_')[1];
					
					if((searchResultListToActivate=="backward" && $('#pagination_backward').parent().hasClass("disabled")) || (searchResultListToActivate=="forward" && $('#pagination_forward').parent().hasClass("disabled"))) {
						
					} else {
						console.log("page clicked: "+searchResultListToActivate);
						
						$('#searchresult_'+lastPaginationIndex).css("display","none");
						
						
						switch (searchResultListToActivate) {
							case "forward":
								console.log("clicked forward pager");
								lastPaginationIndex++;
								break;
							case "backward":
								console.log("clicked backward pager");
								lastPaginationIndex--;
								break;
							default:
								console.log("direct click on index");
								lastPaginationIndex = parseInt(searchResultListToActivate);
								
								break;
						}
						
						$('#pagination_'+lastPaginationIndex).parent().addClass("active");
						console.log("refreshed old page index: "+lastPaginationIndex);
						
						$('#searchresult_'+lastPaginationIndex).css("display","block");
						
						
						if(lastPaginationIndex == (numberOfPages-1)) {
							console.log("disable forward button");
							$('#pagination_forward').parent().addClass("disabled");
							$('#pagination_backward').parent().removeClass("disabled");

						} else {
							if(lastPaginationIndex == "0") {
								console.log("disable backward button");
								$('#pagination_backward').parent().addClass("disabled");
								$('#pagination_forward').parent().removeClass("disabled");
							} else {
								console.log("not first or last page - disable / enable respective buttons if necessary");
								if($('#pagination_forward').parent().hasClass("disabled")) $('#pagination_forward').parent().removeClass("disabled");
								if($('#pagination_backward').parent().hasClass("disabled")) $('#pagination_backward').parent().removeClass("disabled");
							}
						}

					}
					
					
				});
				
			}
			
			if(accessedByMobileTouchDevice()) {
				$('.multiselect_touch_filter').unbind("change").change(function(event) {
					toggleReFilter(event);
				});
			} else {
				$('.filter-checkbox').unbind("change").change(function(event) {
					toggleReFilter(event);
				});
			}
			
			
			$('.filter_searchresult a').unbind("click").click(function(event){
				
				loadingBarStartFilter();
				console.log("click on filter link..."+event.target.id);
				var filter_used = event.target.id.split("_")[1];
				var arrayForSort = [];
				switch(filter_used) {
				case "date":
					console.log("date filter clicked - order list by creation date");
					buildSearchResults(sortFollowingDate(obj, "date"), "");
					break;

				case "name":
					
					var appName = [];

					for(var x=0; x<obj.length; x++) {
						var theAppName = obj[x][2].name.toLowerCase();
						appName.push(theAppName+"_"+obj[x][2].applicationId);
						sessionStorage.setItem(theAppName+"_"+obj[x][2].applicationId, x);
						arrayForSort.push(obj[x]);
					}

					if(searchResultFilterToggledCount == 0 || lastToggledListFilter!="name") {
						console.log("sort name array first, as this is the first call");
						console.log("unsorted array: "+appName);
						appName = appName.sort();
						console.log("sorted array: "+appName);
					}
					console.log("sorted and reversed array: "+appName.reverse());
					
					
					for(var x=0; x<obj.length; x++) {
						obj[x] = arrayForSort[sessionStorage.getItem(appName[x])];
					}
					
					lastToggledListFilter = "name";
					searchResultFilterToggledCount++;
					loadingBarStopFilter();
					buildSearchResults(obj, "");
					break;
				}
			}); 
			
			if(!accessedByMobileTouchDevice() && !isIpad()) {
				$('.res_ent_tooltip').tooltip();
			} else {

				$('.res_ent_tooltip').tooltip({
					trigger:'manual',
					delay: { show: 100, hide: 100 }
				});
				
				$('.res_ent_tooltip').each(function(index) {
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
			}
			
			
			loadingBarStopFilter();
		
		}
		
		
			

	function emptyDiv() {
//		$('#app_detail_tabs').empty();
//		$('#app_detail_tab_content').empty();
		$('#pagination_resultpage').empty();
		$('.back_to_results').hide();
	}
	
	function toggleReFilter(event) {
		
		console.log('filter changed!');
		console.log('event id: '+event.target.id);
		console.log('event Value: '+event.target.value);
		
		
		var newFilterString = '';
		
		if(accessedByMobileTouchDevice()) {
		 $('.multiselect_touch_filter :selected').each(function(i, selected) {
			 newFilterString = newFilterString.concat($(selected).val()+ ";");
            });
		} else {
			$('.filter-checkbox:checked').each(function(index, element) {
				newFilterString+=$(this).val()+';';
			});
		}
		
		
		console.log('change filter string to: '+newFilterString);
		
		filter=newFilterString;
		
		if(accessedBySmartphone()) {
			$('#filters_for_result').css("display", "none");
		}
		prepareSearch();

	}
	
	function clearPreviousResults() {
		$('.searchresult').empty();
		$('.searchresult_entitlements').empty();
		$('#pagination_resultpage').empty();
		$('#pagination_resultpage_entitlements').empty();
	}
	
	function sortFollowingDate(obj, filterIndex) {
		
		loadingBarStartFilter();
		if(!noCookiesAllowed()) {

			
			var arrayForSort = [];
			var creationDate = [];

			
			for(var x=0; x<obj.length; x++) {
				creationDate.push(obj[x][2].createDate);
				sessionStorage.setItem(obj[x][2].createDate,x);
				arrayForSort.push(obj[x]);
			}
			
			
			//sort if initially filtered
			if(searchResultFilterToggledCount == 0 || lastToggledListFilter!="date" ) {
				console.log("sort date array first, as this is the first call");
				console.log("unsorted array: "+creationDate);
				creationDate = creationDate.sort();
				console.log("sorted array: "+creationDate);
			}
			
			console.log("reversed array: "+creationDate.reverse());
			
			for(var x=0; x<obj.length; x++) {
				obj[x] = arrayForSort[sessionStorage.getItem(creationDate[x])];
			}
			
			searchResultFilterToggledCount++;
			lastToggledListFilter = filterIndex;
			
			
		}
		loadingBarStopFilter();
		
		return obj;
		
	}
	

	 
	  function isAppleDevice() {
		  
		  	var appleIndex = -1;
		  	
			var deviceList = ["iphone", "ipad", "ipod"];
			var i = 0;
			
			//alert(navigator.userAgent.toLowerCase());
				
			while(i<deviceList.length) {
				var tmpIndex = navigator.userAgent.toLowerCase().search(deviceList[i]);
				//alert("tmp index for: "+deviceList[i]+" : "+tmpIndex);
				if(tmpIndex>-1) {
					appleIndex = tmpIndex;
				}
				i++;
			}
			
			if(appleIndex>-1) {
				return true;
			} else {
				return false;
			} 
		  	
	  }
	  
	  
	  function isWin8mobDevice() {
		  
		  var windowsNT62Index=navigator.userAgent.toLowerCase().search("windows nt 6.2");
		  var hasTouch=navigator.userAgent.toLowerCase().search("touch");
		  var isWindowsPhoneOS=navigator.userAgent.toLowerCase().search("windows phone");
		  
//		  console.log("win 6.2 index:"+ windowsNT62Index);
//		  console.log("touch device index:"+ hasTouch);
//		  console.log("win phone os index:"+ isWindowsPhoneOS);
		  
		  	if((windowsNT62Index>-1 && hasTouch>-1) || isWindowsPhoneOS>-1) {
		  		return true;
		  	}
		  	
		  	return false;
		  	
	  }
	  
	  function isInternetExplorer() {
		  var ieIndex = navigator.userAgent.toLowerCase().search("msie");
		  if(ieIndex>-1) {
			  console.log("is internet explorer");
			  return true;
		  } 
		  return false;
	  }
	  
	  function isFirefox() {
		  var ieIndex = navigator.userAgent.toLowerCase().search("firefox");
		  if(ieIndex>-1) {
			  console.log("is firefox");
			  return true;
		  } 
		  return false;
	  }
	  
		function loadingBarStartFilter() {
		    if (overlayVisFilter == false) {
		           console.log("SHOWING Filter SPINNER");
		           $("#searchResultTabContent").css("visibility","hidden");
		           $("body").append("<div id='overlay_filter'><span class='center'> <img src='/vepa-theme/images/ajax-loader.gif'><br><br>Inhalte werden geladen ...</span></div>");
		           overlayVisFilter = true;
		    }
		}

		function loadingBarStopFilter() {
		    if (overlayVisFilter == true) {
		 	   	console.log("REMOVING Filter SPINNER");
		 	   	 $("#searchResultTabContent").css("visibility","visible");
		         $("#overlay_filter").remove();
		         if($("#searchResultTabContent").css("visibility")!="visibible") {
		        	 $("#searchResultTabContent").css("visibility", "visible");
		         }
		         if($("#mainSearchStringContainer").css("visibility")!="visibible") {
		        	 $("#mainSearchStringContainer").css("visibility", "visible");
		         }
		         
		         
		         overlayVisFilter = false;
		    }
		}


	 
	
	
	
		
			
	
