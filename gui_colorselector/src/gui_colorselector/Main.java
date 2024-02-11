package gui_colorselector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private ArrayList<String> employeeData = new ArrayList<>();

    private JTextField nameField, idField, positionField;
    private JPanel displayPanel;

    public Main() {
        setTitle("Employee Management");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel nameLabel = new JLabel("Name:");
        JLabel idLabel = new JLabel("ID:");
        JLabel positionLabel = new JLabel("Position:");
        
        // Smaller text fields
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 25));
        idField = new JTextField();
        idField.setPreferredSize(new Dimension(150, 25));
        positionField = new JTextField();
        positionField.setPreferredSize(new Dimension(150, 25));

        JButton addButton = new JButton("Add Employee");
        JButton listButton = new JButton("List Employees");
        JButton colorButton = new JButton("Select Color");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(positionLabel);
        inputPanel.add(positionField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(listButton);
        buttonPanel.add(colorButton);

        // Panel to display entered data
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS)); // Vertical layout
        JScrollPane scrollPane = new JScrollPane(displayPanel);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listEmployees();
            }
        });

        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectBackgroundColor();
            }
        });
    }

    private void addEmployee() {
        String name = nameField.getText();
        String id = idField.getText();
        String position = positionField.getText();
        String employeeInfo = "Name: " + name + ", ID: " + id + ", Position: " + position;

        JLabel employeeLabel = new JLabel(employeeInfo);
        displayPanel.add(employeeLabel); 
        employeeData.add(employeeInfo);
        clearFields();
        revalidate(); // Refresh layout
    }

    private void listEmployees() {
        StringBuilder sb = new StringBuilder();
        for (String employee : employeeData) {
            sb.append(employee).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "List of Employees", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearFields() {
        nameField.setText("");
        idField.setText("");
        positionField.setText("");
    }

    private void selectBackgroundColor() {
        Color bgColor = JColorChooser.showDialog(this, "Select Background Color", Color.WHITE);
        if (bgColor != null) {
            getContentPane().setBackground(bgColor); 
            displayPanel.setBackground(bgColor);
      
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main gui = new Main();
            gui.setVisible(true);
        });
    }
}
