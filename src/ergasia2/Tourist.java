package ergasia2;

public class Tourist extends Traveller {

	private int landmarks;

	public int getHotels() {
		return landmarks;
	}

	public void setHotels(int hotels) {
		this.landmarks = hotels;
	}
	

	public Tourist(String name, int age, int museums, int cafesRestaurantsBars, int skyscrapers, int galleries,
			int parks, int sea, int shops, String weather, double currentlat, double currentlon, int hotels) {
		super(name, age, museums, cafesRestaurantsBars, skyscrapers, galleries, parks, sea, shops, weather, currentlat,
				currentlon);
		this.landmarks = hotels;
	}
	

	@Override
	public String toString() {
		return "Tourist [landmarks=" + landmarks + ", name=" + name + ", age=" + age + ", museums=" + museums
				+ ", cafesRestaurantsBars=" + cafesRestaurantsBars + ", skyscrapers=" + skyscrapers + ", galleries="
				+ galleries + ", parks=" + parks + ", sea=" + sea + ", shops=" + shops + ", weather=" + weather
				+ ", currentlat=" + currentlat + ", currentlon=" + currentlon + "]";
	}

	//empty constructor
	public Tourist() {}
	
	//override	
	double Similarity(City c) {
		int count=0;
		int sum=0;
		if(museums==1 && c.getMuseums()!=0) {
			count++;
			sum=sum+c.getMuseums();
		}	
		if(cafesRestaurantsBars==1 && c.getCafesRestaurantsBars()!=0){
			count++;
			sum=sum+c.getCafesRestaurantsBars();
		}
		if(skyscrapers==1 && c.getSkyscrapers()!=0){
			count++;
			sum=sum+c.getSkyscrapers();
		}
		if(galleries==1 && c.getGalleries()!=0){
			count++;
			sum=sum+c.getGalleries();
		}
		if(parks==1 && c.getParks()!=0){
			count++;
			sum=sum+c.getParks();
		}
		if(sea==1 && c.getSea()!=0){
			count++;
			sum=sum+c.getSea();
		}
		if(shops==1 && c.getShops()!=0){
			count++;
			sum=sum+c.getShops();
		}
		if(weather==c.getWeather()) {
			count++;
		}
		if(landmarks==1 && c.getLandmarks()!=0) {
			count++;
			sum=sum+c.getLandmarks();
		}
		double similar=(count/(double)8)*sum;
		return similar;
	}
}
