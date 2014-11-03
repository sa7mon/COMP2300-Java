package prjInterface;

public class Tech implements Employee{

	/*
	 * Inherited properties:
	 * company: String
	 * salary: float
	 * 
	 * 
	 */
	
	//===========================PROPERTIES==============================//
	private int tier = 0;
	private int companyCarID = 0;
	private int accessLevel = 0;
	protected boolean onCall = false;
	private float salary = 0;
	
	//=============================METHODS===============================//
	
	//=====Constructor Methods=====//
	public Tech() {
		// Default constructor
		System.out.println("New tech created!");
	}
	
	public Tech(int inCompanyCarID, int inAccessLevel, boolean inOnCall){
		//Other constructor
		this.companyCarID = inCompanyCarID;
		this.accessLevel = inAccessLevel;
		this.onCall = inOnCall;
		System.out.println("New specific tech created!");
	}
	
	//=====Inherited Methods=======//
	public void increaseSalary() {
		this.salary += 1000;
	}
	public void decreaseSalary() {
		this.salary -= 1000;
	}
	public void promote() {
		System.out.println("Congratulations! This employee has been promoted.");
	}
	
	//=====Unique Method===========//
	public void whatAmI() {
		System.out.println("I am a tech.");
	}
	
	//=====Setter/Getter Methods==//
	public void setTier(int inTier) { this.tier = inTier; }
	public void setCompanyID (int inCompanyCarID) { this.companyCarID = inCompanyCarID; }	
	public void setOnCall (boolean inOnCall) {this.onCall = inOnCall; }
	public void setAccessLevel(int inAccessLevel) { this.accessLevel = inAccessLevel; }
	
	public int getAccessLevel () { return this.accessLevel; }
	public int getTier () { return this.tier;}
	public int getCompanyCarID () { return this.companyCarID; }
	public boolean getOnCall() { return this.onCall; }
	public float getSalary() { return this.salary; }
}
