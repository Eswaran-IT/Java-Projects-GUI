package gui_studententry;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5)); // Adjusting grid layout for smaller components

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register"); // Adding register button

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton); // Adding register button to layout
        add(new JLabel()); // Empty label for spacing

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new Register().setVisible(true); 
            }
        });
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            dispose(); // Close login window
            new MainPage(username).setVisible(true); 
            } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }
}
