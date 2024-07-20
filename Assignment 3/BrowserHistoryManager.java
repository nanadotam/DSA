
public class BrowserHistoryManager {
    public static void main(String[] args) {
        // Input case :
        String homepage = "ashesi.edu.gh";

        // Initialize the object of Browser History
        BrowserHistory obj = new BrowserHistory(homepage);

        // Visit all the websites
        obj.visit("google.com");
        obj.visit("facebook.com");
        obj.visit("youtube.com");

        // Print all the websites and accompanying actions
        System.out.println("Back 1 step: " + obj.back(1));
        System.out.println("Back 1 step: " + obj.back(1));
        System.out.println("Forward 1 step: " + obj.forward(1));
        obj.visit("linkedin.com");
        System.out.println("Forward 2 steps: " + obj.forward(2));
        System.out.println("Back 2 steps: " + obj.back(2));
        System.out.println("Back 7 steps: " + obj.back(7));
    }
}
