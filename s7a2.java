
class Playlist {
    private String songs[];
    private int count;

    Playlist(int size) {
        songs = new String[size];
        count = 0;
    }

    void addSong(String song) {
        if (count < songs.length)
            songs[count++] = song;
    }

    String[] getSongs() {
        String copy[] = new String[count];

        for (int i = 0; i < count; i++)
            copy[i] = songs[i];

        return copy;
    }

    int getSongCount() {
        return count;
    }
}

public class s7a2 {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String copy[] = p.getSongs();

        copy[0] = "Hacked";

        for (String s : p.getSongs())
            System.out.println(s);

        System.out.println("Count = " + p.getSongCount());
    }
}

