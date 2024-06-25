import java.io.IOException;

public class BrowserHistoryManager {
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory();

        // Add to history
        bh.addPage("www.example1.com", "10:00 AM");
        bh.addPage("www.example2.com", "10:05 AM");
        bh.addPage("www.example3.com", "10:10 AM");
        
        // Delete from history
        bh.removePage("10:05 AM");

        // Display history FIFO
        System.out.println("History Forward:");
        bh.displayHistoryForward();
        System.out.println();

        // Display hisory LIFO
        System.out.println("History Backward:");
        bh.displayHistoryBackward();
        System.out.println();


        try {
            // Save to file
            bh.saveToFile("history.txt");
            
            // clear history
            bh = new BrowserHistory();

            // load history from file
            bh.readFromFile("history.txt");
            System.out.println("History from file:");
            bh.displayHistoryBackward(); // displays in forward order because it was added to list backwards
            
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }   
    }
}
