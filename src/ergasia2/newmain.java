package ergasia2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import OpenData.OpenData;

public class newmain {
	public static ArrayList<Traveller> ReadFile(ArrayList<Traveller> all) {
		
		File f = new File("TravellersData");
		if(f.exists()) {
	        try
	        {
	            FileInputStream fis = new FileInputStream("TravellersData");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            all = (ArrayList) ois.readObject();
	            ois.close();
	            fis.close();
	            System.out.println("Deserialization succeded");
	            System.out.println("All travellers so far:");
	            for(Traveller t:all) {
	            	System.out.println(t);
	            }
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	            //return;
	        } 
	        catch (ClassNotFoundException c) 
	        {
	            System.out.println("Class not found");
	            c.printStackTrace();
	           // return;
	        }
		}else {
			System.out.println("File does not exist!");
		}

		return all;
	}
	
	public static void serialize(ArrayList<Traveller>all){
		//serialization
		try
        {
            FileOutputStream fos = new FileOutputStream("TravellersData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(all);
            oos.close();
            fos.close();
            System.out.println("Serialazation succeded");
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
	}
	
	public static ArrayList<City> ReadDB(ArrayList<City> allCities){
		try {
			DataBase.DBconnection();
			allCities=DataBase.ReadData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return allCities;
	}
	
	public static void main(String args[]) throws IOException,MySpecialException,Exception{
		Frame fr=new Frame();
		fr.showDemo();
	}	
		
}
