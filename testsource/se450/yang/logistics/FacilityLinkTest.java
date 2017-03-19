package se450.yang.logistics;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacilityLinkTest {

	
	@Test
	public void equality() {
		Vertex facilityFrom = new Vertex("Seattle,WA");
		Vertex facilityTo = new Vertex("San Francisco,CA");
		Edge link  = new Edge(facilityFrom, facilityTo);
		Edge link2  = new Edge(facilityFrom, facilityTo);
		assertEquals(link,link2 );
		
		
	}
	
	@Test
	public void equalityDifferent() {
		Vertex facilityFrom = new Vertex("Seattle,WA");
		Vertex facilityTo = new Vertex("San Francisco,CA");
		Edge link  = new Edge(facilityFrom, facilityTo);
		Edge link2  = new Edge(facilityTo, facilityFrom);
		assertNotEquals(link,link2 );
		
		
	}
	
	
	

}
