import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is running. Waiting for client connection...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getInetAddress().getHostAddress());
                
                // Get current date and time
                Date currentDate = new Date();
                
                // Send date and time to client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Date and time on server: " + currentDate);
                
                // Close connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
