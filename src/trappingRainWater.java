public class trappingRainWater {
    public static void main(String[] args) {
        int[] arr = {8, 8, 2, 4, 5, 5, 1};
        System.out.println(trappingWater(arr,7));
    }
    static int trappingWater(int arr[], int n) {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

// water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else {
                if (arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
       /* int left[] = new int[n];
        int[] right = new int[n];
        int lmax = arr[0], rmax = arr[n-1];
        for(int i = 1; i < n; i++){
            left[i] = lmax;
            if(arr[i] > lmax)
                lmax = arr[i];
        }
        for(int i = n-2; i >= 0; i--){
            right[i] = rmax;
            if(arr[i] > rmax)
                rmax = arr[i];
        }
        int water = 0;
        for(int i = 1; i < n-1;i++){
            int diff = Math.min(left[i],right[i]) - arr[i];
            if(diff > 0)
                water+=diff;
        }
        return water;*/
    }
}
