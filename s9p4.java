import java.util.*;

abstract class Connection {
    int units;

    Connection(int u) {
        units = u;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(int u) {
        super(u);
    }

    double bill() {
        if (units <= 100)
            return units * 5.0;
        return 500 + (units - 100) * 7.0;
    }
}

class Shop extends Connection {
    Shop(int u) {
        super(u);
    }

    double bill() {
        return units * 8.0 + 100;
    }
}

class Factory extends Connection {
    Factory(int u) {
        super(u);
    }

    double bill() {
        return Math.max(units * 6.0, 1000);
    }
}

public class s9p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection c;

            if (type.equals("HOME"))
                c = new Home(units);
            else if (type.equals("SHOP"))
                c = new Shop(units);
            else
                c = new Factory(units);

            double b = c.bill();
            System.out.printf("%s: %.2f%n", type, b);
            total += b;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}