public class FullyFunctionalPlaylist {
    private class Node {
        Song song;
        Node prev;
        Node next;
    
        // Constructor
        Node (Song song) {
            this.song = song;
            this.prev = null;
            this.next = null;
        }
    }



    
}