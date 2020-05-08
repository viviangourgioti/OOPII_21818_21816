package ergasia2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WeatherGui {
	
    public JFrame mainFrame;
    public JLabel headerLabel;
    public JLabel statusLabel;
    public JPanel controlPanel;
    
    public WeatherGui(){
    	prepareGUI();
    }
    public static void main(String args[]){
        WeatherGui  swingControlDemo = new WeatherGui();      
        swingControlDemo.showComboboxDemo();
     }
	private void prepareGUI() {
	    mainFrame = new JFrame("Java Swing Examples");
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
	   private void showComboboxDemo(){  
		      headerLabel.setText("Control in action: JComboBox"); 
		      final DefaultComboBoxModel weatherCr = new DefaultComboBoxModel();

		      weatherCr.addElement("rain");
		      weatherCr.addElement("snow");
		      weatherCr.addElement("sun");
		      weatherCr.addElement("clouds");
		      weatherCr.addElement("clear");
		      
		      final JComboBox WeatherCombo = new JComboBox(weatherCr);    
		      WeatherCombo.setSelectedIndex(0);

		      JScrollPane weatherScrollPane = new JScrollPane(WeatherCombo);    
		      JButton showButton = new JButton("Show");

		      showButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) { 
		            String data = "";
		            if (WeatherCombo.getSelectedIndex() != -1) {                     
		               data = "Weather Selected: " 
		                  + WeatherCombo.getItemAt
		                  (WeatherCombo.getSelectedIndex());             
		            }              
		            statusLabel.setText(data);
		         }
		      }); 
		      controlPanel.add(weatherScrollPane);          
		      controlPanel.add(showButton);    
		      mainFrame.setVisible(true);             
		   }
}
