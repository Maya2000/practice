import java.util.Stack;

public class ReversePolishNumber {
    public static void main(String[] args) {
        String[] a = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(a));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int a = s.pop();
                int b = s.pop();
                switch (tokens[i]) {
                    case ("+"):
                        s.push(a + b);
                        break;
                    case ("-"):
                        s.push(b - a);
                        break;
                    case ("*"):
                        s.push(b * a);
                        break;
                    case ("/"): {
                        boolean positive = (a * b >= 0) ? true : false;
                        if (positive)
                            s.push(b / a);
                        else
                            s.push((int) Math.ceil(b / a));
                        break;
                    }
                }
            } else if (Integer.parseInt(tokens[i]) <= 200 && Integer.parseInt(tokens[i]) >= -200)
                s.push(Integer.valueOf(tokens[i]));
        }
        return s.pop();
    }
}
