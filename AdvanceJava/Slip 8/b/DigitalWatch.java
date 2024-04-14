import java.applet.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalWatch extends Applet implements Runnable {
    private Thread clockThread;
    private boolean running = true;

    public void init() {
        setSize(200, 100);
        
        // Start the clock thread
        clockThread = new Thread(this);
        clockThread.start();
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep(1000); // Update every second
                repaint(); // Redraw the applet
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        // Get current time
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        // Draw the time
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(sdf.format(now), 50, 50);
    }

    public void stop() {
        running = false;
    }
}
