package se450.yang.logistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Facilities {
	private final Map<Vertex, FacilityInfo>  facilities;
	
	public Facilities(){
		this.facilities = new HashMap();
	}
	
	public void put(Vertex facility,FacilityInfo facilityInfo){
		facilities.put(facility, facilityInfo);
	}
	
	public FacilityInfo findFacilityInfo(Vertex facility) 
	{
		
		FacilityInfo facilityInfo = facilities.get(facility);
		if (Objects.isNull(facilityInfo)) {
			throw new NoFacilityFoundException(facility);
		}
		return facilityInfo;
	}

	@Override
	public String toString() {
		return "Facilities [facilities=" + facilities + "]";
	}
	
	

}
