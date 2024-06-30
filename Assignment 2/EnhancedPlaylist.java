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
     * @param head Node
     */
    private Node head;

    /* 
     * BasicPlaylist constructor
     * @param head Node
     */
    // Constructor
    public BasicPlaylist() {
        this.head = null;
    }


}
