import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static void main(String[] args) {

    }

    public int meetingRooms(Interval[] intervals){
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals , (a,b) -> a.start - b.start); // sort by start time

        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end - b.end);
        // based on what ends earliest
        // root of the Min Heap is gonna contain the meeting that ends the earliest
        pq.add(intervals[0]);
        for(int i = 1; i<intervals.length;i++){
            Interval curr = intervals[i];
            Interval earliest = pq.remove();
            if(curr.start >= earliest.end){
                earliest.end = curr.end;
            }else{
                pq.add(curr);
            }
            pq.add(earliest);
        }
        return pq.size();
    }

    private static int findMinMeetingRooms(int[][] input) {
        Arrays.sort(input, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])); // compare start times
        int previousEnd = input[0][1];
        PriorityQueue<Integer> endtimes = new PriorityQueue<>(); // earliest end times
        endtimes.add(previousEnd);
        for (int i = 1; i < input.length; i++) {
            int currentBegin = input[i][0];
            int currentEnd = input[i][1];
            if (currentBegin > endtimes.peek()) {
                //If meeting room freed up
                endtimes.remove();
                endtimes.offer(currentEnd);
            } else {
                //If no meeting rooms available
                endtimes.offer(currentEnd);
            }
        }
        return endtimes.size();
    }
}



class Interval {
    int start;
    int end;
    Interval(){
        start = 0;
        end =0;
    }
    Interval(int start,int end){
        this.start = start;
        this.end = end;
    }
}
