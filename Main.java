import java.util.*;

// Mocking
class MockSong {

    public static List<String> getSongList() {
        List<String> songs = new ArrayList<>();
        songs.add("somersault");
        songs.add("cassidy");
        songs.add("10$");
        songs.add("havana");
        songs.add("cassidy");
        songs.add("50 Ways");
        return songs;
    }
}

class Song implements Comparable <Song>{
    private String title;
    private String artist;
    private int bpm;

    public Song(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", bpm=" + bpm +
                '}';
    }

    // Comparable method for using in sort()
    public int compareTo(Song s) {
        return this.title.compareTo(s.getTitle());
    }
}

// Custom Comparator
class ArtistComparator implements Comparator <Song> {
    public int compare(Song obj1, Song obj2) {
        return obj1.getArtist().compareTo(obj2.getArtist());
    }
}

class MockSongV2 {

    public static List<Song> getSongList() {
        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song("somersault", "zero 7", 147));
        songs.add(new Song("cassidy", "grateful dead", 158));
        songs.add(new Song("$10", "hitchhiker", 140));
        songs.add(new Song("havana", "cabello", 105));
        songs.add(new Song("Cassidy", "grateful dead", 158));
        songs.add(new Song("50 ways", "simon", 102));
        return songs;
    }
}



class Main {
    public static void main(String[] args) {

        System.out.println("************ Sorting String ***************");
        List<String> songList = MockSong.getSongList();
        System.out.println("Orginal List ====>");
        System.out.println(songList);

        Collections.sort(songList);
        System.out.println("Collection Sorted List ====>");
        System.out.println(songList);
        System.out.println("************ ############## ***************");

        // =========

        System.out.println("************ Sorting Object ***************");
        List<Song> songListV2 = MockSongV2.getSongList();

        System.out.println("Orginal List ====>");
        System.out.println(songListV2);

        Collections.sort(songListV2);
        System.out.println("Collection Sorted List By Title ====>");
        System.out.println(songListV2);
        System.out.println("************ ############## ***************");

        // ==========

        System.out.println("************ Sorting Object ***************");
        ArtistComparator artistComparator = new ArtistComparator();
        songListV2.sort(artistComparator);
        System.out.println("Collection Sorted List by Artist Comparator ====>");
        System.out.println(songListV2);
        System.out.println("************ ############## ***************");


    }
}