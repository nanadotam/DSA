public class FullyFunctionalPlaylistManager {
    public static void main(String[] args) {
        FullyFunctionalPlaylist playlist = new FullyFunctionalPlaylist();

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

        // FOUND THE BUG
        
        // Get the total duration of the playlist
        System.out.println("\nTotal Duration: " + playlist.getFormattedTotalDuration());
    }
}
