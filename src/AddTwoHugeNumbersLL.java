public class AddTwoHugeNumbersLL {
    public static void main(String[] args) {
        ListNode<Integer> a = new ListNode<>(0);
      //  a.next = new ListNode<>(5432);
      //  a.next.next = new ListNode<>(1999);
        ListNode<Integer> b = new ListNode<>(2789);
       // b.next = new ListNode<>(9999);
      //  b.next.next = new ListNode<>(9999);
       // b.next.next.next = new ListNode<>(9999);
        ListNode<Integer> out = addTwoHugeNumbers(a, b);
        while (out != null) {
            System.out.print(out.value + " ");
            out = out.next;
        }
    }

    static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> l1 = reverse(a), l2 = reverse(b), out = new ListNode(0), ans = out;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int num1 = l1.value, num2 = l2.value;
            StringBuilder sb = new StringBuilder();
            while (num1 > 0 && num2 > 0) {
                int sum = num1%10 + num2%10 + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                num1 /= 10;
                num2 /= 10;
            }
            while(num1 > 0) {
                int sum = num1%10 + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                num1 /= 10;
            }
            while(num2 > 0) {
                int sum = num2%10 + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                num2 /= 10;
            }

            sb.reverse();
            String s = sb.toString();
            ans.value = (s.equals(""))?0:Integer.valueOf(s);
            ans.next = new ListNode(0);
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int num = l1.value;
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                int sum = num%10 + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                num /= 10;
            }
            sb.reverse();
            String s = sb.toString();
            ans.value = (s.equals(""))?0:Integer.valueOf(s);
            ans.next = new ListNode(0);
            ans = ans.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            int num = l2.value;
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                int sum = num%10 + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                num /= 10;
            }
            sb.reverse();
            String s = sb.toString();
            ans.value = (s.equals(""))?0:Integer.valueOf(s);
            ans.next = new ListNode(0);
            ans = ans.next;
            l2 = l2.next;
        }
        if(carry != 0){
            ans.value = carry;
        }
        ListNode<Integer> helper = reverse(out);
        return (helper.value != 0)?helper:helper.next;
    }

    static ListNode<Integer> reverse(ListNode<Integer> l) {
        if (l == null || l.next == null)
            return l;
        ListNode<Integer> temp = reverse(l.next);
        ListNode<Integer> helper = temp;
        l.next = null;
        while (helper.next != null) {
            helper = helper.next;
        }
        helper.next = l;
        return temp;
    }

    /*static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        String numa = getNum(a), numb = getNum(b);
        int la = numa.length(), lb = numb.length();
        int i = la-1, j = lb-1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = (int) numa.charAt(i) - '0' + (int) numb.charAt(j) - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (i == 0) {
            while (j >= 0) {
                int sum = (int) numb.charAt(j) - '0' + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                j--;
            }
        } else {
            while (i >= 0) {
                int sum = (int) numa.charAt(i) - '0' + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                i--;
            }
        }
        sb.reverse();
        ListNode<Integer> out = new ListNode<>(0);
        ListNode<Integer> ans = out;
        i = 0;
        while (i < sb.length()) {
            int digits = 0;
            while (digits < 4 && i < sb.length()) {
                ans.value = 10*ans.value + (int) sb.charAt(i) - '0';
                i++;
                digits++;
            }
            if (i < sb.length())
                ans.next = new ListNode(0);
            ans = ans.next;
        }
        return out;
    }

    static String getNum(ListNode<Integer> l) {
        StringBuilder sb = new StringBuilder();
        while (l != null) {
            sb.append(Integer.toString(l.value));
            l = l.next;
        }
        return sb.toString();
    }*/


    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }
}

 /* if(num1 == 0 || num2 == 0){
                if(num1 == 0 && num2 == 0)
                ans.value = carry;
                else if(num1 == 0 && num2 != 0)
                    ans.value = num2+carry;
                else
                    ans.value = num1+carry;
                ans.next = new ListNode(0);
                ans = ans.next;
                l1 = l1.next;
                continue;
            }*/