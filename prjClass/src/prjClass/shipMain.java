package prjClass;

public class shipMain {

	public static void main(String[] args) {
		/*
		 *  +Use methods from the stand-alone class to change one of the object's attributes/properties/variables.
			  
			+Use methods from the stand-alone class to output or display the current attributes/properties/variables for at least one of the objects.
			
			+Try to change the value of property/variable using inappropriate data. Make sure you use the set method that checks for bad data so you can 
			  show how it protects the objects from being hacked with data that is out of range or just plain wrong.
			  
			+Use the appropriate get( ) method to display the before and after results of the property/variable.
			 
			+Demonstrate accessing the protected property/variable in one of the objects by changing that property/variable directly without using a set( ) method. 
			
			+Use the appropriate get( ) method to display the before and after results of the property/variable.
			
			+Demonstrate how the static variable is shared between multiple instances of the class.
		 */
		Ship ship1 = new Ship (); //Create a new ship
		System.out.println("Number of ships: " + ship1.shipCount); // Get the number of ships from ship1
		Ship ship2 = new Ship ("Chinese"); // Create a new ship
		System.out.println("Number of ships: " + ship2.shipCount); // Get the number of ships from the brand new ship2
		Ship ship3 = new Ship(50,50,40,12,30,"Austrian"); // Create a new ship
		System.out.println("Number of ships: " + ship3.shipCount + "\n"); // Get the number of ships from the brand new ship3
		
		System.out.println("Setting Ship1's length to 34...");
		ship1.setLength(34);
		System.out.println("Ship1's length: " + ship1.getLength() + "\n");
		
		System.out.println("ship3's speed: " + ship3.getSpeed());
		System.out.println("Attempting to set speed of ship3 to 200...");
		ship3.setSpeed(200);
		System.out.println("Ship3's speed: " + ship3.getSpeed());
		
		ship3.shipCount = 5;
		System.out.println("Ship count: " + ship2.shipCount);
		
	}
}
