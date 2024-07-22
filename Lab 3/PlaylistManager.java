public class PlaylistManager {
    public static void main(String[] args) {
        // Initial song in the playlist
        String firstSong = "Song A";

        // Initialize the Playlist Manager with the first song
        Playlist playlist = new Playlist(firstSong);

        // Add more songs to the playlist
        playlist.addSong("Song B");
        playlist.addSong("Song C");
        playlist.addSong("Song D");

        // Print actions on the playlist
        System.out.println("Previous 1 song: " + playlist.previousSong(1));
        System.out.println("Previous 1 song: " + playlist.previousSong(1));
        System.out.println("Next 1 song: " + playlist.nextSong(1));
        playlist.addSong("Song E");
        System.out.println("Next 2 songs: " + playlist.nextSong(2));
        System.out.println("Previous 2 songs: " + playlist.previousSong(2));
        System.out.println("Previous 7 songs: " + playlist.previousSong(7));

        // Remove the current song and print the next song
        playlist.removeCurrentSong();
        System.out.println("After removing current song, next song: " + playlist.nextSong(1));
    }
}
