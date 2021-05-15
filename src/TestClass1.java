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
class TestClass1 {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println(t);
        //sc.nextLine();
        for(int i = 0; i < t; i++){
            //  Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(n);
            sc.nextLine();
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                String s = sc.nextLine();
                System.out.println(s);
                if(s.charAt(0) == 'L'){
                    // int t1 = Integer.getInteger(s.replaceAll("[\\D]",""));
                    // int t1 = sc.nextInt();
                    int t1 = Integer.parseInt(s.substring(2));
                    System.out.println(t1);
                    if(t1 < max)
                        max = t1;
                  //  sc.nextLine();
                }
                if(s.charAt(0) == 'R'){
                    // int t2 = Integer.getInteger(s.replaceAll("[\\D]",""));
                    // int t2 = sc.nextInt();
                    int t2 = Integer.parseInt(s.substring(2));
                    System.out.println(t2);
                    if(t2 > min)
                        min = t2;
                  //  sc.nextLine();
                }
            }
            if(max > min)
                System.out.println(max - min -1);
            else
                System.out.println("-1");
        }
    }
}

