package se450.yang.logistics;

import static org.junit.Assert.*;

import org.junit.Test;

public class XMLFacilityNetworkReaderTest {

	@Test
	public void grape() {
		XMLFacilityNetworkReader reader = new XMLFacilityNetworkReader();
		reader.parse();
	}

}
