import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DisplayFirstRecord extends JFrame {

    private JTextField rnoField;
    private JTextField snameField;
    private JTextField perField;
    private JButton displayButton;

    public DisplayFirstRecord() {
        setTitle("Display First Record");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create text fields
        rnoField = new JTextField(10);
        snameField = new JTextField(10);
        perField = new JTextField(10);

        // Create button
        displayButton = new JButton("Display First Record");

        // Add action listener to button
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFirstRecord();
            }
        });

        // Add components to frame
        setLayout(new FlowLayout());
        add(new JLabel("Roll No:"));
        add(rnoField);
        add(new JLabel("Name:"));
        add(snameField);
        add(new JLabel("Percentage:"));
        add(perField);
        add(displayButton);

        setVisible(true);
    }

    private void displayFirstRecord() {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        // SQL query to retrieve first record from student table
        String sql = "SELECT * FROM Student LIMIT 1";

        try (
            // Establish database connection
            Connection connection = DriverManager.getConnection(url, username, password);
            // Create statement
            Statement statement = connection.createStatement();
            // Execute query
            ResultSet resultSet = statement.executeQuery(sql);
        ) {
            // Check if result set has records
            if (resultSet.next()) {
                // Display record in text fields
                rnoField.setText(resultSet.getString("rno"));
                snameField.setText(resultSet.getString("sname"));
                perField.setText(resultSet.getString("per"));
            } else {
                JOptionPane.showMessageDialog(this, "No records found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DisplayFirstRecord();
            }
        });
    }
}
