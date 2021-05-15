public class rangeSumQueries {
    public static void main(String[] args) {
        int[] a = {4,5,3,2,5};
        System.out.println(sum(a,0,3));
        System.out.println(sum(a,2,4));
        System.out.println(sum(a,1,3));

    }
    public static int sum(int[] a,int l,int h){
        int s = 0;
        int n = a.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            s+=a[i];
            arr[i] = s;
        }
        return (l==0)?arr[h]:arr[h] - arr[l-1];
    }
}
