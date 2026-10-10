
class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int number, String code) {
        lockerNumber = number;
        this.code = code;
    }

    void changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode)) {
            code = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Wrong current code");
        }
    }
}

public class  s7p4{
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}

