
import java.util.Arrays;

class Player implements Comparable<Player> {

    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // First isDraftable method
    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    // Overloaded isDraftable method
    static boolean isDraftable(int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    // Used by Arrays.sort()
    public int compareTo(Player other) {

        if (this.battingAverage < other.battingAverage) {
            return 1;
        }

        if (this.battingAverage > other.battingAverage) {
            return -1;
        }

        return 0;
    }

    static String draftAndRank(Player[] players) {

        // Temporary array
        Player[] draftable = new Player[players.length];

        int count = 0;

        // Find draftable players
        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        // Create array of exact size
        Player[] finalPlayers = new Player[count];

        for (int i = 0; i < count; i++) {
            finalPlayers[i] = draftable[i];
        }

        // Sort using compareTo()
        Arrays.sort(finalPlayers);

        // Create output
        String result = "";

        for (int i = 0; i < finalPlayers.length; i++) {

            result = result + (i + 1) + ". " + finalPlayers[i].name;

            if (i < finalPlayers.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }
}

public class s5a5 {

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),

            new Player("Rahul", 7, 55.0, false),

            new Player("Sameer", 3, 60.0, false),

            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(Player.draftAndRank(players));
    }

}
