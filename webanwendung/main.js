
// @author Alexander Rolwes
// @since 07.12.2016

var map;
var sliderData;
var bosMarkerList = new L.FeatureGroup();
var boolGeojsonErreichbarkeitspolygon = false, boolBosMarkerList = false;


 jQuery(document).ready(function(){
	jQuery("#btn_polygon").prop('disabled', true);
	jQuery("#btn_delete").prop('disabled', true);
    jQuery(".slider").slider({
        max: 25,
        min: 5,
        step: 5,
        value: 0,
        change: function(event, ui){
             sliderData = jQuery(".slider").slider("value");
        }
    })
    .slider("pips", {
        rest: "label",
        suffix: "Min.",
    });
    sliderData = jQuery(".slider").slider("value"); //der Startwert wird der Variablen slider_number_last_dates hinzugefügt
    getMap();
    
    
    
    jQuery("#btn_information").click(function(){
        document.getElementById('modal_header_information').innerHTML = "<h4 class='modal-title'>Information zur Webanwendung</h4>";
        document.getElementById('modal_body_information').innerHTML =  "<div class='info_content'>Software Engineering Projekt der Hochschule Mainz - Semester 1 Master - WS 2016/2017<br><br>Verantwortlich für den Inhalt der Webseite:<br><br>Angelique Prüß, Sandro Mertens, Thomas Müller, Alexander Rolwes<br>Anfragen bitte an info@bos-erreichbarkeitsanalyse.de</div>";
        jQuery("#modal_information").modal();
    });
    
    jQuery("#btn_search").click(function(){
        
        var searchData = jQuery("#form_adress").val();
        var urlGeocoder = "http://143.93.114.139/geocoder";
       
        jQuery.ajax({
            type: 'GET',
            dataType: 'jsonp',
            url: urlGeocoder,
            crossDomain : true,
            data: 'queryString='+searchData+'&locale=de',
            xhrFields: {withCredentials: true},
            success: function(dataGeocoder){
				if (dataGeocoder.features.length > 0){
					longMapcenter = dataGeocoder.features[0].geometry.coordinates[0];
					latMapcenter = dataGeocoder.features[0].geometry.coordinates[1];
                
					map.setView(new L.LatLng(latMapcenter, longMapcenter), 10);
				}else{
					document.getElementById('modal_header_alert').innerHTML = "<h4 class='modal-title'>Achtung!</h4>";
					document.getElementById('modal_body_alert').innerHTML =  "<div class='info_content'>Die von Ihnen eingegeben Adresse ist fehlerhaft. Es konnte kein passender Ort zugeordnet werden. Bitte verändern Sie Ihren Eingabe und führen Sie eine erneute Suchanfrage durch.</div>";
					jQuery("#modal_alert").modal();
				}    
            }
        })
    });
    
    jQuery("#btn_bos").click(function(){
		
        var urlBosStandorte = "http://143.93.114.120/overpassAPI";     //Adresse des MicroServices
        var queryIntrest = "fire_station";
        
		if (boolGeojsonErreichbarkeitspolygon == true){
			geojsonErreichbarkeitspolygon.clearLayers();
		};
		if (boolBosMarkerList == true){
			bosMarkerList.clearLayers();
		};
		
        var eastKoord = map.getBounds().getEast();
        var westKoord = map.getBounds().getWest();
        var southKoord = map.getBounds().getSouth();
        var northKoord = map.getBounds().getNorth();
		
		jQuery.ajax({
			timeout: 15000,
            type: 'GET',           		 //Übergabetyp: Get
            dataType: 'jsonp',           //Übergabe erfolgt im jsonp-Format
            url: urlBosStandorte,      //Adresse des MicroServices (oben)
            crossDomain: true,           //damit er auch auf andere Server zugreifen kann
            data: 'interest='+queryIntrest+'&south='+southKoord+'&west='+westKoord+'&north='+northKoord+'&east='+eastKoord+'',
            xhrFields: {withCredentials: true},
            success: function(dataPoint){    //Ergebnisverarbeitung
                 var dataPoint =  JSON.parse(dataPoint);	
				 if (dataPoint.features.length > 0){
					var fireIcon = L.icon({
					iconUrl: 'marker/firetruck.svg',
					iconSize:     [38, 38], // size of the icon
					// shadowSize:   [0, 0], // size of the shadow
					iconAnchor:   [19, 19], // point of the icon which will correspond to marker's location
					// shadowAnchor: [4, 62],  // the same for the shadow
					// popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
					});
					for (var coord in dataPoint.features){
						var longFireStation = dataPoint.features[coord].geometry.coordinates[0];
						var latFireStation = dataPoint.features[coord].geometry.coordinates[1];
						var marker = new L.marker([latFireStation, longFireStation],{icon: fireIcon});
						bosMarkerList.addLayer(marker);
					}
					map.addLayer(bosMarkerList); 
					boolBosMarkerList = true;
					jQuery("#btn_polygon").prop('disabled', false);
					jQuery("#btn_delete").prop('disabled', false);
				}else{
					document.getElementById('modal_header_alert').innerHTML = "<h4 class='modal-title'>Achtung!</h4>";
					document.getElementById('modal_body_alert').innerHTML =  "<div class='info_content'>In dem von Ihnen ausgewählten Bereich stehen keine BOS-Standorte zur Verfügung. Bitte verändern Sie Ihren Kartenausschnitt und führen Sie eine erneute Suchanfrage durch.</div>";
					jQuery("#modal_alert").modal();
				}	 	 
            },
			error: function(){
				document.getElementById('modal_header_alert').innerHTML = "<h4 class='modal-title'>Achtung! Die maximale Wartezeit wurde überschritten!</h4>";
				document.getElementById('modal_body_alert').innerHTML =  "<div class='info_content'>In dem von Ihnen ausgewählten Bereich stehen eine Vielzahl an BOS-Standorte zur Verfügung. Bitte verkleinern Sie Ihren Kartenausschnitt und führen Sie eine erneute Suchanfrage durch.</div>";
				jQuery("#modal_alert").modal();
			}
       })
    });

    jQuery("#btn_polygon").click(function(){
        var queryPoly = createObjPoly();
    
        var urlIsochrone = "http://143.93.114.120/isochrone";
        
		if (boolGeojsonErreichbarkeitspolygon == true){
			geojsonErreichbarkeitspolygon.clearLayers();
		};
        jQuery.ajax({
			timeout: 15000,
			type: 'POST',
			headers: { 
				'Accept': 'application/json',
				'Content-Type': 'application/json', 
			},
			dataType: 'json',
			url: urlIsochrone,
			crossDomain : true,
			data: queryPoly,
			success: function(dataPoly){
				// console.log(JSON.stringify(dataPoly));
				// alert(dataPoly);
				// if (JSON.stringify(dataPoly).length == 0){
					// alert("nooothing");
				// }else if (dataPoly == "error"){
					// alert("error");
				// }else{ 
					var geojsonErreichbarkeitspolygon = L.geoJson(dataPoly).addTo(map);
					boolGeojsonErreichbarkeitspolygon = true;
				// }
			},
			error: function(){
				document.getElementById('modal_header_alert').innerHTML = "<h4 class='modal-title'>Achtung! Die maximale Wartezeit wurde überschritten!</h4>";
				document.getElementById('modal_body_alert').innerHTML =  "<div class='info_content'>In dem von Ihnen ausgewählten Bereich stehen eine Vielzahl an BOS-Standorte zur Verfügung. Eine Abfrage des Erreichbarkeitspolygons kann nicht ausgeführt werden. <br>Bitte verkleinern Sie Ihren Kartenausschnitt oder verändern Sie ihre Zeitliche Hilfsfrist und führen Sie eine erneute Suchanfrage durch.</div>";
				jQuery("#modal_alert").modal();
			}
        })   
    });
    
    jQuery("#btn_delete").click(function(){
        bosMarkerList.clearLayers();
		jQuery("#btn_polygon").prop('disabled', true);
		jQuery("#btn_delete").prop('disabled', true);
		if (boolGeojsonErreichbarkeitspolygon == true){
			geojsonErreichbarkeitspolygon.clearLayers();
		}
    });
});	

function getMap(){
    map = L.map('map', {
        center: [51.5, 9.75],
        zoom: 6,
        minZoom: 6
    });
    L.tileLayer('http://{s}.tiles.wmflabs.org/bw-mapnik/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors | &copy; SEng Gruppe 1'
    }).addTo(map);
}

function createObjPoly(){
    var obj = new Object();
    obj.timelimit = sliderData;
    bos = [];
    var i = 0;
    for (var fireMarker in bosMarkerList._layers){
        if (fireMarker._latlng !== null) {
			var latitude = bosMarkerList._layers[fireMarker]._latlng.lat;
			var longitude = bosMarkerList._layers[fireMarker]._latlng.lng;
			
			// prüfen ob die koordinaten der marker im map rechteck sind 	
			if(map.getBounds().contains([parseFloat(latitude), parseFloat(longitude)]) == true){
				var bosItem = {};
				var coordItem = {};
				coordItem['lat'] = latitude;
				coordItem['lng'] = longitude;
				bosItem = coordItem;
				bos.push(bosItem);
				i++;
			}else{
				map.removeLayer(bosMarkerList._layers[fireMarker]);
			}
        }
    };
    obj.bos = bos;
    var jsonString = JSON.stringify(obj);
    return jsonString;
}