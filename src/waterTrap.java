import java.util.HashMap;
import java.util.Map;

class waterTrap {
    static int trappingWater(int arr[], int n) {
        Map<Integer, Integer> leftMax = new HashMap<>();
        Map<Integer, Integer> rightMax = new HashMap<>();
        int leftMax1 = arr[0], rightMax1 = arr[n - 1];
        for (int j = 1; j < n - 1; j++) {
            if (arr[j] > leftMax1)
                leftMax1 = arr[j];
            leftMax.put(j, leftMax1);
        }
        for (int k = n - 2; k >= 1; k--) {
            if (arr[k] > rightMax1)
                rightMax1 = arr[k];
            rightMax.put(k, rightMax1);
        }
        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            water += Math.min(leftMax.get(i), rightMax.get(i)) - arr[i];
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr = {8, 8, 2, 4, 5, 5, 1};
        System.out.println(trappingWater(arr, 7));
    }
}



