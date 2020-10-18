import java.util.ArrayDeque;
import java.util.Deque;


public class DiskSpace {
    public int analyse(int numComputer, int[] hardDiskSpace, int segmentLength) {
        Deque <Integer> deq = new ArrayDeque<>();
        int maxMin = Integer.MIN_VALUE; // max of the minimums
        for(int i = 0; i < numComputer; i++) {
            while(!deq.isEmpty() && hardDiskSpace[deq.peekLast()] > hardDiskSpace[i]) {
                deq.pollLast();// the current element is a better minima
            }
            if(!deq.isEmpty() && deq.peekFirst() <= (i - segmentLength)) {
                deq.pollFirst(); // if the window is greater then the size needed
            }
            deq.offerLast(i);
            if(i >= (segmentLength - 1)) { // if the segment is the right length
                maxMin = Math.max(maxMin, hardDiskSpace[deq.peekFirst()]);
            }
        }
        return maxMin;
    }
    public static void main(String[] args) {
        DiskSpace space = new DiskSpace();
        System.out.println(space.analyse(3, new int[] {8, 2, 4}, 2));
        System.out.println(space.analyse(6, new int[] {8, 2,4,3,7,6}, 2));//6
        System.out.println(space.analyse(6, new int[] {8, 2,4,3,7,6}, 3));//3
        System.out.println(space.analyse(7, new int[] {2,4,3,7,8,6,5}, 4));//5
        System.out.println(space.analyse(13, new int[] {2,4,3,7,8,6,5,16,19,33,32,34,35}, 5));
    }
}
