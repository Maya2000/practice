import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopKFrequentElements {
    public static void main(String[] args) {
      int[] nums = {1,1,1,2,2,3,3,3,3};
      int k =2;
      System.out.println(Arrays.toString(topK(nums, k)));
    }


    public static int[] topK(int[] nums, int k){
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] out = new int[k];
        PriorityQueue<elements> pq = new PriorityQueue<>((e1, e2)-> e2.freq-e1.freq);
        Arrays.sort(nums);
        int prev = nums[0];
        int count =1;
        for(int i=1; i<nums.length; i++){
           if(nums[i]==prev){
               count++;
           }else{

               elements e = new elements(prev, count);
               pq.add(e);
               prev = nums[i];
               count =1;
           }
        }
        pq.add(new elements(prev, count));
        IntStream.range(0, k).forEach(i-> out[i]=pq.poll().val);

        return out;
    }
    public static class elements{
        int val, freq ;
        elements(int  x, int y){
            this.val = x;
            this.freq = y;
        }
    }
}
