package classes;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class hr_page {
	 public String name;
	hr_page(String name){
		this.name=name;
	}
	public void execute() throws Exception {
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
		a.add(a1);
		a.add(a2);

		JMenu b = new JMenu("Work & Tasks");
		JMenuItem b1 = new JMenuItem("Assign Tasks");
		JMenuItem b2 = new JMenuItem("Manage Status of task");
		b.add(b1);
		b.add(b2);
		
		JMenu c = new JMenu("Leave Management");
		JMenuItem c1 = new JMenuItem("View Leave Info of employees");
		JMenuItem c2 = new JMenuItem("See Requested Leave");
		c.add(c1);
		c.add(c2);

		JMenu d = new JMenu("Company Info");
		JMenuItem d1 = new JMenuItem("Add Notices & Policies");
		JMenuItem d2 = new JMenuItem("view Feedback");
		d.add(d1);
		d.add(d2);

		mbar.add(a);
		mbar.add(b);
		mbar.add(c);
		mbar.add(d);

        frame.setJMenuBar(mbar);
        frame.setVisible(true);
	
//view personal details
//----------------------------------------------------------------------------------------------
a1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        content.removeAll();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM HR.EMPLOYEE");
            ResultSet rs = ps.executeQuery();
            
            int y = 50;
            int data =0;
            while (rs.next()) {
            	data =1;
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String department = rs.getString("department");
                String role = rs.getString("role");
                String joinDate = rs.getString("join_date");

                JLabel label = new JLabel("<html>"+
                		"<b>Name:</b> " + name + "<br>" +
                        "<b>Email:</b> " + email + "<br>" +
                        "<b>Phone:</b> " + phone + "<br>" +
                        "<b>Department:</b> " + department + "<br>" +
                        "<b>Role:</b> " + role + "<br>" +
                        "<b>Join Date:</b> " + joinDate + "</html>");
                label.setBounds(50, y, 500, 120); 
                content.add(label);
                y += 130;
            }

        if(data==0) {
                JLabel label = new JLabel("Employee not found!");
                label.setBounds(50, 100, 400, 30);
                content.add(label);
            }

           content.revalidate();
           content.repaint();

        } catch (Exception ex) {
        }
    }
});
//update details
//-----------------------------------------------------------------------------------------------
a2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        content.removeAll(); 

JLabel nameLabel = new JLabel("Employee name:");
nameLabel.setBounds(50, 90, 120, 25);
JTextField nameField = new JTextField();
nameField.setBounds(160, 90, 150, 25);

JLabel deptLabel = new JLabel("New Department:");
deptLabel.setBounds(50, 130, 120, 25);
JTextField deptField = new JTextField();
deptField.setBounds(160, 130, 150, 25);

JLabel roleLabel = new JLabel("New Role:");
roleLabel.setBounds(50, 170, 120, 25);
JTextField roleField = new JTextField();
roleField.setBounds(160, 170, 150, 25);

JButton updateButton = new JButton("Update");
updateButton.setBounds(130, 200, 100, 30);

content.add(nameLabel);
content.add(nameField);
content.add(deptLabel);
content.add(deptField);
content.add(roleLabel);
content.add(roleField);
content.add(updateButton);

content.repaint();
content.revalidate();
// pressing button updates
updateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
        	String newName = nameField.getText();
            String newdept = deptField.getText();
            String newrole = roleField.getText();
            
           PreparedStatement ps = con.prepareStatement( "UPDATE HR.EMPLOYEE SET department = ?, role = ? WHERE name = ?");
            ps.setString(1, newdept);
            ps.setString(2, newrole);
            ps.setString(3, newName);
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
//manage tasks
//--------------------------------------------------------------------------------------------------

b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        content.removeAll(); 

JLabel nameLabel = new JLabel("Employee name:");
nameLabel.setBounds(50, 90, 120, 25);
JTextField nameField = new JTextField();
nameField.setBounds(160, 90, 150, 25);

JLabel taskLabel = new JLabel("New Task:");
taskLabel.setBounds(50, 130, 120, 25);
JTextField taskField = new JTextField();
taskField.setBounds(160, 130, 150, 25);

JLabel deadlineLabel = new JLabel("Deadline:");
deadlineLabel.setBounds(50, 170, 120, 25);
JTextField deadlineField = new JTextField();
deadlineField.setBounds(160, 170, 150, 25);

JLabel priorityLabel = new JLabel("Priority level:");
priorityLabel.setBounds(50, 210, 120, 25);
JTextField priorityField = new JTextField();
priorityField.setBounds(160, 210, 150, 25);

JLabel statusLabel = new JLabel("Status:");
statusLabel.setBounds(50, 250, 120, 25);
JTextField statusField = new JTextField();
statusField.setBounds(160, 250, 150, 25);

JLabel descLabel = new JLabel("Description:");
descLabel.setBounds(50, 290, 120, 25);
JTextField descField = new JTextField();
descField.setBounds(160, 290, 150, 25);


JButton updateButton = new JButton("Update");
updateButton.setBounds(130, 350, 100, 30);

content.add(nameLabel);
content.add(nameField);
content.add(taskLabel);
content.add(taskField);
content.add(deadlineLabel);
content.add(deadlineField);
content.add(priorityLabel);
content.add(priorityField);
content.add(statusLabel);
content.add(statusField);
content.add(descLabel);
content.add(descField);
content.add(updateButton);

content.repaint();
content.revalidate();
// pressing button updates
updateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
        	String newName = nameField.getText();
            String newdeadline = deadlineField.getText();
            String newpriority = priorityField.getText();
            String newstatus = statusField.getText();
            String newtask = taskField.getText();
            String newdesc = descField.getText();
            
           PreparedStatement ps = con.prepareStatement( "insert into HR.TASKS (name, task_name, deadline, priority, status, description)values(?,?,?,?,?,?)");
            ps.setString(1, newName); 
            ps.setString(2, newtask);
            ps.setString(3, newdeadline);
            ps.setString(4, newpriority);
            ps.setString(5, newstatus);
            ps.setString(6, newdesc);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(frame, "Task updated successfully!");
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

//manage status of tasks
//--------------------------------------------------------------------------------------------------
b2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        content.removeAll(); 
        content.repaint();
        content.revalidate();

JLabel nameLabel = new JLabel("Employee name:");
nameLabel.setBounds(50, 90, 120, 25);
JTextField nameField = new JTextField();
nameField.setBounds(160, 90, 150, 25);

JLabel taskLabel = new JLabel("Task Name:");
taskLabel.setBounds(50, 130, 120, 25);
JTextField taskField = new JTextField();
taskField.setBounds(160, 130, 150, 25);

JLabel statusLabel = new JLabel("New Status:");
statusLabel.setBounds(50, 170, 120, 25);
JTextField statusField = new JTextField();
statusField.setBounds(160, 170, 150, 25);

JButton updateButton = new JButton("Update");
updateButton.setBounds(130, 200, 100, 30);

content.add(nameLabel);
content.add(nameField);
content.add(taskLabel);
content.add(taskField);
content.add(statusLabel);
content.add(statusField);
content.add(updateButton);

updateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
        	String newName = nameField.getText();
            String newtask = taskField.getText();
            String newstatus = statusField.getText();
            
            PreparedStatement ps = con.prepareStatement( "UPDATE HR.TASKS SET status = ? WHERE name = ? and task_name = ?");
            ps.setString(1, newstatus);
            ps.setString(2, newName);
            ps.setString(3, newtask);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(frame, "Status updated successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Update failed. Employee and task doesn't matches.");
            }
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(frame, "error occured");

        }
    }
});
}
});
// leave info
//------------------------------------------------------------------------------------------------
c1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        content.removeAll();

        JLabel nameLabel = new JLabel("Employee name:");
        nameLabel.setBounds(50, 90, 120, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(160, 90, 150, 25);

        JButton Button = new JButton("Get Absent Dates");
        Button.setBounds(100, 130, 150, 30);

        content.add(nameLabel);
        content.add(nameField);
        content.add(Button);
        content.repaint();
        content.revalidate();

        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    content.removeAll();
                    String name = nameField.getText();
                    PreparedStatement ps = con.prepareStatement("SELECT absent_date FROM HR.EMP_ABSENT_DATE WHERE name = ?");
                    ps.setString(1, name);
                    ResultSet rs = ps.executeQuery();

                    int y = 180;
                    int data=0;

                    JLabel head = new JLabel("Absent Dates:");
                    head.setFont(new Font("Arial", Font.BOLD, 16));
                    head.setBounds(80, 150, 200, 25);
                    content.add(head);

                    while (rs.next()) {
                        JLabel dateLabel = new JLabel(rs.getString("absent_date"));
                        dateLabel.setBounds(80, y, 200, 25);
                        content.add(dateLabel);
                        y += 30;
                        data=1;
                    }

                    if (data==0) {
                        JLabel no = new JLabel("No absent dates recorded.");
                        no.setBounds(80, y, 200, 25);
                        content.add(no);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace(); 
                    JOptionPane.showMessageDialog(content, "Error");
                }

                content.repaint();
                content.revalidate();
            }
        });
    }
});

//see requested leave
//-----------------------------------------------------------------------------------------------
c2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        content.removeAll();

        try {
            PreparedStatement ps = con.prepareStatement( "select *from HR.request_leave" );
            ResultSet rs= ps.executeQuery();
			int days=0;
			int y=60;
			while(rs.next()) {
                days=1;
                
                String name = rs.getString("NAME");
                String from = rs.getString("FROM_DATE");
                String to = rs.getString("TO_DATE");
                String reason = rs.getString("REASON");
          
                JLabel label = new JLabel("<html>"+
                		"<b>NAME:</b> " + name + "<br>" +
                        "<b>FROM_DATE:</b> " + from + "<br>" +
                        "<b>TO_DATE:</b> " + to + "<br>" +
                        "<b>REASON:</b> " + reason + "<br>" +
                        "</html>");
                label.setBounds(50, y, 500, 120); 
                content.add(label);
                y += 130;
			}
			if (days==0) {
                JLabel no = new JLabel("No leave request recorded.");
                no.setBounds(80, y, 200, 25);
                content.add(no);
            }
		} catch (Exception e1) {
            JOptionPane.showMessageDialog(content, "Error retrieving leave requests");
		}
            
content.repaint();
content.revalidate();
}
});

//add notices and policies
//---------------------------------------------------------------------------------------------------
d1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        content.removeAll();

        JLabel title = new JLabel("Company Notices & Policies");
        title.setBounds(200, 20, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        content.add(title);

        JLabel NoticeLabel = new JLabel("Add New Notice:");
        NoticeLabel.setBounds(50, 60, 200, 25);
        content.add(NoticeLabel);

        JTextField noticeField = new JTextField();
        noticeField.setBounds(180, 60, 400, 25);
        content.add(noticeField);

        JButton submitNotice = new JButton("Submit");
        submitNotice.setBounds(600, 60, 100, 25);
        content.add(submitNotice);

        submitNotice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String noticeText = noticeField.getText();
                if (noticeText.isEmpty()) {
                    JOptionPane.showMessageDialog(content, "Notice content cannot be empty.");
                    return;
                }

                try {
                    PreparedStatement ps = con.prepareStatement("INSERT INTO HR.company_notices (notices) VALUES (?)");
                    ps.setString(1, noticeText);
                    int result = ps.executeUpdate();

                    if (result > 0) {
                        JOptionPane.showMessageDialog(content, "Notice added successfully!");
                        noticeField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(content, "Failed to add notice.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(content, "Error adding notice");
                }
            }
        });

        content.repaint();
        content.revalidate();
    }
});


//view feedback
//--------------------------------------------------------------------------------------------------
d2.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent e) {
        content.removeAll();

        JLabel title = new JLabel("Employee Feedbacks");
        title.setBounds(200, 20, 400, 25);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        content.add(title);

        try {
            PreparedStatement ps = con.prepareStatement("SELECT name, feedback FROM HR.feedback");
            ResultSet rs = ps.executeQuery();

            int y = 70;
            int count = 0;

            while (rs.next()) {
                String name = rs.getString("name");
                String feedback = rs.getString("feedback");

                JLabel nameLabel = new JLabel("From: " + name);
                nameLabel.setBounds(50, y, 600, 25);
                content.add(nameLabel);
                y += 25;

                JTextArea feedbackArea = new JTextArea(feedback);
                feedbackArea.setBounds(50, y, 600, 60);
                feedbackArea.setLineWrap(true);
                feedbackArea.setWrapStyleWord(true);
                feedbackArea.setEditable(false);
                feedbackArea.setBackground(new Color(240, 240, 240));
                content.add(feedbackArea);
                y += 80;

                count=1;
            }

            if (count==0) {
                JLabel noFeedback = new JLabel("No feedback submitted yet.");
                noFeedback.setBounds(50, y, 400, 25);
                content.add(noFeedback);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(content, "Error loading feedbacks.");
        }

        content.repaint();
        content.revalidate();
    }
});


	}
	}