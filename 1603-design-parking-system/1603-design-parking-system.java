class ParkingSystem {
    // Array to store the available slots. 
    // Size is 4 to directly map carType (1, 2, 3) to array indices.
    private int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // Check if there is space available for the specific carType
        if (spaces[carType] > 0) {
            spaces[carType]--; // Decrement the available slots
            return true;
        }
        return false; // No slots available
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna