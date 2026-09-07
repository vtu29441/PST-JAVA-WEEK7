import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    
    // Tracks current check-ins: passenger ID -> CheckIn data (station, time)
    private Map<Integer, CheckInEvent> checkIns;
    
    // Tracks completed route statistics: "startStation,endStation" -> Route data (total time, number of trips)
    private Map<String, RouteStat> routeStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInEvent(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove the passenger's check-in event
        CheckInEvent checkInEvent = checkIns.remove(id);
        
        // Calculate travel details
        String routeKey = checkInEvent.stationName + "," + stationName;
        int travelTime = t - checkInEvent.time;
        
        // Update route statistics
        RouteStat stat = routeStats.getOrDefault(routeKey, new RouteStat());
        stat.totalTime += travelTime;
        stat.tripCount++;
        routeStats.put(routeKey, stat);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "," + endStation;
        RouteStat stat = routeStats.get(routeKey);
        
        // Calculate and return the average
        return (double) stat.totalTime / stat.tripCount;
    }
    
    // --- Helper Classes ---
    
    private class CheckInEvent {
        String stationName;
        int time;
        
        public CheckInEvent(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    private class RouteStat {
        long totalTime; // Use long to prevent integer overflow on many trips
        int tripCount;
        
        public RouteStat() {
            this.totalTime = 0;
            this.tripCount = 0;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */