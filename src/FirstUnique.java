import java.util.*;


//public static void main(String[] args) {
//        FirstUnique s = new FirstUnique(new int[]{});
//        s.add(2);
//        System.out.println(s.showFirstUnique()); // 2
//        s.add(2);
//        System.out.println(s.showFirstUnique());  // null
//        s.add(3);
//        System.out.println(s.showFirstUnique());  // 3
//        s.add(4);
//        System.out.println(s.showFirstUnique());  // 3
//        s.add(3);
//        System.out.println(s.showFirstUnique());
//        }

public class FirstUnique {

    public static void main(String[] args) {
        FirstUnique s = new FirstUnique(new int[]{});
        s.add(2);
        System.out.println(s.showFirstUnique()); // 2
        s.add(2);
        System.out.println(s.showFirstUnique());  // null
        s.add(3);
        System.out.println(s.showFirstUnique());  // 3
        s.add(4);
        System.out.println(s.showFirstUnique());  // 3
        s.add(3);
        System.out.println(s.showFirstUnique());
        }

    private Set<Integer> uniqueNumbers = new LinkedHashSet<>(); // storing the unique elements
    private Set<Integer> nonUniqueNumbers = new HashSet<>(); // keeping track of the elements we already come across

    public FirstUnique(int[] nums) {
        if (nums != null && nums.length > 0){
            for(int num : nums){
                add(num);
            }
        }
    }

    public int showFirstUnique() {// 0(1)
        if(uniqueNumbers.isEmpty()){ // if the set is empty
            return -1;
        }

        return uniqueNumbers.iterator().next(); // get the head
    }

    public void add(int value) { // 0(1)
        if(uniqueNumbers.contains(value)){ // come across the value again so its not unique
            uniqueNumbers.remove(value);
            nonUniqueNumbers.add(value);
        } else if (!nonUniqueNumbers.contains(value)) {
            uniqueNumbers.add(value); // the number is unique
        }
    }
}
