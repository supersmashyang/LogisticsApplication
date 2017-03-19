package se450.yang.logistics;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class FacilityLinksTest {

	private static final Vertex seattle = new Vertex("Settle, WA");
	private static final Vertex fargo = new Vertex("Fargo, ND");
	private static final Vertex sanFran = new Vertex("San Francisco, CA");
	private FacilityLinks links;
	
	@Before
	public void setUp() {

		 links = new FacilityLinks();
		
	}

	@Test
	public void findAdjacentFacilities() {
		
		
		
		
		
		links.put(seattle, fargo);
		links.put(seattle, sanFran);
		links.put(sanFran, seattle);
		
		Set<Vertex> set = new HashSet<Vertex>();
		Set<Vertex> set2 = new HashSet<Vertex>();
		set.add(fargo);
		set.add(sanFran);
		set2.add(seattle);
		
		
		assertEquals(set, links.findAdjacentFacilities(seattle));
		assertEquals(set2, links.findAdjacentFacilities(sanFran));
	}
	
	@Test(expected=NoFacilityFoundException.class)
	public void findFacilityInfo_invalidFacility() {
		
		Vertex seattle = new Vertex("Settle, WA");
		Vertex fargo = new Vertex("Fargo, ND");
		Vertex sanFran = new Vertex("San Francisco, CA");
		
		
		
		links.put(seattle, fargo);
		links.put(seattle, sanFran);
		links.put(sanFran, seattle);
		links.findAdjacentFacilities(fargo);
		
	}
}
