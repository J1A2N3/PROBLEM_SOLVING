package classes;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;

public class employee_page {
	public String name;
    public String status="";
	employee_page(String name){
		this.name=name;
	}   
	public void execute() throws Exception  {
		
		Scanner sc=new Scanner(System.in);	
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "connect");
        JFrame frame=new JFrame("HELLO   "+name.toUpperCase()+" ! , ACCESS   YOUR   WORKSPACE   HERE");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setBounds(400,200,400,400);       
        Container content=frame.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(null); 
		JMenuBar mbar = new JMenuBar();
		
		JMenu a = new JMenu("Employee Profile");
		JMenuItem a1 = new JMenuItem("View Personal Details");
		JMenuItem a2 = new JMenuItem("Update Profile");
		JMenuItem a3 = new JMenuItem("Salary Details");
		a.add(a1);
		a.add(a2);
		a.add(a3);

		JMenu b = new JMenu("Work & Tasks");
		JMenuItem b1 = new JMenuItem("View Assigned Tasks");
		JMenuItem b2 = new JMenuItem("Mark Attendance");
		b.add(b1);
		b.add(b2);

		JMenu c = new JMenu("Leave Management");
		JMenuItem c1 = new JMenuItem("View Leave Info");
		JMenuItem c2 = new JMenuItem("Request Leave");
		c.add(c1);
		c.add(c2);

		JMenu d = new JMenu("Company Info");
		JMenuItem d1 = new JMenuItem("Notices & Policies");
		JMenuItem d2 = new JMenuItem("Submit Feedback");
		d.add(d1);
		d.add(d2);

		mbar.add(a);
		mbar.add(b);
		mbar.add(c);
		mbar.add(d);

        frame.setJMenuBar(mbar);
        frame.setVisible(true);
        
        // view personal details
//-----------------------------------------------------------------------------------------------------------------------        
        a1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                content.removeAll();

                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM HR.EMPLOYEE WHERE name = ?");
                    ps.setString(1, name);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        String[] labels = {
                            "Name:       " + rs.getString("name"),
                            "Email:      " + rs.getString("email"),
                            "Phone:      " + rs.getString("phone"),
                            "Department: " + rs.getString("department"),
                            "Role:       " + rs.getString("role"),
                            "Join Date:  " + rs.getString("join_date")
                        };

                        int y = 50;
                        for (String info : labels) {
                            JLabel label = new JLabel(info);
                            label.setFont(new Font("Arial", Font.PLAIN, 16));
                            label.setBounds(100, y, 300, 30);
                            content.add(label);
                            y += 40;
                        }

                    } else {
                        JLabel label = new JLabel("Employee not found!");
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        label.setBounds(50, 100, 400, 30);
                        content.add(label);
                    }

                   content.revalidate();
                   content.repaint();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error occured");

                }
            }
        });
        
        //update details
//-----------------------------------------------------------------------------------------------------------------------------        
        a2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                content.removeAll(); 
                content.repaint();
                content.revalidate();

                JLabel emailLabel = new JLabel("New Email:");
                emailLabel.setBounds(50, 50, 100, 25);
                JTextField emailField = new JTextField();
                emailField.setBounds(160, 50, 150, 25);

                JLabel phoneLabel = new JLabel("New Phone:");
                phoneLabel.setBounds(50, 90, 100, 25);
                JTextField phoneField = new JTextField();
                phoneField.setBounds(160, 90, 150, 25);

                JButton updateButton = new JButton("Update");
                updateButton.setBounds(130, 180, 100, 30);

                content.add(emailLabel);
                content.add(emailField);
                content.add(phoneLabel);
                content.add(phoneField);
                content.add(updateButton);

                content.repaint();
                content.revalidate();
                // pressing button updates
                updateButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String newEmail = emailField.getText();
                            String newPhone = phoneField.getText();
                            
                           PreparedStatement ps = con.prepareStatement( "UPDATE HR.EMPLOYEE SET email = ?, phone = ? WHERE name = ?");
                            ps.setString(1, newEmail);
                            ps.setString(2, newPhone);
                            ps.setString(3, name);
                            int rows = ps.executeUpdate();

                            if (rows > 0) {
                                JOptionPane.showMessageDialog(frame, "Profile updated successfully!");
                            } else {
                                JOptionPane.showMessageDialog(frame, "Update failed. Employee not found.");
                            }
                        } catch (Exception ee) {
                            JOptionPane.showMessageDialog(frame, "error occured");

                        }
                    }
                });
            }
        });
//salary details
//----------------------------------------------------------------------------------------------------------------------------
        a3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                content.removeAll();
                content.repaint();
                content.revalidate();
                try {
                    PreparedStatement ps = con.prepareStatement("Select * from HR.EMP_SALARY where name = ?");
                    ps.setString(1, name);
                    ResultSet rs = ps.executeQuery();

                    JLabel title = new JLabel("Your Salary Details:");
                    title.setBounds(50, 20, 300, 30);
                    title.setFont(new Font("Arial", Font.BOLD, 20));
                    content.add(title);

                    if (rs.next()) {
                        JLabel taskLabel = new JLabel("<html>Salary: " + rs.getString("Salary") +
                                "<br>Present Days: " + rs.getString("Present_days") +
                                "<br>Absent Days: " + rs.getString("Absent_Days") +
                                "<br>Deduction: " + rs.getString("Deduction") +
                                "<br>Allowance: " + rs.getString("Allowance") +
                                "<br>Net Salary: " + rs.getString("Net_Salary") + "</html>");
                        taskLabel.setBounds(30, 60, 700, 150);
                        taskLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                        content.add(taskLabel);
                    } else {
                        JLabel notFound = new JLabel("No salary details found.");
                        notFound.setBounds(30, 60, 300, 30);
                        content.add(notFound);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        
        // view tasks
//---------------------------------------------------------------------------------------------------        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                content.removeAll();
                content.repaint();
                content.revalidate();

                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM HR.TASKS WHERE name = ?");
                    ps.setString(1, name);
                    ResultSet rs = ps.executeQuery();

                    JLabel title = new JLabel("Your Assigned Tasks:");
                    title.setBounds(50, 25, 250, 25);
                    title.setFont(new Font("Arial", Font.BOLD, 20));
                    content.add(title);

                    int y = 60;
                    int taskNo = 1;

                    while (rs.next()) {
                        JLabel taskLabel = new JLabel("Task " + taskNo++ + ": "+ rs.getString("task_name") + " | Deadline: " + 
                                rs.getString("deadline")+ " | Priority: " + rs.getString("priority")+ " | Status: " + rs.getString("status"));
                        taskLabel.setBounds(30, y, 700, 25);
                        taskLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                        content.add(taskLabel);
                        y += 30;

                        JLabel desc = new JLabel("Description: " + rs.getString("description"));
                        desc.setBounds(50, y, 700, 30);
                        content.add(desc);
                        y += 30;
                    }

                    if (taskNo == 1) {
                        JLabel noTask = new JLabel("No tasks found for you.");
                        noTask.setBounds(50, y, 300, 25);
                        content.add(noTask);
                    }

                    content.repaint();
                    content.revalidate();

                } catch (Exception ex) {
                }
            }
        });
        
        //mark attendence
//---------------------------------------------------------------------------------------------------        
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                content.removeAll();
                content.repaint();
                content.revalidate();

                JLabel attendlabel = new JLabel("Enter Present or Absent");
                attendlabel.setBounds(50, 50, 300, 30);
                content.add(attendlabel);

                JTextField attendfield = new JTextField();
                attendfield.setBounds(400, 50, 100, 25);
                content.add(attendfield);

                JButton submitButton = new JButton("Submit Attendance");
                submitButton.setBounds(250, 100, 200, 30);
                content.add(submitButton);

                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String status = attendfield.getText(); 
                        int flag = 0;
                        int present_days = 0; 
                        int absent_days = 0; 
                        int updated_present_days=0;
                        int updated_absent_days=0;
                        if (status.equalsIgnoreCase("Present")) {
                            present_days = 1;  
                        } else  {
                            absent_days = 1;  
                            flag = 1;
                        }

                        LocalDate today = LocalDate.now();
                        String date = today.toString(); 

                        try {
                            PreparedStatement ps = con.prepareStatement("SELECT * FROM HR.EMP_SALARY WHERE name = ?");
                            ps.setString(1, name);
                            ResultSet rs = ps.executeQuery();

                            if (rs.next()) {
                                double deduction = rs.getDouble("deduction");
                                double allowance = rs.getDouble("allowance");
                                double salary = rs.getDouble("salary");
                                int db_present_days = rs.getInt("present_days");
                                int db_absent_days = rs.getInt("absent_days");

                                // Update the present and absent days
                                 updated_present_days = db_present_days + present_days;
                                 updated_absent_days = db_absent_days + absent_days;

                                // Calculate the net salary
                                double daily_salary = salary / 30;
                                double net_salary = (daily_salary * updated_present_days) - deduction - allowance;

                                // Update the salary
                                PreparedStatement ps2 = con.prepareStatement("UPDATE HR.EMP_SALARY SET present_days = ?, absent_days = ?, net_salary = ? WHERE name = ?");
                                ps2.setInt(1, updated_present_days);
                                ps2.setInt(2, updated_absent_days);
                                ps2.setDouble(3, net_salary);
                                ps2.setString(4, name);
                                ps2.executeUpdate();

                                // If  absent, record the absence date
                                if (flag == 1) {
                                    PreparedStatement ps3 = con.prepareStatement("INSERT INTO HR.emp_absent_date (name, absent_date) VALUES (?, ?)");
                                    ps3.setString(1, name);
                                    ps3.setString(2, date);
                                    ps3.executeUpdate();
                                }

                                JOptionPane.showMessageDialog(frame, "Attendance updated successfully!");
                            } else {
                                JOptionPane.showMessageDialog(frame, "Employee not found!");
                            }
                            
                            // Check if the total present and absent days reach 30
                            	if (updated_present_days + updated_absent_days >= 30) {
                            	    // Reset present and absent days to 0 in EMP_SALARY table
                            	    PreparedStatement ps4 = con.prepareStatement("Delete from HR.emp_salary WHERE name = ?");
                            	    ps4.setString(1, name);
                            	    ps4.executeUpdate();

                            	    // Delete all attendance records from emp_absent_date table for this employee
                            	    PreparedStatement ps5 = con.prepareStatement("DELETE FROM HR.emp_absent_date WHERE name = ?");
                            	    ps5.setString(1, name);
                            	    ps5.executeUpdate();

                            	    JOptionPane.showMessageDialog(frame, "Attendance reset for the employee after 30 days.");
                            	}
                            	
                        } catch (Exception ee) {
                            JOptionPane.showMessageDialog(frame, "Error updating attendance: " + ee.getMessage());
                        }
                    }
                });
            }
        });

      //leave info
//--------------------------------------------------------------------------------------------------
	c1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			content.removeAll();
			
			
			JLabel leaves=new JLabel("Absent_dates");
			leaves.setBounds(30,30,100,25);
			content.add(leaves);
			
			try {
				PreparedStatement ps=con.prepareStatement("SELECT absent_date FROM HR.EMP_ABSENT_DATE WHERE name = ?");
				ps.setString(1,name);
				ResultSet rs= ps.executeQuery();
				int days=0;
				int y=60;
				while(rs.next()) {
					JLabel dates=new JLabel(rs.getString("ABSENT_DATE"));
                        dates.setBounds(80, y, 500, 25);
                        content.add(dates);
                        days=1;
                        y+=30;
				}
				if (days==0) {
	                JLabel no = new JLabel("No absent dates recorded.");
	                no.setBounds(80, y, 200, 25);
	                content.add(no);
	            }
			} catch (Exception e1) {
	            JOptionPane.showMessageDialog(content, "Error retrieving absent dates: ");
			}
			
			content.repaint();
			content.revalidate();
		}
	})    ;
 
  //request leave
//--------------------------------------------------------------------------------------------------
	c2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        content.removeAll();

	        JLabel requestlabel = new JLabel("Request for Leave:");
	        requestlabel.setBounds(30, 30, 200, 25);
	        content.add(requestlabel);

	        JTextField requestfield = new JTextField("enter from date"); 
	        requestfield.setBounds(260, 30, 100, 25);
	        content.add(requestfield);

	        JTextField requestfield1 = new JTextField("enter to date"); 
	        requestfield1.setBounds(390, 30, 100, 25);
	        content.add(requestfield1);

	        JTextField requestfield2 = new JTextField("enter reason"); 
	        requestfield2.setBounds(300, 70, 400, 100);
	        content.add(requestfield2);

	        JButton submit = new JButton("Submit Request");
	        submit.setBounds(320, 190, 160, 30);
	        content.add(submit);

	        submit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String fromDate = requestfield.getText();
	                String toDate = requestfield1.getText();
	                String reason = requestfield2.getText();

	                try {
	                    PreparedStatement ps = con.prepareStatement(
	                        "INSERT INTO HR.request_leave (name, from_date, to_date, reason) VALUES (?, ?, ?, ?)"
	                    );
	                    ps.setString(1, name);
	                    ps.setString(2, fromDate);
	                    ps.setString(3, toDate);
	                    ps.setString(4, reason);

	                    int result = ps.executeUpdate();
	                    if (result > 0) {
	                        JOptionPane.showMessageDialog(content, " Leave request submitted successfully!");
	                    } else {
	                        JOptionPane.showMessageDialog(content, " Failed to submit leave request.");
	                    }
	                } catch (Exception e1) {
	                    JOptionPane.showMessageDialog(content, " Error submitting leave request: " + e1.getMessage());
	                }

	                content.repaint();
	                content.revalidate();
	            }
	        });

	        content.repaint();
	        content.revalidate();
	    }
	});
//notices and policies
//---------------------------------------------------------------------------------------------------
	d1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        content.removeAll();

	        JLabel title = new JLabel(" Company Notices & Policies");
	        title.setBounds(200, 20, 400, 30);
	        title.setFont(new Font("Arial", Font.BOLD, 18));
	        content.add(title);

	        try {
	            PreparedStatement ps = con.prepareStatement("SELECT notices FROM HR.company_notices");
	            ResultSet rs = ps.executeQuery();

	            int y = 70;
	            while (rs.next()) {
	                JLabel label = new JLabel("<>" + rs.getString("notices"));
	                label.setBounds(50, y, 700, 25);
	                content.add(label);
	                y += 30;
	            }

	            if (y == 70) {
	                JLabel nonotice = new JLabel("No company notices available.");
	                nonotice.setBounds(50, y, 300, 25);
	                content.add(nonotice);
	            }

	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(content, " Error loading notices: " + ex.getMessage());
	        }

	        content.repaint();
	        content.revalidate();
	    }
	});
	//feedback and suggestions
//----------------------------------------------------------------------------------------
	d2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        content.removeAll();

	        JLabel title = new JLabel("Submit Feedback or Suggestion");
	        title.setBounds(150, 20, 400, 25);
	        title.setFont(new Font("Arial", Font.BOLD, 18));
	        content.add(title);

	        JLabel label = new JLabel("Your Feedback:");
	        label.setBounds(50, 70, 200, 25);
	        content.add(label);

	        JTextArea feedbackArea = new JTextArea();
	        feedbackArea.setBounds(50, 100, 500, 150);
	        feedbackArea.setLineWrap(true);
	        feedbackArea.setWrapStyleWord(true);
	        content.add(feedbackArea);

	        JButton submitButton = new JButton("Submit");
	        submitButton.setBounds(250, 270, 100, 30);
	        content.add(submitButton);

	        submitButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String feedback = feedbackArea.getText().trim();
	                if (!feedback.isEmpty()) {
	                    try {
	                        PreparedStatement ps = con.prepareStatement(
	                            "INSERT INTO HR.feedback (name, feedback) VALUES (?, ?)");
	                        ps.setString(1, name);
	                        ps.setString(2, feedback);

	                        int result = ps.executeUpdate();
	                        if (result > 0) {
	                            JOptionPane.showMessageDialog(content, " Feedback submitted successfully!");
	                            feedbackArea.setText(""); 
	                        } else {
	                            JOptionPane.showMessageDialog(content, " Submission failed.");
	                        }
	                    } catch (Exception ex) {
	                        JOptionPane.showMessageDialog(content, "Error");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(content, " Please enter your feedback first.");
	                }
	            }
	        });

	        content.repaint();
	        content.revalidate();
	    }
	});


	}	
} 