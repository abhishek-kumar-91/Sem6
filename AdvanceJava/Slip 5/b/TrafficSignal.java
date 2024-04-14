import java.applet.*;
import java.awt.*;

public class TrafficSignal extends Applet implements Runnable {
    private Thread animationThread;
    private boolean running = true;
    private int signalIndex = 0;

    private Color[] signalColors = {Color.RED, Color.YELLOW, Color.GREEN};
    private String[] signalNames = {"STOP", "READY", "GO"};

    public void init() {
        setSize(200, 400);
        setBackground(Color.WHITE);

        // Start the animation thread
        animationThread = new Thread(this);
        animationThread.start();
    }

    public void run() {
        while (running) {
            signalIndex = (signalIndex + 1) % 3; // Cycle through signals

            repaint(); // Redraw the applet
            delay(2000); // Delay for 2 seconds between signals
        }
    }

    public void paint(Graphics g) {
        // Draw the signal
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        g.setColor(Color.BLACK);
        g.fillOval(centerX - 30, centerY - 90, 60, 60); // Signal body

        g.setColor(signalColors[signalIndex]);
        g.fillOval(centerX - 25, centerY - 85, 50, 50); // Signal light

        g.setColor(Color.BLACK);
        g.drawString(signalNames[signalIndex], centerX - 15, centerY + 50); // Signal name
    }

    private void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        running = false;
    }
}
