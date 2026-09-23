class Course {

    String code;
    String title;

    Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
}

public class s3p4 {
    public static void main(String[] args) {

        Course c = new Course("21CSC201J", "Data Structures");

        System.out.println(c.code + " - " + c.title);
    }
}
