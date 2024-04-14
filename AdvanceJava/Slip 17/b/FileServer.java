import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    public static void main(String[] args) {
        int portNumber = 12345; // Port number for the server
        String filePath = "path/to/your/file.txt"; // Path to the file on the server
        
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started. Listening on port " + portNumber);
            
            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");
            
            // Check if the file exists
            File file = new File(filePath);
            if (file.exists()) {
                // File exists, so read its contents and send to client
                BufferedReader reader = new BufferedReader(new FileReader(file));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String line;
                while ((line = reader.readLine()) != null) {
                    out.println(line); // Send each line to client
                }
                reader.close();
                out.close();
            } else {
                // File not found, send error message to client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("File Not Found");
                out.close();
            }
            
            // Close sockets
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
