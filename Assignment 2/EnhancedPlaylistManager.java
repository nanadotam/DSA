public class EnhancedPlaylistManager {
    public static void main(String[] args) {
        EnhancedPlaylist playlist = new EnhancedPlaylist();

        // Import songs from SPotify
        playlist.addSong(new Song("Oprah’s Bank Account (Lil Yachty, DaBaby, Drake)", "Lil Yachty, DaBaby, Drake", 207));
        playlist.addSong(new Song("Cardigan", "Don Toliver", 159));
        playlist.addSong(new Song("Space Cadet (feat. Gunna)", "Metro Boomin, Gunna", 203));
        playlist.addSong(new Song("Rich Nigga Shit (feat. Young Thug)", "21 Savage, Metro Boomin, Young Thug", 190));
        playlist.addSong(new Song("DOLLAZ ON MY HEAD (feat. Young Thug)", "Gunna, Young Thug", 198));
        playlist.addSong(new Song("The Box", "Roddy Ricch", 197));
        playlist.addSong(new Song("Sum 2 Prove", "Lil Baby", 206));
        playlist.addSong(new Song("Overdue (with Travis Scott)", "Metro Boomin, Travis Scott", 166));
        playlist.addSong(new Song("Drip or Drown", "Gunna", 126));
        playlist.addSong(new Song("Bacc Seat (feat. Ty Dolla $ign)", "Roddy Ricch, Ty Dolla $ign", 172));
        playlist.addSong(new Song("Sky", "Playboi Carti", 193));
        playlist.addSong(new Song("Who You Foolin", "Gunna", 152));
        playlist.addSong(new Song("Not Another Love Song", "Ella Mai", 218));

        System.out.println("Original Playlist:");
        playlist.displayPlaylist();

        System.out.println("\nTotal Duration: " + playlist.getFormattedTotalDuration());

        System.out.println("\nShuffled Playlist:");
        playlist.shuffle();
        playlist.displayPlaylist();

        System.out.println("\nPlaying next song after 'Cardigan':");
        Song nextSong = playlist.playNext(new Song("Cardigan", "Don Toliver", 159));
        if (nextSong != null) {
            System.out.println("Next Song: " + nextSong.title);
        } else {
            System.out.println("No next song.");
        }

        System.out.println("\nPlaying previous song before 'Cardigan':");
        Song prevSong = playlist.playPrevious(new Song("Cardigan", "Don Toliver", 159));
        if (prevSong != null) {
            System.out.println("Previous Song: " + prevSong.title);
        } else {
            System.out.println("No previous song.");
        }

        playlist.removeSong("Cardigan");
        System.out.println("\nPlaylist after removing 'Cardigan':");
        playlist.displayPlaylist();

        playlist.addSong(new Song("New Song", "New Artist", 220), 1);
        System.out.println("\nPlaylist after adding 'New Song' at position 1:");
        playlist.displayPlaylist();

        playlist.removeSong(1);
        System.out.println("\nPlaylist after removing song at position 1:");
        playlist.displayPlaylist();
    }
}
