import java.io.*;
import java.net.*;

public class PrimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter a number: ");
            String numberStr = reader.readLine();
            writer.println(numberStr);

            boolean isPrime = Boolean.parseBoolean(serverReader.readLine());

            if (isPrime)
                System.out.println(numberStr + " is a prime number.");
            else
                System.out.println(numberStr + " is not a prime number.");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
