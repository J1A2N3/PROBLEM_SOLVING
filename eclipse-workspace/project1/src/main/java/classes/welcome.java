package classes;

import javax.swing.*;
import java.awt.*;

public class welcome {

    public JFrame frame;
	public welcome() {
        // Initialize the frame
         frame = new JFrame("Welcome");

        // Set default close operation and window size
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
        JButton hrButton = new JButton("HR");
        JButton employeeButton = new JButton("EMPLOYEE");
        JLabel orLabel = new JLabel("(or)");
        hrButton.setBounds(250, 150, 200, 30);
        employeeButton.setBounds(250, 200, 200, 30);
        orLabel.setBounds(330, 175, 50, 20);
        frame.add(hrButton);
        frame.add(employeeButton);
        frame.add(orLabel);

        // Action Listeners for Buttons
        hrButton.addActionListener(e -> {
            frame.setVisible(false);
            String pos = "hr";
            homepage hr = new homepage(pos);
            try {
                hr.ask();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        employeeButton.addActionListener(e -> {
            frame.setVisible(false);
            String pos = "employee";
            homepage emp = new homepage(pos);
            try {
                emp.ask();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        // Make sure the frame is visible when it's constructed
        frame.setVisible(true);
    }
        public static void main(String[] args) {
            // Create and display the Welcome page
            new welcome();
        }
    
}
