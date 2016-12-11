
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
		alert("Hier kommt die Verknüpfung zum Geocoder.");
    });
	
	jQuery("#btn_bos").click(function(){

		var fireIcon = L.icon({
			iconUrl: 'marker/firetruck.svg',
			iconSize:     [38, 95], // size of the icon
			shadowSize:   [50, 64], // size of the shadow
			iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
			shadowAnchor: [4, 62],  // the same for the shadow
			popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
		});
	
		var marker = new L.marker([51.289, 9.42626],{icon: fireIcon});
		var marker2 = new L.marker([50.889, 9.82626],{icon: fireIcon});
		markerList.addLayer(marker);
		markerList.addLayer(marker2);
		map.addLayer(markerList);
		
    });
	
	jQuery("#btn_polygon").click(function(){
		alert("poly");
		// Hier kommt Polygon erzeugen mit Anfrage an den Graphhopper MS
    });
	
	jQuery("#btn_delete").click(function(){
        markerList.clearLayers();
		// Hier kommt noch Polygon löschen  
    });
	
	map.on('moveend', function() {
		alert(map.getBounds().getEast());
		
		// prüfen ob die koord im map rechteck ist für big chart
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







