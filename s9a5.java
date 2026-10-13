import java.util.*;

abstract class Appliance {
    double hours;
    static final double COST = 8;

    Appliance(double h) {
        hours = h;
    }

    abstract double power();

    boolean saverSupported() {
        return false;
    }

    double units(boolean saver) {
        double u = power() * hours / 1000;
        if (saver)
            u *= 0.75;
        return u;
    }
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double power() {
        return 150;
    }
}

class AC extends Appliance {
    AC(double h) {
        super(h);
    }

    double power() {
        return 1500;
    }

    boolean saverSupported() {
        return true;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double power() {
        return 100;
    }
}

class Washer extends Appliance {
    Washer(double h) {
        super(h);
    }

    double power() {
        return 500;
    }

    boolean saverSupported() {
        return true;
    }
}

public class s9a5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance a;

            if (type.equals("FRIDGE"))
                a = new Fridge(hours);
            else if (type.equals("AC"))
                a = new AC(hours);
            else if (type.equals("TV"))
                a = new TV(hours);
            else
                a = new Washer(hours);

            if (saver && !a.saverSupported()) {
                System.out.println(type + ": saver mode not supported");
            } else {
                double u = a.units(saver);
                double cost = u * Appliance.COST;

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, u, cost
                );

                total += cost;
            }
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
