package se450.yang.logistics;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacilityTest {

	@Test
	public void test() {
		Vertex facility = new Vertex("Chicago IL");
		assertEquals("Chicago IL", facility.getLocation());
	}
	
	@Test
	public void equality() {
		Vertex facility1 = new Vertex("Chicago IL");
		Vertex facility2 = new Vertex("Chicago IL");
		assertEquals(facility1, facility2);
	}
	
	@Test
	public void equality_different() {
		Vertex facility1 = new Vertex("Seattle WA");
		Vertex facility2 = new Vertex("Chicago IL");
		assertNotEquals(facility1, facility2);
	}
}
