class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        // Since the maximum key is 10^6, we can initialize a boolean array of size 1,000,001.
        set = new boolean[1000001];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }
}