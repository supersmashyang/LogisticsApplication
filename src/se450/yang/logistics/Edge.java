package se450.yang.logistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Edge {
	private final Vertex facilityFrom;
	private final Vertex facilityTo;
	
	
	
	
	public Edge(Vertex facilityFrom, Vertex facilityTo) {
		
		this.facilityFrom = facilityFrom;
		this.facilityTo = facilityTo;
	}


	
	@Override
	public int hashCode() {
		return Objects.hash(facilityFrom,facilityTo);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (facilityFrom == null) {
			if (other.facilityFrom != null)
				return false;
		} else if (!facilityFrom.equals(other.facilityFrom))
			return false;
		if (facilityTo == null) {
			if (other.facilityTo != null)
				return false;
		} else if (!facilityTo.equals(other.facilityTo))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FacilityLink [facilityFrom=" + facilityFrom + ", facilityTo=" + facilityTo + "]";
	}
	
	

	
	
	
	

}
