import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class slidingWindow {
    public static void main(String[] args) {
        int[] arr = {5,2,-1,0,3};
        System.out.println(maxConsecutiveSum(arr,3));
    }
    public static int maxConsecutiveSum(int[] a,int k){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int j =0; j < k; j++){
            q.add(a[j]);
            currSum+=a[j];
        }
        maxSum = currSum;
        for(int i = k; i < a.length; i++){
            if(!q.isEmpty())
                currSum -= q.poll();
                q.add(a[i]);
                currSum+=a[i];
            if(currSum>maxSum)
                maxSum = currSum;
        }
        return maxSum;
    }
}
