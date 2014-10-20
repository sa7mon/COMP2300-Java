package prjInterface;

public interface Parts {
	// Change quantity
	// Get description
	// Get model number
	// Cost
	// Weight
	// Static property (Common to all parts) e.g. - Picker ID: delivered on
	// Methods: 2 constructor, 1 default
	/* Classes:
	 * 
	 * Brakes
	 * Valves
	 * 
	 * Child class only has to override one method
	 */
	public void addQuantity();
	public void getDescription();
}