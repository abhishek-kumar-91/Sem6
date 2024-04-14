import java.util.Scanner;

public class DisplayVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase();
        scanner.close();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ("aeiou".indexOf(ch) != -1) {
                System.out.println(ch);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
