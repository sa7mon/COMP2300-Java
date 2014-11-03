package prjInterface;

public class BenchTech extends Tech{

	public BenchTech() {
		// TODO Auto-generated constructor stub
		super();
		this.onCall = false; // Directly access the protected variable in the parent class.
	}

	@Override
	public void whatAmI() {
		System.out.println("I'm a bench tech!");
	}
}
