package prjInterface;

public class NetworkEngineer extends Tech{
	public NetworkEngineer() {
		// Inherit everything from Tech
		super();
		this.onCall = true; // Directly access the protected variable from the parent class.
	}
	
	@Override
	public void whatAmI() {
		System.out.println("I'm a network engineer!");
	}
}

