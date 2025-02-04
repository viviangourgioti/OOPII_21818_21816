package ergasia2;

@SuppressWarnings("serial")
public class Tourist extends Traveller {

	private int landmarks;

	public int getLandmarks() {
		return landmarks;
	}


	public void setLandmarks(int landmarks) {
		this.landmarks = landmarks;
	}

	public Tourist(String name, int age, int museums, int cafesRestaurantsBars, int skyscrapers, int galleries,
			int parks, int sea, int shops, String weather, double currentlat, double currentlon,String RecommendedCity ,int landmarks) {
		super(name, age, museums, cafesRestaurantsBars, skyscrapers, galleries, parks, sea, shops, weather, currentlat,
				currentlon,RecommendedCity);
		this.landmarks = landmarks;
	}

	@Override
	public String toString() {
		return "Tourist [landmarks=" + landmarks + ", name=" + name + ", age=" + age + ", museums=" + museums
				+ ", cafesRestaurantsBars=" + cafesRestaurantsBars + ", skyscrapers=" + skyscrapers + ", galleries="
				+ galleries + ", parks=" + parks + ", sea=" + sea + ", shops=" + shops + ", weather=" + weather
				+ ", currentlat=" + currentlat + ", currentlon=" + currentlon + ", RecommendedCity=" + RecommendedCity
				+ "]";
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
		double similar=(count/(double)9)*sum;
		return similar;
	}
}
