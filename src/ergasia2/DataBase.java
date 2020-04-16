package ergasia2;
import java.sql.*;
public class DataBase {
	static Connection db_con_obj=null;
	static PreparedStatement db_prep_obj=null;
	
	public static void DBconnection(){	
		try {//We check that the DB Driver is available in our project.		
			Class.forName("oracle.jdbc.driver.OracleDriver"); //This code line is to check that JDBC driver is available. Or else it will throw an exception. Check it with 2. 
			System.out.println("Congrats - Seems your SQLDeveloper JDBC Driver Registered!"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
			db_con_obj = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","it21818","it21818");// Returns a connection to the URL.
			//Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
			if (db_con_obj != null) { 
				System.out.println("Connection Successful! Enjoy. Now it's time to CRUD data. ");
				
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("SQLDeveloper Connection Failed!");
			e.printStackTrace();
			return;
		}
		/*try{  
			//step1 load the driver class  
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			db_con_obj=DriverManager.getConnection("jdbc:oracle:thin:@//10.100.51.123:1521/orcl","it21818","it21818");  
			if(db_con_obj!=null) {
				System.out.println("Congrats!Connection established!");
			}else {
				System.out.println("Connection Failed.");
			}
			 
			//step3 create the statement object  
			Statement stmt=db_con_obj.createStatement();  
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select * from Cities");  
			while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getInt(8)+" "+rs.getInt(9)+" "+rs.getString(10)+" "+rs.getDouble(11)+" "+rs.getDouble(12));  
			  
			//step5 close the connection object  
			db_con_obj.close();  
			  
			}catch(Exception e){ 
				System.out.println(e);
			}*/
	}
	
	public static void addDatatoDB(String name,int museums,int cafesRestaurantsBars,int skyscrapers,int galleries,int parks,int sea,int shops,int landmarks,String weather,double lat,double lon){
		
		try {
			String InsertQueryStatement="INSERT INTO Cities VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			db_prep_obj=db_con_obj.prepareStatement(InsertQueryStatement);
			db_prep_obj.setString(1,name);
			db_prep_obj.setInt(2,museums);
			db_prep_obj.setInt(3,cafesRestaurantsBars);
			db_prep_obj.setInt(4,skyscrapers);
			db_prep_obj.setInt(5,galleries);
			db_prep_obj.setInt(6,parks);
			db_prep_obj.setInt(7,sea);
			db_prep_obj.setInt(8,shops);
			db_prep_obj.setInt(9,landmarks);
			db_prep_obj.setString(10,weather);
			db_prep_obj.setDouble(11,lat);
			db_prep_obj.setDouble(12,lon);
			//db_prep_obj.executeUpdate(InsertQueryStatement);
			int numRowChanged = db_prep_obj.executeUpdate(); 
			System.out.println("Rows "+numRowChanged+" changed.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}