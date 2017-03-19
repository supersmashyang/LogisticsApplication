package se450.yang.logistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FacilityLinkDistance {
	private final Map<Edge, Integer> distanceMap;

	public FacilityLinkDistance() {
		this.distanceMap = new HashMap<>();
	}

	public void put(Edge link, Integer distance) {
		// TODO input validation
		if (Objects.isNull(link)) {
			// throw new
		}
		distanceMap.put(link, distance);
	}

	public int findDistance(Edge link) {
		int dis = distanceMap.get(link);
		return dis;

	}

	@Override
	public String toString() {
		return "FacilityLinkDistance [distanceMap=" + distanceMap + "]";
	}
	
	

}
