import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    public double cgpa;
    public int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {

        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    double getCompositeScore() {

        return cgpa * 10 + codingScore * 0.5;
    }

    @Override
    public int compareTo(Candidate other) {

        if (this.getCompositeScore() < other.getCompositeScore()) {
            return 1;
        }
        else if (this.getCompositeScore() > other.getCompositeScore()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }
}

public class s5p5{

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];

        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (Candidate.isEligible(candidates[i].cgpa)
                    || Candidate.isEligible(
                    candidates[i].cgpa,
                    candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        Candidate[] finalList = new Candidate[count];

        for (int i = 0; i < count; i++) {
            finalList[i] = shortlisted[i];
        }

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result + (i + 1) + ". "
                    + finalList[i].getName()
                    + " (" + finalList[i].getCompositeScore() + ")";

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
