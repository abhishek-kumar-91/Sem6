import javax.swing.*;
import java.awt.event.*;

public class BlinkingImage extends JFrame {
    private Timer timer;
    
    public BlinkingImage() {
        // Create JFrame
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create image label
        ImageIcon imageIcon = new ImageIcon("C:/Users/Abhishek/Downloads/620b2f4b-d.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        // Timer for blinking
        timer = new Timer(500, e -> imageLabel.setVisible(!imageLabel.isVisible()));

        // Add image label to JFrame and start timer
        add(imageLabel);
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BlinkingImage().setVisible(true));
    }
}
