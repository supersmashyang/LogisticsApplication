package se450.yang.logistics;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacilityInfoTest {

	@Test
	public void test() {
		FacilityInfo facilityInfo = new FacilityInfo(8, 300);
		assertEquals(8, facilityInfo.getRate());
		assertEquals(300, facilityInfo.getCost());
		
	}
	
	@Test
	public void equality() {
		FacilityInfo FacilityInfo1 = new FacilityInfo(8,300);
		FacilityInfo FacilityInfo2 = new FacilityInfo(8,300);
		assertEquals(FacilityInfo1, FacilityInfo2);
	}
	
	@Test
	public void equality_different() {
		FacilityInfo FacilityInfo1 = new FacilityInfo(8,300);
		FacilityInfo FacilityInfo2 = new FacilityInfo(9,400);
		assertNotEquals(FacilityInfo1, FacilityInfo2);
	}

}
