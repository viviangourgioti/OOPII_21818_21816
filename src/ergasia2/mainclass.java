package ergasia2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainclass {
	
	public static String[] readString()throws MySpecialException,Exception{
		Scanner in=new Scanner(System.in);
		if(in.hasNextLine()) {
			String[] namesList = in.nextLine().split(",");//έτσι διαχωρίζω σε δυο string την πόλη και την χώρα
			return namesList;
			
		}else if(in.hasNext() && in.next().equals("done")) {
			throw new MySpecialException();		
		}else {
			throw new Exception("Not a String");
		}

	}
	
	public static void main(String args[])throws IOException {
		Scanner sc = new Scanner(System.in);
		
	   /* System.out.println("Are you a traveller(1),a tourist(2) or it is a business trip(3)?");
		int answer;
		do {
		    System.out.println("Please enter 1 or 2 or 3!");
		    while (!sc.hasNextInt()) {
		        System.out.println("That's not a number!");
		        sc.next(); // this is important!
		    }
		    answer = sc.nextInt();
		    
		} while (!(answer==1 || answer==2 || answer==3));
		sc.nextLine();*/
		System.out.println("Hello!");
		System.out.println("Please enter your name.");
		String name=sc.nextLine();
		System.out.println("Please enter your age.");
		int age=sc.nextInt();
		sc.nextLine();
		//τα κριτήρια που διαλέγει ο χρήστης
		System.out.println("Criteria:");
		System.out.println("To add a criterion press 1 or else 0");
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
		System.out.println("What weather would you like the city to have?(rain/snow/sun)");
		String weather=sc.nextLine();
		//αυτα θσ τσ παίρνω με αλλο τροπο
		double currentlat=20.7;
		double currentlon=69.8;
		//δημιουργία αντικειμένου traveller
		Traveller t1=new Traveller(name,age,museums,cafesRestaurantsBars,skyscrapers,galleries,parks,sea,shops,weather,currentlat,currentlon);
		System.out.println(t1);
		//Traveller t2=new Traveller("Andriani",23,1,1,1,1,1,0,1,"sun");
		System.out.println("Number of travellers so far:"+Traveller.numberOfTravellers);
		
		System.out.println("Please give some names of cities followed by comma(,) and then the first 2 letters of the country(eg. Athens,gr)");
		System.out.println("When you are done,type the word done.");
		ArrayList<City> cities =new ArrayList<City>();
		/*while(!input.equals("done")) {
			try {
				String citycountry[]=readString();
				City c=new City();	
				c.gemisma(c,citycountry[0],citycountry[1]);
				System.out.println(c);
				cities.add(c);
				input=sc.nextLine();
			}catch(MySpecialException ex) {
				break;
			}catch(Exception ex) {
				
				System.err.println(ex.toString());
				System.err.println(ex.getMessage());
			}
		}*/
		
		while(true) {
			try {
				String citycountry[]=readString();
				City c=new City();
				c.gemisma(c, citycountry[0], citycountry[1]);
				System.out.println(c);
				cities.add(c);
			}catch(MySpecialException ex) {
				break;
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		
		/*City c=new City();	
		c.gemisma(c,part1, part2);
		System.out.println(c);
		cities.add(c);
			*/
		
		
		//εστω οι innput πολεις μάζι με τα χαρακτηριστικά
		//το γέμισμα των city θα γίνεται με τη χρήση μιας μεθόδου στη κλάση City
		City c1=new City("Athens",12,11,100,19,8,7,30,"sun",20.2,5.3);
		City c2=new City("New York",0,72,5,4,11,60,90,"rain",7.8,88.9);
		City c3=new City("Karpenissi",1,5,0,1,9,0,32,"snow",3.7,123.65);
		
		
		
		//σύγκρηση κριτηρίων που επέλεξε ο χρήστης με τις πόλεις που επέλεξε
		double s1=t1.Similarity(c1);
		System.out.println("Similarity for c1 is:"+s1);
		double s2=t1.Similarity(c2);
		System.out.println("Similarity for c2 is:"+s2);
		double s3=t1.Similarity(c3);
		System.out.println("Similarity for c3 is:"+s3);

		cities.add(c1);
		cities.add(c2);
		cities.add(c3);
		
		t1.CompareCities(cities);
		
		System.out.println("Would you like to skip cities with rain?(true/false)");
		boolean rain=sc.nextBoolean();
		
		t1.CompareCities(cities, rain);
		//Business
		System.out.println("Would you like the distance in similarity to be in miles(M),kilometers(K) or in nautical miles(N)?");
		String unit=sc.next();
		sc.hasNextLine();
		
		Business b1=new Business("Gio",20,1,1,1,0,0,1,1,"sunny",100.2,234.5);
		System.out.println(b1.Similarity(b1.getCurrentlat(),b1.getCurrentlon(),c2.getLat(),c2.getLon(), unit));
		
		//free ticket(ερώτημα 3)
		
		
		
		sc.close();
	}
}
