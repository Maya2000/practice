import java.util.HashMap;
import java.util.Map;

public class cryptarithm {
    public static void main(String[] args) {
        String[] crypt = {"SEND", "MORE", "MONEY"};
        char[][] solution = {{'O', '0'},
        {'M', '1'},
        {'Y', '2'},
        {'E', '5'},
        {'N', '6'},
        {'D', '7'},
        {'R', '8'},
        {'S', '9'}};
        System.out.println(isCryptSolution(crypt,solution));
    }
    static boolean isCryptSolution(String[] crypt, char[][] solution) {
        Map<Character,Integer> m = new HashMap<>();
        for (char[] chars : solution) {
            m.put(chars[0], (int) chars[1]-'0');
        }
        int sumleft = 0;
        for(int i = 0; i < crypt.length-1; i++){
            int sum = 0;
            for(int j = 0; j < crypt[i].length(); j++){
                char c = crypt[i].charAt(j);
                if((m.get(c) == 0 && sum == 0) && crypt[j].length()>0)
                    return false;
                sum = sum*10 + m.get(c);
            }
            sumleft+=sum;
        }
        int sum2 = 0;
        for(int k = 0; k < crypt[2].length(); k++){
            char c = crypt[2].charAt(k);
            if((m.get(c) == 0 && sum2 == 0) && crypt[2].length()>0)
                return false;
            sum2 = sum2*10 + m.get(c);
        }
        return sumleft==sum2;
    }

}
