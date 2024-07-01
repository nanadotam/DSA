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
        if (head == null) { // if list is empty
            head = newNode; // make first node the song
            tail = newNode; // make first node the tail as well
        } else {   // else if the list is non-empty
            tail.next = newNode; // last element is the new node
            newNode.prev = tail; // prev pointer of newNode is the current tail
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
            newNode.next = head; // make newNode point to head
            if (head != null) {
                head.prev = newNode; // update head's prev pointer to new node
            }
            head = newNode; // make newNode the head
            if (tail == null) { // if the list is empty
                tail = newNode; // new node is also the tail
            }
        } else {
            Node current = head; // make the current node the head node
            for (int i = 0; i < position - 1; i++) { // loop through the list to find the position
                if (current.next == null) {
                    break; // if position is out of bounds, add at the end
                }
                current = current.next;
            }
            newNode.next = current.next; // new node points to current's next node
            if (current.next != null) {
                current.next.prev = newNode; // current's next node points back to new node
            } else {
                tail = newNode; // if adding at the end, update the tail
            }
            current.next = newNode; // current node points to new node
            newNode.prev = current; // new node points back to current node
            }
        }

    /*
     * Removes a song from the playlist using its Title
     * @param title Title of song to be removed
     */ 
    public void removeSong(String title) {
        if (head == null && tail == null) {
            return; // empty playlist; do nothing
        }
        if (head.song.title.equals(title)) { // if a match is made
            head = head.next; // the head pointer points to the next element in the list
            if (head != null) {  // if the list is not empty
                head.prev = null; // make the prev pointer of the head node null
            } else { 
                tail = null; // else make the tail null
            }
            return;
        }
        Node current = head; 
        while (current.next != null && !current.next.song.title.equals(title)) {
            current = current.next;
        }
        if (current.next != null) {
            Node toRemove = current.next;
            current.next = toRemove.next;
            if (toRemove.next != null) {
                toRemove.next.prev = current;
            } else {
                tail = current;
            }
        }
    }


    /*
     * Removes a song at a specified position
     * @param position Position of song to be removed
     */
    public void removeSong(int position) {
        if (head == null && tail == null) {
            
        }

}

