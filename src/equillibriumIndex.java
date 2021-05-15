public class equillibriumIndex {
    public static void main(String[] args) {
        int arr[] = {-7,1,5,2,-4,3,0};
        System.out.println(eqIndex(arr));
    }

    public static int eqIndex(int[] a) {
        int l = a.length;
        //int[] prefixArr = new int[l];
        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum += a[i];
        }
        int leftSum = 0;
        for (int j = 0; j < l; j++) {
            sum -= a[j];
            if (leftSum == sum)
                return j;
            leftSum += a[j];
        }
        return  -1;
    }
}
