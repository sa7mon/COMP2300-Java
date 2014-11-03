package prjInterface;

public class ServerTech extends Tech{

	public ServerTech() {
		super();
		this.onCall = true; // Directly access the protected variable in the parent class.
	}

	@Override
	public void whatAmI() {
		System.out.println("I'm a server tech!");
	}
}
