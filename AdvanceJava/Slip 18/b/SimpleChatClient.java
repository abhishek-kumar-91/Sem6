import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClient {

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address (change if server is running on a different machine)
        int portNumber = 12345; // Port number for the server
        
        try {
            // Connect to the server
            Socket socket = new Socket(serverAddress, portNumber);
            System.out.println("Connected to server.");

            // Create input and output streams for communication with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create input stream for reading from console
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            // Start chatting
            String inputLine;
            while (true) {
                System.out.print("You: ");
                String message = consoleInput.readLine(); // Read input from console
                out.println(message); // Send message to server
                
                if (message.equalsIgnoreCase("bye")) {
                    break; // Exit loop if "bye" is entered
                }

                // Read response from server
                inputLine = in.readLine();
                System.out.println("Server: " + inputLine);
            }

            // Close sockets and streams
            in.close();
            out.close();
            consoleInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
