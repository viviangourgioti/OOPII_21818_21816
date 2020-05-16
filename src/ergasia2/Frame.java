package ergasia2;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import OpenData.OpenData;
public class Frame {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	public Frame(){
		mainFrame = new JFrame("Welcome!");
	    mainFrame.setSize(600,600);
	    mainFrame.setLayout(new GridLayout(3, 1));
	    
	    headerLabel = new JLabel("",JLabel.CENTER );
	    statusLabel = new JLabel("",JLabel.CENTER);        
	    statusLabel.setSize(350,100);

	    mainFrame.addWindowListener(new WindowAdapter() {
	       public void windowClosing(WindowEvent windowEvent){
	          System.exit(0);
	       }        
	    }); 
	    
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new FlowLayout());	
	    
	    mainFrame.add(headerLabel);
	    mainFrame.add(controlPanel);
	    mainFrame.add(statusLabel);
	    mainFrame.setVisible(true); 
	}

	public void  showDemo() {		
		Allinfo user=new Allinfo();
    	//Allinfo user=new Allinfo();
		ArrayList<City> AllCities =new ArrayList<City>();//όλες οι πόλεις που εισάγουν οι χρήστες
		//List<City> CityDup=new ArrayList<>();//όλες οι πόλεις χωρίς διπλότυπα
		ArrayList<City> cities =new ArrayList<City>();//πόλεις που εισάγει ένας χρήστης
		ArrayList<Traveller> AllTravellers =new ArrayList<Traveller>();//όλοι οι χρήστες

		headerLabel.setText("Please complete the following fields:"); 
		//personal information swing(textfields)
		JLabel namelabel=new JLabel("Name: ", JLabel.RIGHT);
	    JLabel ageLabel =new JLabel("Age: ", JLabel.CENTER);
	    JLabel nowLabel=new JLabel("Current location:",JLabel.LEFT);
	    
		final JTextField nameText = new JTextField(6);
	    final JTextField ageText = new JTextField(6);      
	    final JTextField nowText = new JTextField(6);

		controlPanel.add(namelabel);
		controlPanel.add(nameText);
		controlPanel.add(ageLabel);       
	    controlPanel.add(ageText);
	    controlPanel.add(nowLabel);       
	    controlPanel.add(nowText);
	     	     
	    //kind of traveller swing(jcombobox)
	    final DefaultComboBoxModel kindOfTraveller = new DefaultComboBoxModel();
	    kindOfTraveller.addElement("Traveller");
	    kindOfTraveller.addElement("Tourist");
	    kindOfTraveller.addElement("Business");
	    final JComboBox travellerCombo=new JComboBox(kindOfTraveller);
	    travellerCombo.setSelectedIndex(0);
	    JScrollPane travellerScrollPane=new JScrollPane(travellerCombo);
	    controlPanel.add(travellerScrollPane);
	     
	     
	     //add cities swing(jtabe)
	    DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("City");
	    JTable cityTable = new JTable(model);
	    cityTable.setBounds(100,100,100,100);
	    JScrollPane table_sp = new JScrollPane(cityTable);
	    controlPanel.add(table_sp);
	    cityTable.setSize(1000,1000);
	    cityTable.setVisible(true);
	    controlPanel.add(cityTable);

	    JButton addButton = new JButton("Add City");
	    JTextField cityField = new JTextField();
	    addButton.addActionListener(new ActionListener(){
	           @Override
	           public void actionPerformed(ActionEvent actionEvent)
	           {
					while(true) {
						try {
							String cit[]=cityField.getText().split(",");
							City c=City.gemisma(cit[0], cit[1]);
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
							model.addRow(new Object[]{cityField.getText()});
							user.getGuiCities().add(c.getName());
							//break;
						}catch(Exception ex) {
							//statusLabel.setText("Invalid input");
							System.err.println("Invalid input");
							break;
						}
					}   
	           }
	    });

	    controlPanel.add(addButton);
	    controlPanel.add(cityField);
	     
	     
	     //criteria (jcheckbox)
	    final JCheckBox chkmuseums= new JCheckBox("Museums");
  	   	final JCheckBox chkcafes= new JCheckBox("CafesRestaurantsBars");
  	   	final JCheckBox chkskyscrapers= new JCheckBox("Skyscrapers");
  	   	final JCheckBox chkgalleries= new JCheckBox("Galleries");
  	   	final JCheckBox chkparks= new JCheckBox("Parks");
  	   	final JCheckBox chksea= new JCheckBox("Sea");
	   	final JCheckBox chkshops= new JCheckBox("Shops");
	    final JCheckBox chklandmarks=new JCheckBox("Landmarks");

	    controlPanel.add(chkmuseums);
	    controlPanel.add(chkcafes);
        controlPanel.add(chkskyscrapers);   
        controlPanel.add(chkgalleries);
        controlPanel.add(chkparks);
        controlPanel.add(chksea);
        controlPanel.add(chkshops);
	    controlPanel.add(chklandmarks);
	     
	    //weather criteria(jcomboBox)
	    final DefaultComboBoxModel weatherCr = new DefaultComboBoxModel();
	    weatherCr.addElement("rain");
	    weatherCr.addElement("snow");
	    weatherCr.addElement("sun");
	    weatherCr.addElement("clouds");
	    weatherCr.addElement("clear");
	    final JComboBox WeatherCombo = new JComboBox(weatherCr);    
	    WeatherCombo.setSelectedIndex(0);
	    JScrollPane weatherScrollPane = new JScrollPane(WeatherCombo);    
	    controlPanel.add(weatherScrollPane);    
	    
	    //skip rainy cities(jcomboBox)
	    final DefaultComboBoxModel skip = new DefaultComboBoxModel();
	    skip.addElement("Skip rainy cities");
	    skip.addElement("Do not skip rainy cities");
	    final JComboBox skipCombo=new JComboBox(skip);
	    skipCombo.setSelectedIndex(0);
	    JScrollPane skipScrollPane=new JScrollPane(skipCombo);
	    controlPanel.add(skipScrollPane);
	    
	    //end
	    JButton okButton = new JButton("OK");
	   	okButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) { 

				//γεμίζω τα arraylist με προηγούμενες εισαγωγές
				newmain.ReadFile(AllTravellers);
				newmain.ReadDB(AllCities);
				
			    Traveller tr=new Traveller();
			    Tourist tour=new Tourist();
			    Business b=new Business();

		    	user.setName(nameText.getText());

		    	String bage=ageText.getText();
		    	int aage=Integer.parseInt(bage);
		    	user.setAge(aage);
		    	
		    	user.setLocation(nowText.getText());
				double currentlat=0;
				double currentlon=0;
				try {
					String currentCitycountry[]=user.getLocation().split(",");
					currentlon=OpenData.lon(currentCitycountry[0],currentCitycountry[1],"eec6890cb4afa0e897cce002c69e11f0");
					currentlat=OpenData.lat(currentCitycountry[0],currentCitycountry[1],"eec6890cb4afa0e897cce002c69e11f0");
				}catch(Exception ex) {
					System.out.println("This is not a location!");
					System.err.println(ex.getMessage());
				}
				
		    	user.setKindOfTraveller((String) travellerCombo.getItemAt(travellerCombo.getSelectedIndex()));
		    	
		    	if(chkmuseums.isSelected()) {
		    		user.getCriteria().add(1);
		    	}else {
		    		user.getCriteria().add(0);
		    	}
		    	if(chkcafes.isSelected()) {
		    		user.getCriteria().add(1);
		    	}else {
		    		user.getCriteria().add(0);
		    	}
		    	if(chkskyscrapers.isSelected()) {
		    		user.getCriteria().add(1);
		    	}else {
		    		user.getCriteria().add(0);
		    	}
		    	if(chkgalleries.isSelected()) {
		    		user.getCriteria().add(1);
		    	}else {
		    		user.getCriteria().add(0);
		    	}
		    	if(chkparks.isSelected()) {
		    		user.getCriteria().add(1);
		    	}else {
		    		user.getCriteria().add(0);
		    	}
		    	if(chksea.isSelected()) {
		    		user.getCriteria().add(1);
		    	}else {
		    		user.getCriteria().add(0);
		    	}
		    	if(chkshops.isSelected()) {
		    		user.getCriteria().add(1);
		    	}else {
		    		user.getCriteria().add(0);
		    	}

			    user.setWeather((String) WeatherCombo.getItemAt(WeatherCombo.getSelectedIndex()));

			    if(skipCombo.getItemAt(skipCombo.getSelectedIndex())=="Skip rainy cities") {
			    	user.setSkiprain(true);
			    }else {
			    	user.setSkiprain(false);
			    }
			    
			    if(user.getKindOfTraveller()=="Traveller") {
			    	if(chklandmarks.isSelected()) {
			    		chklandmarks.setSelected(false);
			    	}
					tr=new Traveller(user.getName(),user.getAge(),user.getCriteria().get(0),user.getCriteria().get(1),user.getCriteria().get(2),user.getCriteria().get(3),user.getCriteria().get(4),user.getCriteria().get(5),user.getCriteria().get(6),user.getWeather(),currentlat,currentlon,tr.CompareCities(cities).getName());
					AllTravellers.add(tr);	
					tr.CompareCities(cities,user.isSkiprain());
			    }else if(user.getKindOfTraveller()=="Tourist") {
					tour=new Tourist(user.getName(),user.getAge(),user.getCriteria().get(0),user.getCriteria().get(1),user.getCriteria().get(2),user.getCriteria().get(3),user.getCriteria().get(4),user.getCriteria().get(5),user.getCriteria().get(6),user.getWeather(),currentlat,currentlon,tour.CompareCities(cities).getName(),user.getCriteria().get(7));
					AllTravellers.add(tour);
					tour.CompareCities(cities, user.isSkiprain());
			    }else {
					b=new Business(user.getName(),user.getAge(),0,0,0,0,0,0,0,null,currentlat,currentlon,b.CompareCities(cities).getName());
					AllTravellers.add(b);
					b.CompareCities(cities, user.isSkiprain());
			    }

			    List<City> CityDup=new ArrayList<>();
				System.out.println("All cities so far:");
				CityDup=AllCities.stream().distinct().collect(Collectors.toList());
				Iterator<City> iterc=CityDup.iterator();
				while(iterc.hasNext()) {
					System.out.println(iterc.next());
				}

				//ταξινόμηση(με βάση την ηλικία) και αφαίρεση διπλοτύπων(ίδιο όνομα) του arraylist AllTravellers 
				//δημιουργια λιστας χωρις διπλοτυπα
				List<Traveller> listWithoutDuplicates = AllTravellers.stream().distinct().collect(Collectors.toList());
				Collections.sort(listWithoutDuplicates);//ταξινόμηση
				System.out.println("Sorted Travellers without duplicates:");
				Iterator<Traveller> dupiter=listWithoutDuplicates.iterator();
				while(dupiter.hasNext()) {
					System.out.println(dupiter.next());
				}
				newmain.serialize(AllTravellers);
				//serialization
				/*try
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
		        }*/
				
			   //System.out.println(user);
				if(user.getKindOfTraveller()=="Traveller") {
					statusLabel.setText("Recommended city:"+String.valueOf(tr.getRecommendedCity()));
				}else if(user.getKindOfTraveller()=="Tourist") {
					statusLabel.setText("Recommended city:"+String.valueOf(tour.getRecommendedCity()));
				}else {
					statusLabel.setText("Recommended city:"+String.valueOf(b.getRecommendedCity()));
				}
				
				//clear fields for the next user
				nameText.setText("");
				ageText.setText("");
				nowText.setText("");
				chkmuseums.setSelected(false);
				chkcafes.setSelected(false);
				chkskyscrapers.setSelected(false);
				chkgalleries.setSelected(false);
				chkparks.setSelected(false);
				chksea.setSelected(false);
				chkshops.setSelected(false);
				chklandmarks.setSelected(false);
				cityField.setText("");
		     }
		 }); 	

	   	
	   	controlPanel.add(okButton);
	     
	    mainFrame.setVisible(true);  

		
	}
}