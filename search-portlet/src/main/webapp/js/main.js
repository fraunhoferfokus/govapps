/*
 * #%L
 * govapps_search
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

		/*
		 * global vars
		 */
$('#searchform1x1').css("visibility", "visible");
$('#mainnav').css("visibility", "visible");

var fixedEntitlementString = "entitlement_1;entitlement_2;entitlement_3;entitlement_4;entitlement_5;entitlement_6;"; 

$(document).ready(function() {
		var apps = new Array();
		var typeoarray = new Array();
		var uniqueArray = new Array(); 
		var wsurl = "/VmAmG-portlet/api/jsonws/";
		
		
		// write to typeahead array 	
			if(sessionStorage.getItem("allAppNames") != null) {
				
					var typoobj = JSON.parse(sessionStorage.getItem(["allAppNames"]));
				    console.log("------------------get all App names from the space :" + typoobj);
					for(var i=0; i<typoobj.length; i++) {
						typeoarray.push(typoobj[i]);
						uniqueArray.push(typoobj[i]);
					}
				
			} else  { 
				Liferay.Service(
						  '/VmAmG-portlet#application/get-all-application-names',
						  function(obj) {
								for (var i = 0; i < obj.length; i++) {		
									apps.push(obj[i].toString());
								}
						    	var tmparray = unique(apps);	
						    	for(i = 0; i<tmparray.length; i++) {
						    		uniqueArray.push(tmparray[i]);
						    		typeoarray.push(tmparray[i]);
						    	}
						  }
				);
			
				
			}

			
		
		
		$('#toggle_extrasearch_mobile').on('touchend',function(event) {
		    event.preventDefault();
//		    $('#toggle_extrasearch_mobile').click();
		});
		
		noCookiesAllowed();
		
		if(!noCookiesAllowed()) {
			if(localStorage["localStoragePrepared"]!="true") {
								
				$.ajax({
					'url': wsurl + "entitlement/get-regions-categories-entitlements/company-id/10154",
					async:false,
					success: function(result) {
						var obj = typeof JSON !='undefined' ?  JSON.parse(result) : eval('('+result+')');
						for(var i=0; i<obj[0].length; i++) {
							$('#setRegions2012').append("<option value='region_"+obj[0][i].regionId+"'>"+ obj[0][i].name + "</option>");
							$('#ddRegions').append("<option value='region_"+obj[0][i].regionId+"'>"+ obj[0][i].name + "</option>");
						}
						for(var i=0; i<obj[1].length; i++) {
							$('#setCategories2012').append("<option value='category_"+obj[1][i].categoryId+"'>"+ obj[1][i].categoryName + "</option>");
							$('#ddCategories').append("<option value='category_"+obj[1][i].categoryId+"'>"+ obj[1][i].categoryName + "</option>");	
						}
						
						for(var i=0; i<obj[2].length; i++) {
			//				$('#setEntitlements2012').append("<option selected='true' value='entitlement_"+obj[2][i].entitlementId+"'>"+ obj[2][i].entitlementName + "</option>");
							uniqueArray.push(obj[2][i].entitlementName);
						}
						
						uniqueArray.concat(unique(obj[0]));
						uniqueArray.concat(unique(obj[1]));
						uniqueArray.concat(unique(obj[2]));	
						localStorage.setItem("allCategories", JSON.stringify(obj[1]));
						localStorage.setItem("allEntitlements", JSON.stringify(obj[2]));
						localStorage.setItem("allRegions", JSON.stringify(obj[0]));
							
						localStorage.setItem("localStoragePrepared", "true");
						localStoragePrepared = true;
					},
					error: function(jqXHR, textStatus, errorThrown) {
						console.log("suche-portlet, error textStatus: "+textStatus);
						console.log("suche-portlet, error errorThrown: "+errorThrown);
						location.href="/fehler";
					}
				});
					
			} else {
				console.log("vepa-suche-Portlet: regions / categories / entitlements are loaded, no ajax!");
				var obj = JSON.parse(localStorage["allRegions"]);
				for(var i=0; i<obj.length; i++) {
					$('#setRegions2012').append("<option value='region_"+obj[i].regionId+"'>"+ obj[i].name + "</option>");
					$('#ddRegions').append("<option value='region_"+obj[i].regionId+"'>"+ obj[i].name + "</option>");
					uniqueArray.push(obj[i].name);
				}
				
							
				obj = JSON.parse(localStorage["allCategories"]);
				for(var i=0; i<obj.length; i++) {
					$('#setCategories2012').append("<option value='category_"+obj[i].categoryId+"'>"+ obj[i].categoryName + "</option>");
					$('#ddCategories').append("<option value='category_"+obj[i].categoryId+"'>"+ obj[i].categoryName + "</option>");
					uniqueArray.push(obj[i].categoryName);
				}
				
						
		//		obj = JSON.parse(localStorage["allEntitlements"]);
	//
					for(var i=0; i<obj.length; i++) {
	//					$('#setEntitlements2012').append("<option selected='true' value='entitlement_"+obj[i].entitlementId+"'>"+ obj[i].entitlementName + "</option>");
						uniqueArray.push(obj[i].entitlementName);
					}
						
			}
		} else {
			console.log("vepa-suche-Portlet: regions / categories / entitlements are loaded, with ajax!");
			
			$.ajax({
				'url': wsurl + "entitlement/get-regions-categories-entitlements/company-id/10154",
				async:false,
				success: function(result) {
					var obj = typeof JSON !='undefined' ?  JSON.parse(result) : eval('('+result+')');
					for(var i=0; i<obj[0].length; i++) {
						$('#setRegions2012').append("<option value='region_"+obj[0][i].regionId+"'>"+ obj[0][i].name + "</option>");
						$('#ddRegions').append("<option value='region_"+obj[0][i].regionId+"'>"+ obj[0][i].name + "</option>");
					}
					for(var i=0; i<obj[1].length; i++) {
						$('#setCategories2012').append("<option value='category_"+obj[1][i].categoryId+"'>"+ obj[1][i].categoryName + "</option>");
						$('#ddCategories').append("<option value='category_"+obj[1][i].categoryId+"'>"+ obj[1][i].categoryName + "</option>");	
					}
					
					for(var i=0; i<obj[2].length; i++) {
	//					$('#setEntitlements2012').append("<option selected='true' value='entitlement_"+obj[2][i].entitlementId+"'>"+ obj[2][i].entitlementName + "</option>");
						uniqueArray.push(obj[2][i].entitlementName);
					}
					
					uniqueArray.concat(unique(obj[0]));
					uniqueArray.concat(unique(obj[1]));
					uniqueArray.concat(unique(obj[2]));	

				},
				error: function(jqXHR, textStatus, errorThrown) {
					location.href="/fehler";
				}
			});
		}

		
		
		if(accessedBySmartphone()) {
			$('#advsearchbtn').css("display","none");
		}
		
		/*
		 * Render MultiBoxes now!
		 */
		
		if(!accessedByMobileTouchDevice()) { 
			$(".multiselect_touch_filter option[value='--null--']").remove();
			$("#ddPlattform option[value='--null--'],#ddRegions option[value='--null--'],#ddCategories option[value='--null--']").remove();
			$("#setPlattform2012 option[value='--null--'],#setRegions2012 option[value='--null--'],#setCategories2012 option[value='--null--']").remove();
			
			$("#setPlattform2012").multiselect({
			      noneSelectedText: 'Plattformen',
			      selectedText: "Plattformen"
			       });
			
			$("#setRegions2012").multiselect({
			      noneSelectedText: 'Regionen',
			    	  selectedText: "Regionen"
			       });
			
			$("#setCategories2012").multiselect({
				      noneSelectedText: 'Themen',
				    	  selectedText: "Themen"
				       });
			
			
			$("#ddRegions").multiselect({
				   multiple: false,
				   width: "100%",
				   noneSelectedText: "Regionen",
				   selectedText: "Regionen"
				});
			
			$("#ddCategories").multiselect({
				   multiple: false,
				   width: "100%",
				   noneSelectedText: "Themen",
				   selectedText: "Themen"
				});
			
			$("#ddPlattform").multiselect({
				   multiple: false,
				   width: "100%",
				   noneSelectedText: "Plattformen",
				   selectedText: "Plattformen"
				});
			
			
		}
		else {
				$("#ddPlattform option[value='--null--'],#ddRegions option[value='--null--'],#ddCategories option[value='--null--']").attr("disabled", true);
				$("#sePlattform2012 option[value='--null--'],#setRegions2012 option[value='--null--'],#setCategories2012 option[value='--null--']").attr("disabled", true);
				
		}
	
		
		
		$(".searchprice input:checkbox").change(function() {
		    $(".searchprice input:checkbox").attr("checked", false);
		    $(this).attr("checked", true);
		});
		
		$('button[type=reset] ').click(function(e) {
			$('#advsearch.collapse').collapse('toggle');
			$('#advsearch input:checkbox').removeAttr('checked');
			$('#advsearch').removeAttr('selected');
		});
		
/* Fire top inputfields */		
		
	$("#ddCategories").change(function(event) {
		document.getElementById('filter').value = fixedEntitlementString + $('#ddCategories').val();
		document.setFilter.submit();

	});
	$("#ddRegions").change(function(event) {
		document.getElementById('filter').value = fixedEntitlementString + $('#ddRegions').val();
		document.setFilter.submit();

	});
	
	$("#ddPlattform").change(function(event) {
		document.getElementById('filter').value = fixedEntitlementString + $('#ddPlattform').val();
		document.setFilter.submit();

	});
	
/* typeahead */
		
		$('#searchStr2').typeahead({
		    source: function(typeahead, query){
		    	return(typeoarray);
		    },
		    property: 'name',
		    items:11,
		    updater: function (obj) {
		    	console.log("HIGHLITHER: "+ obj);
		    	sendForm1(obj);
		    }
		   
		});
		
/* Type in search */	
		
		$('#searchStr2').keydown(function(event) {
			if(event.keyCode==13) {
				var search = $("ul.typeahead.dropdown-menu").find('li.active').data('value'); 
				sendForm1(search);
			}
		});
		
	});	

	function sendForm1(obj) {
		
		var checked123 ="";
		var checked456 ="";
		var checked789 ="";
		var checkedOD = "";
				 $('#advsearch :selected').each(function(i, selected) {
					 checked123 = checked123.concat($(selected).val()+ ";");
		            });
				 $('.searchios :checked').each(function() {
					 checked456 = checked456.concat($(this).val()+ ";");
		            });
				 $('.searchprice :checked').each(function() {
					 checked789 = checked789.concat($(this).val()+ ";");
		            });
				 $('.searchopendata :checked').each(function() {
					 checkedOD = checkedOD.concat($(this).val());
		          });
				 
			checked123 = checked123.concat(checked456);
			checked123 = checked123.concat(checked789);
			checked123 = checked123.concat(checkedOD);
			checked123 = checked123.concat(fixedEntitlementString);
			
			document.getElementById('filter').value = checked123;
		
			if(obj==undefined || obj.length==0) {
				document.getElementById('searchStr').value = document.getElementById('searchStr2').value;
			} else {
				document.getElementById('searchStr').value = obj;
			}
			document.setFilter.submit();	 
		}

/* Make typeahead unique */
	
		function unique(origArr) {
		    var newArr = [],
		        origLen = origArr.length,
		        found,
		        x, y;
		  
		    for ( x = 0; x < origLen; x++ ) {
		        found = undefined;
		        for ( y = 0; y < newArr.length; y++ ) {
		            if ( origArr[x] === newArr[y] ) {
		              found = true;
		              break;
		            }
		        }
		        if ( !found) newArr.push( origArr[x] );
		        
		    }
		    sessionStorage.setItem("allAppNames",JSON.stringify(newArr));
		   return newArr;
		};
		


		

