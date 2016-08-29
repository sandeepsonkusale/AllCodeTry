package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MConnector {
	public static void main(String Args[]){System.out.print("Here is Im going to connect Maria");}
	public void call(){
		int insRecords=1000;
		int insRecordsP=50;
		int updateRecords=200;
		System.out.println("Here is Im going to connect Maria. Getting DB Connection ");
		// Elapsed Time Calculation 
		System.out.println("====================================================");
		long startTime = System.currentTimeMillis();
		try{
		//insertIntoDB(insRecords);
			//insertIntoDBGetMultiConnections(insRecordsP);
			updateRecordToTable(updateRecords);
		}catch(SQLException e){System.out.println(e.toString());}
		long stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time for Insert: "+ (stopTime - startTime));
		
		startTime = System.currentTimeMillis();
		try{
		//insertIntoDB(insRecords);
			readFromoDB();
		}catch(SQLException e){System.out.println(e.toString());}
		stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time for Read: "+ (stopTime - startTime));
		
		System.out.println("====================================================");
	}
	
	// Insert into DB
	public static void insertIntoDB(int records) throws SQLException
	{
	    //Statement st = getDBConnection().createStatement();
			PreparedStatement pst = getDBConnection().prepareStatement("INSERT INTO Employee (id, first_name, last_name, designation, salary, department, location, experience, reporting_to) values (?,?,?,?,?,?,?,?,?)");
			// Check the connection
			int i=0;
			int counter=0;
			int batchNo=0;
			for (i=0;i<= records; i++, counter++ )
			{
			pst.setInt(1, i);
			pst.setString(2, i+"F");
			pst.setString(3, i+"L");
			pst.setString(4, i+"Desi");
			pst.setInt(5, i+10);
			pst.setString(6, i+"dept");
			pst.setString(7, i+"Loc");
			pst.setInt(8, i);
			pst.setInt(9, i);
			pst.addBatch();
			if ( counter == 100)
			{	batchNo++;
				System.out.println("Executing Bacth Number:"+batchNo);
				counter=0;
			try{
				int[] exe = pst.executeBatch();
				System.out.println("Executed Results:"+ exe.length);
				
				}catch(SQLException sqe){System.out.println("Exception"+sqe.toString());}
			}
			}
		}
    
	// Insert into DB
		public static void insertIntoDBGetMultiConnections(int records) throws SQLException
		{
		    //Statement st = getDBConnection().createStatement();
				
				// Check the connection
				int i=0;
				int counter=0;
				int batchNo=0;
				for (i=0;i<= records; i++, counter++ )
				{
					PreparedStatement pst = getDBConnection().prepareStatement("INSERT INTO Employee (id, first_name, last_name, designation, salary, department, location, experience, reporting_to) values (?,?,?,?,?,?,?,?,?)");
					pst.setInt(1, i);
					pst.setString(2, i+"F");
					pst.setString(3, i+"L");
					pst.setString(4, i+"Desi");
					pst.setInt(5, i+10);
					pst.setString(6, i+"dept");
					pst.setString(7, i+"Loc");
					pst.setInt(8, i);
					pst.setInt(9, i);
					pst.addBatch();
					int[] exe = pst.executeBatch();
				if ( getDBConnection().isValid(1)){ getDBConnection().close();}
				}
			}
		// Method to read from DB	
		public ResultSet readFromoDB() throws SQLException
			{
			    Statement statement = getDBConnection().createStatement(); 
				// Check the connection
			    ResultSet rs = statement.executeQuery("select * from employee limit 1000;");
			    //System.out.println("List result set for reference...."+rs.getRow()+rs.getFetchSize());
			    //Call printRS function to print the RS
			    printRs(rs);
					//Close the conneciton
			    return rs;
			}
		
	
	// Method to Print the ResultSet
	public static void printRs(ResultSet rs) throws SQLException{
	      //Ensure we start with first row
	      rs.beforeFirst();
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         String first = rs.getString("first_name");
	         String last = rs.getString("last_name");
	         int salary = rs.getInt("salary");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", Age: " + salary);
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	     }
	     System.out.println();
	   }//end printRs()
	
	// Update Records in Employee Table..
	private static void updateRecordToTable(int records) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement pst = null;

		String updateTableSQL = "UPDATE employee SET first_name = ?,last_name=? "
				                  + " WHERE id = ?";

		try {
			dbConnection = getDBConnection();
			int i=0;
			int counter=0;
			int batchNo=0;
			for (i=0;i<= records; i++, counter++ )
			{
				pst = dbConnection.prepareStatement(updateTableSQL);
				pst.setInt(3, i);
				pst.setString(1, i+"FF");
				pst.setString(2, i+"LL");
				//pst.addBatch();
				
			// execute update SQL statement
				pst.executeUpdate();
				
				if ( counter == 100)
				{	batchNo++;
					System.out.println("Executing Bacth Number:"+batchNo);
					counter=0;
				try{
					
					int[] exe = pst.executeBatch();
					System.out.println("Executed Results:"+ exe.length);
					
					}catch(SQLException sqe){System.out.println("Exception"+sqe.toString());}
				}
				
			}
			System.out.println("Record is updated to DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (pst != null) {
				pst.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	//Get the connection
		private static Connection getDBConnection(){
			// Check the driver
			Connection con=null;
			try{
		        Class.forName("org.mariadb.jdbc.Driver");  
		      con = DriverManager.getConnection(  
		              "jdbc:mariadb://localhost:3306/MonkeyDB", "root", "root");  

		     }catch(Exception e){System.out.println("Exception"+e.toString());}
			return con;
			}// GetDBCOnnection Ends
	
	
	}

	
