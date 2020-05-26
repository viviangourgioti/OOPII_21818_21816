package OpenData;

import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;

public class LatThread implements Runnable{
	private String city;
	private String Country;
	private String appid;
	private volatile Double l;
	
	public LatThread(String city,String Country,String appid,Double l) {
		this.city=city;
		this.Country=Country;
		this.appid=appid;
		this.l=l;
	}
	
	public Double getL() {
		return l;
	}

	public void run() {
		 ObjectMapper mapper = new ObjectMapper(); 
		 OpenWeatherMap weather_obj = null;
		try {
			weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+Country+"&APPID="+appid+""), OpenWeatherMap.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 l=weather_obj.getCoord().getLat();
	}
	public static void main(String args[]) throws InterruptedException {
		LatThread lt=new LatThread("Athens","gr","eec6890cb4afa0e897cce002c69e11f0",null);
		Thread t=new Thread(lt);
		t.start();
		t.join();
		double lat=lt.getL();
		System.out.println(lat);
		
	}
}
