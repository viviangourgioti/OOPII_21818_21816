package ergasia2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import OpenData.OpenData;

public class mainclass {
	
	public static String[] readString()throws MySpecialException,Exception{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		if(in.hasNext()) {
			String input = in.next();
			if(!(input.toLowerCase()).equals("done")){
				System.out.print("Input more cities: ");
				String[] namesList = input.split(",");//έτσι διαχωρίζω σε δυο string την πόλη και την χώρα
				return namesList;
			}else{ 
				System.out.println("You entered done. Input finished,");
				throw new MySpecialException();
			}
		}else {
			throw new Exception("Not a String");
		}

	}
	
	public static String[] latlon()throws MySpecialException,Exception{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		if(in.hasNext()) {
			String input = in.next();
			if(!(input.toLowerCase()).equals("done")){
				System.out.print("Please enter   done    now or if you want to change your location enter your new city !");
				String[] namesList = input.split(",");//έτσι διαχωρίζω σε δυο string την πόλη και την χώρα
				return namesList;
			}else{ 
				//System.out.println("You entered done. Input finished,");
				throw new MySpecialException();
			}
		}else {
			throw new Exception("Not a String");
		}

	
	}
	
	public static int ele() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int i;
		do {
		    System.out.println("Please enter 0 or 1!");
		    while (!in.hasNextInt()) {
		        System.out.println("That's not a number!");
		        in.next(); // this is important!
		    }
		    i = in.nextInt();
		} while (!(i==1 || i==0));
		return i;
	}
	
	public static void main(String args[])throws IOException {
		Scanner sc = new Scanner(System.in);
		
		List<City> CityDup=new ArrayList<>();
		ArrayList<City> AllCities =new ArrayList<City>();
		try {
			DataBase.DBconnection();
			AllCities=DataBase.ReadData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ArrayList<Traveller> AllTravellers =new ArrayList<Traveller>();		
		
		File f = new File("TravellersData");
		if(f.exists()) {
	        try
	        {
	            FileInputStream fis = new FileInputStream("TravellersData");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            AllTravellers = (ArrayList) ois.readObject();
	            ois.close();
	            fis.close();
	            System.out.println("Deserialization succeded");
	            /*Iterator<Traveller> it=AllTravellers.iterator();
	            while(it.hasNext()) {
	            	System.out.println(it.next());
	            }*/
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	            return;
	        } 
	        catch (ClassNotFoundException c) 
	        {
	            System.out.println("Class not found");
	            c.printStackTrace();
	            return;
	        }
		}

		int menuAnswer;
		do {
			System.out.println("1.City recommendetion, press (1)!");
			System.out.println("2.Exit, press (2)");
			menuAnswer=sc.nextInt();
			switch(menuAnswer) {
				case 1:
					System.out.println("Where are you now?Please give the name of your city followed by comma(,)and then the abbservation of your country.");
					System.out.println("We want to calculate your current lat and lon.");
					double currentlat=0;
					double currentlon=0;
					
					while(true) {
						try {
							String currentCitycountry[]=latlon();
							currentlon=OpenData.lon(currentCitycountry[0],currentCitycountry[1],"eec6890cb4afa0e897cce002c69e11f0");
							currentlat=OpenData.lat(currentCitycountry[0],currentCitycountry[1],"eec6890cb4afa0e897cce002c69e11f0");
						}catch(MySpecialException ex) {
							break;
						}catch(Exception ex) {
							System.err.println(ex.getMessage());
						}
					}
				
					System.out.println("Are you a traveller(1),a tourist(2) or business(3)?");
					int answer;
					do {
					    System.out.println("Please enter 1 or 2 or 3!");
					    while (!sc.hasNextInt()) {
					        System.out.println("That's not a number!");
					        sc.next(); // this is important!
					    }
					    answer = sc.nextInt(); 
					} while (!(answer==1 || answer==2 || answer==3));
					sc.nextLine();
					
					System.out.println("Please enter your name.");
					String name=sc.nextLine();
					System.out.println("Please enter your age.");
					int age=sc.nextInt();
					sc.nextLine();
					
				    Traveller tr=new Traveller();
					Tourist tour=new Tourist();
					Business b=new Business();
						
					System.out.println("Please give some names of cities followed by comma(,) and then the abbservation of the country(eg. Athens,gr)");
					System.out.println("When you are done,type the word done.");
					
					ArrayList<City> cities =new ArrayList<City>();
					while(true) {
						try {
							String citycountry[]=readString();
							City c=City.gemisma(citycountry[0], citycountry[1]);
							int i=0;
							Iterator<City> itci=cities.iterator();
							while(itci.hasNext()) {
								if(itci.next().equals(c)) {
									//System.out.println("Iparxei");
									cities.add(itci.next());//προσθέτω το αντικείμενο που ηδη υπάρχει στο AllCities
									i=1;
									break;
								}
							}
							if(i==0) {
								cities.add(c);
							}
							AllCities.add(c);
							DataBase.DBconnection();
							DataBase.addDatatoDB(c.getName(),c.getMuseums(),c.getCafesRestaurantsBars(),c.getSkyscrapers(),c.getGalleries(),c.getParks(),c.getSea(),c.getShops(),c.getLandmarks(),c.getWeather(),c.getLat(),c.getLon());
						}catch(MySpecialException ex) {
							break;
						}catch(Exception ex) {
							System.err.println(ex.getMessage());
						}
					}
					
					System.out.println("Those are the cities you input:");
					Iterator<City> cityiter=cities.iterator();
					while(cityiter.hasNext()) {
						System.out.println(cityiter.next());
					}

					//τα κριτήρια που διαλέγει ο χρήστης
					System.out.println("Criteria:");
					System.out.println("To add a criterion press 1 or else 0");
					int landmarks=0;
					if(answer==2) {//γιατι μόνο ο tourist διλέγει αν θέλει landmark
						System.out.println("Would you like the city to have landmarks?(0/1)");
						landmarks=ele();
					}
					
					if(answer==1 || answer==2) {	
						System.out.println("Would you like the city to have museums?(0/1)");
						int museums=ele();
						
						System.out.println("Would you like the city to have cafesRestaurantsBars?(0/1)");
						int cafesRestaurantsBars=ele();
						
						System.out.println("Would you like the city to have skyscrapers(0/1)?");
						int skyscrapers=ele();
						
						System.out.println("Would you like the city to have galleries(0/1)?");
						int galleries=ele();
						
						System.out.println("Would you like the city to have parks(0/1)?");
						int parks=ele();
						
						System.out.println("Would you like the city to have sea(0/1)?");
						int sea=ele();
			
						System.out.println("Would you like the city to have shops(0/1)?");
						int shops=ele();
						
						System.out.println("What weather would you like the city to have?(rain/snow/sun/clouds/clear)");
						String weather=sc.nextLine();
						if(!(weather.equals("snow")||weather.equals("rain")||weather.equals("sun")||weather.equals("clouds")||weather.equals("clear"))) {
							weather=null;
							do {
								System.out.println("Wrong input.Please try again.");
								weather=sc.nextLine();
							}while(!(weather.equals("snow")||weather.equals("rain")||weather.equals("sun")||weather.equals("clouds")||weather.equals("clear")));
						}
						
						if(answer==1) {
							//δημιουργία αντικειμένου traveller
							tr=new Traveller(name,age,museums,cafesRestaurantsBars,skyscrapers,galleries,parks,sea,shops,weather,currentlat,currentlon,tr.CompareCities(cities).getName());
							AllTravellers.add(tr);
							System.out.println(tr);
						}else {
							//δημιουργία αντικειμένου tourist
							tour=new Tourist(name,age,museums,cafesRestaurantsBars,skyscrapers,galleries,parks,sea,shops,weather,currentlat,currentlon,tour.CompareCities(cities).getName(),landmarks);
							AllTravellers.add(tour);
							System.out.println(tour);
						}
					}else {
						//δημιουργία αντικειμένου business
						//τα κριτηρια είναι 0 και null αντίστοιχα γιατι δεν μας ενδιαφερουν στην περίπτωση αυτή
						b=new Business(name,age,0,0,0,0,0,0,0,null,currentlat,currentlon,b.CompareCities(cities).getName());
						AllTravellers.add(b);
					}
			
					//static μέθοδος που μετράει το πλήθος των travellers
					System.out.println("Number of travellers so far:"+Traveller.numberOfTravellers);
					
					if(answer==1) {
						for(City c:cities) {
							System.out.println("Similarity for "+c.getName()+" is:");
							System.out.println(tr.Similarity(c));						}
					}else if(answer==2) {
						for(City x:cities) {
							System.out.println("Similarity for "+x.getName()+" is:");
							System.out.println(tour.Similarity(x));
						}
					}else {
						for(City x:cities) {
							System.out.println("Similarity for "+x.getName()+" is:");
							System.out.println(b.Similarity(x));
						}
					}

					/*System.out.println("Checking the best city for you...");
					if(answer==1) {
						tr.CompareCities(cities);
					}else if(answer==2) {
						tour.CompareCities(cities);
					}else {
						b.CompareCities(cities);
					}*/
					
					try {
						System.out.println("Would you like to skip cities with rain?(true/false)");
						boolean rain = sc.nextBoolean();
						if(answer==1) {	
							tr.CompareCities(cities, rain);
						}else if(answer==2) {
							tour.CompareCities(cities, rain);
						}else {
							b.CompareCities(cities, rain);
						}
				    } catch (InputMismatchException e) {
				           	System.out.println("Invalid input!");	           
				    }
					
				 /*//free ticket(ερώτημα 3),polymorphism
					System.out.println("We want to give a free ticket for Madrid (c1)");
					City c1=City.gemisma("madrid","es");
					
					//Εστω ότι αυτοί είναι οι υποψήφιοι travellers
					Traveller t1=new Traveller("Vivian",20,1,1,0,0,1,1,0,"sun",currentlat,currentlon,"Athens");
					Traveller t2=new Tourist("Eleftheria",20,1,1,1,1,1,0,0,"snow",currentlat,currentlon,"Milano",3);
					Traveller t3=new Business("Giorgos",20,0,0,0,0,0,0,0,null,currentlat,currentlon,"Mykonos");
					
					//τοποθέτηση υποψηφίων σε array
					Traveller[] travellers= {t1,t2,t3};
					
					double maxSimilarity=0;
					Traveller maxtraveller=null;
					
					for(Traveller p:travellers) {
						if(p.Similarity(c1)>=maxSimilarity) {
							maxSimilarity=p.Similarity(c1);
							maxtraveller=p;
						}
					}					
					System.out.println("The lucky one is:"+maxtraveller.getName());
					System.out.println("Congrats!");*/
					
					/*for(Traveller t:AllTravellers) {
						System.out.println(t);
					}*/
					System.out.println("All cities so far:");
					CityDup=AllCities.stream().distinct().collect(Collectors.toList());
					Iterator<City> iterc=CityDup.iterator();
					while(iterc.hasNext()) {
						System.out.println(iterc.next());
					}

					/*System.out.println("All travellers so far(unsorted):");
					Iterator<Traveller> iter=AllTravellers.iterator();
					while(iter.hasNext()) {
						System.out.println(iter.next());
					}*/					
					
					//ταξινόμηση(με βάση την ηλικία) και αφαίρεση διπλοτύπων(ίδιο όνομα) του arraylist AllTravellers 
					//δημιουργια λιστας χωρις διπλοτυπα
					List<Traveller> listWithoutDuplicates = AllTravellers.stream().distinct().collect(Collectors.toList());
					Collections.sort(listWithoutDuplicates);//ταξινόμηση
					System.out.println("Sorted Travellers without duplicates:");
					Iterator<Traveller> dupiter=listWithoutDuplicates.iterator();
					while(dupiter.hasNext()) {
						System.out.println(dupiter.next());
					}
					//serialization
					try
			        {
			            FileOutputStream fos = new FileOutputStream("TravellersData");
			            ObjectOutputStream oos = new ObjectOutputStream(fos);
			            oos.writeObject(AllTravellers);
			            oos.close();
			            fos.close();
			            System.out.println("Serialazation succeded");
			        } 
			        catch (IOException ioe) 
			        {
			            ioe.printStackTrace();
			        }
					
					break;
				case 2:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Wrong input.Please try again.");
			}
		}while(menuAnswer!=2);
		sc.close();	
			
	}		
}
