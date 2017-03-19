package se450.yang.logistics;

import static org.junit.Assert.*;

import org.junit.Test;

public class XMLFacilityInventoryReaderTest {

	@Test
	public void grape() {
		XMLFacilityInventoryReader reader = new XMLFacilityInventoryReader();
		reader.parse();
	}
}
