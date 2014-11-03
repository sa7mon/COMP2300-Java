package prjInterface;

import java.util.ArrayList;

public class EmployeeMain {

	static ArrayList<Tech> TechTeam = new ArrayList <Tech>(); //Create our list of objects to populate
	
	public static void main(String[] args) {
		
		// Create and add Dan, a Bench Tech.
		Tech Dan = new BenchTech();
		TechTeam.add(Dan);
		// Create and add Jim, a Server Tech.
		Tech Jim = new ServerTech();
		TechTeam.add(Jim);
		// Create and add Jeremy, a Network Engineer.
		Tech Jeremy = new NetworkEngineer();
		TechTeam.add(Jeremy);
		
		// Loop through each tech in TechTeam, outputting what they are.
		
		for (int x=0; x<TechTeam.size(); x++) {
			//For every object in TechTeam.....
			TechTeam.get(x).whatAmI();
		}
		printMetaphor();
	}
	public static void printMetaphor () {
		/*
		 * A Java interface is like _______________________.
		2. An abstract method is like _________________________.
		3. Polymorphism is like ________________________.
		4. If a class is a(n) __________________ than an object is a(n) 
		__________________. 
		
		*/
		System.out.println("------------------");
		System.out.println("A java interface is like a set of rules that the programmer must follow. "
				+ "It dictates loosely what will be included in a class.");
		System.out.println("If an interface is a set of loose rules, then an abstract method is a group of much more defined rules."
				+ "It's a much more specific and defined rule for an individual method.");
		System.out.println("Polymorphism is like human genes.  Some of the properties of one parent will be exactly the same"
				+ "in the child, but some of the properties will be unique to that child.");
		System.out.println("If a class is a recipe, then an object is a cake.");
	}

}
