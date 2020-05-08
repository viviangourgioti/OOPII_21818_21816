package ergasia2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Criteria {
	
	private JFrame mainFrame;
	private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    
    public Criteria(){
        prepareGUI();
    }
    public static void main(String[] args){
        Criteria  swingControlDemo = new Criteria();      
        swingControlDemo.showCheckBoxDemo();
     }
	private void prepareGUI() {
		
	    mainFrame = new JFrame("Criteria CheckBox");
	    mainFrame.setSize(400,400);
	    mainFrame.setLayout(new GridLayout(3, 1));
	      
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
	
	private void showCheckBoxDemo(){
		   
		   headerLabel.setText("Control in action: CheckBox"); 

	       //final JCheckBox chklandmarks = new JCheckBox("Landmarks");
    	   final JCheckBox chkmuseums= new JCheckBox("Museums");
		   final JCheckBox chkcafes= new JCheckBox("CafesRestaurantsBars");
		   final JCheckBox chkskyscrapers= new JCheckBox("Skyscrapers");
		   final JCheckBox chkgalleries= new JCheckBox("Galleries");
		   final JCheckBox chkparks= new JCheckBox("Parks");
		   final JCheckBox chksea= new JCheckBox("Sea");
		   final JCheckBox chkshops= new JCheckBox("Shops");
		   
		   
		   chkmuseums.setMnemonic(KeyEvent.VK_C);
	       chkcafes.setMnemonic(KeyEvent.VK_M);
	       chkskyscrapers.setMnemonic(KeyEvent.VK_P);
	       chkgalleries.setMnemonic(KeyEvent.VK_P);
	       chkparks.setMnemonic(KeyEvent.VK_P);
	       chksea.setMnemonic(KeyEvent.VK_P);
	       chkshops.setMnemonic(KeyEvent.VK_P);
	       
	       JButton DoneButton = new JButton("OK");

	   	DoneButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) { 
		    	String msg="";
		    	if(chkmuseums.isSelected()) {
		    		msg="Museums\n";
		    	}
		    	if(chkcafes.isSelected()) {
		    		msg+="Cafes\n";
		    	}
		    	if(chkskyscrapers.isSelected()) {
		    		msg+="Skyscrapers\n";
		    	}
		    	if(chkgalleries.isSelected()) {
		    		msg+="Galleries\n";
		    	}
		    	if(chkparks.isSelected()) {
		    		msg+="Parks\n";
		    	}
		    	if(chksea.isSelected()) {
		    		msg+="Sea\n";
		    	}
		    	if(chkshops.isSelected()) {
		    		msg+="Shops\n";
		    	}
		    	JOptionPane.showMessageDialog(DoneButton, msg);
		     }
		 }); 
	       
		  /* chkmuseums.addItemListener(new ItemListener() {
			   
		       public void itemStateChanged(ItemEvent e) {  	   
		           statusLabel.setText("Museums Checkbox: " 
		               + (e.getStateChange()==1?"checked":"unchecked"));
		       }           
		   });
		   chkcafes.addItemListener(new ItemListener() {		   
		       public void itemStateChanged(ItemEvent e) {             
		           statusLabel.setText("Cafes Checkbox: " 
		               + (e.getStateChange()==1?"checked":"unchecked")); 
		       }           
		   });
		   chkskyscrapers.addItemListener(new ItemListener() {			   
		       public void itemStateChanged(ItemEvent e) {             
		            statusLabel.setText("Skyscrapers Checkbox: " 
		               + (e.getStateChange()==1?"checked":"unchecked"));
		       }           
		    });
		   chkgalleries.addItemListener(new ItemListener() {			   
		       public void itemStateChanged(ItemEvent e) {             
		            statusLabel.setText("Galleries Checkbox: " 
		               + (e.getStateChange()==1?"checked":"unchecked"));
		       }           
		    });
		   chkparks.addItemListener(new ItemListener() {			   
		       public void itemStateChanged(ItemEvent e) {             
		            statusLabel.setText("Paeks Checkbox: " 
		               + (e.getStateChange()==1?"checked":"unchecked"));
		       }           
		    });
		   chksea.addItemListener(new ItemListener() {			   
		       public void itemStateChanged(ItemEvent e) {             
		            statusLabel.setText("Sea Checkbox: " 
		               + (e.getStateChange()==1?"checked":"unchecked"));
		       }           
		    });
		   chkshops.addItemListener(new ItemListener() {			   
		       public void itemStateChanged(ItemEvent e) {             
		            statusLabel.setText("Shops Checkbox: " 
		               + (e.getStateChange()==1?"checked":"unchecked"));
		       }           
		    });*/
		   
		    controlPanel.add(chkmuseums);
		    controlPanel.add(chkcafes);
	        controlPanel.add(chkskyscrapers);   
	        controlPanel.add(chkgalleries);
	        controlPanel.add(chkparks);
	        controlPanel.add(chksea);
	        controlPanel.add(chkshops);
	        controlPanel.add(DoneButton);
	        
		    mainFrame.setVisible(true);  
		   }
}
