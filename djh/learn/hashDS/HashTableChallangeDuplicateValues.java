package djh.learn.hashDS;

import java.util.HashMap;
import java.util.List;

public class HashTableChallangeDuplicateValues {
    public static void main(String[] args) {

        int[] nums = new int[10];
        int[] numsToAdd = { 43, 43, 6894, 500, 99, -58 ,99};
        HashMap<Integer,Integer> integers = new HashMap<>();
        for (int i = 0; i < numsToAdd.length; i++) {
            integers.putIfAbsent(numsToAdd[i],numsToAdd[i]);
        }
        List<Integer> ints = integers.values().stream().toList();
        for (int i = 0; i < ints.size(); i++) {
            nums[i] = ints.get(i);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"--");
        }
    }
}
