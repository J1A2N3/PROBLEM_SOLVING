package classes;

import javax.swing.*;
import java.awt.*;

public class homepage {
	public String pos;
	public JFrame frame;
    public homepage(String pos){
	 this.pos=pos;
	 try {
	        ask();  
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
 }
    public void ask() throws Exception {
        // Create frame
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Set background color
        frame.getContentPane().setBackground(new Color(128, 0, 128));
        frame.setLayout(null);

        // Title label
        JLabel intro = new JLabel("WELCOME TO PERSONNEL MANAGEMENT SYSTEM", SwingConstants.CENTER);
        intro.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
        intro.setForeground(Color.WHITE);
        intro.setBounds(50, 50, 500, 30);
        frame.add(intro);

        // Buttons
        JButton login = new JButton("LOGIN");
        JButton signup = new JButton("SIGN-UP");
        JLabel orLabel = new JLabel("(or)");
        login.setBounds(250, 150, 200, 30);
        signup.setBounds(250, 200, 200, 30);
        orLabel.setBounds(330, 175, 50, 20);
        frame.add(login);
        frame.add(signup);
        frame.add(orLabel);

     // Action Listeners for Buttons
        login.addActionListener(e -> {
            frame.setVisible(false);
            String entry="login";
            credentials log=new credentials(pos,entry);
            try {
				log.ask();
			} catch (Exception ee) {}
			
    });

        signup.addActionListener(e -> {
            frame.setVisible(false);
            String entry="signup";
            credentials sgn=new credentials(pos,entry);
            try {
				sgn.ask();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        });

        frame.setVisible(true);
    }
}
