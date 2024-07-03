public class FullyFunctionalPlaylist {
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
     * FullyFunctionalPlaylist constructor
     * @param head Pointer for traversing through list.
     */
    // Constructor
    public FullyFunctionalPlaylist() {
        this.head = null;
        this.tail = null;
    }

    /*
     * Adds a song to the end of the playlist.
     * @param song Song to be added
     */
    public void addSong(Song song) {
        Node newNode = new Node(song); // initialization of new node
        if (head == null) { // if list is empty
            head = newNode; // make first node the song
            tail = newNode; // make first node the tail as well
        } else {   // else if the list is non-empty
            tail.next = newNode; // last element is the new node
            newNode.prev = tail; // prev pointer of newNode is the current tail
            tail = newNode; // update current tail to the newNode
        }
    }

}