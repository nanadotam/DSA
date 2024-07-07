public class FullyFunctionalPlaylist {
    /**
     * Node class
     * @param song Song object
     * @param prev Node object
     * @param next Node object
     */
    private class Node {
        Song song;
        Node prev;
        Node next;
        

        /**
         * Node constructor
         * @param song Song object
         */
        Node (Song song) {
            this.song = song;
            this.prev = null;
            this.next = null;
        }
    }

    /**
     * Head of the playlist
     * Tail of the playlist
     * @param head Node
     * @param tail Node
     */
    private Node head;
    private Node tail;
    private boolean repeatAll; // continuous play

    /**
     * FullyFunctionalPlaylist constructor
     * @param head Pointer for traversing through list.
     */
    public FullyFunctionalPlaylist() {
        this.head = null;
        this.tail = null;
    }

    /**
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
        } else {   // else if the list is not empty
            tail.next = newNode; // last element is the new node
            newNode.prev = tail; // prev pointer of newNode is the current tail
            newNode.next = head; // next pointer of newNode is the head to make it circular
            tail = newNode; // update current tail to the newNode
        }
    }


    /**
     * Adds a song to the playlist at a specified position.
     * @param song Song to be added.
     * @param position Position to add the song at
     */
    public void addSong(Song song, int position) {
        Node newNode = new Node(song); // initailize new node
        if (position == 0) { // if position is at the beginning 

            if (head != null) {     // meaning: head.prev points to tail
                head = newNode; // make first node the song
                tail = newNode; // make first node the tail as well
                head.next = head; // make the head point to itself to make it circular
                head.prev = head;   // make the head point to itself to make it circular
            
            // empty list implementation
            } else {            // else if the head is null in the circularlylinkedlist
                newNode.next = head; // make newNode point to head
                newNode.prev = tail; // point to tail
                head.prev = newNode; // initialize pointers
                tail.next = newNode;
                head = newNode; // the head is the newNode
            }
        } else {
            Node current = head; // make current pointer the head node
            for (int i = 0; i < position - 1; i++) { // find position
                current = current.next;
                if (current.next == head) { // tail node points to head
                    // stop the loop
                    break;  // position out of bounds, add at the end of list
                }
            }   
            newNode.next = current.next; // new node points to current next node
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode; // point back to each other

            if (current == tail) {
                tail = newNode; // upon adding at the end, update tail node
            }
        }
    }

    /**
    * Removes a song from the playlist using its Title
    * @param title Title of song to be removed
    */ 
    public void removeSong(String title) {
        if (head == null) {
            return; // empty playlist; do nothing
        }

        Node current = head;

        // Loop through the list until we return to the head
        while (true) {
            if (current.song.title.equals(title)) {
                if (current == head && current == tail) { // only one node in the list
                    head = null;
                    tail = null; // list becomes empty
                } else {        // more than one in list
                    current.prev.next = current.next; // skip current song point to its next
                    current.next.prev = current.prev; // skip current song point to its prev
                    if (current == head) { // if first element
                        head = current.next; // point to next
                    }
                    if (current == tail) { // if last element
                        tail = current.prev; // point to prev
                    }
                }
                return;
            }
            current = current.next;
            if (current == head) {
                break; // traversed the whole list and returned to the head
            }
        }
    }

    /**
     * Removes a song at a specified position
     * @param position Position of song to be removed
     */
    public void removeSong(int position) {
        if (head == null && tail == null) { // empty playlist
            return;
        }
        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
            if (current == head) {
                return; // if position is out of bounds, do nothing
            }
        }
        if (current == head) {
            head = head.next; // skipped and moved on to the next
            tail.next = head; // make the tail.next point to the new head
            head.prev = tail; // make the new head.prev point to tail
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        } else {        // any other position logic
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }


    /**
    * Prints the playlist
    */
    public void displayPlaylist() {
        if (head == null) {
            return; // if the list is empty, do nothing
        }
        Node current = head;
        boolean firstPass = true;
        while (firstPass || current != head) {
            // firstPass = false;
            System.out.println("Title: " + current.song.title + ", Artist: " + current.song.artist + ", Duration: " + current.song.getFormattedDuration());
            current = current.next;
            if (current == head) { // traversed the whole list and returned to the head
                firstPass = false;
                break; 
            }
        }
    }

    /**
    * Returns the number of songs in the playlist
    */
    public int getTotalDuration() {
        int totalDuration = 0;
        Node current = head;
        while (current != null) {
            totalDuration += current.song.duration;
            current = current.next;
            if (current == head) { // traversed the whole list and returned to the head
                break; 
            }
        }
        return totalDuration;
    }
    
    /**
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


    /**
     * Play next song in the playlist using song title of current song
     * @param title Title of current Song object being played
     * @return the next Song object
     */
    public Song playNext(String title) {
        Node current = head; // initialize current pointer to head
        while (current != null) {
            // incase there are two songs same name
            // check if artists are the same
            if (current.song.getTitle().equals(title)) { // Finding song in playlist using title
                if (current.next != head || repeatAll) { // check if there is a next song
                    return current.next.song;
                } else {
                    return null; // no next song
                }
            }
            current = current.next; // move to the next node
        }
        return null; // no song found
    }

    /**
     * Play previous song in the playlist using song title of current song
     * @param title Title of current Song object being played
     * @return the previous Song object
     */
    public Song playPrevious(String title) { 
        Node current = head; // initialize current pointer to head
        while (current != null) {
            if (current.song.getTitle().equals(title)) { // Finding song in playlist using title
                if (current.prev != tail || repeatAll) { // check if there is a prev song
                    return current.prev.song;
                } else {
                    return null; // no next song
                }
            }
            current = current.next; // move to the next node
        }
        return null; // no song found
    }

    /**
     * Toggles the continuous play mode
     */
    public void toggleRepeatAll() {
        repeatAll = !repeatAll;
    }

    /**
     * Shuffle Method
     * Shuffles the playlist using the Fisher-Yates Algorithm.
     * For more info on the algorithm, see: 
     * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
    */
    public void shuffle() {
        if (head == null && tail == null) { // empty playist
            return;
        }

        // Traverse list to count the number of nodes
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
            if (current == head) { // traversed the whole list and returned to the head
                break; 
            }
        }

        // Storing nodes in an array
        Node[] numNodes = new Node[count]; // create node array with size of elements in List
        current = head;
        for (int i = 0; i < count; i++) { // loop to store nodes in node array
            numNodes[i] = current;     
            current = current.next;     
        }

        // Implementing Fisher-Yates algorithm
        for (int i = count - 1; i > 0; i--) { // replace elements by traversing list in reverse and swapping
            int j = (int) (Math.random() * (i + 1)); // random number between 0 and i
            // Swap song nodes
            Song temp = numNodes[i].song;
            numNodes[i].song = numNodes[j].song;
            numNodes[j].song = temp;
        }
    }

    // Additional method -- for fun
    /**
     * Search Method
     * Searches for songs by title or artist.
     * @param keyword The title or artist to search for.
     * @return A list of songs that match the keyword.
     */
    public void search(String keyword) {
        if (head == null) {
            System.out.println("The playlist is empty.");
            return; // empty playlist, do nothing
        }
        Node current = head;    // current pointer
        boolean found = false;  // track found songs
    
        do {
            if (current.song.getTitle().equalsIgnoreCase(keyword) || current.song.getArtist().equalsIgnoreCase(keyword)) {
                System.out.println("Title: " + current.song.title + ", Artist: " + current.song.artist + ", Duration: " + current.song.getFormattedDuration());
                found = true;   // change to true if song found
            }
            current = current.next; // move to next song node
        } while (current != head); // traversed the whole list and returned to the head
    
        if (!found) {
            System.out.println("No results found for '" + keyword + "'."); // display message to user
        }
    }
    
}
