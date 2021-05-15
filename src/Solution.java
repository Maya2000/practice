import jdk.jfr.Unsigned;
import java.lang.*;
import java.util.*;

/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*public class Solution {
    public static boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null)
            return true ;
        if(root.left != null && root.right == null && maxNode(root.left) < root.val && isValidBST(root.left))
            return true ;
        if(root.left == null && root.right != null && minNode(root.right) > root.val && isValidBST(root.right))
            return true ;
        if(root.left != null && root.right != null && isValidBST(root.left) && isValidBST(root.right)){
            if(root.val > maxNode(root.left) && root.val < minNode(root.right))
                return true ;
        }
        return false;
    }
    public static int maxNode(TreeNode root){
        if(root == null)
            return Integer.MIN_VALUE ;
        if(root.left == null && root.right == null)
            return root.val ;
        int max = root.val ;
        if(maxNode(root.left)>= max)
            max = maxNode(root.left);
        if(maxNode(root.right)>= max)
            max = maxNode(root.right);
        return max ;
    }
    public static int minNode(TreeNode root){
        if(root == null)
            return Integer.MAX_VALUE ;
        if(root.left == null && root.right == null)
            return root.val ;
        int min = root.val ;
        if(minNode(root.left)<= min)
            min = minNode(root.left);
        if(minNode(root.right)<= min)
            min = minNode(root.right);
        return min ;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(22);
        TreeNode r1 = new TreeNode(-4);
        r.left = r1;
        TreeNode r2 = new TreeNode(-60);
        r1.left = r2;
        TreeNode r3 = new TreeNode(-90);
        r2.left = r3;

        boolean b = isValidBST(r);
        System.out.println(b);
    }
}*/
 /*class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> l =  threeSum(nums);
        for(List<Integer> l1:l){
            for(int a: l1){
                System.out.println(a);
            }
        }
    }
     public static List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> l1 = new ArrayList<>();
         List<Integer> l2 = new ArrayList<>();
         int l = nums.length ;
         int index = 0;
         for(int i = 0; i < l; i++){
             int target = nums[i];
             for(int j = (i+1)%l; j%l != i-1 ; j++){
                 if(nums[j%l] + nums[(j+1)%l] + target == 0){
                     l2.add(0,nums[i]);
                     l2.add(1,nums[j%l]);
                     l2.add(2,nums[(j+1)%l]);
                     l1.add(index,l2);
                     l2.clear();
                     index++;
                 }
                 if(j%l == (i+l-1)%l)
                     break;
             }
         }
         return l1;
     }
 }*/
class Solution {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> l = groupAnagrams(strs);
        for (int i = 0; i < l.size(); i++) {
            List<String> l2 = l.get(i);
            for (int j = 0; j < l2.size(); j++) {
                System.out.println(l2.get(j));
            }
        }
        /*TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;
        List<Integer> l = inorderTraversal(root);Scanner s = new Scanner(System.in);
         long  i = s.nextLong();String c = s.nextLine();c.substring(1);
        System.out.println(l);
    }

    /*  public static boolean increasingTriplet(int[] nums) {
          int l = nums.length;
          if(l<3)
              return false;
          else{
              int count = 1 ;
              for(int k = 0 ; k < l-2 ; k++){
                  int first = nums[k], second = nums[k], third = nums[k];
                  count = 1;
                  for(int i = k+1; i < l ; i++){
                  }
                  if (count >= 3)
                      return true;
              }
              return false;
          }
      }*/
    }
    // static int count = 0;

    /* public static List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> l = new ArrayList<>();
         if (root == null && count == 0)
             return l;
         else
             Solution.count++;
         if (root.left != null) {
             Solution.count++;
             inorderTraversal(root.left);
         }
         l.add(root.val);
         if (root.right != null) {
             Solution.count++;
             inorderTraversal(root.right);
         }
         return l;
     }*/
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        List<List<String>> l = new ArrayList<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String k = String.valueOf(arr);
            List<String> l2 = m.getOrDefault(k, new ArrayList<>());
            l2.add(s);
            m.put(k, l2);
        }
        int n = m.keySet().size();
        for (Map.Entry<String, List<String>> e : m.entrySet()) {
            l.add(e.getValue());
        }
        return l;
    }

    static void printPattern(int n) {
        // Your code here
        int e = 2, o = 1;
        int t = (n + 1) / 2;
        int l = t, h = t;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n; k++) {
                if (present(k, l, h)) {
                    if (i % 2 == 0 && k % 2 != 0) {
                        System.out.print(e);
                        e += 2;
                    } else if (i % 2 != 0 && k % 2 == 0) {
                        System.out.print(o);
                        o += 2;
                    } else
                        System.out.print(" ");
                } else
                    System.out.print(" ");
                if (i <= (n + 1) / 2) {
                    l--;
                    h++;
                } else {
                    l++;
                    h--;
                }
                System.out.println("");
            }
        }
    }
        public static boolean present ( int t, int low, int high){
            if (t < low || t > high)
                return false;
            else
                return true;
        }
}
