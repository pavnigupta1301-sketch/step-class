import java.util.Scanner;

class p5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int secretNumber = 42;
        int maxTries = 4;

        int[] guesses = {20, 60, 42};

        int i = 0;
        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && guessed == false) {

            int guess = guesses[i];

            if (guess > secretNumber) {
                System.out.print("Too high ");

            } else if (guess < secretNumber) {
                System.out.print("Too low ");

            } else {
                System.out.print("Correct! You guessed it");
                guessed = true;
            }

            tries++;
            i++;
        }

        if (guessed == false) {
            System.out.println("Out of tries - the number was " + secretNumber);
        }
    }
}
