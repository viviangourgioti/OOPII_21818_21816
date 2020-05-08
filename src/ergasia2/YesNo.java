package ergasia2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class YesNo {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	/*public YesNo() {
		prepareGUI();
	}*/
	public static void main(String[] args){
		YesNo yn = new YesNo();  
		yn.showEventDemo();       
	}
	public YesNo(){
		
		mainFrame = new JFrame("Welcome!");
	    mainFrame.setSize(400,400);
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
	public void  showEventDemo() {
		headerLabel.setText("Do you want to make a city Recommendation?");
		
		JButton YesButton = new JButton("YES");
	    JButton NoButton = new JButton("NO");

	    YesButton.setActionCommand("YES");
	    NoButton.setActionCommand("NO");

	    
	    YesButton.addActionListener(new ButtonClickListener()); 
	    NoButton.addActionListener(new ButtonClickListener()); 	    
	    
	    controlPanel.add(YesButton);
	    controlPanel.add(NoButton);
	    
	    mainFrame.setVisible(true); 
	}
	public class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command=e.getActionCommand();
			if(command.equals("YES")) {
				//εδω θα βαλω τις ενεργειες-εντολές που χρειαζονται για City REcommendation
				//statusLabel.setText("Yes Button clicked.");
			}else if(command.equals("NO")) {
				//εδω θα βαλω τις ενεργειες που χρειαζονται για έξοδο
				System.exit(0);
				statusLabel.setText("Νο Button clicked.");				
			}
		}

	}
}
