package prjSQL;

public class PrjSQLmain {

	/** This is the main method of the program.  It will contain short statements that leverage
	 * functions from SQLUtil.java.
	 * 
	 * By: Dan Salmon (https://github.com/sa7mon)
	 * Created on: 11/5/14
	 */
	public static void main(String[] args) {
		
		SQLutil util = new SQLutil(); // Create SQL object.
		util.createTable(); //Create table and import schema.
		
		// Insert data to work with
		String [] row1 = {"NULL","Ash Tree", "dc", "0003dc", "400","20","80"};
		util.insertData(row1);
		String [] row2 = {"NULL", "Oak Tree", "dc", "0002dc", "50", "65", "80"};
		util.insertData(row2);
		String [] row3 = {"NULL", "Christmas Tree", "eg", "0001eg", "20", "50", "100"};
		util.insertData(row3);
		String [] row4 = {"NULL", "Balsam Fir", "eg", "0002eg", "45", "10", "30"};
		util.insertData(row4);
		String [] row5 = {"NULL","Willow Tree","dc","0001dc","50", "30", "60"};
		util.insertData(row5);
		String [] row6 = {"NULL", "Maple Tree", "dc", "0004dc","10","45","90"};
		util.insertData(row6);
		String [] row7 = {"NULL", "Black Hill Spruce", "eg", "0003eg", "15", "90","180"};
		util.insertData(row7);
		String [] row8 = {"NULL", "Colorado Spruce", "eg", "0004eg", "12","30","60" };
		util.insertData(row8);
		
		util.showTable(); // Output all records in table.
		util.showCategory("0002dc"); // Output all records in the same category as an item.
		
		System.out.println("");
		util.updateRecord(); // Change the price of an item.
		util.deleteRecord("2"); // Delete a record by id number.
		
		System.out.println("");
		util.showAllByCategory(); // Outputs all records sorted by category.
	}
}
