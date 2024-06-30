public class EnhancedPlaylist {
    /*
     * Node class
     * @param song Song object
     * @param prev Node object
     * @param next Node object
     */
    private class Node { 
        Song song;
        Node prev;
        Node next;

    /*
         * Node constructor
         * @param song Song object
         */
        // Constructor
        Node (Song song) {
            this.song = song;
            this.prev = null;
            this.next = null;
        }
    }

    /*
     * Head of the playlist
     * Tail of the playlist
     * @param head Node
     * @param tail Node
     */
    private Node head;
    private Node tail;

    /* 
     * EnhancedPlaylist constructor
     * @param head Pointer for traversing through list.
     */
    // Constructor
    public EnhancedPlaylist() {
        this.head = null;
        this.tail = null;
    }

    /*
     * Adds a song to the end of the playlist.
     * @param song Song to be added
     */
    public void addSong(Song song) {
        Node newNode = new Node(song); // initialization of new node
        if (head == null && tail == null) { // if list is empty
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


}
