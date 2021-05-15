public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3,4,5,9};
        for(int a : searchRange(nums,3)){
            System.out.print(a+" ");
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid;
                r = mid;
                while (l >= 0 && nums[l] == target)
                    l--;
                while (r < nums.length && nums[r] == target)
                    r++;
                ans[0] = l + 1;
                ans[1] = r - 1;
                return ans;
            }
            if (nums[mid] < target)
                l = mid + 1;
            else if (nums[mid] > target)
                r = mid - 1;
        }
        return ans;
    }
}
