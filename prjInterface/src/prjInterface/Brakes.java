package prjInterface;

public class Brakes implements Parts{
	/*- Include at least three private properties
	- Include at least one protected property
	- Include at least two constructor methods (one will be the default). You can have more constructors 
	if you think it will make your class more useful.
	- Include setters and getters for the properties you want exposed for other 
	classes to use.
	- Include at least one method that is unique to each class
	*/
	
	// Properties
	// 3 private
	// At least one protected
	private int qty = 0;
	private int pressureRating = 0;
	private String description = "";
	protected float price = 0.0f;
	
	// Methods
	// At least 2 constructors
	// Setters and getters for private properties
	// At least one unique method
	
	//==============Constructors=======================
	public Brakes () {}
	public Brakes (int inpQty, int inpPressureRating,String inpDescription, float inpPrice) {
		
	}
	
	@Override
	public void addQuantity() {
		
	}
	@Override
	public void getDescription() {
		String description = "qwer";
		System.out.println(description);
	}

}
