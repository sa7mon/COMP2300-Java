package prjSQL;

public class PrjSQLmain {

	/** This is the main method of the program.  It will contain short statements that leverage
	 * functions from SQLUtil.java.
	 * 
	 * By: Dan Salmon (https://github.com/sa7mon)
	 * Created on: 11/5/14
	 */
	public static void main(String[] args) {
		/*
	    -Create SQL object
		-Create table
		-Add 5-10 items
		-Display all items
		-Display all items in a category (Extract this from 
		the part number. The last two letters designate a category)
		-Edit an item in that category
		-Delete an item in the that category
		-Display all items sorted by category
		 */
		
		SQLutil util = new SQLutil();
		util.createTable("inventory2");
		
		String [] row1 = {"NULL","Another thing", "dc0003", "400","20","80"};
		util.insertData(row1, "inventory2");
		
	}

}
