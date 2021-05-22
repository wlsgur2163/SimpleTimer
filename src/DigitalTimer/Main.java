package DigitalTimer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
	static ActionListener actionListenerMinup;
	static ActionListener actionListenerSecup;
	static ActionListener actionListenerSecdown;
	static ActionListener actionListenerMindown;
	static ActionListener actionListenerMinup2;
	static ActionListener actionListenerSecup2;
	static JButton buttstart = new JButton("S/S");
	static JButton buttreset = new JButton("Reset");
	static JButton buttmode = new JButton("Timer");
	static JButton buttminup = new JButton("min¡è");
	static JButton buttsecup = new JButton("s/m¡è");
	static JButton buttmindown = new JButton("min¡é");
	static JButton buttsecdown = new JButton("s/m¡é");
	static JButton butt5secup = new JButton("5sec¡è");
	static JButton butt5minup = new JButton("5min¡è");
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
    
	public static void main(String[] args)
	{
		start();
		reset();
		buttstart.addActionListener(actionListenerSS);
		buttreset.addActionListener(actionListenerRESET);
		buttmode.addActionListener(actionListenerMode);
		buttminup.addActionListener(actionListenerMinup);
	    buttsecup.addActionListener(actionListenerSecup);
	    buttmindown.addActionListener(actionListenerMindown);
	    buttsecdown.addActionListener(actionListenerSecdown);
	    butt5minup.addActionListener(actionListenerMinup2);
	    butt5secup.addActionListener(actionListenerSecup2);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Digital Timer Component");
		frame.setLayout(new BorderLayout());
	    frame.setSize(240, 125+40);
	    frame.setLocationRelativeTo(null);

	    panel.setLayout(new GridLayout(3,3));
	    panel.setBackground(Color.BLACK);
		
		panel.add(buttstart);
		panel.add(buttreset);
		panel.add(buttmode);
		panel.add(buttminup);
	    panel.add(buttsecup);
	    panel.add(butt5minup);
	    panel.add(buttmindown);
	    panel.add(buttsecdown);
	    panel.add(butt5secup);
	    
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
