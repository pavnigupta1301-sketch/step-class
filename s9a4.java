import java.util.*;

abstract class Cab {
    double km;

    Cab(double k) {
        km = k;
    }

    abstract double rate();

    boolean nightAllowed() {
        return true;
    }

    double fare(String time) {
        double f = Math.max(100, km * rate());

        if (time.equals("NIGHT")) {
            if (!nightAllowed())
                return -1;
            f *= 1.2;
        }

        return f;
    }
}

class Mini extends Cab {
    Mini(double k) {
        super(k);
    }

    double rate() {
        return 10;
    }

    boolean nightAllowed() {
        return false;
    }
}

class Sedan extends Cab {
    Sedan(double k) {
        super(k);
    }

    double rate() {
        return 14;
    }
}

class SUV extends Cab {
    SUV(double k) {
        super(k);
    }

    double rate() {
        return 18;
    }
}

public class s9a4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab c;

            if (type.equals("MINI"))
                c = new Mini(km);
            else if (type.equals("SEDAN"))
                c = new Sedan(km);
            else
                c = new SUV(km);

            double f = c.fare(time);

            if (f == -1) {
                System.out.println(type + ": night service not available");
            } else {
                System.out.printf("%s: %.2f%n", type, f);
                total += f;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
