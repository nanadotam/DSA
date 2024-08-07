public class BasicPlaylist {
    /*
     * Node class
     * @param song Song object
     * @param next Node object
     */
    private class Node { 
        Song song;
        Node next;

        /*
         * Node constructor
         * @param song Song object
         */
        Node (Song song) {
            this.song = song;
            this.next = null;
        }
    }

    /*
     * Head of the playlist
     * @param head Node
     */
    private Node head;

    /* 
     * BasicPlaylist constructor
     * @param head Pointer for traversing through list.
     */
    public BasicPlaylist() {
        this.head = null;
    }

    /*
     * Adds a song to the end of the playlist.
     * @param song Song to be added
     */
    public void addSong(Song song) {
        Node newNode = new Node(song); // initialization of new node
        if (head == null) { // if list is empty
            head = newNode; // make first node the song
        } else {   // else if the list is non-empty
            Node current = head; // else make the current node the head node (prev)
            while (current.next != null) { // while the next node is not the last element
                current = current.next; // make current the next node
            }
            // append to the end of the list
            current.next = newNode; // make the last element point to the new node
            }
        }

    /*
     * Adds a song to the playlist at a specified position.
     * @param song Song to be added.
     * @param position Position to add the song at
     */
    public void addSong(Song song, int position) {
        // adding a song to the playlist at a specific position
        Node newNode = new Node(song); // intialize new node
        if (position == 0) { // if the position is the first
            newNode.next = head; // make the new node point to the head node
            head = newNode; // make the head node the new node
            return;
        } else { // if the position is anywhere else in the list
            Node current = head; // make the current node the head node (prev)
            for (int i = 0; i < position - 1; i++) { // loop through the list to find the position
                current = current.next;
            }
            if (current.next != null) {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    /*
     * Removes a song from the playlist using its Title
     * @param title Title of song to be removed
     */
    public void removeSong(String title) {
        if (head == null) {
            // System.out.println("The playlist is empty");
            return;
        }
        if (head.song.title.equals(title)) {
            head = head.next;
            return;
        }
        Node current = head;
        // Node previous = null;
        while (current.next != null && !current.next.song.title.equals(title)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    /*
     * Removes a song at a specified position
     * @param position Position of song to be removed
     */
    public void removeSong(int position) {
        if (head == null) {
            // The playlist is empty
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current != null) {
                current = current.next;
            }
        }
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }

    /*
     * Prints the playlist
     */
    public void displayPlaylist() {
        Node current = head;
        while (current != null) { 
            System.out.println("Title: " + current.song.title + ", Artist: " + current.song.artist + ", Duration: " + current.song.getFormattedDuration());
            current = current.next;
        }
    }

    /*
    * Returns the number of songs in the playlist
    */
    public int getTotalDuration() {
        int totalDuration = 0;
        Node current = head;
        while (current != null) {
            totalDuration += current.song.duration;
            current = current.next;
        }
        return totalDuration;
    }
    
    /*
     * Converts total song duration to a formatted form "H:MM:SS"
     */
    public String getFormattedTotalDuration() {
        int totalDuration = getTotalDuration();         
        int hours = totalDuration / 3600;
        int min = (totalDuration % 3600) / 60;
        int secs = totalDuration % 60;
    
        if (hours <= 0) {
            return String.format("%02d:%02d", min, secs);
        } else {
            return String.format("%d:%02d:%02d", hours, min, secs);
        }
    }
}
