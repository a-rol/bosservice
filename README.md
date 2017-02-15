# BOS-SERVICE   

------
**BOS** --> Blaulichtorganisationen (Feuerwehr, Polizei, Ersthelfer) [german]

translation in english: Blue light organizations (fire brigade, police, first aid)

------
Licensing information: READ LICENSE

------
Project source can be downloaded from https://github.com/a-rol/bosservice

------
**Author & Contributor list**
<br />
Angelique Pruess	*angelique.pruess@students.hs-mainz.de*

Alexander Rolwes 	*alexander.rolwes@students.hs-mainz.de*

Sandro Mertens 		*sandro.mertens@students.hs-mainz.de*

Thomas Mueller 		*thomas.mueller@students.hs-mainz.de*

------
**About the website**
<br />
This website is used for the visualization of known fire departments as well as the accessibility polygons 
in a given help period in minutes.

------
**Motivation**
<br />
In the context of the lecture "Software Engineering", a project entitled "Visualization of areas of
application of the police, fire brigade or first responders" is to be realized. The aim of the 
project is the creation of a web client for the visualization of accessibility polygons of a freely 
selectable area. Furthermore, this project allows the use of the knowledge gained in the 
above-mentioned lecture. This includes, in particular, project management.
Our motivation for creating the web client is that all users can create free-of-charge 
accessibility analyzes for BOS sites.

------
**How to run file**
<br />
The website can be started by entering the URL: "http://143.93.114.120/webanwendung/" with any browser.
<br />
Step-by-step explanation for the display of the accessibility polygons:

1. Open the website
2. Find address with the button "Adresse suchen" and/or select area
3. Select the time-dependent help period in minutes with the slider "Zeitliche Hilfsfrist [Min.]"
4. Click "BOS anzeigen" to display fire departments
5. Click "Polygon berechnen" to display availability polygons
6. Selection can be deleted with the button "Daten löschen"

------
**Used libraries**
<br />
See File list
################################################# muss noch ergänzt werden
------
**File list**
<br />
gitignore

LICENSE

README-md
<br />

./isochroneAPI

./overpassAPI

./webanwendung
<br />

/isochroneAPI:

pom.xml

/isochroneAPI/src/main:

/isochroneAPI/src/main/java/isochroneAPI:

CORS_Filter.java

GetPropertyValue.java

Main.java

MyResourceTest.java

RequestHandler.java

call_IsochroneAPI.java

/isochroneAPI/src/main/java/isochroneAPI/ParseGEOJSON:

FeatureList.java

Geometry.java

IsochroneGEOJSON.java

Polygon.java

Properties.java

/isochroneAPI/src/main/java/isochroneAPI/ParseJSON/Input:

Coordinate.java

InputJSON.java

/isochroneAPI/src/main/resources:

config.properties


<br />
/overpassAPI:




<br />
/webanwendung:



########################################## muss ebenfalls noch vervollständigt werden

------