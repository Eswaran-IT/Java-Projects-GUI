package gui_studententry;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register  extends JFrame {
    private static String USERNAME = "admin";
    private static String PASSWORD = "admin123";

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Register() {
        setTitle("Registration");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5)); // Adjusting grid layout for smaller components

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        
        // Smaller text fields
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(150, 25));
        
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 25));

        JButton registerButton = new JButton("Register");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);
        add(new JLabel()); // Empty label for spacing

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
    }

    private void register() {
        String username = usernameField.getText();
        if (username.equals(USERNAME)) {
            JOptionPane.showMessageDialog(this, "Username already exists. Please choose another one.");
            return;
        }
        String password = new String(passwordField.getPassword());
        USERNAME = username; // Update the static username
        PASSWORD = password; // Update the static password
        JOptionPane.showMessageDialog(this, "Registration successful!");
        redirectToMainPage(); // Redirect to the main page after successful registration
    }

    private void redirectToMainPage() {
        dispose(); // Close registration window
        new MainPage(USERNAME).setVisible(true); // Open main page with registered username
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Register register = new Register();
            register.setVisible(true);
        });
    }
}
