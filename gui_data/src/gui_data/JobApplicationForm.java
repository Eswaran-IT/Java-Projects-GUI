package gui_data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JobApplicationForm extends JFrame {
    private JTextField[] fields;
    private JButton submitButton;

    public JobApplicationForm() {
        setTitle("Job Application Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10)); // 0 rows to allow dynamic expansion

        // Create array to hold text fields
        fields = new JTextField[10];

        // Add labels and text fields for each data field
        String[] labels = {"Name:", "Email:", "Phone:", "Address:", "Education:", "Skills:", "Experience:", "Portfolio Link:", "Cover Letter:", "Expected Salary:"};
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            add(label);
            fields[i] = new JTextField();
            fields[i].setToolTipText(labels[i]); // Set tooltip text to correspond to label
            add(fields[i]);
        }

        // Create submit button
        submitButton = new JButton("Submit Application");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitApplication();
            }
        });
        add(submitButton);

        setVisible(true);
    }

    private void submitApplication() {
        // Validate all fields are filled
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Incomplete Application", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // If all fields are filled, print details to console
        System.out.println("Application Details:");
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getToolTipText() + ": " + fields[i].getText());
        }

        // Optionally, you can clear the fields after submission
        clearFields();
    }

    private void clearFields() {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JobApplicationForm();
        });
    }
}
