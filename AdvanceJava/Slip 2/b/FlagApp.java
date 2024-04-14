import java.applet.*;
import java.awt.*;

public class FlagApp extends Applet implements Runnable {
    private Thread flagThread;

    public void init() {
        flagThread = new Thread(this);
        flagThread.start();
    }

    public void run() {
        try {
            while (true) {
                // Repaint the applet every 500 milliseconds
                repaint();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        Dimension d = getSize();
        int width = d.width;
        int height = d.height;

        // Draw the first band (top band)
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, width, height / 3);

        // Draw the second band (middle band)
        g.setColor(Color.WHITE);
        g.fillRect(0, height / 3, width, height / 3);

        // Draw the third band (bottom band)
        g.setColor(Color.RED);
        g.fillRect(0, (2 * height) / 3, width, height / 3);
    }
}
