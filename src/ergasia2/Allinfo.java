package ergasia2;

import java.util.ArrayList;

public class Allinfo {
	private String name;
	private int age;
	private String location;
	private String kindOfTraveller;
	private ArrayList<String> guiCities=new ArrayList<String>();
	private ArrayList<Integer> criteria=new ArrayList<Integer>();
	private String weather;
	private boolean skiprain;
	
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

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getKindOfTraveller() {
		return kindOfTraveller;
	}
	public void setKindOfTraveller(String kindOfTraveller) {
		this.kindOfTraveller = kindOfTraveller;
	}

	public ArrayList<String> getGuiCities() {
		return guiCities;
	}
	public void setGuiCities(ArrayList<String> guiCities) {
		this.guiCities = guiCities;
	}

	public ArrayList<Integer> getCriteria() {
		return criteria;
	}
	public void setCriteria(ArrayList<Integer> criteria) {
		this.criteria = criteria;
	}

	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}

	public boolean isSkiprain() {
		return skiprain;
	}
	public void setSkiprain(boolean skiprain) {
		this.skiprain = skiprain;
	}

	@Override
	public String toString() {
		return "Allinfo [name=" + name + ", age=" + age + ", location=" + location + ", kindOfTraveller="
				+ kindOfTraveller + ", guiCities=" + guiCities + ", criteria=" + criteria + ", weather=" + weather
				+ ", skiprain=" + skiprain + "]";
	}
	public Allinfo(String name, int age, String location, String kindOfTraveller, ArrayList<String> guiCities,
			ArrayList<Integer> criteria, String weather, boolean skiprain) {
		super();
		this.name = name;
		this.age = age;
		this.location = location;
		this.kindOfTraveller = kindOfTraveller;
		this.guiCities = guiCities;
		this.criteria = criteria;
		this.weather = weather;
		this.skiprain = skiprain;
	}
	public Allinfo() {}
	
	
	

}
