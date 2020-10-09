import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    Map<String, Integer> totalTravels = new HashMap<>();// keeps count of travel from x-> y
    Map<String, Long> totalTimeStay = new HashMap<>();// keeps time stay from x-> y
    Map<Integer, String> stationName = new HashMap<>();//keeps stationName status of customer ID
    Map<Integer, Integer> time = new HashMap<>();//keeps checkin time of customer ID

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        this.stationName.put(id, stationName);// where is custID
        time.put(id, t);// put check in time
    }

    public void checkOut(int id, String stationName, int t) {
        String code = this.stationName.get(id) + "*" + stationName;// custID start-end
        int change = t - time.get(id);
        this.stationName.remove(id);
        time.remove(id);

        if (!totalTravels.containsKey(code)){
            totalTravels.put(code, 0);
        } //travelled 1st time
        totalTravels.put(code, totalTravels.get(code) + 1);// update total
        
        if (!totalTimeStay.containsKey(code)){
            totalTimeStay.put(code, 0L);   
        }
        totalTimeStay.put(code, totalTimeStay.get(code) + change);
    }

    public double getAverageTime(String startStation, String endStation) {
        String code = startStation + "*" + endStation;
        double x = totalTimeStay.get(code);
        return x / totalTravels.get(code);
    }
}
