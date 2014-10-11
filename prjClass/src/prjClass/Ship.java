package prjClass;

/**
 * Ship.java - A class for Java: Project Class
 * @author Dan Salmon
 * Created: 10/1/14
 */
public class Ship {

	// Pirates of the Superior 

	// ===============PROPERTIES=================
	private float defense = 0.0f;
	private float attack = 0.0f;
	private float length = 0.0f;
	private float width = 0.0f;
	private int speed = 0;
	private String nation = "";
	protected static int shipCount = 0;
	
	// ===========CONSTRUCTOR METHODS============
	public Ship () {
		//Default constructor method. No parameters
		shipCount++; //Increment the total ship counter
	} 
	
	public Ship (String paraNation) {
		// Overloaded constructor with one parameter. We'll auto-fill the rest based on nation.
		shipCount++; // Increment the total ship counter
		switch (paraNation) {
			case "Spanish":
				this.width = 15;
				this.length = 40;
				this.speed = 75;
				this.attack = 30;
				this.defense = 12;
				this.nation = "Spanish";
				break;
			case "Portugese":
				this.width = 25;
				this.length = 30;
				this.speed = 45;
				this.attack = 40;
				this.defense = 30;
				this.nation = "Portugese";
				break;
			case "Chinese":
				this.width = 20;
				this.length = 50;
				this.speed = 100;
				this.attack = 100;
				this.defense = 100;
				this.nation = "Spanish";
				break;
			default:
				System.out.println("That is not a pre-defined nationality of ship. Creating a blank ship.");
		}
	}
	public Ship (float paraDefense,int paraAttack,float paraLength,float paraWidth,int paraSpeed,String paraNation) {
		// Overloaded constructor method with 4 parameters. We'll leave the rest alone for now.
		shipCount++; //Increment the total ship counter
		this.width = paraWidth;
		this.length = paraLength;
		this.speed = paraSpeed;
		this.attack = paraAttack;
		this.defense = paraAttack;
		this.nation = paraNation;
	}
	
	// ==============SET METHODS=====================
	public void setDefense (float paraDefense) {
		//Validate our input
		if (paraDefense > 100) {
			System.out.println("That's too big! Max defense is 100");
		} else {
			this.defense = paraDefense;
		}
	}
	
	public void setAttack (float paraAttack) {
		if (paraAttack > 100) {
			// More than 100 attack is against the rules.
			System.out.println("That's too big! Max attack is 100");
		} else {
			this.attack = paraAttack;
		}
	}
	
	public void setLength (float paraLength) {
		// Validate this input.
		if (paraLength > 50) { // Too long!
			System.out.println("That's too long! Max length is: 50m");
		} else { // It checks out.
			this.length = paraLength;
		}
	}
	
	public void setWidth (float paraWidth) {
		if (paraWidth > 20) {
			System.out.println("That's too wide! The max width is 20");
			System.out.println("Setting the width to default of 10\n");
			this.width = 10;
		} else {
			this.width = paraWidth;
		}
	}

	public void setSpeed (int paraSpeed) {
		if (paraSpeed > 100) {
			// Invalid
			System.out.println("That's too fast! Max speed is 100.");
			System.out.println("Setting the speed to default of 50.\n");
			this.speed = 50;
		} else {
			this.speed = paraSpeed;
		}
	}
	
	public void setNation (String paraNation) {
		// We'll take pretty much anything.
		this.nation = paraNation;
	}
	
	// ==============GET METHODS=====================
	public float getDefense () {
		return this.defense;
	}
	
	public float getAttack() {
		return this.attack;
	}
	
	public float getLength () {
		return this.length;
	}
	
	public float getWidth () {
		return this.width;
	}
	
	public int getSpeed () {
		return this.speed;
	}
	
	public String getNation () {
		return this.nation;
	}
	
	public int countShips () {
		return shipCount;
	}
	// ==========OTHER METHODS====================
	public void changeHeading (float heading) {
		System.out.println("Changing ship heading to " + heading + "\u00b0" + ".");
	}
	
	public void fireGuns (char ps) {
		// Parameter is a character. Either P for port or S for starboard.
		switch (Character.toString(ps)) {
		case "P":
			System.out.println("Firing all guns on the port side!");
			break;
		case "S":
			System.out.println("Firing all gund on the starboard side!");
			break;
		default:
			System.out.println("Error: Valid directions are either P for port or S for starboard.");
		}
	}
	
	public void dropAnchors () {
		System.out.println("Dropping anchors. You must stay here for at least 2 turns.");
	}
	
}
