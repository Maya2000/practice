public class SearchInaSortedRotatedArray {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(search(nums,5));
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e = n;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]){
                s = i;
                break;
            }
        }
        e = s+n;
        while(s <= e){
            int m = (s+(e-s)/2);
            if(nums[m%n] == target)
                return m%n;
            else if(nums[m%n] < target)
                s = (m+1);
            else
                e = (m-1);
        }
        return -1;
    }
}
