package prjSQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class SQLutil {
	/**
	 * SQLUtil - The class that will hold all of our useful functions for connecting to SQL
	 * 
	 * Referenced Libraries: mysql-connector-java-5.1.33-bin.jar
	 * Download: https://dev.mysql.com/downloads/file.php?id=454396 (tar.gz 3.5M)
	 * 
	 */
	
	/*---------------------CONSTANTS-----------------------*/
	
    private final static String DB = "prjsql"; 
    private final static String TABLE = "inventory2";
    private final static String user = "root";
    private final static String pass = "root";
    private final static String mySqlServer = "localhost";
    private final static int portNumber = 3306; /* MAMP set to 3306*/
    
    /*-------------------------------------CONSTRUCTORS------------------------------------------------*/
    /**
     * Default constructor
     */
    public SQLutil() { }
    
    /*-----------------------------------RESUSABLE FUNCTIONS--------------------------------------*/

	/**
	 * getConnection - Connects to the database.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException 
    {
       Connection conn = null;
       Properties connectionProps = new Properties();
       connectionProps.put("user", this.user);
       connectionProps.put("password", this.pass);

       conn = DriverManager.getConnection("jdbc:mysql://"
               + this.mySqlServer + ":" + this.portNumber + "/" + DB,
               connectionProps);
       return conn;
    }
    
	/**
	 * executeUpdate - Execute an SQL command that doesn't return a ResultSet.
	 * e.g. CREATE/INSERT/UPDATE/DELETE/DROP
	 * 
	 * @param conn - Connection to SQL database.
	 * @param command - Command to run that returns nothing.
	 * @return Boolean whether or not it was successful
	 * @throws SQLException
	 */
    public boolean executeUpdate(Connection conn, String command) throws SQLException 
    {
       Statement stmt = null;
       try 
       {
           stmt = conn.createStatement();
           stmt.executeUpdate(command); // This will throw a SQLException if it fails
           return true;
       } 
       finally 
       {
           // This will run whether we throw an exception or not
           if (stmt != null) { stmt.close(); }
       }
   } // end of executeUpdate( )
	
    /**
     * executeQuery - Run a SQL command which returns a result set:
     * SELECT
     * 
     * @throws SQLException If something goes wrong
     * @return ResultSet containing data from the table
     */
    public ResultSet executeQuery(Connection conn, String command) throws SQLException 
    {
       ResultSet rs; 
       Statement stmt = null;
        try 
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(command); // This will throw a SQLException if it fails
            return rs;
        } 
        finally 
        {
            // This will run whether we throw an exception or not
            if (stmt != null) { stmt.close(); }           
        }
    } // end of executeQuery( )

    /**
     * releaseResource( ) - Free up the system resources that were opened.
     *                      If not used,  a null will be passed in for that parameter.
     * @param rs - ResultSet
     * @param ps - Statement
     * @param conn - Connection
     */
    public void releaseResource(ResultSet rs, Statement ps, Connection conn )
    {
       if (rs != null) 
       {
          try { rs.close(); } 
          catch (SQLException e) { /* ignored */}
       }
       if (ps != null) 
       {
          try { ps.close(); } 
          catch (SQLException e) { /* ignored */}
       }
       if (conn != null) 
       {
          try { conn.close();}
          catch (SQLException e) { /* ignored */}
       }
    }
    
    
    /* ------------------------------------ CUSTOM FUNCTIONS ---------------------------------------*/
    
    
    /**
     * createTable() - Creates a table after connecting to the db.
     * 					Doesn't currently check for table's existence.
     * @param tableName
     */
    public void createTable() {
    	Connection conn = null;
    	
    	String sql = "CREATE TABLE " + TABLE + " ( " +
    				 "`id` int(10) NOT NULL, " +
    				 "`descr` varchar(500) NOT NULL, " + 
    				 "`category` varchar(20) NOT NULL, " +
    				 "`partno` varchar(20) NOT NULL, " + 
    				 "`qty` int(10) NOT NULL, " + 
    				 "`cost` varchar(10) NOT NULL, " +
					 "`price` varchar(10) NOT NULL ) "+ 
    				 "ENGINE=InnoDB DEFAULT CHARSET=latin1;"; 
    	String sql2 ="ALTER TABLE " + TABLE + " ADD PRIMARY KEY (`id`), " +
    				 "ADD UNIQUE KEY `key` (`id`);";
    	String sql3 ="ALTER TABLE " + TABLE + " MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;";
    	
    	// Make a connection to the SQL database
    	try {
    		conn = this.getConnection();
    	}
    	catch (SQLException e) {
    		System.out.println("ERROR: Couldn't connect to the SQL database\n");
    		e.printStackTrace();
    		return;
    	} // end try
    	
    	// Try to create the table
    	try {
    		this.executeUpdate(conn,  sql);
    		System.out.println("Created table named: " + TABLE);
    	}
    	catch(SQLException e) {
    		System.out.println("ERROR: Couldn't create the table named: " + TABLE);
    		e.printStackTrace();
    		return;
    	}
    	
    	//Try to make the key field unique
    	try {
    		this.executeUpdate(conn, sql2);
    		System.out.println("Successfully added unique attribute to key field");
    	}
    	catch (SQLException e){
    		System.out.println("ERROR: Couldn't set key field with unique attribute.");
    		e.printStackTrace();
    		return;
    	}
    	
    	try{
    		this.executeUpdate(conn, sql3);
    		System.out.println("Successfully added AUTO_INCREMENT attribute to key field.");
    	}
    	catch (SQLException e) {
    		System.out.println("ERROR: Couldn't set AUTO_INCREMENT attribute to key field.");
    		e.printStackTrace();
    		return;
    	}
    	// Release the resources
    	finally {releaseResource(null,null,conn);}
    } // End of createTable()
    
    /**
     * insertData() - Creates a new record with data passed from array of data.
     * 
     * @param rowArray - Array of data insert into the record.
     * @param thisTable - Defines which table to add records into.
     */
    public void insertData(String [] rowArray) {
    	Connection conn = null;
    	String sql = "";
    	
    	try { //Try to connect to the database.
    		conn = this.getConnection();
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't connect to the database. (insertData())");
    		e.printStackTrace();
    	}
    	
    	// Try to insert the data
    	try {
    		sql = "INSERT INTO `" + DB + "`.`" + TABLE + "` (`id`, `descr`, `category`, `partno`, `qty`, `cost`, `price`) "
    				+ "VALUES (" 
    				+ rowArray[0] + ","
    				+ "'" + rowArray[1] + "',"
    				+ "'" + rowArray[2] + "',"
    				+ "'" + rowArray[3] + "',"
    				+ "'" + rowArray[4] + "',"
    				+ "'" + rowArray[5] + "',"
    				+ "'" + rowArray[5] + "');";
    		this.executeUpdate(conn, sql);
    		System.out.println("Inserted a record.");
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't insert the data.");
    		e.printStackTrace();
    	}
    	finally { 
    		releaseResource(null,null,conn);
    	}
    	
    } // End insertData()

    /**
     * showTable -  Outputs the result of a query to show all columns in all rows.
     * @param tableName
     */
    public void showTable() {
    	String sql = "";
    	Statement stmt = null;
    	ResultSet rs = null;
    	int id = 0;
    	
    	// Connect to the DB
    	Connection conn = null;
    	try {
    		conn = this.getConnection();
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't connect to the db. (showTable)");
    		e.printStackTrace();
    	}
    	// Run query
    	try {
    		sql="SELECT * FROM " + TABLE;
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql);
    		
    		System.out.println("------------------------ Showing all records from table ----------------------------");
    		while (rs.next()) {
    			System.out.println("################ ID: " + rs.getInt("id") + " #################");
    			System.out.println("# Description: " + rs.getString("descr"));
    			System.out.println("# Category:    " + rs.getString("category"));
    			System.out.println("# Part No:     " + rs.getString("partno"));
    			System.out.println("# Quantity:    " + rs.getInt("qty"));
    			System.out.println("# Cost:        " + rs.getString("cost"));
    			System.out.println("# Price:       " + rs.getString("price"));
    			System.out.println("########################################");
    		}
    	} catch (SQLException e) {
    		System.out.println("Error: SELECT error on sql: " + sql);
    		e.printStackTrace();
    	}
    	finally {
    		releaseResource(rs,stmt,conn); 
    	}
    	
    } //End showTable
    
    /**
     * showCategory - Shows all records in a given category. 
     * 				Category determined by last two of partNo.
     * @param partNo
     * @param tableName
     */
    public void showCategory (String partNo) {
    	String sql = "";
    	Statement stmt = null;
    	ResultSet rs = null;
    	String category = "";
    	//Get category from substring of partNo
    	category = partNo.substring(partNo.length() -2);
    	
    	// Connect to the DB
    	Connection conn = null;
    	try {
    		conn = this.getConnection();
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't connect to the db. (showCategory)");
    		e.printStackTrace();
    	}
    	// Run query
    	try {
    		sql="SELECT * FROM " + TABLE + " WHERE `category` = '" + category + "'";
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql);
    		
    		System.out.println("------------------------- Showing all records from category `dc` --------------------------");
    		while (rs.next()) {
    			System.out.println("################ ID: " + rs.getInt("id") + " #################");
    			System.out.println("# Description: " + rs.getString("descr"));
    			System.out.println("# Category:    " + rs.getString("category"));
    			System.out.println("# Part No:     " + rs.getString("partno"));
    			System.out.println("# Quantity:    " + rs.getInt("qty"));
    			System.out.println("# Cost:        " + rs.getString("cost"));
    			System.out.println("# Price:       " + rs.getString("price"));
    			System.out.println("########################################");
    		}
    	} catch (SQLException e) {
    		System.out.println("Error: SELECT error on sql: " + sql);
    		e.printStackTrace();
    	}
    	finally {
    		releaseResource(rs,stmt,conn); 
    	}
    } //End showCategory()
    
    /**
     * updateRecord() - Changes the data of an existing record.
     * 
     * @param tableName
     */
    public void updateRecord () {
    	Connection conn = null;
    	String sql = "";
    	
    	//Try to connect to the database.
    	try { 
    		conn = this.getConnection();
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't connect to the database. (updateRecord() )");
    		e.printStackTrace();
    	}
    	// Try to insert the data
    	try {
    		sql = "UPDATE " + TABLE + " SET `cost` = '200' WHERE `" + TABLE + "`.`id` = 1";
    		this.executeUpdate(conn, sql);
    		System.out.println("Changed cost of record #1.");
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't insert the data using hard-coded data.");
    		e.printStackTrace();
    	}
    	finally { releaseResource(null,null,conn);}
    } // End updateRecord() 

    /**
     * deleteRecord - Deletes a record based on ID.
     * 
     * @param id - ID of record to delete.
     * @param tableName - Table to delete record from.
     */
    public void deleteRecord (String id) {
    	Connection conn = null;
    	String sql = "";
    	
    	//Try to connect to the database.
    	try { 
    		conn = this.getConnection();
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't connect to the database. (deleteRecord() )");
    		e.printStackTrace();
    	}
    	// Try to delete the record by id
    	try {    		
    		sql = "DELETE FROM " + TABLE + " WHERE id = " + id;
    		this.executeUpdate(conn, sql);
    		System.out.println("Deleted record #" + id);
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't delete the record.");
    		e.printStackTrace();
    	}
    	finally { releaseResource(null,null,conn);}	
    } // End deleteRecord()

    /**
     * showAllByCategory - Displays all record, sorted by category: ascending.
     * @param tableName
     */
    public void showAllByCategory () {
    	String sql = "";
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	// Connect to the DB
    	Connection conn = null;
    	try {
    		conn = this.getConnection();
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't connect to the db. (showAllByCategory() )");
    		e.printStackTrace();
    	}
    	// Run query
    	try {
    		sql="SELECT * FROM `" + TABLE + "` ORDER BY `" + TABLE + "`.`category` ASC";
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql);
    		
    		System.out.println("--------------------- Diplaying all records sorted by category -----------------------");
    		while (rs.next()) {
    			System.out.println("################ ID: " + rs.getInt("id") + " #################");
    			System.out.println("# Description: " + rs.getString("descr"));
    			System.out.println("# Category:    " + rs.getString("category"));
    			System.out.println("# Part No:     " + rs.getString("partno"));
    			System.out.println("# Quantity:    " + rs.getInt("qty"));
    			System.out.println("# Cost:        " + rs.getString("cost"));
    			System.out.println("# Price:       " + rs.getString("price"));
    			System.out.println("########################################");
    			}
    	} catch (SQLException e) {
    		System.out.println("Error: SELECT error on sql: " + sql);
    		e.printStackTrace();
    	}
    	finally {releaseResource(rs,stmt,conn); }
    }
}// End public class
