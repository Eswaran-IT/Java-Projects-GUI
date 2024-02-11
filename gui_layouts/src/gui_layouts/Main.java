package gui_layouts;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setTitle("FlowLayout Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(new JLabel("Components are arranged in a single row or column, wrapping to the next line when necessary, with optional alignment and spacing."));
      
        for (int i = 1; i <= 5; i++) {
        	panel.add(new JButton("Button " + i));
        }
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main example = new Main();
            example.setVisible(true);
        });
    }
}
