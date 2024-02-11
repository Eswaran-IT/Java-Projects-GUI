package gui_layouts;

import javax.swing.*;
import java.awt.*;

public class bagLayout extends JFrame {

    public bagLayout() {
        setTitle("GridBagLayout Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(5, 5, 5, 5); 

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JButton("Button 1"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(new JButton("Button 2"), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(new JButton("Button 3"), constraints);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           bagLayout example = new bagLayout();
            example.setVisible(true);
        });
    }
}
