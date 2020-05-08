package ergasia2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cities {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	public Cities() {
		prepareGui2();
	}
	public static void main(String args[]){
		Cities  ci = new Cities();      
		ci.showTextFieldDemo();
	}
	public void prepareGui2() {
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
		headerLabel.setText("Please give some names of cities:"); 

		JLabel namelabel=new JLabel("Name: ", JLabel.RIGHT);

		final JTextField nameText = new JTextField(6);	    
		JButton NextButton = new JButton("Next");
		JButton end=new JButton("Done");
		
		end.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       mainFrame.dispose();
		    }
		});
		
		NextButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) { 
		    	
		        String data = "Name:" + nameText.getText();		        
		        statusLabel.setText(data);        
		     }
		 }); 
		 controlPanel.add(namelabel);
		 controlPanel.add(nameText);
	     controlPanel.add(NextButton);
	     controlPanel.add(end);
		 mainFrame.setVisible(true);  
   }

}
