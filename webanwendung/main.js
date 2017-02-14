
// @author Alexander Rolwes
// @since 07.12.2016


//****************************************
// GLOBALE VARIABLEN
//****************************************

var map;
var sliderData;
var bosMarkerList = new L.FeatureGroup();
var geojsonErreichbarkeitspolygon;
var boolGeojsonErreichbarkeitspolygon = false, boolBosMarkerList = false;
	
	
//****************************************
// FUNKTIONASAUFRUF WENN DOKUMENT VOLLSTÄNDIG GELADEN IST
//****************************************

jQuery(document).ready(function(){
	jQuery("#btnPolygon").prop('disabled', true);	// Button "Polygon berechnen" bei Anwendungsaufruf nicht auswaehlbar
	jQuery("#btnDelete").prop('disabled', true);	// Button "Daten loeschen" bei Anwendungsaufruf nicht auswaehlbar
    jQuery(".slider").slider({						// Slider Einstellungen
        max: 25,
        min: 5,
        step: 5,
        value: 0,
        change: function(event, ui){							// Reaktion, wenn sich die Value des Sliders veraendert
             sliderData = jQuery(".slider").slider("value");	// Slider-Value	in globale Variable sliderData schreiben
        }
    })
    .slider("pips", {
        rest: "label",
    });
    sliderData = jQuery(".slider").slider("value"); // der Startwert wird der Variablen sliderData hinzugefuegt
    getMap();  										// Funktionsaufruf getMap()
    
	// REAKTION BEI KLICK AUF DEN BUTTON "Information"
    jQuery("#btnInformation").click(function(){ 
        document.getElementById('modalHeaderInformation').innerHTML = "<h4 class='modal-title'>Information zur Webanwendung</h4>";
        document.getElementById('modalBodyInformation').innerHTML =  "<div>Software Engineering Projekt der Hochschule Mainz - Semester 1 Master - WS 2016/2017<br><br>Verantwortlich für den Inhalt der Webseite:<br><br>Angelique Prüß, Sandro Mertens, Thomas Müller, Alexander Rolwes<br>Anfragen bitte an angelique.pruess@students.hs-mainz.de</div>";
        jQuery("#modalInformation").modal();		// Aufruf des Bootstrap Modals
    });   
	
	// REAKTION BEI KLICK AUF DEN BUTTON "Adresse suchen"
    jQuery("#btnSearch").click(function(){ 				
        var searchData = jQuery("#formAdress").val(); 	// Auslesen des Formulars
		displayProgressBar();							// Ladebalken starten
		if (searchData.length > 0){						// Kommunikation mit dem Geocode MicroService nur wenn das Formular gefuellt ist
			var urlGeocoder = "http://143.93.114.139/geocoder";	//Adresse des MicroServices
			jQuery.ajax({
				type: 'GET',									// Übergabetyp: Get
				dataType: 'jsonp',								// Übergabe erfolgt im jsonp-Format
				url: urlGeocoder,								// Adresse des MicroServices
				crossDomain : true,								// Erlaubt Zugriff auf andere Server (cross origin)
				data: 'queryString='+searchData+'&locale=de',	// Daten welche in der AJAX Abfrage an den MicroService uebergeben werden sollen
				xhrFields: {withCredentials: true},
				success: function(dataGeocoder){				// Durchfuehrung im Erfolgsfall 
					closeProgressBar();							// Ladebalken schliessen
					if (dataGeocoder.features.length > 0 && searchData !=""){
						// die als Ergebnis zurueckgegebenen Daten verarbeiten und mit der Karte in den gesuchten Bereich zoomen
						longMapcenter = dataGeocoder.features[0].geometry.coordinates[0];
						latMapcenter = dataGeocoder.features[0].geometry.coordinates[1];
						map.setView(new L.LatLng(latMapcenter, longMapcenter), 12);
					}else{
						// Fehlermeldung falls keine Adresse zur Eingabe gefunden wurde
						document.getElementById('modalHeaderAlert').innerHTML = "<h4 class='modal-title'>Achtung!</h4>";
						document.getElementById('modalBodyAlert').innerHTML =  "<div>Die von Ihnen eingegeben Adresse ist fehlerhaft. Es konnte kein passender Ort zugeordnet werden. Bitte verändern Sie Ihren Eingabe und führen Sie eine erneute Suchanfrage durch.</div>";
						jQuery("#modalAlert").modal();
					}    
				}
			})
		}else{
			// Fehlermeldung falls das Suchformular leer ist
			closeProgressBar();
			document.getElementById('modalHeaderAlert').innerHTML = "<h4 class='modal-title'>Achtung!</h4>";
			document.getElementById('modalBodyAlert').innerHTML =  "<div>Das Suchformular ist leer. Bitte geben Sie eine Adresse ein.</div>";
			jQuery("#modalAlert").modal();
		}
    });
    
	// REAKTION BEI KLICK AUF DEN BUTTON "BOS anzeigen"
    jQuery("#btnBos").click(function(){
        var urlBosStandorte = "http://143.93.114.120/overpassAPI";		// Adresse des MicroServices
        var queryIntrest = "fire_station";								// Festlegung welche BOS angefragt werden sollen
		if (boolGeojsonErreichbarkeitspolygon == true){
			geojsonErreichbarkeitspolygon.clearLayers();				// bisherige Erreichbarkeitspolygone loeschen, falls vorhanden 
		};
		if (boolBosMarkerList == true){
			bosMarkerList.clearLayers();								// bisherige Marker loeschen, falls vorhanden 
		};
		// Koordinaten der aktuellen Karten-BoundingBox auslesen
        var eastKoord = map.getBounds().getEast();
        var westKoord = map.getBounds().getWest();
        var southKoord = map.getBounds().getSouth();
        var northKoord = map.getBounds().getNorth();
		displayProgressBar();				// Ladebalken starten
		jQuery.ajax({
			timeout: 15000,					// Festlegung der maximalen Ladezeit der AJAX-Anfrage
            type: 'GET',					// Übergabetyp: Get
            dataType: 'jsonp',				// Übergabe erfolgt im jsonp-Format
            url: urlBosStandorte,			// Adresse des MicroServices
            crossDomain: true,				// Erlaubt Zugriff auf andere Server (cross origin)
            data: 'interest='+queryIntrest+'&south='+southKoord+'&west='+westKoord+'&north='+northKoord+'&east='+eastKoord+'', // Daten welche in der AJAX Abfrage an den MicroService uebergeben werden sollen
            xhrFields: {withCredentials: true},
            success: function(dataPoint){				// Durchfuehrung im Erfolgsfall
				closeProgressBar();						// Ladebalken schliessen
				var dataPoint =  JSON.parse(dataPoint); // parsen des empfangenen JSON
				if (dataPoint.features.length > 0){
					var fireIcon = L.icon({				// neuen Icon erzeugen
					iconUrl: 'marker/firetruck.svg',	// Icon URL
					iconSize:     [38, 38], 			// Icongroesse
					iconAnchor:   [19, 19], 			// Iconposition im Verhaeltnis zur Markerposotion
					});
					// fuer jeden BOS-Standort ein Marker erstellen und als Layer der bosMarkerList hinzufügen
					for (var coord in dataPoint.features){
						var longFireStation = dataPoint.features[coord].geometry.coordinates[0];
						var latFireStation = dataPoint.features[coord].geometry.coordinates[1];
						var marker = new L.marker([latFireStation, longFireStation],{icon: fireIcon});
						bosMarkerList.addLayer(marker);
					}
					map.addLayer(bosMarkerList); 		// bosMarkerList als Layer auf die Karte bringen
					boolBosMarkerList = true;
					jQuery("#btnPolygon").prop('disabled', false);	// Button "Polygon berechnen" nun auswaehlbar
					jQuery("#btnDelete").prop('disabled', false);	// Button "Daten loeschen" nun auswaehlbar
				}else{
					// Fehlermeldung falls keine BOS-Standorte im ausgewaehlten Bereich zur Verfuegung stehen
					document.getElementById('modalHeaderAlert').innerHTML = "<h4 class='modal-title'>Achtung!</h4>";
					document.getElementById('modalBodyAlert').innerHTML =  "<div>In dem von Ihnen ausgewählten Bereich stehen keine BOS-Standorte zur Verfügung. Bitte verändern Sie Ihren Kartenausschnitt und führen Sie eine erneute Suchanfrage durch.</div>";
					jQuery("#modalAlert").modal();
					jQuery("#btnPolygon").prop('disabled', true);		// Button "Polygon berechnen" nun nicht mehr auswaehlbar
					jQuery("#btnDelete").prop('disabled', true);		// Button "Daten loeschen" nun nicht mehr auswaehlbar
				}	 	 
            },
			// Fehlermeldung falls die maximale Wartezeit ueberschritten wurde
			error: function(){
				closeProgressBar();
				document.getElementById('modalHeaderAlert').innerHTML = "<h4 class='modal-title'>Achtung! Die maximale Wartezeit wurde überschritten!</h4>";
				document.getElementById('modalBodyAlert').innerHTML =  "<div>In dem von Ihnen ausgewählten Bereich stehen eine Vielzahl an BOS-Standorte zur Verfügung. Bitte verkleinern Sie Ihren Kartenausschnitt und führen Sie eine erneute Suchanfrage durch.</div>";
				jQuery("#modalAlert").modal();
			}
       })
    });
	
	// REAKTION BEI KLICK AUF DEN BUTTON "Polygon berechnen"
    jQuery("#btnPolygon").click(function(){
        var queryPoly = createObjPoly(); 						// Abfrage fuer den MicroService durch Funktionsaufruf "createObjPoly()" erzeugen
        var urlIsochrone = "http://143.93.114.120/isochrone";	// Adresse des MicroServices
		if (boolGeojsonErreichbarkeitspolygon == true){
			geojsonErreichbarkeitspolygon.clearLayers();		// bisherige Erreichbarkeitspolygone loeschen, falls vorhanden 
		}
		displayProgressBar();									// Ladebalken starten
        jQuery.ajax({
			timeout: 15000,										// Festlegung der maximalen Ladezeit der AJAX-Anfrag
			type: 'POST',										// Übergabetyp: Post
			headers: {											// Ein Objekt mit zusaetzlichen Header-Schluessel, die zusammen mit den Anforderungen des XMLHttpRequest-Transport gesendet werden.
				'Accept': 'application/json',
				'Content-Type': 'application/json',
			},
			dataType: 'json',									// Übergabe erfolgt im jsonp-Format
			url: urlIsochrone,									// Adresse des MicroServices
			crossDomain : true,									// Erlaubt Zugriff auf andere Server (cross origin)
			data: queryPoly,									// Daten welche in der AJAX Abfrage an den MicroService uebergeben werden sollen
			success: function(dataPoly){						// Durchfuehrung im Erfolgsfall
				closeProgressBar();								// Ladebalken schliessen
				geojsonErreichbarkeitspolygon = L.geoJson(dataPoly).addTo(map); // Erreichbarkeitspolygon auf die Karte bringen
				boolGeojsonErreichbarkeitspolygon = true;
			},
			// Fehlermeldung falls die maximale Wartezeit ueberschritten wurde
			error: function(){
				closeProgressBar();
				document.getElementById('modalHeaderAlert').innerHTML = "<h4 class='modal-title'>Achtung!</h4>";
				document.getElementById('modalBodyAlert').innerHTML =  "<div>In dem von Ihnen ausgewählten Bereich stehen eine Vielzahl an BOS-Standorte zur Verfügung. Eine Abfrage des Erreichbarkeitspolygons kann nicht ausgeführt werden. <br>Bitte verkleinern Sie Ihren Kartenausschnitt oder verändern Sie ihre Zeitliche Hilfsfrist und führen Sie eine erneute Suchanfrage durch. Polygone können zudem nur in Deutschland erzeugt werden!</div>";
				jQuery("#modalAlert").modal();
			}
        })   
    });  
	// REAKTION BEI KLICK AUF DEN BUTTON "Daten loeschen"
    jQuery("#btnDelete").click(function(){
        bosMarkerList.clearLayers();						// bisherige Marker loeschen
		document.getElementById("formAdress").value = "";	// Formular zur Adresssuche leeren
		jQuery("#btnPolygon").prop('disabled', true);		// Button "Polygon berechnen" nun nicht mehr auswaehlbar
		jQuery("#btnDelete").prop('disabled', true);		// Button "Daten loeschen" nun nicht mehr auswaehlbar
		if (boolGeojsonErreichbarkeitspolygon == true){
			geojsonErreichbarkeitspolygon.clearLayers();	// bisherige Erreichbarkeitspolygone loeschen
		}
	});
});


//****************************************
// PUBLIC METHODEN
//****************************************

// ERZEUGEN DER KARTE
function getMap(){
	// Attribue der Karte
    map = L.map('map', {
        center: [51.5, 9.75],
        zoom: 6,
        minZoom: 6
    });
	// Festlegung der Karte sowie der Urheberrechte
    L.tileLayer('http://{s}.tiles.wmflabs.org/bw-mapnik/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors | &copy; SEng Gruppe 1'
    }).addTo(map);
}

// OBJEKT ERZEUGEN ALS VORBEREITUNG ZUR ABFRAGE AN DEN ISOCHRONE MICROSERVICE
function createObjPoly(){
    var obj = new Object();			// Objekt anlegen
    obj.timelimit = sliderData;		// Slider-Value als Zeitlimit 
    var bos = [];					// BOS-Array erzeugen, wo alle Standorte der BOS gespeichert werden
    var i = 0;
	// Schleife um die gesamte bosMarkerList zu durchlaufen
    for (var fireMarker in bosMarkerList._layers){	
        if (fireMarker._latlng !== null) {
			// Latitude / Longitude des jeweiligen Markers
			var latitude = bosMarkerList._layers[fireMarker]._latlng.lat;
			var longitude = bosMarkerList._layers[fireMarker]._latlng.lng;
			
			// Pruefen ob die Koordinaten der jeweiligen Marker im der aktuellen BoundingBox der Map sind
			if(map.getBounds().contains([parseFloat(latitude), parseFloat(longitude)]) == true){
				// Teilobjekt zum jeweiligen Marker erzeugen
				var bosItem = {};
				var coordItem = {};
				coordItem['lat'] = latitude;
				coordItem['lng'] = longitude;
				bosItem = coordItem;
				bos.push(bosItem);
				i++;
			}else{
			// falls die Koordinaten des jeweiligen Markers nicht in der BoundingBox der Map sind, Marker von Karte und aus Objekt loeschen
				map.removeLayer(bosMarkerList._layers[fireMarker]);
				delete bosMarkerList._layers[fireMarker];
			}
        }
    };
    obj.bos = bos;							// Gesamtobjekt erzeugen
    var jsonString = JSON.stringify(obj);	// Objekt in JSON-Notation erzeugen und in String-Variablen schreiben
    return jsonString;						// Rueckgabe der Variable
}

// OBJEKT ERZEUGEN ALS VORBEREITUNG ZUR ABFRAGE AN DEN ISOCHRONE MICROSERVICE
function displayProgressBar(){
	jQuery('body').css('pointer-events','none');	// Mausevents nicht zulassen
	document.getElementById('modalBodyProgress').innerHTML =  "<div> <br><img src='marker/progressBar.gif'><br><br>Bitte warten, die Daten werden geladen!<br></div>";
	jQuery("#modalProgressBar").modal({
		keyboard: false		// Tastaturevents nicht zulassen
	});
}

// SCHLIESSEN DES LADEBALKENS
function closeProgressBar(){
	jQuery("#modalProgressBar").modal('toggle');
	jQuery('body').css('pointer-events','auto');	// Mausevents wieder zulassen
}