package DigitalTimer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main
{
	static Model model = new Model();
	static TimeComponent t = new TimeComponent(model);
	static ActionListener actionListenerSS;
	static ActionListener actionListenerRESET;
	static ActionListener actionListenerMode;
	static JButton buttstart = new JButton("S/S");
	static JButton buttreset = new JButton("Reset");
	static JButton buttmode = new JButton("Timer");
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
    
	public static void main(String[] args)
	{
		start();
		reset();
		buttstart.addActionListener(actionListenerSS);
		buttreset.addActionListener(actionListenerRESET);
		buttmode.addActionListener(actionListenerMode);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Digital Timer Component");
		frame.setLayout(new BorderLayout());
		frame.setSize(210, 82+25);
		frame.setLocationRelativeTo(null);

		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.BLACK);
		
		panel.add(buttstart, BorderLayout.WEST);
		panel.add(buttreset, BorderLayout.EAST);
		panel.add(buttmode);
		
		frame.add(t, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}
	
	static int onOff = 0;
	public static void start(){        
		actionListenerSS = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
            	  if(onOff == 0){
            		  System.out.println("start");
            		  onOff =1;
                	  model.setStart(1);
                	  t.repaint();
            	  }else{
            		  System.out.println("stop");
            		  onOff =0;
                	  model.setStart(0);
            	  }
            	  
              }
        };                
    }
	
	public static void reset(){        
		actionListenerRESET = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
            	  System.out.println("stop");
        		  onOff =0;
            	  model.setStart(0);
            	  System.out.println("reset");
            	  model.setReset(1);
            	  t.repaint();
              }
        };                
    }              
}
