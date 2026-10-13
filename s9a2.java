import java.util.*;

abstract class Parcel {
    double weight, value;

    Parcel(double w, double v) {
        weight = w;
        value = v;
    }

    abstract double charge();

    double insurance() {
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel {
    Express(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    double insurance() {
        return value * 0.02;
    }
}

class Fragile extends Parcel {
    Fragile(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    double insurance() {
        return value * 0.02;
    }
}

public class s9a2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p;

            if (type.equals("STANDARD"))
                p = new Standard(weight, value);
            else if (type.equals("EXPRESS"))
                p = new Express(weight, value);
            else
                p = new Fragile(weight, value);

            double c = p.charge();
            double ins = p.insurance();
            double t = p.total();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, c, ins, t
            );

            grand += t;
        }

        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}
