package OpenData;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;



public class RetrieveDataThread implements Runnable{
	
	private String city;
	private String Country;
	private String appid;
	
	public RetrieveDataThread(String city,String Country,String appid) {
		this.city=city;
		this.Country=Country;
		this.appid=appid;
	}
	
	// public static void RetrieveData(String city, String country, String appid) throws  IOException {
	public void run() {
		 ObjectMapper mapper = new ObjectMapper(); 
		 OpenWeatherMap weather_obj = null;
		try {
			weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+Country+"&APPID="+appid+""), OpenWeatherMap.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		 System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
		 MediaWiki mediaWiki_obj = null;
		try {
			mediaWiki_obj = mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());	 
		 String extracts= mediaWiki_obj.getQuery().getPages().get(0).getExtract();
		 System.out.println("hello tread");
	}
	public static void main(String args[]) {
		RetrieveDataThread t=new RetrieveDataThread("Athens","gr","eec6890cb4afa0e897cce002c69e11f0");
		Thread t1=new Thread(t);
		t1.start();
	}

}
