// HistoryNode Class
public class HistoryNode {
    String url;
    String timestamp;
    HistoryNode prev;
    HistoryNode next;

    // Constructor
    public HistoryNode(String url, String timestamp) {
        this.url = url;
        this.timestamp = timestamp;
        this.prev = null;
        this.next = null;
    }
}
