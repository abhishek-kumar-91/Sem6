import javax.swing.*;
import java.awt.*;

public class TempleDrawing extends JFrame {

    public TempleDrawing() {
        setTitle("Temple Drawing");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panel for drawing
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTemple(g);
            }
        };

        add(panel);
        setVisible(true);
    }

    private void drawTemple(Graphics g) {
        // Set drawing color
        g.setColor(Color.BLACK);

        // Draw temple base
        g.drawRect(100, 200, 200, 100);
        // Draw temple roof
        int[] roofX = {100, 200, 300};
        int[] roofY = {200, 100, 200};
        g.fillPolygon(roofX, roofY, 3);
        // Draw temple door
        g.drawRect(180, 250, 40, 50);
        // Draw temple windows
        g.drawRect(120, 220, 30, 30);
        g.drawRect(250, 220, 30, 30);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TempleDrawing();
            }
        });
    }
}
