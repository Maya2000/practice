public class largestSumSubarray {
    public static void main(String[] args) {
        int[] arr = {-3, 4, -1, -2, 1, 5};
        System.out.println(maxSum(arr));

    }

    public static int maxSum(int[] a) {
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        for (int i = 0; i < a.length; i++) {
            currMax += a[i];
            if (currMax > max)
                max = currMax;
            if (currMax < 0)
                currMax = 0;
        }
        return max;
    }
}
