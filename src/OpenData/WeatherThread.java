package OpenData;

import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;

public class WeatherThread implements Runnable{
	private String city;
	private String Country;
	private String appid;
	private volatile String  w;
	
	public WeatherThread(String city,String Country,String appid,String w) {
		this.city=city;
		this.Country=Country;
		this.appid=appid;
		this.w=w;
	}
	@Override
	public void run() {
		 ObjectMapper mapper = new ObjectMapper(); 
		 OpenWeatherMap weather_obj = null;
		try {
			weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+Country+"&APPID="+appid+""), OpenWeatherMap.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w=(weather_obj.getWeather()).get(0).getMain();
	}
	public String getW() {
		return w;
	}
	
	public static void main(String args[]) throws InterruptedException {
		WeatherThread wt=new WeatherThread("Athens","gr","eec6890cb4afa0e897cce002c69e11f0",null);
		Thread t=new Thread(wt);
		t.start();
		t.join();
		String weth=wt.getW();
		System.out.println(weth);
		
	}

}
