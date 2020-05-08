package ergasia2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PersonalInfo {
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	public PersonalInfo() {
		prepareGui();
	}
	public static void main(String[] args){
		PersonalInfo  g2 = new PersonalInfo();      
		g2.showTextFieldDemo();
	}
	public void prepareGui() {
	    mainFrame = new JFrame("Welcome!");
	    mainFrame.setSize(400,400);
	    mainFrame.setLayout(new GridLayout(3,1));
		
	    mainFrame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent windowEvent){
	           System.exit(0);
	        }        
	    });
	    headerLabel = new JLabel("", JLabel.CENTER);        
	    statusLabel = new JLabel("",JLabel.CENTER);    
	    statusLabel.setSize(350,100);
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new FlowLayout());
	    
	    mainFrame.add(headerLabel);
	    mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); 
	    
	}
	public void showTextFieldDemo(){	
		headerLabel.setText("Please give your personal information:"); 

		JLabel namelabel=new JLabel("Name: ", JLabel.RIGHT);
	    JLabel ageLabel =new JLabel("Age: ", JLabel.CENTER);
	    JLabel latLabel=new JLabel("Current lat:",JLabel.LEFT);
	    JLabel lonLabel=new JLabel("Current lon:");
	    
		final JTextField nameText = new JTextField(6);
	    final JTextField ageText = new JTextField(6);      
	    final JTextField latText = new JTextField(6);
	    final JTextField lonText = new JTextField(6); 
	    
		JButton DoneButton = new JButton("OK");
		
		DoneButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) { 
		    	
		        String data = "Name:" + nameText.getText();
		        data += ", Age: " + new String(ageText.getText()); 
		        data+=",Lat:"+new String(latText.getText());
		        data+=",Lon:"+new String(lonText.getText());
		        
		        statusLabel.setText(data);        
		     }
		 }); 
		 controlPanel.add(namelabel);
		 controlPanel.add(nameText);
         controlPanel.add(ageLabel);       
	     controlPanel.add(ageText);
	     controlPanel.add(latLabel);       
	     controlPanel.add(latText);
	     controlPanel.add(lonLabel);       
	     controlPanel.add(lonText);
	     controlPanel.add(DoneButton);
		 mainFrame.setVisible(true);  
   }

}
