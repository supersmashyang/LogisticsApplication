package se450.yang.logistics;

import java.util.HashMap;
import java.util.Map;

public class ItemCatalog {
	private final Map<String,Integer> itemCatalog;
	
	
	public ItemCatalog() {
		this.itemCatalog = new HashMap();
				
	}

	public void put (String id, int price){
		itemCatalog.put(id, price);
		
	}

	@Override
	public String toString() {
		return "ItemCatalog [itemCatalog=" + itemCatalog + "]";
	}
	
	

}
