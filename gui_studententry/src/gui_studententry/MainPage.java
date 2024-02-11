package gui_studententry;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainPage extends JFrame {
    private ArrayList<String> studentData = new ArrayList<>();
    private String username;

    private JTextField nameField, emailField, deptField, courseField;
    private JLabel displayLabel;

    public MainPage(String username) {
        this.username = username;
        setTitle("Main Page");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); // Using null layout to position components manually

        // Top label
        JLabel topLabel = new JLabel("Student Data");
        topLabel.setBounds(50, 50, 200, 25); // Set position and size
        add(topLabel);

        // Input fields and labels
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 100, 200, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 150, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 150, 200, 25);
        add(emailField);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(50, 200, 100, 25);
        add(deptLabel);

        deptField = new JTextField();
        deptField.setBounds(150, 200, 200, 25);
        add(deptField);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(50, 250, 100, 25);
        add(courseLabel);

        courseField = new JTextField();
        courseField.setBounds(150, 250, 200, 25);
        add(courseField);

        // Add student button
        JButton addButton = new JButton("Add Student");
        addButton.setBounds(150, 300, 200, 30);
        add(addButton);

        // Display label for showing entered data
        displayLabel = new JLabel();
        displayLabel.setBounds(50, 350, 500, 30);
        add(displayLabel);

        // Add ActionListener for the Add Student button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
    }

    private void addStudent() {
        String name = nameField.getText();
        String email = emailField.getText();
        String dept = deptField.getText();
        String course = courseField.getText();
        if (!name.isEmpty() && !email.isEmpty() && !dept.isEmpty() && !course.isEmpty()) {
            String data = "Name: " + name + ", Email: " + email + ", Department: " + dept + ", Course: " + course;
            studentData.add(data);
            displayLabel.setText(data); // Update display label with entered data
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        deptField.setText("");
        courseField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainPage mainPage = new MainPage("Admin");
            mainPage.setVisible(true);
        });
    }
}
