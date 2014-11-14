
package prjSQL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class SQLutil {
	/* SQLUtil - The class that will hold all of our useful functions for connecting to SQL
	 * 
	 * Referenced libs: mysql-connector-java-5.1.33-bin.jar
	 * 
	 */
	
	/*---------------------CONSTANTS-----------------------*/
	
    private final static String DB = "prjsql"; 
    private final static String TABLE = "customer";
    private final static String user = "root";
    private final static String pass = "root";
    private final static String mySqlServer = "localhost";
    private final static int portNumber = 3306; /* MAMP set to 3306*/
    
    /*-------------------CONSTRUCTORS-----------------------*/
    /**
     * Default constructor
     */
    public SQLutil() { }
    
    /*-----------------CRUD FUNCTIONS-----------------------*/

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
     * @param rs - Resultset
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
    
    
    public void createTable(String tableName) {
    	Connection conn = null;
    	
    	String sql = "CREATE TABLE " + tableName + " ( " +
    				 "`id` int(10) NOT NULL, " +
    				 "`descr` varchar(500) NOT NULL, " + 
    				 "`partno` varchar(20) NOT NULL, " + 
    				 "`qty` int(10) NOT NULL, " + 
    				 "`cost` varchar(10) NOT NULL, " +
					 "`price` varchar(10) NOT NULL ) "+ 
    				 "ENGINE=InnoDB DEFAULT CHARSET=latin1;"; 
    	String sql2 ="ALTER TABLE " + tableName + " ADD PRIMARY KEY (`id`), " +
    				 "ADD UNIQUE KEY `key` (`id`);";
    	String sql3 ="ALTER TABLE " + tableName + " MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;";
    	
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
    		System.out.println("Created table named: " + tableName);
    	}
    	catch(SQLException e) {
    		System.out.println("ERROR: Couldn't create the table named: " + tableName);
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
    
    public void insertData(String [] rowArray, String thisTable) {
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
    		sql = "INSERT INTO `" + DB + "`.`" + thisTable + "` (`id`, `descr`, `partno`, `qty`, `cost`, `price`) "
    				+ "VALUES (" 
    				+ rowArray[0] + ","
    				+ "'" + rowArray[1] + "',"
    				+ "'" + rowArray[2] + "',"
    				+ "'" + rowArray[3] + "',"
    				+ "'" + rowArray[4] + "',"
    				+ "'" + rowArray[5] + "');";
    		this.executeUpdate(conn, sql);
    		System.out.println("Inserted a record with hard-coded data.");
    	} catch (SQLException e) {
    		System.out.println("ERROR: Couldn't insert the data using hard-coded data.");
    		e.printStackTrace();
    	}
    	
    	finally { releaseResource(null,null,conn);}
    	
    } // End insertData()
    
}// End public class
