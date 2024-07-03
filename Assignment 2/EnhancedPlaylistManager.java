public class EnhancedPlaylistManager {
    public static void main(String[] args) {
        EnhancedPlaylist playlist = new EnhancedPlaylist();

        // Import songs from Spotify
        playlist.addSong(new Song("Oprah’s Bank Account", "Lil Yachty, DaBaby, Drake", 207));
        playlist.addSong(new Song("Cardigan", "Don Toliver", 159));
        playlist.addSong(new Song("Space Cadet", "Metro Boomin, Gunna", 203));
        playlist.addSong(new Song("Rich Nigga Shit", "21 Savage, Metro Boomin, Young Thug", 190));
        playlist.addSong(new Song("DOLLAZ ON MY HEAD", "Gunna, Young Thug", 198));
        playlist.addSong(new Song("The Box", "Roddy Ricch", 197));
        playlist.addSong(new Song("Sum 2 Prove", "Lil Baby", 206));
        playlist.addSong(new Song("Drip or Drown", "Gunna", 126));
        playlist.addSong(new Song("Bacc Seat", "Roddy Ricch, Ty Dolla $ign", 172));
        playlist.addSong(new Song("Sky", "Playboi Carti", 193));
        playlist.addSong(new Song("Who You Foolin", "Gunna", 152));
        playlist.addSong(new Song("Not Another Love Song", "Ella Mai", 218));

        // Display Original Playlist
        System.out.println("Original Playlist:");
        playlist.displayPlaylist();

        // Dispays total duration
        System.out.println("\nTotal Duration: " + playlist.getFormattedTotalDuration());

        // Play Previous song before song at position 1, should return null
        System.out.println("\nPlaying previous song before 'Oprah’s Bank Account':");
        Song prevSong = playlist.playPrevious("Oprah’s Bank Account");
        if (prevSong != null) {
            System.out.println("Previous Song: " + prevSong.title);
        } else {
            System.out.println("No previous song.");
        }

        // Shuffles playlist
        System.out.println("\nShuffled Playlist:");
        playlist.shuffle();

        // Display Playlist after shuffling
        playlist.displayPlaylist();

        // Play Next Song
        System.out.println("\nPlaying next song after 'Cardigan':");
        Song nextSong = playlist.playNext("Cardigan");
        if (nextSong != null) {
            System.out.println("Next Song: " + nextSong.title);
        } else {
            System.out.println("No next song.");
        }
        
        // Play Previous song, Should return actual song and not null
        System.out.println("\nPlaying previous song before 'Cardigan':");
        Song prevSong = playlist.playPrevious("Cardigan");
        if (prevSong != null) {
            System.out.println("Previous Song: " + prevSong.title);
        } else {
            System.out.println("No previous song.");
        }

        // Remove song from Playlist
        playlist.removeSong("Cardigan");
        System.out.println("\nPlaylist after removing 'Cardigan':");
        playlist.displayPlaylist();

        // Add new song by position
        playlist.addSong(new Song("New Song", "New Artist", 220), 1);
        System.out.println("\nPlaylist after adding 'New Song' at position 1:");
        playlist.displayPlaylist();

        // Remove song by position
        playlist.removeSong(1);
        System.out.println("\nPlaylist after removing song at position 1:");
        playlist.displayPlaylist();
    }
}
