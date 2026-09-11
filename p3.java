import java.util.Scanner;

class p3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cycles: ");
        int cycles = sc.nextInt();

        for (int i = 0; i < cycles; i++) {

            int state = i % 3;

            switch (state) {

                case 0:
                    System.out.print("Red - Stop ");
                    break;

                case 1:
                    System.out.print("Green - Go ");
                    break;

                case 2:
                    System.out.print("Yellow - Prepare to stop ");
                    break;
            }
        }
    }
}