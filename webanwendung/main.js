
var map;
var slider_data;
var markerList = new L.FeatureGroup();



 jQuery(document).ready(function(){

	jQuery(".slider").slider({
		max: 25,
		min: 5,
		step: 5,
		value: 0,
		change: function( event, ui ) {
			slider_data = jQuery( ".slider" ).slider( "value" );
			// alert(slider_data);
		}
		
	})	
	.slider("pips", {
        rest: "label",
		suffix: " Min.",
    });
	slider_data = jQuery( ".slider" ).slider( "value" ); //der Startwert wird der Variablen slider_number_last_dates hinzugefügt
	// alert(slider_data);
	// Karte anzeigen lassen
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
				long_mapcenter = data_geocoder.features[0].geometry.coordinates[0];
				lat_mapcenter = data_geocoder.features[0].geometry.coordinates[1];
				map.setView(new L.LatLng(lat_mapcenter, long_mapcenter), 10);
			}
		})
		// .done(function( data ) {
			// console.log("done");
			// console.log(data);
		// })
		// .fail( function(xhr, textStatus, errorThrown) {
			// console.log(xhr);
			// alert(textStatus);
		// });	
    });
	
	
	jQuery("#btn_bos").click(function(){

		// var search_data = ;
		// var url_bos_standorte = "http://............";
		
	
		var fireIcon = L.icon({
			iconUrl: 'marker/firetruck.svg',
			iconSize:     [38, 95], // size of the icon
			shadowSize:   [50, 64], // size of the shadow
			iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
			shadowAnchor: [4, 62],  // the same for the shadow
			popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
		});
	
		var marker = new L.marker([51.289, 9.42626],{icon: fireIcon});
		var marker2 = new L.marker([50.789, 9.82626],{icon: fireIcon});
		markerList.addLayer(marker);
		markerList.addLayer(marker2);
		map.addLayer(markerList);
    });
	
	
	jQuery("#btn_polygon").click(function(){
		var query_poly = create_obj_poly();
	
		var url_isochrone = "http://localhost:8085/isochrone";
		
		jQuery.ajax({
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
				console.log(JSON.stringify(data_poly));
				geojsonLayer = L.geoJson(data_poly).addTo(map);
			}
		})		
    });
	
	
	jQuery("#btn_delete").click(function(){
        markerList.clearLayers();
		geojsonLayer.clearLayers();
    });
	
	map.on('moveend', function() {
		map_east = map.getBounds().getEast();

		
		// prüfen ob die koord im map rechteck ist 
		// if(map.getBounds().contains([parseFloat(latitude), parseFloat(longitude)]) == true){
			// Hier kommt die prüfung rein!
		// }
	});
	
	
	map.on('zoomend', function() {
		alert(map.getZoom());
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
				bos_item = {};
				
				coord_item = {};
				
				coord_item['lat'] = markerList._layers[fire_marker]._latlng.lat;
				coord_item['lng'] = markerList._layers[fire_marker]._latlng.lng;
				
				bos_item = coord_item;
				
				bos.push(bos_item);
		
				i++;
			}
			
		};
		
		obj.bos = bos;

	var jsonString = JSON.stringify(obj);
	return jsonString;
}
