package se450.yang.logistics;

public class NoFacilityFoundException extends RuntimeException {

	public NoFacilityFoundException (Vertex facility)
	{
		super("There is no facility "+ facility);
	}
}
