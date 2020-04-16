package ergasia2;

@SuppressWarnings("serial")
public class Business extends Traveller{



	public Business(String name, int age, int museums, int cafesRestaurantsBars, int skyscrapers, int galleries,
			int parks, int sea, int shops, String weather, double currentlat, double currentlon,
			String recommendedCity) {
		super(name, age, museums, cafesRestaurantsBars, skyscrapers, galleries, parks, sea, shops, weather, currentlat,
				currentlon, recommendedCity);
		// TODO Auto-generated constructor stub
	}

	//empty constructor
	public Business() {}

	//override
	double Similarity(City c) {
		if ((currentlat == c.getLat()) && (currentlon== c.getLon())) {
			return 0;
		}
		else {
			double theta = currentlon - c.getLon();
			double dist = Math.sin(Math.toRadians(currentlat)) * Math.sin(Math.toRadians(c.getLat())) + Math.cos(Math.toRadians(currentlat)) * Math.cos(Math.toRadians(c.getLat())) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			return (dist);
		}
	
	}

}
