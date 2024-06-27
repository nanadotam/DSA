public class BasicPlaylist {
    private class Node { 
        Song song;
        Node next;

        // Constructor
        Node (Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;

    // Constructor
    public BasicPlaylist() {
        this.head = null;
    }

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
        // System.out.println("Adding a song to the playlist at position " + position )





        if (head == null) { // if list is empty
            head = newNode; // make first node the song
        } else {
            Node current = head; // else make the current node the head node (prev)
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void removeSong(Song song) {
        // System.out.println("Removing a song from the playlist");
        if (head == null) {
            System.out.println("The playlist is empty");
        } else {
            Node current = head;
            Node previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
        }
    }

                }
                public void printPlaylist() {
                    // System.out.println("Printing the playlist");
                    Node current = head;
                    while (current != null) {
                        System.out.println(current.song);
                        current = current.next;
                    }
                    }
                    public void printPlaylistReverse() {
                        // System.out.println("Printing the playlist in reverse");
                        Node current = head;
                        Node previous = null;
                        while (current != null) {
                            previous = current;
                            current = current.next;
                            }
                            while (previous != null) {
                                System.out.println(previous.song);
                                previous = previous.next;
                                }
                                }

    }

}
