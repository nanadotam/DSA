/**
 * This program is an implementation of a music playlist manager using stacks 
 * and doubly linked lists.
 */

 class Song {
    String title;    // Title of the song
    Song previous;   // Pointer to the previous song
    Song next;       // Pointer to the next song

    /**
     * Constructor
     */
    Song(String title) {
        this.title = title;
        this.previous = null;
        this.next = null;
    }
}

/**
 * PlaylistManager Class
 */
public class Playlist {
    Song current; // Pointer to the current song

    /**
     * Constructor
     */
    public Playlist (String firstSong) { // First song in the playlist
        current = new Song(firstSong);   // Set the current pointer to the first song
    }

    /**
     * Add a new song to the playlist
     * @param title the title of the new song
     */
    public void addSong(String title) {
        // Initialize new song node
        Song newSong = new Song(title);

        // Normal doubly linked list pointer implementation
        newSong.previous = current;     // Make the previous pointer be the current song
        current.next = newSong;         // Make the next song be the new song
        current = newSong;              // Make the current pointer be the new song
    }

    /**
     * Play the previous song
     * Moves the current pointer back by the given number of songs.
     *
     * @param steps the number of songs to move back
     * @return the title of the current song after moving back
     */
    public String previousSong(int steps) {
        // If steps is greater than 0
        while (steps > 0 && current.previous != null) {
            current = current.previous;   // Go back to the previous song
            steps--;                      // Decrement steps
        }
        return current.title;             // Return the title of the current song
    }

    /**
     * Play the next song
     * Moves the current pointer forward by the given number of songs.
     *
     * @param steps the number of songs to move forward
     * @return the title of the current song after moving forward
     */
    public String nextSong(int steps) {
        // If steps is greater than 0
        while (steps > 0 && current.next != null) {
            current = current.next;       // Go forward to the next song
            steps--;                      // Decrement steps
        }
        return current.title;             // Return the title of the current song
    }

    /**
     * Remove the current song from the playlist
     * Moves the current pointer to the next song or previous song if the next song is null.
     */
    public void removeCurrentSong() {
        if (current.previous != null) {
            current.previous.next = current.next; // Bypass the current song
        }
        if (current.next != null) {
            current.next.previous = current.previous; // Bypass the current song
            current = current.next; // Move to the next song
        } else {
            current = current.previous; // Move to the previous song if next is null
        }
    }
}
