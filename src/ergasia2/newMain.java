package ergasia2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*public void prepareGUI() {
	
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
}*/
public class newMain {
	public static void main(String args[]) {
		YesNo yn=new YesNo();
		yn.showEventDemo();
		
	}

    	
}
