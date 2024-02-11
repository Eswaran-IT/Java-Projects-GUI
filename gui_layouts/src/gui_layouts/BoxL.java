package gui_layouts;

import javax.swing.*;
import java.awt.*;

public class BoxL extends JFrame {

    public BoxL() {
        setTitle("BoxLayout Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);
        for (int i = 1; i <= 5; i++) {
            panel.add(new JButton("Button " + i));
            panel.add(Box.createRigidArea(new Dimension(0, 5))); // Add spacing between buttons
        }
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoxL example = new BoxL();
            example.setVisible(true);
        });
    }
}
