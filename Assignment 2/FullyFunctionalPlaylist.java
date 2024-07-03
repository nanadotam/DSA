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
    private boolean enableRepeatAll; // continuous play

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
            head.next = head; // make the head point to itself to make it circular
            head.prev = head;   // make the head point to itself to make it circular
        } else {   // else if the list is non-empty
            tail.next = newNode; // last element is the new node
            newNode.prev = tail; // prev pointer of newNode is the current tail
            newNode.next = head; // next pointer of newNode is the head to make it circular
            tail = newNode; // update current tail to the newNode
        }
    }


    /*
     * Adds a song to the playlist at a specified position.
     * @param song Song to be added.
     * @param position Position to add the song at
     */
    public void addSong(Song song, int position) {
        Node newNode = new Node(song); // initailize new node
        if (position == 0) { // if position is at the beginning 
            // newNode.next = head; // make newNode point to head
            if (head != null) {
                // head.prev = newNode; // update head's prev pointer to new node
                head = newNode; // make first node the song
                tail = newNode; // make first node the tail as well
                head.next = head; // make the head point to itself to make it circular
                head.prev = head;   // make the head point to itself to make it circular
            } else {
                newNode.next = head; // make newNode point to head
                newNode.prev = tail; // point to tail
                head.prev = newNode;
                tail.next = newNode;
                head = newNode;
            }
        } else {
            Node current = head; // make current node the head node
            for (int i = 0; i < position - 1; i++) { // find position
                if (current.next == head) {
                    break;  // if position is out of bounds, add at the end
                }
            }   
            newNode.next = current.next; // new node points to current next node
            newNode.prev = current;

            // TO BE FINISHED!
        }
}
