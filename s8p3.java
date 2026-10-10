
import java.util.*;

abstract class Delivery {
    double weight, distance;

    Delivery(double w, double d) {
        weight = w;
        distance = d;
    }

    abstract double calculate();
    abstract String getType();
}

class Standard extends Delivery {
    Standard(double w, double d) {
        super(w, d);
    }

    double calculate() {
        return 5 + 0.5 * weight + 0.1 * distance;
    }

    String getType() {
        return "STANDARD";
    }
}

class Express extends Delivery {
    Express(double w, double d) {
        super(w, d);
    }

    double calculate() {
        return 15 + weight + 0.2 * distance;
    }

    String getType() {
        return "EXPRESS";
    }
}

class International extends Delivery {
    double customs;

    International(double w, double d, double c) {
        super(w, d);
        customs = c;
    }

    double calculate() {
        return 25 + 2 * weight + 0.5 * distance + customs;
    }

    String getType() {
        return "INTERNATIONAL";
    }
}

public class s8p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double d = sc.nextDouble();
            Delivery obj;

            if (type.equals("STANDARD"))
                obj = new Standard(w, d);
            else if (type.equals("EXPRESS"))
                obj = new Express(w, d);
            else
                obj = new International(w, d, sc.nextDouble());

            double fee = obj.calculate();
            System.out.printf("%s: %.2f%n", obj.getType(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

