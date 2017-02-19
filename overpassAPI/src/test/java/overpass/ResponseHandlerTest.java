package overpass;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsmainz.bos.overpassApi.RequestHandler;
import de.hsmainz.bos.overpassApi.ResponseHandler;

public class ResponseHandlerTest {
	/**
	 * Tests for ResponseHandler
	 */
	@Test
	public void singleBOS() throws Exception {
		/**
		 * the function of the ResponseHandler and RequestHandler are started
		 * without the server. the GeoJson-File for one BOS of the OverpassAPI
		 * should be the same as the one of the OverpassTurbo of OSM
		 */
		// Testdaten
		String testStr = "fire_station";
		String resShould = "{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":{\"name\":\"Berufsfeuerwehr Mainz, Feuerwache 1\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[8.2357993,49.9785691]}}]}";
		// localhost:8050/overpassAPI?callback=xxx&interest=fire_station&south=49.9221&west=8.0842&north=50.0972&east=8.4584
		// Test
		String resIs = ResponseHandler
				.getResponse(RequestHandler.getRelevantBOS(testStr, 49.97656, 8.23063, 49.98074, 8.24163));

		// Asserts
		assertNotNull("Ergebnis darf nicht null sein", resIs);
		assertEquals(resIs, resShould);
	}

	@Test
	public void bosList() throws Exception {
		/**
		 * the function of the ResponseHandler and RequestHandler are started
		 * without the server. the GeoJson-File for 5 BOS of the OverpassAPI
		 * should be the same as the one of the OverpassTurbo of OSM
		 */
		// Testdaten
		String testStr = "fire_station";
		String resShould = "{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":{\"name\":\"Berufsfeuerwehr Mainz, Feuerwache 1\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[8.2357993,49.9785691]}},{\"type\":\"Feature\",\"properties\":{},\"geometry\":{\"type\":\"Point\",\"coordinates\":[8.2840119,50.010247]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Feuerwache 2\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[8.2699156,50.0236326]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Freiwillige Feuerwehr Mainz-Bretzenheim\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[8.2416798,49.9813486]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Feuerwehr\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[8.3229931,49.9971363]}}]}";
		// Test
		String resIs = ResponseHandler
				.getResponse(RequestHandler.getRelevantBOS(testStr, 49.96933, 8.1776, 50.03619, 8.35373));

		// Asserts
		assertNotNull("Ergebnis darf nicht null sein", resIs);
		assertEquals(resIs, resShould);
	}

	@Test
	public void badInput() throws Exception {
		/**
		 * the function of the ResponseHandler and RequestHandler are started
		 * without the server. the GeoJson-File for zero BOS of the OverpassAPI
		 * should be the same as the one of the OverpassTurbo of OSM
		 */
		// Testdaten
		String testStr = "fire_station";
		String resShould = "{\"type\":\"FeatureCollection\",\"features\":[]}";

		// Test
		String resIs = ResponseHandler
				.getResponse(RequestHandler.getRelevantBOS(testStr, 49.97724, 8.2212, 49.98142, 8.2322));
		// Asserts
		assertNotNull("Ergebnis darf nicht null sein", resIs);
		assertEquals(resIs, resShould);
	}
}
