import java.util.Scanner;

class p2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String correctPin = "4821";
        int attempts = 0;
        boolean success = false;

        while (attempts < 3 && success == false) {

            System.out.print("Enter PIN: ");
            String pin = sc.next();

            if (pin.equals(correctPin)) {
                System.out.println("PIN accepted");
                success = true;
            } else {
                attempts++;
            }
        }

        if (success == false) {
            System.out.println("Card blocked - too many incorrect attempts");
        }
    }
}