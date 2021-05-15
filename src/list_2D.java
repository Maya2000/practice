import org.w3c.dom.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class list_2D {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        System.out.println(countUnvisited(25,7));
    }
    /*static int countTriplets(Node head, int x) {
        int ans = 0;
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int[] arr = new int[len];
        temp = head;
        int i = 0;
        while (temp != null) {
            arr[i] = temp.data;
            temp = temp.next;
            i++;
        }
        for (int j = 0; j < arr.length - 2; j++)
            ans += twosum(arr, -arr[j], j + 1, ans);
        return ans;
    }*/
    public static int countUnvisited(int n, int m)
    {
        int X = (m * n) - m - n;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            if (curr - m > 0)
                queue.add(curr - m);
            if (curr - n > 0)
                queue.add(curr - n);
        }
        return count;
    }

    public static int twosum(int[] arr, int x, int i, int count) {
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] < x)
                j--;
            else if (arr[i] + arr[j] > x)
                i++;
            else {
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}