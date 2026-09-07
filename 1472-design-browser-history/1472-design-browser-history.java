import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    private List<String> history;
    private int curr;
    private int bound;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
        bound = 0; // Tracks the maximum forward history available
    }
    
    public void visit(String url) {
        curr++;
        // If we are overwriting existing forward history
        if (curr < history.size()) {
            history.set(curr, url);
        } else {
            // If we are at the end of our current list allocation
            history.add(url);
        }
        // Visiting a new URL clears all forward history
        bound = curr;
    }
    
    public String back(int steps) {
        // Jump back, bounded by the 0th index (homepage)
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        // Jump forward, bounded by the furthest valid history index
        curr = Math.min(bound, curr + steps);
        return history.get(curr);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna