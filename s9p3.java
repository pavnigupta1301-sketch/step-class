import java.util.*;

abstract class Item {
    String title;
    int days;

    Item(String t, int d) {
        title = t;
        days = d;
    }

    abstract double fine();
}

class Book extends Item {
    Book(String t, int d) {
        super(t, d);
    }

    double fine() {
        return days * 2.0;
    }
}

class DVD extends Item {
    DVD(String t, int d) {
        super(t, d);
    }

    double fine() {
        return Math.min(days * 5.0, 50.0);
    }
}

class Magazine extends Item {
    Magazine(String t, int d) {
        super(t, d);
    }

    double fine() {
        return days;
    }
}

public class s9p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            Item item;

            if (type.equals("BOOK"))
                item = new Book(title, days);
            else if (type.equals("DVD"))
                item = new DVD(title, days);
            else
                item = new Magazine(title, days);

            double f = item.fine();
            System.out.printf("%s: %.2f%n", title, f);
            total += f;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
