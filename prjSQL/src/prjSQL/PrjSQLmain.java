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
		
		String [] row1 = {"NULL","Ash Tree", "dc", "dc0003", "400","20","80"};
		util.insertData(row1, "inventory2");
		
		String [] row2 = {"NULL", "Oak Tree", "dc", "dc0002", "50", "65", "80"};
		util.insertData(row2, "inventory2");
		
		String [] row3 = {"NULL", "Christmas Tree", "eg", "eg0001", "20", "50", "100"};
		util.insertData(row3, "inventory2");
		
		String [] row4 = {"NULL", "Balsam Fir", "eg", "eg0002", "45", "10", "30"};
		util.insertData(row4, "inventory2");
		
		util.showTable("inventory2");
	}

}
