package se450.yang.logistics;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Test;

public class XMLCatalogReaderTest {

	@Test
	public void grape() throws URISyntaxException  {
		XMLCatalogReader reader = new XMLCatalogReader();
		reader.parse();
	}

}
