public class jugglingAlgo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        leftRotate(arr, 3);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static void leftRotate(int[] a, int k) {
        int l = a.length;
        int sets = gcd(k, l);
        int i = 0;
        while (i < sets) {
            int j = i;
            int temp = a[j];
            while (j + sets < l) {
                a[j] = a[j + sets];
                j += sets;
            }
            a[j] = temp;
            i++;
        }
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else
            return gcd(b % a, a);
    }
}
