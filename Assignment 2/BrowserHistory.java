import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class BrowserHistory {
    private HistoryNode head;
    private HistoryNode tail;
    
    // Constructor
    public BrowserHistory() {
        this.head = null;
        this.tail = null;
    }

    // Logic to add a new page
    public void addPage(String url, String timestamp) {
        HistoryNode newNode = new HistoryNode(url, timestamp); // initialize a newNode
        if (head == null) { // if no page is at the head (e.g. firstly added page)
            head = newNode; // head is new page
            tail = newNode; // tail is also new page
        } else {            // else if a page already exists
            tail.next = newNode; // the next page after tail is the new page 
            newNode.prev = tail; // and the previous page of the new page is tail
            tail = newNode; // and now tail is the new page
        }
    }

    public void removePage(String timestamp) {
        HistoryNode curr = head;
        while (curr != null) {
            if (curr.timestamp.equals(timestamp)) {
                if (curr.prev == null) { // if the page is the first page
                    head = curr.next; // head is the next page
                    if (head != null) {
                        head.prev = null; // and we make previous page of the next page null
                    }
                } else if (curr.next == null) { // if the page is the last page
                    tail = curr.prev; // tail is the previous page
                    curr.prev.next = null; // and the next page of the previous page is null
                } else {                    // if the page is in the middle
                    curr.prev.next = curr.next; // the next page of the previous page is the next page
                    curr.next.prev = curr.prev; // and the previous page of the next page is the previous
                }
                return; // break out of the loop once the page is found and removed
            }
            curr = curr.next;
        }
    }   

    public void displayHistoryForward() {
        HistoryNode curr = head;
        while (curr != null) {
            System.out.println(curr.url + " " + curr.timestamp);
            curr = curr.next;
        }
    }

    public void displayHistoryBackward() {
        HistoryNode curr = tail;
        while (curr != null) {
            System.out.println(curr.url + " " + curr.timestamp);
            curr = curr.prev;
        }
    }

    public void saveToFile (String file) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            HistoryNode curr = tail;
            while (curr != null) {
                writer.write(curr.url + " " + curr.timestamp);
                writer.newLine();
                curr = curr.prev;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readFromFile (String file) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(" ");
                String url = parts[0];
                String timestamp = (parts[1]);
                addPage(url, timestamp);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
