import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleChatServer {

    public static void main(String[] args) {
        int portNumber = 12345; // Port number for the server
        
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started. Listening on port " + portNumber);
            
            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create input and output streams for communication with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Create input stream for reading from console
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            // Start chatting
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                System.out.print("You: ");
                String response = consoleInput.readLine(); // Read input from console
                out.println(response); // Send response to client
            }

            // Close sockets and streams
            in.close();
            out.close();
            consoleInput.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
