package ergasia2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
	
	public static void main(String args[])throws IOException {
		Scanner sc = new Scanner(System.in);
		
	
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
		System.out.println("Hello!");
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
				cities.add(c);
			}catch(MySpecialException ex) {
				break;
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		
		
		System.out.println("Those are the cities you input:");
		for(City c:cities) {
			System.out.println(c);
		}
		
		
		
		//τα κριτήρια που διαλέγει ο χρήστης
		System.out.println("Criteria:");
		System.out.println("To add a criterion press 1 or else 0");
		int landmarks = 0;
		if(answer==2) {//γιατι μόνο ο tourist διλέγει αν θέλει hotel
			System.out.println("Would you like the city to have landmarks?(0/1)");
			
			do {
			    System.out.println("Please enter 0 or 1!");
			    while (!sc.hasNextInt()) {
			        System.out.println("That's not a number!");
			        sc.next(); // this is important!
			    }
			    landmarks = sc.nextInt();
			} while (!(landmarks==1 ||landmarks==0));
		}
		
		if(answer==1 || answer==2) {
			
			System.out.println("Would you like the city to have museums?(0/1)");
			int museums;
			do {
			    System.out.println("Please enter 0 or 1!");
			    while (!sc.hasNextInt()) {
			        System.out.println("That's not a number!");
			        sc.next(); // this is important!
			    }
			    museums = sc.nextInt();
			} while (!(museums==1 || museums==0));
			
			System.out.println("Would you like the city to have cafesRestaurantsBars?(0/1)");
			int cafesRestaurantsBars;
			do {
			    System.out.println("Please enter 0 or 1!");
			    while (!sc.hasNextInt()) {
			        System.out.println("That's not a number!");
			        sc.next(); // this is important!
			    }
			    cafesRestaurantsBars = sc.nextInt();
			} while (!(cafesRestaurantsBars==1 ||cafesRestaurantsBars ==0));
			
			System.out.println("Would you like the city to have skyscrapers(0/1)?");
			int skyscrapers;
			do {
			    System.out.println("Please enter 0 or 1!");
			    while (!sc.hasNextInt()) {
			        System.out.println("That's not a number!");
			        sc.next(); // this is important!
			    }
			    skyscrapers = sc.nextInt();
			} while (!(skyscrapers==1 ||skyscrapers==0));
			
			System.out.println("Would you like the city to have galleries(0/1)?");
			int galleries;
			do {
			    System.out.println("Please enter 0 or 1!");
			    while (!sc.hasNextInt()) {
			        System.out.println("That's not a number!");
			        sc.next(); // this is important!
			    }
			    galleries= sc.nextInt();
			} while (!(galleries==1 ||galleries==0));
			
			System.out.println("Would you like the city to have parks(0/1)?");
			int parks;
			do {
			    System.out.println("Please enter 0 or 1!");
			    while (!sc.hasNextInt()) {
			        System.out.println("That's not a number!");
			        sc.next(); // this is important!
			    }
			    parks = sc.nextInt();
			} while (!(parks==1 ||parks==0));
			
			System.out.println("Would you like the city to have sea(0/1)?");
			int sea;
			do {
			    System.out.println("Please enter 0 or 1!");
			    while (!sc.hasNextInt()) {
			        System.out.println("That's not a number!");
			        sc.next(); // this is important!
			    }
			    sea = sc.nextInt();
			} while (!(sea==1 ||sea==0));
			
			System.out.println("Would you like the city to have shops(0/1)?");
			int shops;
			do {
			    System.out.println("Please enter 0 or 1!");
			    while (!sc.hasNextInt()) {
			        System.out.println("That's not a number!");
			        sc.next(); // this is important!
			    }
			    shops = sc.nextInt();
			} while (!(shops==1 ||shops==0));
			sc.nextLine();
			
			System.out.println("What weather would you like the city to have?(rain/snow/sun/clouds)");
			String weather=sc.nextLine();
			if(!(weather.equals("snow")||weather.equals("rain")||weather.equals("sun")||weather.equals("clouds"))) {
				weather=null;
				do {
					System.out.println("Wrong input.Please try again.");
					weather=sc.nextLine();
				}while(!(weather.equals("snow")||weather.equals("rain")||weather.equals("sun")||weather.equals("clouds")));
			}
			


			if(answer==1) {
				//δημιουργία αντικειμένου traveller
				tr=new Traveller(name,age,museums,cafesRestaurantsBars,skyscrapers,galleries,parks,sea,shops,weather,currentlat,currentlon);
				System.out.println(currentlat);
				System.out.println(tr);
				
			}else {
				//δημιουργία αντικειμένου tourist
				tour=new Tourist(name,age,museums,cafesRestaurantsBars,skyscrapers,galleries,parks,sea,shops,weather,currentlat,currentlon,landmarks);
				
			}
		}else {
			//δημιουργία αντικειμένου business
			//τα κριτηρια είναι 0 και null αντίστοιχα γιατι δεν μας ενδιαφερουν στην περίπτωση αυτή
			b=new Business(name,age,0,0,0,0,0,0,0,null,currentlat,currentlon);
		}

		//static μέθοδος που μετράει το πλήθος των travellers
		System.out.println("Number of travellers so far:"+Traveller.numberOfTravellers);

		if(answer==1) {
			for(City x:cities) {
				System.out.println("Similarity for "+x.getName()+" is:");
				System.out.println(tr.Similarity(x));
			}
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
		
		
		
		//εστω οι input πολεις μάζι με τα χαρακτηριστικά(this is only for testing)
		/*City c2=City.gemisma("milan","it");
		City c3=City.gemisma("trikala","gr");
		
		cities.add(c2);
		cities.add(c3);*/
		
		System.out.println("Checking the best city for you...");
		if(answer==1) {
			tr.CompareCities(cities);
		}else if(answer==2) {
			tour.CompareCities(cities);
		}else {
			b.CompareCities(cities);
		}
		
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
		

		//free ticket(ερώτημα 3),polymorphism
		System.out.println("We want to give a free ticket for Madrid (c1)");
		City c1=City.gemisma("madrid","es");
		
		//Εστω ότι αυτοί είναι οι υποψήφιοι travellers
		Traveller t1=new Traveller("Vivian",20,1,1,0,0,1,1,0,"sun",currentlat,currentlon);
		Traveller t2=new Tourist("Eleftheria",20,1,1,1,1,1,0,0,"snow",currentlat,currentlon,3);
		Traveller t3=new Business("Giorgos",20,0,0,0,0,0,0,0,null,currentlat,currentlon);
		
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
		System.out.println("Congrats!");
		
		
		sc.close();
	}
}
