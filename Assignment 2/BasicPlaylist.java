public class BasicPlaylist {
    private class Node { 
        Song song;
        Node next;

        Node (Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;

    public BasicPlaylist() {
        this.head = null;
    }

    public void addSong(Song song) {
        // System.out.println("Adding a song to the playlist");
        Node newNode = new Node(song);
        if (head == null) { // if list is empty
            head = newNode; // make first node the song
        } else {   
            Node current = head; // else make the current node the head node (prev)
            while (current.next != null) {
                current = current.next;
            }
                current.next = newNode;
            }
        }

    public void addSong(Song song, int position) {
        // System.out.println("Adding a song to the playlist");
        Node newNode = new Node(song);
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
