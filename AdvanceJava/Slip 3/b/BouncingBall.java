import java.applet.*;
import java.awt.*;
import java.util.Random;

public class BouncingBall extends Applet implements Runnable {
    private int x, y; // Ball coordinates
    private int dx = 2, dy = 2; // Velocity of the ball
    private int radius = 20; // Ball radius
    private Color ballColor; // Current color of the ball
    private Thread animationThread;
    private boolean running = true;

    public void init() {
        setSize(400, 300);
        x = getWidth() / 2;
        y = getHeight() / 2;

        // Start the animation thread
        animationThread = new Thread(this);
        animationThread.start();
    }

    public void run() {
        while (running) {
            // Update ball position
            x += dx;
            y += dy;

            // Check for collision with walls
            if (x - radius < 0 || x + radius > getWidth()) {
                dx = -dx; // Reverse direction
                changeColor(); // Change ball color
            }
            if (y - radius < 0 || y + radius > getHeight()) {
                dy = -dy; // Reverse direction
                changeColor(); // Change ball color
            }

            repaint(); // Redraw the applet
            delay(20); // Delay for smoother animation
        }
    }

    public void paint(Graphics g) {
        // Draw the ball with the current color
        g.setColor(ballColor);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    private void changeColor() {
        // Generate a random color
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        ballColor = new Color(r, g, b);
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
