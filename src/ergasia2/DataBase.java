package ergasia2;
import java.sql.*;
import java.util.ArrayList;
public class DataBase {
	static Connection db_con_obj=null;
	static PreparedStatement db_prep_obj=null;
	
	public static void DBconnection(){	
		try {//We check that the DB Driver is available in our project.		
			Class.forName("oracle.jdbc.driver.OracleDriver"); //This code line is to check that JDBC driver is available. Or else it will throw an exception. Check it with 2. 
			System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
			db_con_obj = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl","it21818","it21818");// Returns a connection to the URL.
			//Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
			if (db_con_obj != null) { 
				System.out.println("Connection Successful! Enjoy. Now it's time to CRUD data. ");
				
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}
	}
	public static ArrayList<City> ReadData() throws SQLException {
	db_prep_obj = db_con_obj.prepareStatement("select * from cities");
	ResultSet  rs = db_prep_obj.executeQuery();
	ArrayList<City> AllCities=new ArrayList<>();
    while (rs.next()){
    	City c=new City();
        String name = rs.getString("name");
        int museums = rs.getInt("museums");
        int cafesRestaurantsBars = rs.getInt("cafesRestaurantsBars");
        int skyscrapers=rs.getInt("skyscrapers");
        int galleries=rs.getInt("galleries");
        int parks=rs.getInt("parks");
        int sea=rs.getInt("sea");
        int shops=rs.getInt("shops");
        int landmarks=rs.getInt("landmarks");
        String weather = rs.getString("weather");
        double lat = rs.getDouble("lat");
        double lon = rs.getFloat("lon");
        //int wordCount = rs.getInt("wordCount");
        c.setName(name);
        c.setMuseums(museums);
        c.setCafesRestaurantsBars(cafesRestaurantsBars);
        c.setSkyscrapers(skyscrapers);
        c.setGalleries(galleries);
        c.setParks(parks);
        c.setSea(sea);
        c.setShops(shops);
        c.setLandmarks(landmarks);
        c.setWeather(weather);
        c.setLat(lat);
        c.setLon(lon);
        //System.out.println("The data are: "+ name + " "+ museums+" "+cafesRestaurantsBars+" "+ skyscrapers+" "+galleries+" "+parks+" "+sea+" "+shops+" "+landmarks+" "+weather+" "+lat+" "+lon+" ");
        AllCities.add(c);
    }
    return AllCities;
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
			int numRowChanged=db_prep_obj.executeUpdate(); 
			System.out.println("Rows "+numRowChanged+" changed.");
		} catch (SQLException e) {
			System.out.println("Already exists to database");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}