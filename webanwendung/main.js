
var map;
var slider_data;

	
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
	
	jQuery("#btn_bos").click(function(){
		
			var firstGroup = L.layerGroup([
                L.marker([51.289, 9.42626]),
                L.marker([50.889, 9.82626]),
            ]).addTo(map);
			
          
		
    });
	
	jQuery("#btn_polygon").click(function(){
		alert("poly");
    });
	
	jQuery("#btn_delete").click(function(){
		  if (map.hasLayer(firstGroup)) {
            map.removeLayer(firstGroup);
          } 
    });
	
	map.on('moveend', function() {
		
	});
		
});	
	
	
function get_map(){
	map = L.map('map', {
		center: [51.5, 9.75],
		zoom: 6
    });
    L.tileLayer('http://{s}.tiles.wmflabs.org/bw-mapnik/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors | &copy; SEng Gruppe 1'
    }).addTo(map);
	

}







