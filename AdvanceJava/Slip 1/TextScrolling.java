public class TextScrolling {

    public static void main(String[] args) throws InterruptedException {
        String text = "This is a scrolling text! ";

        while (true) {
            // Scroll text from left to right
            for (int i = 0; i < text.length(); i++) {
                System.out.print("\r" + text.substring(i) + text.substring(0, i));
                Thread.sleep(200); // Adjust the delay as needed
            }

            // Scroll text from right to left
            for (int i = text.length() - 1; i >= 0; i--) {
                System.out.print("\r" + text.substring(i) + text.substring(0, i));
                Thread.sleep(200); // Adjust the delay as needed
            }
        }
    }
}
