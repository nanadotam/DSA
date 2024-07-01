// class for testing

public class EnhancedPlaylistManager {
    public static void main(String[] args) {
        EnhancedPlaylist playlist = new EnhancedPlaylist();

        Song song1 = new Song("Song1", "Artist1", 300);
        Song song2 = new Song("Song2", "Artist2", 240);
        Song song3 = new Song("Song3", "Artist3", 182);
        Song song4 = new Song("Song4", "Artist4", 210);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.addSong(song4);

        System.out.println("Original Playlist:");
        playlist.displayPlaylist();

        System.out.println("\nTotal Duration: " + playlist.getFormattedTotalDuration());

        // playlist.shufflePlaylist();
        System.out.println("\nShuffled Playlist:");
        playlist.displayPlaylist();

        System.out.println("\nPlaying next song after Song2:");
        Song nextSong = playlist.playNext(song2);
        if (nextSong != null) {
            System.out.println("Next Song: " + nextSong.title);
        } else {
            System.out.println("No next song.");
        }

        System.out.println("\nPlaying previous song before Song2:");
        Song prevSong = playlist.playPrevious(song2);
        if (prevSong != null) {
            System.out.println("Previous Song: " + prevSong.title);
        } else {
            System.out.println("No previous song.");
        }

        playlist.removeSong("Song2");
        System.out.println("\nPlaylist after removing Song2:");
        playlist.displayPlaylist();

        playlist.addSong(new Song("Song5", "Artist5", 220), 1);
        System.out.println("\nPlaylist after adding Song5 at position 1:");
        playlist.displayPlaylist();

        playlist.removeSong(1);
        System.out.println("\nPlaylist after removing song at position 1:");
        playlist.displayPlaylist();
    }
}
