# ***Dokumentation OverpassAPI***<br/>
***API Aufruf:***<br/>
143.93.114.120/overpassAPI<br/><br/>
***Example der Aufruf URL:***<br/>
localhost:8050/overpassAPI?callback=xxx&interest=fire_station&south=49.97656&west=8.23063&north=49.98074&east=8.24163
<br/><br/>
***Parameter:***<br/>
*interest:*
Stichwort nach dem in der OSM-Datenbank gesucht werden soll<br/><br/>
*south:* Südkoordinate der Bbox<br/><br/>
*west:* Westkoordinate der Bbox<br/><br/>
*north:* Nordkoordinate der Bbox<br/><br/>
*east:* Ostkoordinate der Bbox<br/><br/>
***Example Output:***<br/>
{"type":"FeatureCollection","features":[{"type":"Feature","properties":{"name":"Berufsfeuerwehr Mainz, Feuerwache 1"},"geometry":{"type":"Point","coordinates":[8.2357993,49.9785691]}}]}
<br/>


