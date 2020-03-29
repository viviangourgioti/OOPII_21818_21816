package ergasia2;

import java.io.IOException;

import OpenData.OpenData;

public class City {
	private String name;
	private int museums;
	private int cafesRestaurantsBars;
	private int skyscrapers;
	private int galleries;
	private int parks;
	private int sea;
	private int shops;
	private int landmarks;
	private String weather;
	private double lat;
	private double lon;
	
	
	public int getLandmarks() {
		return landmarks;
	}
	public void setLandmarks(int landmarks) {
		this.landmarks = landmarks;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMuseums() {
		return museums;
	}
	public void setMuseums(int museums) {
		this.museums = museums;
	}
	public int getCafesRestaurantsBars() {
		return cafesRestaurantsBars;
	}
	public void setCafesRestaurantsBars(int cafesRestaurantsBars) {
		this.cafesRestaurantsBars = cafesRestaurantsBars;
	}
	public int getSkyscrapers() {
		return skyscrapers;
	}
	public void setSkyscrapers(int skyscrapers) {
		this.skyscrapers = skyscrapers;
	}
	public int getGalleries() {
		return galleries;
	}
	public void setGalleries(int galleries) {
		this.galleries = galleries;
	}
	public int getParks() {
		return parks;
	}
	public void setParks(int parks) {
		this.parks = parks;
	}
	public int getSea() {
		return sea;
	}
	public void setSea(int sea) {
		this.sea = sea;
	}
	public int getShops() {
		return shops;
	}
	public void setShops(int shops) {
		this.shops = shops;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}

	
	
	@Override
	public String toString() {
		return "City [name=" + name + ", museums=" + museums + ", cafesRestaurantsBars=" + cafesRestaurantsBars
				+ ", skyscrapers=" + skyscrapers + ", galleries=" + galleries + ", parks=" + parks + ", sea=" + sea
				+ ", shops=" + shops + ", weather=" + weather + ", lat=" + lat + ", lon=" + lon + ", landmarks=" + landmarks
				+ "]";
	}
	
	public City(String name, int museums, int cafesRestaurantsBars, int skyscrapers, int galleries, int parks, int sea,
			int shops, int hotels, String weather, double lat, double lon) {
		super();
		this.name = name;
		this.museums = museums;
		this.cafesRestaurantsBars = cafesRestaurantsBars;
		this.skyscrapers = skyscrapers;
		this.galleries = galleries;
		this.parks = parks;
		this.sea = sea;
		this.shops = shops;
		this.landmarks = hotels;
		this.weather = weather;
		this.lat = lat;
		this.lon = lon;
	}
	//empty constructor για να μπορώ να αρχικοποιώ αντικείμενα city
	public City() {}
	
	/*public void gemisma( City c,String cityname,String country) throws IOException {
		OpenData.RetrieveData(cityname, country,"eec6890cb4afa0e897cce002c69e11f0");
		String article=OpenData.article(cityname, country,"eec6890cb4afa0e897cce002c69e11f0" );
		//System.out.println(article);
		c.setName(cityname);
		c.setMuseums(OpenData.countCriterionfCity(article,"museum"));
		c.setCafesRestaurantsBars(OpenData.countCriterionfCity(article,"cafes"));
		c.setSkyscrapers(OpenData.countCriterionfCity(article,"skyscrapers"));
		c.setGalleries(OpenData.countCriterionfCity(article, "galleries"));
		c.setParks(OpenData.countCriterionfCity(article, "parks"));
		c.setSea(OpenData.countCriterionfCity(article, "sea"));
		c.setShops(OpenData.countCriterionfCity(article,"shops"));
		c.setLon(OpenData.lon(cityname, country,"eec6890cb4afa0e897cce002c69e11f0"));
		c.setLat(OpenData.lat(cityname, country,"eec6890cb4afa0e897cce002c69e11f0" ));
		c.setWeather(OpenData.weather(cityname, country,"eec6890cb4afa0e897cce002c69e11f0"));
		

	}*/
	public static City gemisma( String cityname,String country) throws IOException  {
		City c =new City();
		String article = OpenData.article(cityname, country);
		c.setName(cityname);
		c.setMuseums(OpenData.countCriterionfCity(article,"museum"));
		c.setCafesRestaurantsBars(OpenData.countCriterionfCity(article,"cafes"));
		c.setSkyscrapers(OpenData.countCriterionfCity(article,"skyscrapers"));
		c.setGalleries(OpenData.countCriterionfCity(article, "galleries"));
		c.setParks(OpenData.countCriterionfCity(article, "parks"));
		c.setSea(OpenData.countCriterionfCity(article, "sea"));
		c.setShops(OpenData.countCriterionfCity(article,"shops"));
		c.setLandmarks(OpenData.countCriterionfCity(article, "landmarks"));
		try {
			c.setLon(OpenData.lon(cityname, country,"eec6890cb4afa0e897cce002c69e11f0"));
			c.setLat(OpenData.lat(cityname, country,"eec6890cb4afa0e897cce002c69e11f0" ));
			c.setWeather(OpenData.weather(cityname, country,"eec6890cb4afa0e897cce002c69e11f0"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
		
	
	
	
	
}
