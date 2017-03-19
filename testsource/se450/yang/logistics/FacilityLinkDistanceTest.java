package se450.yang.logistics;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class FacilityLinkDistanceTest {

	@Test
	public void facilityLinkDistance() {
		//HashMap<FacilityLink, Integer> distanceMap = new HashMap<FacilityLink, Integer>();
		Edge facilityLink = new Edge();
		
		FacilityLinkDistance link = new FacilityLinkDistance();
		Vertex facility1 = new Vertex("Chicago,IL");
		Vertex facility2 = new Vertex("New York,NY");
		facilityLink.put(facility1, facility2);
		int distance = 30;
		link.getDistance(distance);
		link.put(facilityLink, distance);
		
		
		
		assertEquals(link.findDistance(facilityLink),distance );
	}

}
