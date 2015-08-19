/*
 * #%L
 * govapps_concern
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
	/*
	 * some variables:
	 * 
	 * 
	 */



	
	
	var overlayVisFilter = false;
	var searchResultFilterToggledCount = 0;
	var listenerAction = "click", lastToggledListFilter="";
	var resultOrderASCed = true;
	var wsurl = "/VmAmG-portlet/api/jsonws/";
	loadingBarStartFilter();
	
	
	$(document).ready(function() {
	
		
				
		if(accessedBySmartphone()) {
			
			listenerAction = "touchend";
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
		 * add two-click social media
		 */
		
		if(!accessedBySmartphone()) {
			$('#globalSocialMedia_concernList').socialSharePrivacy();
		}

		getStaticCatRegEnt();
		getAllConcerns(false);


		/*
		 * initiate trigger action for concernForm
		 */
		
		if(previousAddNot!=undefined && previousAddNot.length>0) {
			
			/*
			 * concern was added ... determine result
			 */
			
			if(previousAddNot=="false") {
				$('#add_concern').css("display", "block");
			}
		}
	
		
		$('#add_concern').on(listenerAction, function(event) {
			
		
			if ($('#addConcernForm').css("display") != "none") {
				$('#addConcernForm').css("display", "none");
			} else {
				$('.concernRegionPlatform').removeClass("error");
				$('#concernNameDescriptionBox').removeClass("error");
				$('#errorBox').css("display","none");
				$('#successBox').css("display","none");
				$('#addConcernForm').css("display", "block");
				
				/*
				 * check, if a concern was added previously to restore respective fields
				 */
				
				if(previousAddNot!=undefined && previousAddNot.length>0) {
					
					/*
					 * concern was added ... determine result
					 */
					
					if(previousAddNot=="false") {
						//captcha was invalid. set respective contents of fields
						
						console.log("restoring information for submitted concern request - only captcha was invalid");
						
						$('#concernName').val(req_concernName);
						$('#concernMail').val(req_concernMail);
						$('#concernDescription').val(req_concernDescription);
						
						console.log("restoring information for platforms: "+req_concernPlatforms);
						
						var platforms = req_concernPlatforms.split(";");
						for(var d=0; d<platforms.length; d++) {
							if(platforms[d].length>0) {
								console.log("enable platform: "+platforms[d].split("_")[1]+" for concern wish");
								$('#platform_'+platforms[d].split("_")[1]).attr('checked', true);
							}
						}
						
						console.log("restoring information for categories: "+req_concernCategory);
						var categories = req_concernCategory.split(";");
						for(var d=0; d<categories.length; d++) {
							if(categories[d].length>0) {
								
								console.log("enable category: "+categories[d].split("_")[1]+" for concern wish");
								var idToEnable = categories[d].split("_")[1];
								idToEnable-=1;
								$('#ui-multiselect-concern_Categories-option-'+idToEnable).attr('checked', true);
							}
						}
						console.log("restoring information for regions: "+req_concernRegion);
						
						var regions = req_concernRegion.split(";");
						for(var d=0; d<regions.length; d++) {
							if(regions[d].length>0) {
								console.log("enable region: "+regions[d].split("_")[1]+" for concern wish");
								var idToEnable = regions[d].split("_")[1];
								idToEnable-=1;
								$('#ui-multiselect-concern_Regions-option-'+idToEnable).attr('checked', true);
							}
						}

					} 
					
				} else {
					$('#concernDescription').val("");
				}
			}
		});
		
		
		
		/*
		 * add propose Form action to button
		 */
		
		$('#addConcernForm').submit(function(event){
			
			$('#errorBox').css("display","none");
			$('#concern_captcha').removeClass("error");
			$('.concernRegionPlatform').removeClass("error");
			$('.concernNameDescriptionBox').removeClass("error");
			
			var concernName=$('#concernName').val();
			var concernDescription=$('#concernDescription').val();
			var concernMail=$('#concernMail').val();
			
			var concernRegion="", concernCategory="", concernPlatforms="";
			
			$('#concern_Categories :selected').each(function(i, selected) {
				concernCategory = concernCategory.concat($(selected).val()+ ";");
	        });
			
			$('#concern_Regions :selected').each(function(i, selected) {
				concernRegion = concernRegion.concat($(selected).val()+ ";");
	        });
			
			$('.concern_Platform :checked').each(function(i, selected) {
				concernPlatforms = concernPlatforms.concat($(selected).val()+";");
			});
			
			console.log("Concern to propose:\nName:"+concernName+"\n"
					+"Description: \""+concernDescription+"\"\n"
					+"Categories: "+concernCategory+"\n"
					+"Regions: "+concernRegion+"\n"
					+"Platforms: "+concernPlatforms);
			
			var errorText ="";
			var concernIsValid = true;
			
			//concernName.length==0 || concernDescription.length==0 || concernMail.length == 0 Kontaktinformationen, Name und
			if(concernDescription.length==0) {
				console.log("ConcernDescription has length 0");
				$('.concernNameDescriptionBox').addClass("error");
				errorText+="Beschreibung des Wunsches muss ausgef&uuml;llt sein!";
				concernIsValid = false;
			}
			
			if(concernPlatforms.length==0 || concernRegion.length==0) {
				$('.concernRegionPlatform').addClass("error");
				errorText+="\nDie bevorzugte(n) Ziel-Plattform(en) und Ziel-Region(en) m&uuml;ssen ausgew&auml;hlt werden!\n";
				concernIsValid = false;
			}
			
			//add validation if on mobile 
			
			if(accessedBySmartphone()) {
				if($('#concern_captcha').val().length==0) {
					errorText="Bitte die Zeichen aus dem Captcha eingeben! "+errorText;
					concernIsValid = false;
					$('#concern_captcha').addClass("error");
				}
				
				if(concernName.length==0) {
					errorText="Bitte Titel der Idee eingeben! "+errorText;
					concernIsValid = false;
				}
			}
			

			
				
			if (!concernIsValid) {
				$('#errorBox').html(errorText);
				$('#errorBox').css("display","block");
				event.preventDefault();
			} else {
				
				document.getElementById('form_concernName').value=concernName;
				document.getElementById('form_concernCategory').value=concernCategory;
				document.getElementById('form_concernDescription').value=concernDescription;
				document.getElementById('form_concernPlatforms').value=concernPlatforms;
				document.getElementById('form_concernRegion').value=concernRegion;
				document.getElementById('form_concernMail').value=concernMail;
				document.addConcernForm.submit();
//				Liferay.Service(
//						  '/Vepla-concern-Portlet-portlet#concern/add-concern',
//						  {
//						    category: concernCategory,
//						    name: concernName,
//						    description: concernDescription,
//						    region: concernRegion,
//						    platforms: concernPlatforms,
//						    userId: 0
//						  },
//						  function(obj) {
//							  if(""+obj=="true") {
//								  console.log("Returned result: "+obj);
//								  $('#concernName').val("");
//								  $('#concernDescription').val("");
//								  $('#add_concern').click();
//								  $('#successBox').html("Ihr Wunsch wird nun &uuml;berpr&uuml;ft." +
//								  		"Sofern er allen Kriterien gen&uuml;gt, wird er freigeschaltet!");
//								  $('#successBox').css("display","block"); 
//							  }
//							  
//						  }
//						);
			}
			
			
		});
		
		/*
		 * first determine, if user accesses page from mobile device and make respective changes
		 */
	
	//	$('.toggle_filter_mobile').on('touchend', function(event) {
	//		event.preventDefault();
	//		$(this).collapse({ //manually add collapse to the targeted button
	//			toggle : true
	//		});
	//	});
		
		
		
		
		
	});
	
	_.templateSettings = {
		interpolate : /\{\{(.+?)\}\}/g
	};
	
	function getStaticCatRegEnt() {
		/*
		 * load categories, entitlements and regions
		 */
	
		console.log(isWin8mobDevice());
	
		var isToucheable = false;
	
		if (accessedByMobileTouchDevice()) {
			isToucheable = true;
		}
	
		// no matter of localstorage, initialize fee and platform checkbox /
		// multiselect
	
		if (isToucheable) {
	

	
			// plattform
	
			$('#accordion4')
					.empty()
					.removeClass("accordion")
					.append(
							'<select size="1" id="filter_platforms" class="multiselect_touch_filter" multiple="multiple">'
									+ '<option value="--null--" selected>Plattform</option>'
									+
									// '<optgroup label="Betriebssystem">'+
									'<option class="filter-checkbox" id="os_webapp" value="platform_webapp">WebApp</option>'
									+ '<option class="filter-checkbox" id="os_android" value="platform_android">Android</option>'
									+ '<option class="filter-checkbox" id="os_apple" value="platform_ios">Apple iOS</option>'
									+ '<option class="filter-checkbox" id="os_win" value="platform_windows">Windows</option>'
									+
									// '</optgroup>'+
									// '<optgroup label="Gerät">'+
									// '<option class="filter-checkbox"
									// id="device_Smartphone"
									// value="device_Smartphone">Smartphone</option>'+
									// '<option class="filter-checkbox"
									// id="device_Tablet"
									// value="device_Tablet">Tablet</option>'+
									// '</optgroup>'+
									'</select>');
	
		}
	
		if (!noCookiesAllowed()) {
			if (localStorage["localStoragePrepared"] == "true") {
				console.log("Search-Result-Portlet: regions / categories / entitlements are loaded, no ajax!");
	
				/* getCategories */
				var obj = JSON.parse(localStorage["allCategories"]);
				if (isToucheable) {
					$('#accordion2')
							.empty()
							.removeClass("accordion")
							.append(
									'<select size="1" id="categories" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Themen</option>');
				}
	
				for ( var i = 0; i < obj.length; i++) {
					
					$('#concern_Categories').append("<option value='category_"+obj[i].categoryId+"'>"+ obj[i].categoryName + "</option>");
					
					if (isToucheable) {
						$('#categories').append(
								"<option class='filter-checkbox' value='category_"
										+ obj[i].categoryId + "' id='category"
										+ obj[i].categoryId + "'>"
										+ obj[i].categoryName + "</option>");
					} else {
	
						var categoryIcon = '';
	
						switch (obj[i].categoryId) {
						case 1:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Bildung.png" width="19">';
							break;
						case 2:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Familie.png" width="19">';
							break;
						case 3:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Gesundheit.png" width="19">';
							break;
						case 4:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Nachrichten.png" width="19">';
							break;
						case 5:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Lexika.png" width="19">';
							break;
						case 6:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Verkehr.png" width="19">';
							break;
						case 7:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Politik.png" width="19">';
							break;
						case 8:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Organisation.png" width="19">';
							break;
						case 9:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Tourismus.png" width="19">';
							break;
						case 10:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-2-Soziale-Netzwerke.png" width="19">';
							break;
						case 11:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Sport.png" width="19">';
							break;
						case 12:
							categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Wetter.png" width="19">';
							break;
						}
	
						$('#categories')
								.append(
										"<li><label class='checkbox inline'><input type='checkbox' class='filter-checkbox' value='category_"
												+ obj[i].categoryId
												+ "' id='category"
												+ obj[i].categoryId
												+ "'>"
												+ categoryIcon
												+ " "
												+ obj[i].categoryName
												+ "</label></li>");
						
					}
				}
	
				if (isToucheable) {
					$('#accordion2').append('</select>');
				}
	
				/* getRegions */
				obj = JSON.parse(localStorage["allRegions"]);
				if (isToucheable) {
					$('#accordion6')
							.empty()
							.removeClass("accordion")
							.append(
									'<select size="1" id="regions" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Regionen</option>');
				}
				for ( var i = 0; i < obj.length; i++) {
					$('#concern_Regions').append("<option value='region_"+obj[i].regionId+"'>"+ obj[i].name + "</option>");
					
					if (isToucheable) {
						$('#regions').append(
								"<option class='filter-checkbox' value='region_"
										+ obj[i].regionId + "' id='region"
										+ obj[i].regionId + "'>" + obj[i].name
										+ "</option>");
					} else {
						var regionIcon = '';
	
						switch (obj[i].regionId) {
	
						case 1:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Deutschland.png" width="19">';
							break;
						case 2:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Baden-Wuerttemberg.png" width="19">';
							break;
						case 3:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Bayern.png" width="19">';
							break;
						case 4:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Berlin.png" width="19">';
							break;
						case 5:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Brandenburg.png" width="19">';
							break;
						case 6:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Bremen.png" width="19">';
							break;
						case 7:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hamburg.png" width="19">';
							break;
						case 8:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hessen.png" width="19">';
							break;
						case 9:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Mecklenburg-Vorpommern.png" width="19"> ';
							break;
						case 10:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Niedersachsen.png" width="19"> ';
							break;
						case 11:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Nordrhein-Westfalen.png" width="19"> ';
							break;
						case 12:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Rheinland-Pfalz.png" width="19"> ';
							break;
						case 13:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Saarland.png" width="19"> ';
							break;
						case 14:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen.png" width="19"> ';
							break;
						case 15:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Anhalt.png" width="19"> ';
							break;
						case 16:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Schleswig-Holstein.png" width="19"> ';
							break;
						case 17:
							regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Thueringen.png" width="19"> ';
							break;
						}
	
						$('#regions')
								.append(
										"<li><label class='checkbox inline'><input type='checkbox' class='filter-checkbox' value='region_"
												+ obj[i].regionId
												+ "' id='region"
												+ obj[i].regionId
												+ "'>"
												+ regionIcon
												+ " "
												+ obj[i].name
												+ "</label></li>");
					}
				}
	
				if (isToucheable) {
					$('#accordion6').append('</select>');
				}
	
				/* get Entitlements */
	
				// if(isToucheable) {
				// $('#accordion5').empty().removeClass("accordion").append('<select
				// size="1" id="filter_entitlements"
				// class="multiselect_touch_filter" multiple="multiple"><option
				// value="--null--" selected>Berechtigungen</option>');
				// }
				// obj = JSON.parse(localStorage["allEntitlements"]);
				// for(var i=0; i<obj.length; i++) {
				// var entitlementTag='';
				// if(!isToucheable) {
				//							
				// switch (obj[i].entitlementId) {
				// case 1:
				// //network communication
				// //entitlementTag+=obj[i].explanation+'">';
				// entitlementTag+='<img
				// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Netzwerkkommunikation.png">
				// ';
				// break;
				// case 2:
				// //access media (cam, mic, vid)
				// //entitlementTag+=obj[i].explanation+'">';
				// entitlementTag+='<img
				// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Medienzugriff.png">';
				// break;
				// case 3:
				// //access
				// /vepa-theme/images/vepa-icons/Plattform/Icon-Web-App-Aktiv.png
				// //entitlementTag+=obj[i].explanation+'">'
				// entitlementTag+='<img
				// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Ortungsdienste.png">
				// ';
				// break;
				// case 4:
				// //system settings
				// //entitlementTag+=obj[i].explanation+'">';
				// entitlementTag+='<img
				// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Systemeinstellung.png">';
				// break;
				// case 5:
				// //requires money
				// //entitlementTag+=obj[i].explanation+'">';
				// entitlementTag+='<img
				// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-kostenpflichtige-Dienste.png">
				// ';
				// break;
				// case 6:
				// //personal data
				// //entitlementTag+=obj[i].explanation+'">';
				// entitlementTag+='<img
				// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-persoenliche-Daten.png">';
				// break;
				// default:
				// //entitlementTag+=obj[i].explanation+'">';
				// entitlementTag+=' <i class="icon-remove">';
				// break;
				// }
				// $('#filter_entitlements').append("<li><label class='checkbox
				// inline'><input type='checkbox' checked='true'
				// class='filter-checkbox' value='entitlement_"+
				// obj[i].entitlementId +"'
				// id='entitlement"+obj[i].entitlementId+"'>" + entitlementTag + ' '
				// +obj[i].entitlementName + "</label></li>");
				// } else {
				// $('#filter_entitlements').append("<option class='filter-checkbox'
				// selected='true' value='entitlement_"+ obj[i].entitlementId +"'
				// id='entitlement"+obj[i].entitlementId+"'>" + entitlementTag + ' '
				// +obj[i].entitlementName + "</option>");
				// }
				// }
				//					
				// if(isToucheable) {
				// $('#accordion5').append('</select>');
				// $("#filter_entitlements option[value='--null--'],#regions
				// option[value='--null--'],#categories
				// option[value='--null--'],#filter_fees option[value='--null--'],
				// #filter_platforms option[value='--null--']").attr("disabled",
				// true);
				// }
			} else {
				doAjaxForFilterBuild();
			}
		} else {
			doAjaxForFilterBuild();
		}
	
		function doAjaxForFilterBuild() {
			console
					.log("Search-Result-Portlet: regions / categories / entitlements are not loaded, do ajax!");
			$
					.ajax({
						'url' : wsurl
								+ "entitlement/get-regions-categories-entitlements/company-id/10154",
						success : function(result) {
							var obj = typeof JSON != 'undefined' ? JSON
									.parse(result) : eval('(' + result + ')');
							/* getCategories */
							if (isToucheable) {
								$('#accordion2')
										.empty()
										.removeClass("accordion")
										.append(
												'<select size="1" id="categories" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Themen</option>');
							}
							for ( var i = 0; i < obj[1].length; i++) {
								$('#concern_Categories').append("<option value='category_"+obj[1][i].categoryId+"'>"+ obj[1][i].categoryName + "</option>");
								if (isToucheable) {
									$('#categories').append(
											"<option class='filter-checkbox' value='category_"
													+ obj[1][i].categoryId
													+ "' id='category"
													+ obj[1][i].categoryId + "'>"
													+ obj[1][i].categoryName
													+ "</option>");
								} else {
	
									var categoryIcon = '';
									switch (obj[1][i].categoryId) {
									case 1:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Bildung.png" width="19">';
										break;
									case 2:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Familie.png" width="19">';
										break;
									case 3:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Gesundheit.png" width="19">';
										break;
									case 4:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Nachrichten.png" width="19">';
										break;
									case 5:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Lexika.png" width="19">';
										break;
									case 6:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Verkehr.png" width="19">';
										break;
									case 7:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Politik.png" width="19">';
										break;
									case 8:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Organisation.png" width="19">';
										break;
									case 9:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Tourismus.png" width="19">';
										break;
									case 10:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-2-Soziale-Netzwerke.png" width="19">';
										break;
									case 11:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Sport.png" width="19">';
										break;
									case 12:
										categoryIcon += '<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Wetter.png" width="19">';
										break;
									}
	
									$('#categories')
											.append(
													"<li><label class='checkbox inline'><input type='checkbox' class='filter-checkbox' value='category_"
															+ obj[1][i].categoryId
															+ "' id='category"
															+ obj[1][i].categoryId
															+ "'>"
															+ categoryIcon
															+ " "
															+ obj[1][i].categoryName
															+ "</label></li>");
								}
							}
	
							if (isToucheable) {
								$('#accordion2').append('</select>');
							}
	
							/* getRegions */
	
							if (isToucheable) {
								$('#accordion6')
										.empty()
										.removeClass("accordion")
										.append(
												'<select size="1" id="regions" class="multiselect_touch_filter" multiple="multiple"><option value="--null--" selected>Regionen</option>');
							}
							for ( var i = 0; i < obj[0].length; i++) {
								$('#concern_Regions').append("<option value='region_"+obj[0][i].regionId+"'>"+ obj[0][i].name + "</option>");
								if (isToucheable) {
									$('#regions').append(
											"<option class='filter-checkbox' value='region_"
													+ obj[0][i].regionId
													+ "' id='region"
													+ obj[0][i].regionId + "'>"
													+ obj[0][i].name + "</option>");
								} else {
									var regionIcon = '';
	
									switch (obj[0][i].regionId) {
	
									case 1:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Deutschland.png" width="19">';
										break;
									case 2:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Baden-Wuerttemberg.png" width="19">';
										break;
									case 3:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Bayern.png" width="19">';
										break;
									case 4:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Berlin.png" width="19">';
										break;
									case 5:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Brandenburg.png" width="19">';
										break;
									case 6:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Bremen.png" width="19">';
										break;
									case 7:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hamburg.png" width="19">';
										break;
									case 8:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hessen.png" width="19">';
										break;
									case 9:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Mecklenburg-Vorpommern.png" width="19">';
										break;
									case 10:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Niedersachsen.png" width="19">';
										break;
									case 11:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Nordrhein-Westfalen.png" width="19">';
										break;
									case 12:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Rheinland-Pfalz.png" width="19">';
										break;
									case 13:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Saarland.png" width="19">';
										break;
									case 14:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen.png" width="19">';
										break;
									case 15:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Anhalt.png" width="19"> ';
										break;
									case 16:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Schleswig-Holstein.png" width="19">';
										break;
									case 17:
										regionIcon += '<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Thueringen.png" width="19">';
										break;
									}
	
									$('#regions')
											.append(
													"<li><label class='checkbox inline'><input type='checkbox' class='filter-checkbox' value='region_"
															+ obj[0][i].regionId
															+ "' id='region"
															+ obj[0][i].regionId
															+ "'>"
															+ regionIcon
															+ " "
															+ obj[0][i].name
															+ "</label></li>");
								}
							}
	
							if (isToucheable) {
								$('#accordion6').append('</select>');
							}
							// /* get Entitlements */
							//						
							// if(isToucheable) {
							// $('#accordion5').empty().removeClass("accordion").append('<select
							// size="1" id="filter_entitlements"
							// class="multiselect_touch_filter"
							// multiple="multiple"><option value="--null--"
							// selected>Berechtigungen</option>');
							// }
							//						
							//						
							//						
							// for(var i=0; i<obj[2].length; i++) {
							// var entitlementTag='';
							// if(!isToucheable) {
							//								
							// switch (obj[2][i].entitlementId) {
							// case 1:
							// //network communication
							// //entitlementTag+=obj[2][i].explanation+'">';
							// entitlementTag+='<img
							// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Netzwerkkommunikation.png">';
							// break;
							// case 2:
							// //access media (cam, mic, vid)
							// //entitlementTag+=obj[2][i].explanation+'">';
							// entitlementTag+='<img
							// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-2-Medienzugriff.png">';
							// break;
							// case 3:
							// //access
							// /vepa-theme/images/vepa-icons/Plattform/Icon-Web-App-Aktiv.png
							// //entitlementTag+=obj[2][i].explanation+'">';
							// entitlementTag+='<img
							// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Ortungsdienste.png">'
							// ;
							// break;
							// case 4:
							// //system settings
							// //entitlementTag+=obj[2][i].explanation+'">';
							// entitlementTag+='<img
							// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-Systemeinstellung.png">';
							// break;
							// case 5:
							// //requires money
							// // entitlementTag+=obj[2][i].explanation+'">';
							// entitlementTag+='<img
							// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-kostenpflichtige-Dienste.png">';
							// break;
							// case 6:
							// //personal data
							// //entitlementTag+=obj[2][i].explanation+'">';
							// entitlementTag+='<img
							// src="/vepa-theme/images/vepa-icons/Berechtigungen_Klein/Icon-persoenliche-Daten.png">';
							// break;
							// default:
							// //entitlementTag+=obj[2][i].explanation+'">';
							// entitlementTag+=' <i class="icon-remove">';
							// break;
							// }
							// $('#filter_entitlements').append("<li><label
							// class='checkbox inline'><input type='checkbox'
							// checked='true' class='filter-checkbox'
							// value='entitlement_"+ obj[2][i].entitlementId +"'
							// id='entitlement"+obj[2][i].entitlementId+"'>" +
							// entitlementTag + ' ' +obj[2][i].entitlementName +
							// "</label></li>");
							//							} else {
							//								 $('#filter_entitlements').append("<option class='filter-checkbox' selected='true' value='entitlement_"+ obj[2][i].entitlementId +"' id='entitlement"+obj[2][i].entitlementId+"'>" + entitlementTag + ' ' +obj[2][i].entitlementName + "</option>");
							//							}
							//							
							//							if(isToucheable) {
							//								$('#accordion5').append('</select>');
							//							}
							//						}
							//						
							//						if(isToucheable) {
							//							$("#filter_entitlements option[value='--null--'],#regions option[value='--null--'],#categories option[value='--null--'],#filter_fees option[value='--null--'], #filter_platforms option[value='--null--']").attr("disabled", true);
							//						}
	
						},
						error : function(error) {
							//TODO ajax call did not work -> redirect to global error page
							location.href = "/web/umfrage/fehler";
						}
					});
	
		}
		
		if(!accessedByMobileTouchDevice()) { 
			$(".multiselect_touch_filter option[value='--null--']").remove();
			$("#concern_Regions option[value='--null--'],#concern_Categories option[value='--null--']").remove();
	
			$("#concern_Regions").multiselect({
			      noneSelectedText: 'Regionen',
			    	  selectedText: "Regionen"
			       });
			
			$("#concern_Categories").multiselect({
				      noneSelectedText: 'Themen',
				    	  selectedText: "Themen"
				       });
			
			
		}
		else {
			$("#concern_Regions option[value='--null--'],#concern_Categories option[value='--null--']").attr("disabled", true);
		}
	
	}
	
	function getAllConcerns(getOppositeOrder) {
		
		/* first:retrieve all concerns via json call */
		
	
		var allConcerns;
		
		if(getOppositeOrder) {
			console.log("get all Concerns ordered by Likes DSC");
			Liferay.Service(
					  '/Vepla-concern-Portlet-portlet#concern/get-all-approved-concerns-dsc',
					  {
					    companyId: 10154
					  },
					  function(obj) {
						  
					    buildConcernList(obj);
					    
					  }
					);
			
		} else {
			console.log("get all Concerns ordered by Likes ASC");
			Liferay.Service(
					  '/Vepla-concern-Portlet-portlet#concern/get-all-approved-concerns',
					  {
					    companyId: 10154
					  },
					  function(obj) {
						  
					    buildConcernList(obj);
					    
					  }
					);
		}
		
		
	}
	
	function filterApprovedConcerns(filter) {
		
		//inspect filter string, reset previous search
		
		console.log("inspect filter string ...:\""+filter+"\"");
		
		var filterItems = filter.split(';');
		var regionParam='', platformParam='';
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
						console.log('toogle checkbox platform based on:'+currentFilterId);
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
					default:
						console.log('filtercategory is not known - check markup!');
						break;
				}
			}
			
		}
			
			
		console.log("calling server for filter request...");
		
		Liferay.Service(
				  '/Vepla-concern-Portlet-portlet#concern/filter-all-approved-concerns',
				  {
				    platformFilter: platformParam,
				    regionFilter: regionParam
				  },
				  function(obj) {
				    console.log("result:" + obj);
				    buildConcernList(obj);
				  }
				);
			
	}
	
	function buildConcernList(allConcerns) {
		
		var classNameOfSearchResultDiv = '.searchresult';
		$(classNameOfSearchResultDiv).empty();
		var classNameOfPaginationDiv = '#pagination_resultpage';
		$(classNameOfPaginationDiv).empty();
		
		if(allConcerns.length>0) {
			console.log("Currently available: "+ allConcerns.length+" concerns!\nStart building result list!");
			
			var concerns_per_result_page = 10;
			var paginationTag = '<div class="pagination pagination-right"><ul><li class="pagination_link disabled"><a href="#" id="pagination_backward">Zur&uuml;ck</a></li><li class="pagination_link active"><a href="#" id="pagination_0">1</a></li>';
			var paginationIndex = 0;
			var newResultListOpened = false;
			
			/*
			 * prepare number of pages for pagination
			 */
			
			var numberOfPages = 1;
			
			if(allConcerns.length>concerns_per_result_page) {
				numberOfPages = Math.floor(allConcerns.length/concerns_per_result_page);
				var modOfDivision = allConcerns%concerns_per_result_page; 
				if(modOfDivision!= 0) {
					console.log("manually increase numberOfPages");
					numberOfPages++;
				}
			}
			
			console.log("calculated: "+numberOfPages+" pages for pagination");
						
			for(var c=1; c<numberOfPages; c++) {
				paginationTag+='<li class="pagination_link"><a href="#" id="pagination_'+c+'">'+(c+1)+'</a></li>';
			}
			
			for(var b=0; b<numberOfPages; b++) {
				$(classNameOfSearchResultDiv).append('<ul id="searchresult_'+b+'" style="display:none"></ul>');
			}
			
			for(var a=0; a<allConcerns.length; a++) {
				
				
				/*
				 * all variables needed for concern template:
				 */
				
				var concern_description="", concern_name="", concern_region="", concern_category="", 
				concern_platforms="", concern_date="", concern_Id="", concern_supports="";
				
				/*
				 * fill variables
				 */
				
				//process name & id:				
				concern_name = allConcerns[a].name;
				//	console.log("Found name: "+concern_name);
				concern_id = allConcerns[a].id;
				
				
				//process date:
				concern_date = new Date(allConcerns[a].createDate).toLocaleDateString();
				
				//process categories:
				concern_category = allConcerns[a].category;
				//		console.log("Found category: "+concern_category);
				var categories = concern_category.split(";");
				concern_category = "";
				
				for(var d=0; d<categories.length; d++) {
					if(categories[d].length>0) {
						var categoryId = categories[d].split("_")[1];
						//			console.log("enable category: "+categoryId+" for concern: "+concern_id);
						
						switch(categoryId) {
						
						case "1":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Bildung.png"> Bildung';
							break;
						case "2":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Familie.png"> Familie';
							break;
						case "3":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Gesundheit.png"> Gesundheit';
							break;
						case "4":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Nachrichten.png"> Nachrichten';
							break;
						case "5":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Lexika.png"> Lexika';
							break;
						case "6":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Verkehr.png"> Verkehr';
							break;
						case "7":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Politik.png"> Politik';
							break;
						case "8":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Organisation.png"> Organisation';
							break;
						case "9":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Tourismus.png"> Tourismus';
							break;
						case "10":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-2-Soziale-Netzwerke.png"> Soziale Netzwerke';
							break;
						case "11":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Sport.png"> Sport';
							break;
						case "12":
							concern_category+='<img src="/vepa-theme/images/vepa-icons/Themen/Icon-Wetter.png"> Wetter';
							break;							
						}
					}
				}
				
				
				//process regions:
				concern_region = allConcerns[a].region;
				//	console.log("Found region: "+concern_region);
				var regions = concern_region.split(";");
				concern_region="";
				
				for(var d=0; d<regions.length; d++) {
					if(regions[d].length>0) {
						var regionId = regions[d].split("_")[1];
						//			console.log("enable region: "+regionId+" for concern: "+concern_id);
						switch(regionId) {
						
						case "1":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Deutschland-Aktiv.png">Deutschland';
							break;
						case "2":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Baden-Wuerttemberg-Aktiv.png">Baden-W&uuml;rttemberg';
							break;
						case "3":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Bayern-Aktiv.png">Bayern';
							break;
						case "4":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Berlin-Aktiv.png">Berlin';
							break;
						case "5":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Brandenburg-Aktiv.png">Brandenburg';
							break;
						case "6":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Icon-Bremen-Aktiv.png">Bremen';
							break;
						case "7":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hamburg-Aktiv.png">Hamburg';
							break;
						case "8":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Hessen-Aktiv.png">Hessen';
							break;
						case "9":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Mecklenburg-Vorpommern-Aktiv.png">Mecklenburg-Vorpommern';
							break;
						case "10":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Niedersachsen-Aktiv.png">Niedersachsen';
							break;
						case "11":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Nordrhein-Westfalen-Aktiv.png">Nordrhein-Westfalen';
							break;
						case "12":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Rheinland-Pfalz-Aktiv.png">Rheinland-Pfalz';
							break;
						case "13":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Saarland-Aktiv.png">Saarland';
							break;
						case "14":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Aktiv.png">Sachsen';
							break;
						case "15":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Sachsen-Anhalt-Aktiv.png">Sachsen-Anhalt';
							break;
						case "16":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Schleswig-Holstein-Aktiv.png">Schleswig-Holstein';
							break;
						case "17":
							concern_region+='<img src="/vepa-theme/images/vepa-icons/Regionen/Wappen-Thueringen-Aktiv.png">Th&uuml;ringen';
							break;
							
						}
					}
				}
				
				
				//process platforms:
				concern_platforms = allConcerns[a].platforms;
				//	console.log("Found platforms: "+concern_platforms);
				var webapp='', android='', ios='', windows='';
				var platforms = concern_platforms.split(";");
				for(var d=0;d<platforms.length;d++) {
					if(platforms[d].length>0) {
						var platform = platforms[d].split("_")[1];
						//			console.log("enable platform: "+platform+" for concern: "+concern_id);
						switch(platform) {
						case "android":
							android = "-Aktiv";
							break;
						case "windows":
							windows = "-Aktiv";
							break;
						case "ios":
							ios = "-Aktiv";
							break;
						case "webapp":
							webapp = "-Aktiv";
						default:
							osTag='OS';
						break;
						}
					}
				}
				
				var template_variables = {webapp:webapp, android:android, apple:ios, windows:windows};
				concern_platforms = _.template( $("#os_template").html(), template_variables);
				
				
				//process description:
				concern_description = allConcerns[a].description;
				//	console.log("Found description: "+concern_description);
				if(concern_description.length<144) {
					concern_description_teaser=concern_description;
					concern_description="";
				} else {
					concern_description_teaser = concern_description.substring(0,144)+"...";
					concern_description = concern_description.substring(144, concern_description.length-1);
				}
				//		console.log("description teaser: "+concern_description_teaser);
				//		console.log("description: "+concern_description);
				

				concern_supports = allConcerns[a].supports;
				
				
				/*
				 * prepare template
				 */

				var template_variables = {concern_id:concern_id,
						concern_category:concern_category,
						concern_region:concern_region,
						concern_name:concern_name,
						concern_platforms:concern_platforms,
						concern_description: concern_description,
						concern_supports:concern_supports,
						concern_description_teaser : concern_description_teaser,
						concern_date:concern_date};
				
				/*
				 * get template
				 */
				
				var concernTag = _.template( $("#concern_template").html(), template_variables);
				
				/*
				 * append template tag to current list: therefor: calculate current index
				 * append tag
				 */
	
				var pageIndex = Math.floor(a / concerns_per_result_page);
				//console.log("current page index: "+pageIndex+" for index: "+a);
	
				$('#searchresult_'+pageIndex).append("<li>"+concernTag+"</li>");
				
				$('#socialmedia_'+concern_id).socialSharePrivacy({
					uri : $('#socialmedia_href_'+concern_id).val()
				});
	
			}
			
			for(var a=0; a<allConcerns.length; a++) {
				$('#concern_collapse_'+a).addClass("collapse");
			}
			
			$('#searchresult_0').css("display", "block");
			$('#hitCount').html(allConcerns.length);
			
			/*
			 * prepare pagination
			 */
			
			var lastPaginationIndex = 0;
			
			$('#searchresult_0').trigger("create");
			
			$(classNameOfPaginationDiv).append(paginationTag+'<li class="pagination_link"><a href="#" id="pagination_forward">Vor</a></li></ul></div>');
			
			/*
			 * configure control elements
			 */
			
			console.log("number of pages: "+numberOfPages);
			if(numberOfPages <= 1){ 
				console.log("disable pagination");
				$(classNameOfPaginationDiv).css("visibility", "hidden");
			} else {
				console.log("enable pagination, if disabled before");
				$(classNameOfPaginationDiv).css("visibility", "visible");
			}
			
			/*
			 * enable control elements
			 */
			
			
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
				
			
			
		} else {
			console.log("No concerns available!");
			$(classNameOfSearchResultDiv).addClass("span12").html('<div class="alert alert-info alert-block"><h4>Ihre Wunschlisten-Suche ergab keine Ergebnisse</h4></div>');
			$('#hitCount').html('0');
		}
		
		
		/*
		 * disable all support buttons for concerns already voted for
		 */
		
		var supportedConcernIds = getConcernIDsVotedFor();
		
		if(supportedConcernIds.length==0) {
			console.log("No concerns supported yet");
		}
		
		for(var p=0; p<supportedConcernIds.length; p++) {
			console.log("disabling support button for concern: "+supportedConcernIds[p]);
			$('#support_button_'+supportedConcernIds[p]).addClass("disabled");
	    	$('#support_button_'+supportedConcernIds[p]).html("Unterst&uuml;tzt");
	    	$('#support_button_'+supportedConcernIds[p]).attr("disabled", true);
		}
		
		/*
		 * add interaction logic
		 */
		

		
		$(".supportConcern").on(listenerAction, function(event) {
			
			
			
			if(!noCookiesAllowed()) {

				var votedConcernId = event.target.id.split("_")[2];
				
				var oldSupportCount = $('#support_'+votedConcernId).html();
				
				
				Liferay.Service(
						  '/Vepla-concern-Portlet-portlet#concern/support-concern',
						  {
						    concernId: votedConcernId
						  },
						  function(obj) {
							  console.log("Got result: "+obj);
						    if(""+obj=="true") {
						    	console.log("successfully supported App");
						    	oldSupportCount++;
						    	$('#support_'+votedConcernId).html(oldSupportCount);
						    	
						    	/*
						    	 * set cookie to prevent vote push and disable button
						    	 */
						    	
						    	addVotedConcernIdToCookie(votedConcernId);
						    	$('#support_button_'+votedConcernId).addClass("disabled");
						    	$('#support_button_'+votedConcernId).html("Unterst&uuml;tzt");
						    	$('#support_button_'+votedConcernId).attr("disabled", true);
						    	
						    } else {
						    	console.log("supporting concern triggered exception - check server");
						    }
						  }
				);
			} else {
				alert("Bitte aktivieren Sie Cookies in ihren Internet-Einstellungen");
			}
			
			
		});
		
		
		
		if(!noCookiesAllowed()) {
			//add filter mechanism
			
			if(!accessedBySmartphone()) {
				$('.filter_concernList').css("display","block");
				$('.filter_concernList a').unbind(listenerAction).click(function(event){
					
						
					
						loadingBarStartFilter();

						
						console.log("click on filter link..."+event.target.id);
						var filter_used = event.target.id.split("_")[1];
						var arrayForSort = [];
						var helper = [];
			
						if(filter_used=="likes") {
							if(lastToggledListFilter != filter_used) {
								//first call
								//get all Concerns freshly from server as they are already sorted
								getAllConcerns(true);
								resultOrderASCed = false;
							} else {
								//change ordering
								//get reversed List
								if(resultOrderASCed) {
									getAllConcerns(true);
									resultOrderASCed = false;
								} else {
									getAllConcerns(false);
									resultOrderASCed = true;
								}
							}
							
						} else {
							for(var x=0; x<allConcerns.length; x++) {
									
									var theFilterAttribute = "";
									switch(filter_used) {
									case "date":
										console.log("date filter clicked - order list by creation date");
										theFilterAttribute = allConcerns[x].createDate;
										helper.push(theFilterAttribute);
										sessionStorage.setItem(theFilterAttribute, x);
									break;
									case "name":
										console.log("name filter clicked - order list by name");
										theFilterAttribute = allConcerns[x].name.toLowerCase();
										helper.push(theFilterAttribute+"_"+allConcerns[x].id);
										sessionStorage.setItem(theFilterAttribute+"_"+allConcerns[x].id, x);
										break;
									}
									
															
									arrayForSort.push(allConcerns[x]);
									
							}
							
							if(searchResultFilterToggledCount == 0 ) {
								console.log("sorting array as first call:");
								helper = helper.sort();
							} else {
								if(filter_used!=lastToggledListFilter) {
									console.log("sorting array as new filter applied:");
									helper = helper.sort();	
								}
							}
							
							
							
							console.log("reversing array: "+helper.reverse());
							for(var x=0; x<allConcerns.length; x++) {
								allConcerns[x] = arrayForSort[sessionStorage.getItem(helper[x])];
							}
						}

							


						
						lastToggledListFilter = filter_used;
						searchResultFilterToggledCount++;
						loadingBarStopFilter();
						buildConcernList(allConcerns);
						
						loadingBarStopFilter();
				});
			}
		
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
		
		/*
		 * if concern content is collapsed, add hash-tag
		 */
		
		$('.concern_collapser').on("show", function(event) {
			console.log("add: "+event.target.id.split("_")[1]+" to hashtag");
			window.location.hash="#"+event.target.id.split("_")[1];
		});
		
		/*
		 * validate locationhash
		 */
	
		var locationHash = window.location.hash;
		if(locationHash.length>0) {
			locationHash = locationHash.substring(1,locationHash.length);
			var concernIdentifier ='#concern_'+locationHash; 
			console.log("try locating concern with id: "+concernIdentifier);
			
			if($(concernIdentifier).length>0) {
				//get id of respective searchresult
				var concernElement = $(concernIdentifier);
				var searchresultlistId = concernElement.parent().parent().id;
				console.log("concern with id: "+locationHash+" is on page: "+ searchresultlistId);
				if(searchresultlistId!="0") {
					$('#pagination_'+searchresultlistId).click();
				} 
				var accordionIdentifier = '#concern_desc_teaser_'+locationHash; 
				console.log("collapsing respective accordeon with id: "+accordionIdentifier)
				$(accordionIdentifier).click();
				$('html, body').animate({
					scrollTop: $(concernIdentifier).offset().top
				}, 1000);
			}
		} else {
			console.log("someone entered locationhash that has no related iD: "+locationHash);
		}
		
		
//		$('.concern_toggle')
			
		
		
		loadingBarStopFilter();
		
		
	}
	
	/*
	 * see w3schools.com
	 */
	
	function addVotedConcernIdToCookie(concernId) {
		
		if(getConcernIDsVotedFor().length>0) {
			var oldIds = $.cookie("votedIds");
			oldIds+=";"+concernId;
			$.cookie("votedIds", oldIds);
		} else {
			$.cookie("votedIds", ""+concernId);
		}
		
		console.log("new votedForConcernsList: "+$.cookie("votedIds"));

	}
	
	
	function getConcernIDsVotedFor() {
		stringOfVotedIds  = $.cookie("votedIds");
		if(stringOfVotedIds!=undefined) {
			console.log("current voted Ids: "+stringOfVotedIds);
			return stringOfVotedIds.split(";");
		} else {
			return new Array();
		}
		

	}
	
	
	
	function toggleReFilter(event) {
		
		console.log('filter changed!');
		console.log('event id: '+event.target.id);
		console.log('event Value: '+event.target.value);
		
		
		//if location.hash is set -> remove hash
		
		if(window.location.hash.length>0) {
			console.log("window location hash > 0; remove: "+window.location.hash+" to prevent scrolling");
			location.hash="";
		}
		
		
		
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
		
		filterApprovedConcerns(newFilterString);
	
	}
	
	function loadingBarStartFilter() {
	    if (overlayVisFilter == false) {
	           console.log("SHOWING Filter SPINNER");
	           $("#concernsPage").css("visibility","hidden");
	           $("#concernHeader").css("visibility","hidden");
	           $("#concernContainer").append("<div id='overlay_filter'><span class='center'> <img src='/vepa-theme/images/ajax-loader.gif'><br><br>Inhalte werden geladen ...</span></div>");
	           overlayVisFilter = true;
	    }
	}
	
	function loadingBarStopFilter() {
	    if (overlayVisFilter == true) {
	 	   	console.log("REMOVING Filter SPINNER");
	 	   	 $("#concernsPage").css("visibility","visible");
	 	   	 $("#concernHeader").css("visibility","visible");
	         $("#overlay_filter").remove();
	         if($("#concernsPage").css("visibility")!="visibible") {
	        	 $("#concernsPage").css("visibility", "visible");
	         }
	         if($("#concernHeader").css("visibility")!="visibible") {
	        	 $("#concernHeader").css("visibility", "visible");
	         }

	         overlayVisFilter = false;
	    }
	}
