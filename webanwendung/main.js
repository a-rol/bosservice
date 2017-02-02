
// @author Alexander Rolwes
// @since 07.12.2016

var map;
var slider_data;
var markerList = new L.FeatureGroup();
var bool_geojsonLayer = false, bool_markerList = false;


 jQuery(document).ready(function(){
	jQuery("#btn_polygon").prop('disabled', true);
	jQuery("#btn_delete").prop('disabled', true);
    jQuery(".slider").slider({
        max: 25,
        min: 5,
        step: 5,
        value: 0,
        change: function( event, ui ){
             slider_data = jQuery( ".slider" ).slider( "value" );
             // alert(slider_data);
        }
    })
    .slider("pips", {
        rest: "label",
        suffix: "Min.",
    });
    slider_data = jQuery( ".slider" ).slider( "value" ); //der Startwert wird der Variablen slider_number_last_dates hinzugefügt
    get_map();
    
    
    
    jQuery("#btn_information").click(function(){
        document.getElementById('modal_header_information').innerHTML = "<h4 class='modal-title'>Information zur Webanwendung</h4>";
        document.getElementById('modal_body_information').innerHTML =  "<div class='info_content'>Software Engineering Projekt der Hochschule Mainz - Semester 1 Master - WS 2016/2017<br><br>Verantwortlich für den Inhalt der Webseite:<br><br>Angelique Prüß, Sandro Mertens, Thomas Müller, Alexander Rolwes<br>Anfragen bitte an info@bos-erreichbarkeitsanalyse.de</div>";
        jQuery("#modal_information").modal();
    });
    
    jQuery("#btn_search").click(function(){
        
        var search_data = jQuery("#form_adress").val();
        var url_geocoder = "http://localhost:8080/pubapp/geocoder";
       
        jQuery.ajax({
            type: 'GET',
            dataType: 'jsonp',
            url: url_geocoder,
            crossDomain : true,
            data: 'queryString='+search_data+'&locale=de',
            xhrFields: { withCredentials: true},
            success: function(data_geocoder){
				if (data_geocoder.features.length > 0){
					long_mapcenter = data_geocoder.features[0].geometry.coordinates[0];
					lat_mapcenter = data_geocoder.features[0].geometry.coordinates[1];
                
					map.setView(new L.LatLng(lat_mapcenter, long_mapcenter), 10);
				}else{
					document.getElementById('modal_header_alert').innerHTML = "<h4 class='modal-title'>Achtung!</h4>";
					document.getElementById('modal_body_alert').innerHTML =  "<div class='info_content'>Die von Ihnen eingegeben Adresse ist fehlerhaft. Es konnte kein passender Ort zugeordnet werden. Bitte verändern Sie Ihren Eingabe und führen Sie eine erneute Suchanfrage durch.</div>";
					jQuery("#modal_alert").modal();
				}    
            }
        })
    });
    
    jQuery("#btn_bos").click(function(){
		
        var url_bos_standorte = "http://localhost:8050/overpassAPI";     //Adresse des MicroServices
        var query_intrest = "fire_station";
        
		if (bool_geojsonLayer == true){
			geojsonLayer.clearLayers();
		};
		if (bool_markerList == true){
			markerList.clearLayers();
		};
		
        var east_koord = map.getBounds().getEast();
        var west_koord = map.getBounds().getWest();
        var south_koord = map.getBounds().getSouth();
        var north_koord = map.getBounds().getNorth();
		
		jQuery.ajax({
			timeout: 15000,
            type: 'GET',           		 //Übergabetyp: Get
            dataType: 'jsonp',           //Übergabe erfolgt im jsonp-Format
            url: url_bos_standorte,      //Adresse des MicroServices (oben)
            crossDomain: true,           //damit er auch auf andere Server zugreifen kann
            data: 'interest='+query_intrest+'&south='+south_koord+'&west='+west_koord+'&north='+north_koord+'&east='+east_koord+'',
            xhrFields: {withCredentials: true},
            success: function(data_point){    //Ergebnisverarbeitung
                 var data_point =  JSON.parse(data_point);	
				 if (data_point.features.length > 0){
					var fireIcon = L.icon({
					iconUrl: 'marker/firetruck.svg',
					iconSize:     [38, 38], // size of the icon
					// shadowSize:   [0, 0], // size of the shadow
					iconAnchor:   [19, 19], // point of the icon which will correspond to marker's location
					// shadowAnchor: [4, 62],  // the same for the shadow
					// popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
					});
					for (var coord in data_point.features){
						long_fire = data_point.features[coord].geometry.coordinates[0];
						lat_fire = data_point.features[coord].geometry.coordinates[1];
						var marker = new L.marker([lat_fire, long_fire],{icon: fireIcon});
						markerList.addLayer(marker);
					}
					map.addLayer(markerList); 
					bool_markerList = true;
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
        var query_poly = create_obj_poly();
    
        var url_isochrone = "http://localhost:8085/isochrone";
        
		if (bool_geojsonLayer == true){
			geojsonLayer.clearLayers();
		};
        jQuery.ajax({
			timeout: 15000,
			type: 'POST',
			headers: { 
				'Accept': 'application/json',
				'Content-Type': 'application/json', 
			},
			dataType: 'json',
			url: url_isochrone,
			crossDomain : true,
			data: query_poly,
			success: function(data_poly){
				// console.log(JSON.stringify(data_poly));
				// alert(data_poly);
				// if (JSON.stringify(data_poly).length == 0){
					// alert("nooothing");
				// }else if (data_poly == "error"){
					// alert("error");
				// }else{
					geojsonLayer = L.geoJson(data_poly).addTo(map);
					bool_geojsonLayer = true;
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
        markerList.clearLayers();
		jQuery("#btn_polygon").prop('disabled', true);
		jQuery("#btn_delete").prop('disabled', true);
		if (bool_geojsonLayer == true){
			geojsonLayer.clearLayers();
		}
    });
    
    map.on('zoomend', function() {
        //alert(map.getZoom());
    });
});	

function get_map(){
    map = L.map('map', {
        center: [51.5, 9.75],
        zoom: 6,
        minZoom: 6
    });
    L.tileLayer('http://{s}.tiles.wmflabs.org/bw-mapnik/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors | &copy; SEng Gruppe 1'
    }).addTo(map);
}

function create_obj_poly(){
    var obj = new Object();
    obj.timelimit = slider_data;
    bos = [];
    var i = 0;
    for (var fire_marker in markerList._layers){
        if (fire_marker._latlng !== null) {
			var latitude = markerList._layers[fire_marker]._latlng.lat;
			var longitude = markerList._layers[fire_marker]._latlng.lng;
			
			// prüfen ob die koordinaten der marker im map rechteck sind 	
			if(map.getBounds().contains([parseFloat(latitude), parseFloat(longitude)]) == true){
				bos_item = {};
				coord_item = {};
				coord_item['lat'] = latitude;
				coord_item['lng'] = longitude;
				bos_item = coord_item;
				bos.push(bos_item);
				i++;
			}else{
				map.removeLayer(markerList._layers[fire_marker]);
			}
        }
    };
    obj.bos = bos;
    var jsonString = JSON.stringify(obj);
    return jsonString;
}