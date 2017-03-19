package se450.yang.logistics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class FacilityLinks {
	private final Map<Vertex, Set<Vertex>> adjacentFacilities;

	public FacilityLinks() {
		this.adjacentFacilities = new HashMap<Vertex, Set<Vertex>>();

	}

	public void put(Vertex facilityFrom, Vertex facilityTo) {

		if (!adjacentFacilities.containsKey(facilityFrom)) {
			HashSet<Vertex> set = new HashSet<Vertex>();
			set.add(facilityTo);
			adjacentFacilities.put(facilityFrom, set);
		} else {
			adjacentFacilities.get(facilityFrom).add(facilityTo);

		}

	}

	public Set<Vertex> findAdjacentFacilities(Vertex facility) {
		Set<Vertex> set = adjacentFacilities.get(facility);
		if (Objects.isNull(set)) {
			throw new NoFacilityFoundException(facility);
		}
		return set;
	}

	@Override
	public String toString() {
		return "FacilityLinks [adjacentFacilities=" + adjacentFacilities + "]";
	}
	
	

}
