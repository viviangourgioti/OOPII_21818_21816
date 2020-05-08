package ergasia2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KindOfTraveller {
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	public KindOfTraveller(){
		prepareGUI();
	}

	public static void main(String[] args){
		KindOfTraveller gui = new KindOfTraveller();  
		gui.showEventDemo();       
	}
	
	private void prepareGUI() {
		
		mainFrame = new JFrame("Welcome!");
	    mainFrame.setSize(400,400);
	    mainFrame.setLayout(new GridLayout(3, 1));
	    
	    headerLabel = new JLabel("",JLabel.CENTER );
	    statusLabel = new JLabel("",JLabel.CENTER);        
	    statusLabel.setSize(350,100);
	    
	    //δεν ξερω ακριβως τι κανει
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
	
	public void  showEventDemo() {
		headerLabel.setText("Are you a Traveller/Tourist/Business?");
		
		JButton TravellerButton = new JButton("Traveller");
	    JButton TouristButton = new JButton("Tourist");
	    JButton BusinessButton = new JButton("Business");
	    
	    TravellerButton.setActionCommand("Traveller");
	    TouristButton.setActionCommand("Tourist");
	    BusinessButton.setActionCommand("Business");
	    
	    TravellerButton.addActionListener(new ButtonClickListener()); 
	    TouristButton.addActionListener(new ButtonClickListener()); 
	    BusinessButton.addActionListener(new ButtonClickListener());	    
	    
	    controlPanel.add(TravellerButton);
	    controlPanel.add(TouristButton);
	    controlPanel.add(BusinessButton);
	    
	    mainFrame.setVisible(true); 
	}
	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command=e.getActionCommand();
			if(command.equals("Traveller")) {
				//εδω θα βαλω τις ενεργειες-εντολές που χρειαζονται για Traveller
				statusLabel.setText("Traveller Button clicked.");
			}else if(command.equals("Tourist")) {
				//εδω θα βαλω τις ενεργειες που χρειαζονται για Tourist
				statusLabel.setText("Tourist Button clicked.");				
			}else {
				//εδω θα βαλω τις ενεργειες που χρειαζονται για Business
				statusLabel.setText("Business Button clicked.");
			}
		}

	}

}
