import java.net.*;

public class ClientInfo {
    public static void main(String[] args) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("IP Address: " + localhost.getHostAddress());
            System.out.println("Name: " + localhost.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
