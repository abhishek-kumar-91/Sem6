import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
            Thread.sleep(1000); // Pause for 1 second
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
