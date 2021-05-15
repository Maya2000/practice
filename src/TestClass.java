/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.util.*;
import java.lang.*;

class TestClass {
    public static void main(String[] args) {
        List<Integer> l = generatePrime(50);
        for (int a : l) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> generatePrime(int n) {
        List<Integer> l = new ArrayList<>();
        Map<Integer, Boolean> m = new HashMap<>();
        for(int b = 2; b <= n; b++){
            m.put(b,false);
        }
        int i = 2;
        while (i < n) {
            for (int j = 2 * i; j <= n; j += i) {
                m.put(j, true);
            }
            int k = 0;
            for ( k = i + 1; k <= n; k++) {
                if (m.get(k) == false) {
                    i = k;
                    break;
                }
                if(k == n)
                    i = n;
            }
        }
        for (int a = 2; a <= n; a++) {
            if (m.get(a) != true)
                l.add(a);
        }
        return l;
    }
}
  /*  public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        HashMap<Integer, Boolean> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            m.put(i, false);
        }
        int g1 = 0, g2 = 0;
        g1 += a[maxIndex(a, 0, n - 1, m)];
        int last = maxIndex(a, 0, n - 1, m);
        m.put(last, true);
        for (int k = 1; k < n; k++) {
            int max1 = 0, max2 = 0;
            boolean next = false, prev = false;
            if (last + 1 < n) {
                if (!m.get(last + 1)) {
                    max1 = a[last + 1];
                    next = true;
                }
            }
            if (last - 1 >= 0) {
                if (!m.get(last - 1)) {
                    max2 = a[last - 1];
                    prev = true;
                }
            }
            if (!(next || prev)) {
                if (k % 2 == 0) {
                    int m1 = 0, m2 = 0;
                    if (last - 1 >= 0)
                        m1 = a[maxIndex(a, 0, last - 1, m)];
                    if (last + 1 < n)
                        m2 = a[maxIndex(a, last + 1, n - 1, m)];
                    g1 += (m1 > m2) ? m1 : m2;
                    if (m1 > m2) {
                        last = maxIndex(a, 0, last - 1, m);
                    } else if (m1 < m2) {
                        last = maxIndex(a, last + 1, n - 1, m);
                    }
                    m.put(last, true);
                } else {
                    int m3 = 0, m4 = 0;
                    if (last - 1 >= 0 && !alltrue(a, 0, last - 1, m))
                        m3 = a[maxIndex(a, 0, last - 1, m)];
                    if (last + 1 < n && !alltrue(a, last + 1, n - 1, m))
                        m4 = a[maxIndex(a, last + 1, n - 1, m)];
                    g2 += (m3 > m4) ? m3 : m4;
                    if (m3 > m4) {
                        last = maxIndex(a, 0, last - 1, m);
                    } else if (m3 < m4) {
                        last = maxIndex(a, last + 1, n - 1, m);
                    }
                    m.put(last, true);
                }
            } else {
                if (k % 2 == 0) {
                    g1 += (max1 > max2) ? max1 : max2;
                    last = (max1 > max2) ? last + 1 : last - 1;
                    m.put(last, true);
                } else {
                    g2 += (max1 > max2) ? max1 : max2;
                    last = (max1 > max2) ? last + 1 : last - 1;
                    m.put(last, true);
                }
            }
        }
        System.out.println(g1 + " " + g2);
    }

    public static boolean alltrue(int[] a, int l, int h, HashMap<Integer, Boolean> map) {
        for (int z = l; z < h; z++) {
            if (!map.get(z))
                return false;
        }
        return true;
    }

    public static int maxIndex(int[] a, int l, int h, HashMap<Integer, Boolean> map) {
        int out = l;
        int maxval = 0;
        for (int j = l + 1; j <= h; j++) {
            if (a[j] > maxval && map.get(j) == false) {
                maxval = a[j];
                out = j;
            }
        }
        return out;
    }*/

