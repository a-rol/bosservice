# BOS-SERVICE
![BOS-SERVICE](webanwendung\marker\logo.png "Logo BOS")
------
**BOS** --> Blaulichtorganisationen (Feuerwehr, Polizei, Ersthelfer) [German]

Translation in English: Blue light organizations (fire department, police, first aider)

------
Licensing information: READ LICENSE

------
Project source can be downloaded from https://github.com/a-rol/bosservice

------
**Author & Contributor list**<br/><br/>
Angelique Pruess	*angelique.pruess@students.hs-mainz.de*

Alexander Rolwes 	*alexander.rolwes@students.hs-mainz.de*

Sandro Mertens 		*sandro.mertens@students.hs-mainz.de*

Thomas Mueller 		*thomas.mueller@students.hs-mainz.de*

------
**About the website**<br/><br/>
This website is used for the visualization of known fire departments as well as the accessibility polygons 
in a given help period in minutes.<br/>
This website is a project of the lecture "Software Engineering" from the master programme "Geoinformatics 
and Surveying" of the [University of Applied Science Mainz](https://www.hs-mainz.de/technology/geoinformatics-and-surveying/geoinformatics-and-surveying-master-full-time/index.html "University of Applied Science Mainz").

------
**Motivation**<br/><br/>
In the context of the lecture "Software Engineering", a project entitled "Visualization of 
operational areas of the police, fire department or first aider" is to be realized. The aim of 
the project is the creation of a web client for the visualization of accessibility polygons of a 
freely selectable area. Furthermore, this project allows the use of the knowledge gained in the 
above-mentioned lecture. This includes in particular project management.
Our motivation for creating the web client is that all users can access BOS sites for free.

------
**How to run file**<br/><br/>
The website can be started by entering the URL: "http://143.93.114.120/webanwendung/" with any browser.<br/><br/>
Step-by-step explanation for the display of the accessibility polygons:

1. Open the website
2. Find address with the button "Adresse suchen" and/or select area
3. Select the time-dependent help period in minutes with the slider "Zeitliche Hilfsfrist [Min.]"
4. Click "BOS anzeigen" to display fire departments
5. Click "Polygon berechnen" to display availability polygons
6. Selection can be deleted with the button "Daten löschen"

------
**File list**<br/><br/>
a-rol\bosservice\.gitignore                                                                                 
a-rol\bosservice\config.properties                                                                          
a-rol\bosservice\geocoder\pom.xml                                                                           
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\controller\HttpAPIRequest.java           
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\controller\HttpAPIRequesterFactory.java  
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\controller\HttpGraphhopperRequest.java   
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\controller\HttpNominatimRequest.java     
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\GeocoderServiceMain.java                 
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\APIKeys.java                       
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\ClientInputJson.java               
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\ErrorJson.java                     
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\geojson\Features.java              
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\geojson\GeoJsonCollection.java     
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\geojson\Geometry.java              
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\geojson\Properties.java            
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\graphhopperjson\GrahhopperJson.java
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\graphhopperjson\HitsJson.java      
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\graphhopperjson\PointJson.java     
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\nominatimjson\Address.java         
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\model\nominatimjson\NominatimJson.java   
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\MyProperties.java                        
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\web\Resource.java                        
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\web\ResourceJson.java                    
a-rol\bosservice\geocoder\src\main\java\de\hsmainz\pubapp\geocoder\web\ResourceTemplate.java                
a-rol\bosservice\geocoder\src\main\resources\default.properties                                             
a-rol\bosservice\geocoder\src\main\resources\lable_de.properties                                            
a-rol\bosservice\geocoder\src\main\resources\lable_en.properties                                            
a-rol\bosservice\geocoder\src\main\resources\log4j2.properties                                              
a-rol\bosservice\geocoder\src\test\java\de\hsmainz\pubapp\geocoder\APIKeysTest.java                         
a-rol\bosservice\geocoder\src\test\java\de\hsmainz\pubapp\geocoder\JsonParserTest.java                      
a-rol\bosservice\isochroneAPI\javadoc\allclasses-frame.html                                                 
a-rol\bosservice\isochroneAPI\javadoc\allclasses-noframe.html                                               
a-rol\bosservice\isochroneAPI\javadoc\constant-values.html                                                  
a-rol\bosservice\isochroneAPI\javadoc\deprecated-list.html                                                  
a-rol\bosservice\isochroneAPI\javadoc\help-doc.html                                                         
a-rol\bosservice\isochroneAPI\javadoc\index-files\index-1.html                                              
a-rol\bosservice\isochroneAPI\javadoc\index-files\index-2.html                                              
a-rol\bosservice\isochroneAPI\javadoc\index-files\index-3.html                                              
a-rol\bosservice\isochroneAPI\javadoc\index-files\index-4.html                                              
a-rol\bosservice\isochroneAPI\javadoc\index-files\index-5.html                                              
a-rol\bosservice\isochroneAPI\javadoc\index-files\index-6.html                                              
a-rol\bosservice\isochroneAPI\javadoc\index-files\index-7.html                                              
a-rol\bosservice\isochroneAPI\javadoc\index-files\index-8.html                                              
a-rol\bosservice\isochroneAPI\javadoc\index-files\index-9.html                                              
a-rol\bosservice\isochroneAPI\javadoc\index.html                                                            
a-rol\bosservice\isochroneAPI\javadoc\isochrone\CallIsochroneApi.html                                       
a-rol\bosservice\isochroneAPI\javadoc\isochrone\class-use\CallIsochroneApi.html                             
a-rol\bosservice\isochroneAPI\javadoc\isochrone\class-use\CorsFilter.html                                   
a-rol\bosservice\isochroneAPI\javadoc\isochrone\class-use\Main.html                                         
a-rol\bosservice\isochroneAPI\javadoc\isochrone\class-use\RequestHandler.html                               
a-rol\bosservice\isochroneAPI\javadoc\isochrone\class-use\RequestHandlerTest.html                           
a-rol\bosservice\isochroneAPI\javadoc\isochrone\CorsFilter.html                                             
a-rol\bosservice\isochroneAPI\javadoc\isochrone\Main.html                                                   
a-rol\bosservice\isochroneAPI\javadoc\isochrone\package-frame.html                                          
a-rol\bosservice\isochroneAPI\javadoc\isochrone\package-summary.html                                        
a-rol\bosservice\isochroneAPI\javadoc\isochrone\package-tree.html                                           
a-rol\bosservice\isochroneAPI\javadoc\isochrone\package-use.html                                            
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\class-use\FeatureList.html                     
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\class-use\Geometry.html                        
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\class-use\IsochroneGeojson.html                
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\class-use\Polygon.html                         
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\class-use\Properties.html                      
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\FeatureList.html                               
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\Geometry.html                                  
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\IsochroneGeojson.html                          
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\package-frame.html                             
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\package-summary.html                           
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\package-tree.html                              
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\package-use.html                               
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\Polygon.html                                   
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseGeojson\Properties.html                                
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseJson\input\class-use\Coordinate.html                   
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseJson\input\class-use\InputJson.html                    
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseJson\input\Coordinate.html                             
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseJson\input\InputJson.html                              
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseJson\input\package-frame.html                          
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseJson\input\package-summary.html                        
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseJson\input\package-tree.html                           
a-rol\bosservice\isochroneAPI\javadoc\isochrone\parseJson\input\package-use.html                            
a-rol\bosservice\isochroneAPI\javadoc\isochrone\RequestHandler.html                                         
a-rol\bosservice\isochroneAPI\javadoc\isochrone\RequestHandlerTest.html                                     
a-rol\bosservice\isochroneAPI\javadoc\overview-frame.html                                                   
a-rol\bosservice\isochroneAPI\javadoc\overview-summary.html                                                 
a-rol\bosservice\isochroneAPI\javadoc\overview-tree.html                                                    
a-rol\bosservice\isochroneAPI\javadoc\package-list                                                          
a-rol\bosservice\isochroneAPI\javadoc\resources\background.gif                                              
a-rol\bosservice\isochroneAPI\javadoc\resources\tab.gif                                                     
a-rol\bosservice\isochroneAPI\javadoc\resources\titlebar.gif                                                
a-rol\bosservice\isochroneAPI\javadoc\resources\titlebar_end.gif                                            
a-rol\bosservice\isochroneAPI\javadoc\stylesheet.css                                                        
a-rol\bosservice\isochroneAPI\pom.xml                                                                       
a-rol\bosservice\isochroneAPI\README.md                                                                     
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\CallIsochroneApi.java                                 
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\CorsFilter.java                                       
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\Main.java                                             
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\parseGeojson\FeatureList.java                         
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\parseGeojson\Geometry.java                            
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\parseGeojson\IsochroneGeojson.java                    
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\parseGeojson\Polygon.java                             
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\parseGeojson\Properties.java                          
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\parseJson\input\Coordinate.java                       
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\parseJson\input\InputJson.java                        
a-rol\bosservice\isochroneAPI\src\main\java\isochrone\RequestHandler.java                                   
a-rol\bosservice\isochroneAPI\src\test\java\isochrone\RequestHandlerTest.java                               
a-rol\bosservice\LICENSE                                                                                    
a-rol\bosservice\overpassAPI\doc\allclasses-frame.html                                                      
a-rol\bosservice\overpassAPI\doc\allclasses-noframe.html                                                    
a-rol\bosservice\overpassAPI\doc\constant-values.html                                                       
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\controller\class-use\OverpassAPI.html                       
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\controller\OverpassAPI.html                                 
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\controller\package-frame.html                               
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\controller\package-summary.html                             
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\controller\package-tree.html                                
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\controller\package-use.html                                 
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\BOS.html                                              
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\BOS.html                                    
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\GeoJsonFeature.GeoJsonGeometry.html         
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\GeoJsonFeature.GeoJsonProperties.html       
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\GeoJsonFeature.html                         
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\GeoJsonFeatureCollection.html               
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\Geometry.html                               
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\Location.html                               
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\Place.html                                  
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\PlacesResult.html                           
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\Result.html                                 
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\class-use\Tags.html                                   
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\GeoJsonFeature.GeoJsonGeometry.html                   
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\GeoJsonFeature.GeoJsonProperties.html                 
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\GeoJsonFeature.html                                   
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\GeoJsonFeatureCollection.html                         
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\Geometry.html                                         
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\Location.html                                         
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\package-frame.html                                    
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\package-summary.html                                  
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\package-tree.html                                     
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\package-use.html                                      
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\Place.html                                            
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\PlacesResult.html                                     
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\Result.html                                           
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\model\Tags.html                                             
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\class-use\Main.html                             
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\class-use\RequestHandler.html                   
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\class-use\ResponseHandler.html                  
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\Main.html                                       
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\package-frame.html                              
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\package-summary.html                            
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\package-tree.html                               
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\package-use.html                                
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\RequestHandler.html                             
a-rol\bosservice\overpassAPI\doc\de\hsmainz\bos\overpassApi\ResponseHandler.html                            
a-rol\bosservice\overpassAPI\doc\de\hs_mainz\BOS\Overpass_API\AppTest.html                                  
a-rol\bosservice\overpassAPI\doc\de\hs_mainz\BOS\Overpass_API\class-use\AppTest.html                        
a-rol\bosservice\overpassAPI\doc\de\hs_mainz\BOS\Overpass_API\package-frame.html                            
a-rol\bosservice\overpassAPI\doc\de\hs_mainz\BOS\Overpass_API\package-summary.html                          
a-rol\bosservice\overpassAPI\doc\de\hs_mainz\BOS\Overpass_API\package-tree.html                             
a-rol\bosservice\overpassAPI\doc\de\hs_mainz\BOS\Overpass_API\package-use.html                              
a-rol\bosservice\overpassAPI\doc\deprecated-list.html                                                       
a-rol\bosservice\overpassAPI\doc\help-doc.html                                                              
a-rol\bosservice\overpassAPI\doc\index-files\index-1.html                                                   
a-rol\bosservice\overpassAPI\doc\index-files\index-10.html                                                  
a-rol\bosservice\overpassAPI\doc\index-files\index-11.html                                                  
a-rol\bosservice\overpassAPI\doc\index-files\index-2.html                                                   
a-rol\bosservice\overpassAPI\doc\index-files\index-3.html                                                   
a-rol\bosservice\overpassAPI\doc\index-files\index-4.html                                                   
a-rol\bosservice\overpassAPI\doc\index-files\index-5.html                                                   
a-rol\bosservice\overpassAPI\doc\index-files\index-6.html                                                   
a-rol\bosservice\overpassAPI\doc\index-files\index-7.html                                                   
a-rol\bosservice\overpassAPI\doc\index-files\index-8.html                                                   
a-rol\bosservice\overpassAPI\doc\index-files\index-9.html                                                   
a-rol\bosservice\overpassAPI\doc\index.html                                                                 
a-rol\bosservice\overpassAPI\doc\overpass\class-use\ResponseHandlerTest.html                                
a-rol\bosservice\overpassAPI\doc\overpass\package-frame.html                                                
a-rol\bosservice\overpassAPI\doc\overpass\package-summary.html                                              
a-rol\bosservice\overpassAPI\doc\overpass\package-tree.html                                                 
a-rol\bosservice\overpassAPI\doc\overpass\package-use.html                                                  
a-rol\bosservice\overpassAPI\doc\overpass\ResponseHandlerTest.html                                          
a-rol\bosservice\overpassAPI\doc\overview-frame.html                                                        
a-rol\bosservice\overpassAPI\doc\overview-summary.html                                                      
a-rol\bosservice\overpassAPI\doc\overview-tree.html                                                         
a-rol\bosservice\overpassAPI\doc\package-list                                                               
a-rol\bosservice\overpassAPI\doc\script.js                                                                  
a-rol\bosservice\overpassAPI\doc\stylesheet.css                                                             
a-rol\bosservice\overpassAPI\pom.xml                                                                        
a-rol\bosservice\overpassAPI\README.md                                                                      
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\controller\OverpassAPI.java                       
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\model\BOS.java                                    
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\model\GeoJsonFeature.java                         
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\model\GeoJsonFeatureCollection.java               
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\model\Geometry.java                               
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\model\Location.java                               
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\model\Place.java                                  
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\model\PlacesResult.java                           
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\model\Result.java                                 
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\model\Tags.java                                   
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\overpassApi\Main.java                             
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\overpassApi\RequestHandler.java                   
a-rol\bosservice\overpassAPI\src\main\java\de\hsmainz\bos\overpassApi\ResponseHandler.java                  
a-rol\bosservice\overpassAPI\src\test\java\overpass\ResponseHandlerTest.java                                
a-rol\bosservice\README.md                                                                                  
a-rol\bosservice\webanwendung\css\bootstrap.css                                                             
a-rol\bosservice\webanwendung\css\bootstrap.min.css                                                         
a-rol\bosservice\webanwendung\css\jquery-ui-slider-pips.css                                                 
a-rol\bosservice\webanwendung\css\leaflet.css                                                               
a-rol\bosservice\webanwendung\css\mainStyle.css                                                             
a-rol\bosservice\webanwendung\index.html                                                                    
a-rol\bosservice\webanwendung\js\bootstrap.js                                                               
a-rol\bosservice\webanwendung\js\bootstrap.min.js                                                           
a-rol\bosservice\webanwendung\js\jquery-ui-slider-pips.js                                                   
a-rol\bosservice\webanwendung\js\leaflet.js                                                                 
a-rol\bosservice\webanwendung\main.js                                                                       
a-rol\bosservice\webanwendung\marker\firetruck.png                                                          
a-rol\bosservice\webanwendung\marker\firetruck.svg                                                          
a-rol\bosservice\webanwendung\marker\logo.png                                                               
a-rol\bosservice\webanwendung\marker\polygonLegend.svg                                                      
a-rol\bosservice\webanwendung\marker\progressBar.gif                                                        

------