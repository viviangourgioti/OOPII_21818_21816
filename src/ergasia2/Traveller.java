package ergasia2;

import java.util.ArrayList;

public class Traveller {
	protected String name;
	protected int age;
	protected int museums;
	protected int cafesRestaurantsBars;
	protected int skyscrapers;
	protected int galleries;
	protected int parks;
	protected int sea;
	protected int shops;
	protected String weather;
	protected double currentlat;
	protected double currentlon;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public double getCurrentlat() {
		return currentlat;
	}
	public void setCurrentlan(double currentlat) {
		this.currentlat= currentlat;
	}
	public double getCurrentlon() {
		return currentlon;
	}
	public void setCurrentlon(double currentlon) {
		this.currentlon = currentlon;
	}
	
	public Traveller(String name, int age, int museums, int cafesRestaurantsBars, int skyscrapers, int galleries,
			int parks, int sea, int shops, String weather, double currentlat, double currentlon) {
		//super();
		this.name = name;
		this.age = age;
		this.museums = museums;
		this.cafesRestaurantsBars = cafesRestaurantsBars;
		this.skyscrapers = skyscrapers;
		this.galleries = galleries;
		this.parks = parks;
		this.sea = sea;
		this.shops = shops;
		this.weather = weather;
		this.currentlat = currentlat;
		this.currentlon = currentlon;
	}
	
	@Override
	public String toString() {
		return "Traveller [name=" + name + ", age=" + age + ", museums=" + museums + ", cafesRestaurantsBars="
				+ cafesRestaurantsBars + ", skyscrapers=" + skyscrapers + ", galleries=" + galleries + ", parks="
				+ parks + ", sea=" + sea + ", shops=" + shops + ", weather=" + weather + ", currentlat=" + currentlat
				+ ", currentlon=" + currentlon + "]";
	}

	static int numberOfTravellers=0;{
		numberOfTravellers+=1;
	}
	
	double Similarity(City c) {
		int count=0;
		if(museums==1 && c.getMuseums()!=0) {
			count++;
		}	
		if(cafesRestaurantsBars==1 && c.getCafesRestaurantsBars()!=0){
			count++;
		}
		if(skyscrapers==1 && c.getSkyscrapers()!=0){
			count++;
		}
		if(galleries==1 && c.getGalleries()!=0){
			count++;
		}
		if(parks==1 && c.getParks()!=0){
			count++;
		}
		if(sea==1 && c.getSea()!=0){
			count++;
		}
		if(shops==1 && c.getShops()!=0){
			count++;
		}
		if(weather==c.getWeather()) {
			count++;
		}
		double similar=count/(double)8;
		//System.out.println("Similarity is:"+similar);
		return similar;
	}
	
	City CompareCities(ArrayList<City> cities) {
		double max=0;
		City maxcity = null;
		for(City c:cities) {
			Similarity(c);
			if(Similarity(c)>=max) {
				max=Similarity(c);
				maxcity=c;
			}
		}
		System.out.println("Best city:"+maxcity);
		return maxcity;
		
	}
	
	void CompareCities(ArrayList<City> cities,boolean rain) {
		if(rain==true) {
			for(City c:cities) {
				if(c.getWeather()=="rain") {
					System.out.printf("%s will not be compared\n",c.getName());
					cities.remove(c);//διαγραφή της συγκεκριμένης City 
				}
			}
			System.out.println("Cities that we will compare for you:");
			System.out.println(cities);
		}
	}
	
}
