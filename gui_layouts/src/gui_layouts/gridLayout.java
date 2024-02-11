package gui_layouts;
import javax.swing.*;
import java.awt.*;

public class gridLayout extends JFrame {

    public gridLayout() {
        setTitle("GridLayout Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));
        panel.setBackground(Color.LIGHT_GRAY);
        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton("Button " + i));
        }
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            gridLayout example = new gridLayout();
            example.setVisible(true);
        });
    }
}
