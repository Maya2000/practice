import java.util.ArrayList;
import java.util.List;

class NaivePatterSearchingInString{
    public static void main(String[] args) {
        List<Integer> l = naiveSearch("ababab","ab");
        for(int a: l){
            System.out.println(a);
        }
    }
    public static List<Integer> naiveSearch(String large, String small){
        int n = large.length();
        int m = small.length();
        List<Integer> l = new ArrayList<>(n-m+1);
        for(int i = 0; i <= n - m; i++){
            int j ;
            for(j = 0; j < m; j++){
                if(large.charAt(i+j) != small.charAt(j))
                    break;
            }
            if(j == m)
                l.add(i);
        }
        return  l;
    }
}