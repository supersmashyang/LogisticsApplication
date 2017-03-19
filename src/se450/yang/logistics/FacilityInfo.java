package se450.yang.logistics;

import java.util.Objects;

public class FacilityInfo {
	private final int rate;
	private final int cost;

	public FacilityInfo(int rate, int cost) {
		this.rate = rate;
		this.cost = cost;
	}

	public int getRate() {
		return rate;
	}

	public int getCost() {
		return cost;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(rate,cost);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacilityInfo other = (FacilityInfo) obj;
		if (cost != other.cost)
			return false;
		if (rate != other.rate)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacilitiesInfo [rate=" + rate + ", cost=" + cost + "]";
	}
	
	
	

}
