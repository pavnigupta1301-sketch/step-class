import java.util.Scanner;

class p4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] candidates = {-3, 0, 7, 9};

        for (int i = 0; i < candidates.length; i++) {

            int number = candidates[i];

            if (number < 1) {
                System.out.println("Skipping invalid number: " + number);
                continue;
            }

            for (int j = 1; j <= 10; j++) {
                System.out.println(number + " x " + j + " = " + (number * j));
            }

            break;
        }
    }
}
