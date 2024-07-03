// Edit Class rebuild for testing

public class BasicPlaylistManager {
    public static void main(String[] args) {
        BasicPlaylist playlist = new BasicPlaylist();

        // Create new Song objects
        Song song1 = new Song("Space Cadet", "Metro Boomin, Gunna", 203);
        Song song2 = new Song("Rich Nigga Shit", "21 Savage, Metro Boomin, Young Thug", 190);
        Song song3 = new Song("DOLLAZ ON MY HEAD", "Gunna, Young Thug", 198);

        // Add songs to playlist using song object
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        // Display playlist
        System.out.println("Playlist:");
        playlist.displayPlaylist();
        System.out.println();

        // Display total duration of playlist
        System.out.println("Total Duration: " + playlist.getFormattedTotalDuration());
        System.out.println();

        // Remove song by title
        playlist.removeSong("Song2");
        System.out.println("Playlist after removing Song2:");
        playlist.displayPlaylist();
        System.out.println();

        // Add song using song object and insertion at a specified position
        playlist.addSong(new Song("Song4", "Artist4", 210), 1);
        System.out.println("Playlist after adding Song4 at position 1:");
        playlist.displayPlaylist();
        System.out.println();

        // Remove song by position
        playlist.removeSong(1);
        System.out.println("Playlist after removing song at position 1:");
        playlist.displayPlaylist();
    }
}
