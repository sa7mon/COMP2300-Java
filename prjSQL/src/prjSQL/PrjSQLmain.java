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
		String [] row1 = {"NULL","Ash Tree", "dc", "0003dc", "400","20","80"};
		util.insertData(row1, "inventory2");
		String [] row2 = {"NULL", "Oak Tree", "dc", "0002dc", "50", "65", "80"};
		util.insertData(row2, "inventory2");
		String [] row3 = {"NULL", "Christmas Tree", "eg", "0001eg", "20", "50", "100"};
		util.insertData(row3, "inventory2");
		String [] row4 = {"NULL", "Balsam Fir", "eg", "0002eg", "45", "10", "30"};
		util.insertData(row4, "inventory2");
		String [] row5 = {"NULL","Willow Tree","dc","0001dc","50", "30", "60"};
		util.insertData(row5, "inventory2");
		String [] row6 = {"NULL", "Maple Tree", "dc", "0004dc","10","45","90"};
		util.insertData(row6, "inventory2");
		String [] row7 = {"NULL", "Black Hill Spruce", "eg", "0003eg", "15", "90","180"};
		util.insertData(row7, "inventory2");
		String [] row8 = {"NULL", "Colorado Spruce", "eg", "0004eg", "12","30","60" };
		util.insertData(row8, "inventory2");
		
		util.showTable("inventory2");
		util.showCategory("0002dc", "inventory2");
		util.updateRecord("inventory2");
		util.deleteRecord("2", "inventory2");
		util.showAllByCategory("inventory2");
	}
}
