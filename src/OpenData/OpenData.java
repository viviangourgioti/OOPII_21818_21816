package OpenData;
import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

/**City description and weather information using OpenData with Jackson JSON processor.
* @since 29-2-2020
* @version 1.0
* @author John Violos */
public class OpenData {

/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city.
* @param city The Wikipedia article and OpenWeatherMap city. 
* @param country The country initials (i.e. gr, it, de).
* @param appid Your API key of the OpenWeatherMap.*/ 
 public static void RetrieveData(String city, String country, String appid) throws  IOException {
	 ObjectMapper mapper = new ObjectMapper(); 
	 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
	 System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
	 System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
	 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
	//System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());	 
	 String extracts= mediaWiki_obj.getQuery().getPages().get(0).getExtract();
	 String[] criterions = {"museum","cafes" ,"skyscrapers","galleries","parks" ,"sea", "shops"};
		for (int i=0; i<criterions.length;i++) { 
			System.out.println("The term "+criterions[i]+" occurs "+countCriterionfCity(extracts,criterions[i]) + " number of times.");		
		}
}
 public static String article(String city, String country) throws  IOException {
	 ObjectMapper mapper = new ObjectMapper(); 
	 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
	 String extracts= mediaWiki_obj.getQuery().getPages().get(0).getExtract();
	 return extracts;
}
 public static double lat(String city, String country, String appid) throws  IOException {
	 ObjectMapper mapper = new ObjectMapper(); 
	 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
	 return weather_obj.getCoord().getLat();
}
 public static double lon(String city, String country, String appid) throws  IOException {
	 ObjectMapper mapper = new ObjectMapper(); 
	 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
	 return weather_obj.getCoord().getLon();
}
 public static String weather(String city, String country, String appid) throws  IOException {
	 ObjectMapper mapper = new ObjectMapper(); 
	 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
	 return (weather_obj.getWeather()).get(0).getMain();
}

	public static int countTotalWords(String str) {	
		String s[]=str.split(" ");
		return 	s.length;
	}	
	
	public static int countCriterionfCity(String cityArticle, String criterion) {
		cityArticle=cityArticle.toLowerCase();
		int index = cityArticle.indexOf(criterion);
		int count = 0;
		while (index != -1) {
		    count++;
		    cityArticle = cityArticle.substring(index + 1);
		    index = cityArticle.indexOf(criterion);
		}
		return count;
	}

 
public static void main(String[] args) throws IOException {
	String appid ="";
	RetrieveData("Rome","it",appid);	
	RetrieveData("Athens","gr",appid);
	RetrieveData("Corfu","gr",appid);	
	RetrieveData("Berlin","de",appid);	
}

}
