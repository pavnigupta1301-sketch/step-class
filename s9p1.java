import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
}

class Circle extends Plot {
    double r;

    Circle(String o, double r) {
        super(o);
        this.r = r;
    }

    double area() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Plot {
    double l, w;

    Rectangle(String o, double l, double w) {
        super(o);
        this.l = l;
        this.w = w;
    }

    double area() {
        return l * w;
    }
}

class Triangle extends Plot {
    double b, h;

    Triangle(String o, double b, double h) {
        super(o);
        this.b = b;
        this.h = h;
    }

    double area() {
        return 0.5 * b * h;
    }
}

public class s9p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();
            Plot p;

            if (type.equals("CIRCLE")) {
                p = new Circle(owner, sc.nextDouble());
            } else if (type.equals("RECTANGLE")) {
                p = new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
            } else {
                p = new Triangle(owner, sc.nextDouble(), sc.nextDouble());
            }

            double a = p.area();
            System.out.printf("%s (%s): %.2f%n", owner, type, a);
            total += a;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}