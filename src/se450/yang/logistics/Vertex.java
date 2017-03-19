package se450.yang.logistics;

import java.util.Objects;

public class Vertex {
	private final String location;

	public Vertex(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Facility [location=" + location + "]";
	}

}
