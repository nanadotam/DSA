// Edit Class rebuild for testing

public class BasicPlaylistManager {
    public static void main(String[] args) {
        BasicPlaylist playlist = new BasicPlaylist();

        Song song1 = new Song("Song1", "Artist1", 300);
        Song song2 = new Song("Song2", "Artist2", 240);
        Song song3 = new Song("Song3", "Artist3", 180);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        System.out.println("Playlist:");
        playlist.displayPlaylist();

        System.out.println("Total Duration: " + playlist.getTotalDuration() + " seconds");

        playlist.removeSong("Song2");
        System.out.println("Playlist after removing Song2:");
        playlist.displayPlaylist();

        playlist.addSong(new Song("Song4", "Artist4", 210), 1);
        System.out.println("Playlist after adding Song4 at position 1:");
        playlist.displayPlaylist();

        playlist.removeSong(1);
        System.out.println("Playlist after removing song at position 1:");
        playlist.displayPlaylist();
    }
}
