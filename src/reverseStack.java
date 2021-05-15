import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for(int i = 9; i >= 0; i--){
            s.push(i);
        }
        System.out.println("old stack is");
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        for(int i = 9; i >= 0; i--){
            s.push(i);
        }
        reverse(s);
        System.out.println("new stack is");
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    static void insert_at_bottom(Stack<Integer> s, int key) {
        if (s.isEmpty())
            s.push(key);
        else {
            int temp = s.pop();
            insert_at_bottom(s, key);
            s.push(temp);
        }
    }

    public static void reverse(Stack<Integer> s) {
        if(s.isEmpty())
            return;
        else{
            int x = s.pop();
            reverse(s);
            insert_at_bottom(s,x);
        }
    }
}
