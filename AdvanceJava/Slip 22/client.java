import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            // Receive date and time from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverDateTime = in.readLine();
            
            // Display date and time received from server
            System.out.println(serverDateTime);
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: localhost");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
