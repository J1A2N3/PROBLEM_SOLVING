package classes;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class credentials {
    private final String log_code = "hr_unique_code";
    private String entry;
    private String pos;

    public credentials(String pos, String entry) {
        this.pos = pos;
        this.entry = entry;
    }

    public void ask() {
        JFrame frame = new JFrame(pos.toUpperCase() + " " + entry.toUpperCase());
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(230, 230, 255));

        JLabel title = new JLabel("Personnel Management - " + pos.toUpperCase());
        title.setBounds(80, 20, 400, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 16));

        JTextField nameField = new JTextField();
        nameField.setBounds(180, 70, 200, 25);
        frame.add(new JLabel("Name:")).setBounds(80, 70, 100, 25);
        frame.add(nameField);

        JPasswordField passField = new JPasswordField();
        if (entry.equals("login") || pos.equals("employee")) {
            frame.add(new JLabel("Password:")).setBounds(80, 110, 100, 25);
            passField.setBounds(180, 110, 200, 25);
            frame.add(passField);
        }

        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField roleField = new JTextField();
        JPasswordField codeField = new JPasswordField();

        if (pos.equals("employee") && entry.equals("signup")) {
            frame.add(new JLabel("Email:")).setBounds(80, 150, 100, 25);
            emailField.setBounds(180, 150, 200, 25);
            frame.add(emailField);

            frame.add(new JLabel("Phone:")).setBounds(80, 190, 100, 25);
            phoneField.setBounds(180, 190, 200, 25);
            frame.add(phoneField);

            frame.add(new JLabel("Department:")).setBounds(80, 230, 100, 25);
            deptField.setBounds(180, 230, 200, 25);
            frame.add(deptField);

            frame.add(new JLabel("Role:")).setBounds(80, 270, 100, 25);
            roleField.setBounds(180, 270, 200, 25);
            frame.add(roleField);
        }

        if (pos.equals("hr") && entry.equals("signup")) {
            frame.add(new JLabel("Passcode:")).setBounds(80, 150, 100, 25);
            codeField.setBounds(180, 150, 200, 25);
            frame.add(codeField);
        }

        JButton submit = new JButton(entry.toUpperCase());
        submit.setBounds(180, 320, 100, 30);
        frame.add(submit);

        frame.add(title);
        frame.setVisible(true);

        // Button click logic
        submit.addActionListener(e -> {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "connect");

                String name = nameField.getText();
                String pass = new String(passField.getPassword());

                if (pos.equals("hr")) {
                    if (entry.equals("signup")) {
                        String code = new String(codeField.getPassword());

                        if (code.equals(log_code)) {
                            PreparedStatement ps = con.prepareStatement("INSERT INTO HR.HR_LOG(name) VALUES (?)");
                            ps.setString(1, name);
                            int rows = ps.executeUpdate();
                            if (rows > 0) {
                                JOptionPane.showMessageDialog(frame, "HR Signed up successfully!");
                                frame.dispose();
                                new hr_page(name).execute();
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect passcode!");
                        }
                    } else {
                        PreparedStatement ps = con.prepareStatement("SELECT * FROM HR.HR_LOG WHERE name = ?");
                        ps.setString(1, name);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(frame, "HR Login successful!");
                            frame.dispose();
                            new hr_page(name).execute();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Name not found.");
                        }
                    }
                }

                else if (pos.equals("employee")) {
                    if (entry.equals("signup")) {
                        String email = emailField.getText();
                        String phone = phoneField.getText();
                        String dept = deptField.getText();
                        String role = roleField.getText();

                        PreparedStatement ps = con.prepareStatement("INSERT INTO HR.EMPLOYEE(name, email, phone, department, role, password) VALUES (?,?,?,?,?,?)");
                        ps.setString(1, name);
                        ps.setString(2, email);
                        ps.setString(3, phone);
                        ps.setString(4, dept);
                        ps.setString(5, role);
                        ps.setString(6, pass);

                        int rows = ps.executeUpdate();
                        if (rows > 0) {
                            JOptionPane.showMessageDialog(frame, "Employee signed up successfully!");
                            frame.dispose();
                            new employee_page(name).execute();
                        }
                    } else {
                        PreparedStatement ps = con.prepareStatement("SELECT * FROM HR.EMPLOYEE WHERE name = ? AND password = ?");
                        ps.setString(1, name);
                        ps.setString(2, pass);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(frame, "Employee login successful!");
                            frame.dispose();
                            new employee_page(name).execute();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid credentials!");
                        }
                    }
                }

                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });
    }
}
