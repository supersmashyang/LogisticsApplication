package se450.yang.logistics;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacilitiesTest {

	@Test
	public void findFacilityInfo() {
		Facilities facilities = new Facilities();
		Vertex facility = new Vertex("Chicago,IL");
		FacilityInfo facilityInfo = new FacilityInfo(8, 300);
		facilities.put(facility, facilityInfo);
		
		assertEquals(facilityInfo, facilities.findFacilityInfo(facility));
	}
	
	@Test(expected=NoFacilityFoundException.class)
	public void findFacilityInfo_invalidFacility() {
		Facilities facilities = new Facilities();
		Vertex facility1 = new Vertex("Chicago,IL");
		Vertex facility2 = new Vertex("Seattle, WA");
		FacilityInfo facilityInfo = new FacilityInfo(8, 300);
		facilities.put(facility2, facilityInfo);
		
		facilities.findFacilityInfo(facility1);
	}
	
//	@Test
//	public void equality() {
//		Facility facility1 = new Facility("Chicago IL");
//		Facility facility2 = new Facility("Chicago IL");
//		assertEquals(facility1, facility2);
//	}
//	
//	@Test
//	public void equality_different() {
//		Facility facility1 = new Facility("Seattle WA");
//		Facility facility2 = new Facility("Chicago IL");
//		assertNotEquals(facility1, facility2);
//	}

}
