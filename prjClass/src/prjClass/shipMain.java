package prjClass;

public class shipMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  -Use methods from the stand-alone class to change one of the object's 
			  attributes/properties/variables.
			-Use methods from the stand-alone class to output or display the current 
			  attributes/properties/variables for at least one of the objects.
			-Try to change the value of property/variable using inappropriate data. 
			  (Make sure you use the set method that checks for bad data so you can 
			  show how it protects the objects from being hacked with data that is Project: Class Specifications / 8
			  out of range or just plain wrong.) 
			-Use the appropriate get( ) method to display the before and after results 
of the property/variable.
• Demonstrate accessing the protected property/variable in one of the 
objects by changing that property/variable directly without using a set( ) 
method. 
• Use the appropriate get( ) method to display the before and after results 
of the property/variable.
• Demonstrate how the static variable is shared between multiple 
instances of the class (An object made from a class is an instance of 
that class).
		 * 
		 * 
		 * 
		 * 
		 */
		Ship ship1 = new Ship ();
		Ship ship2 = new Ship ("Chinese");
		Ship ship3 = new Ship(50,50,40,12,30,"Austrian");
		
		
		
		System.out.println("Ships: " + Integer.toString(ship1.countShips()));
		ship2.setLength(30);
		ship1.setLength(15);
		System.out.println(ship1.getLength());
		System.out.println(ship2.getLength());
	}

}
