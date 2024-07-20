/**
 * This program is an implementation of a browser history using a stack using
 * doubly linked lists.
 */

class Node {
    String link;    // URL you visit
    Node previous;      // pointer to prev node/link you visit
    Node next;      // pointer to next node/link you visit

    /**
     * Constructor
     */
    Node(String link) {
        this.link = link;
        this.previous = null;
        this.next = null;
    }
}

/**
 * BrowserHistory Class
 */
public class BrowserHistory {
    Node current; // curent pointer of url we are on at a given time

    /**
     * Constructor
     */
    public BrowserHistory(String homepage) {    // homepage of browser
        current = new Node(homepage);   // set current pointer to homepage
    }

    public void visit(String url) {
        // Initialize url node 
        Node urlNode = new Node(url);

        // Normal doubly linked list pointer implementation
        urlNode.previous = current;     // make the previous pointer be the current
        current.next = urlNode;     // make the next next node url
        current = urlNode;  // make the current pointer be the url
        
        current.next = null;    // Reset forward history
    }

    /**
     * Moves the current pointer back by the given number of steps.
     *
     * @param  step the number of steps to move back
     * @return the link of the current node after moving back
     */
    public String back(int step) {
        // if step is greater than 0
        while (step > 0 && current.previous != null) {
            current = current.previous;   // go back to the pevious node
            step-- ;    // decrement step
        }
        return current.link;     // return the link of the current node
    }

    /**
     * 
     */
    public String forward(int step) {
        // if step is greater than 0
        while (step > 0 && current.next != null) {
            current = current.next;   // go forward to the next node
            step-- ;    // decrement step
        }
        return current.link;     // return the link of the current node
    }
}
