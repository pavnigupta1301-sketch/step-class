import java.util.*;

abstract class Student {
    String name;

    Student(String n) {
        name = n;
    }

    abstract double tuition();

    boolean usesBus() {
        return true;
    }

    double fee() {
        double f = tuition();
        if (usesBus())
            f += 12000;
        return f;
    }
}

class DayScholar extends Student {
    DayScholar(String n) {
        super(n);
    }

    double tuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String n) {
        super(n);
    }

    double tuition() {
        return 100000;
    }

    boolean usesBus() {
        return false;
    }
}

class Scholar extends Student {
    Scholar(String n) {
        super(n);
    }

    double tuition() {
        return 20000;
    }
}

public class s9a3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double f = s.fee();
            System.out.printf("%s: %.2f%n", name, f);
            total += f;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
