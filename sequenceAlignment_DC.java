//Author: Connor Mulberry
//Date: 4/18/23
//Sequence Alignment Using Divide and Conquer
//Finds the cost of an optimal alignment between two DNA sequences

import java.lang.Math;

public class sequenceAlignment_DC {

    private static char[] x = {'A', 'A'};
    private static char[] y = {'T', 'A'};
    private static int m = x.length;
    private static int n = y.length;
    static int comparisons;

    public static void main(String[] args) {
        long start = System.nanoTime();
        int optimalCost = findOpt(0, 0);
        long finish = System.nanoTime();
        long elapsed = finish-start;
        System.out.println("The cost of an optimal alignment is: " + optimalCost);
        System.out.println("Elapsed time: " + elapsed + " nanoseconds");
        System.out.println(comparisons + " comparisons performed");
    }


    public static int findOpt(int i, int j) {
       int opt;
       int penalty;
        if (i==m) {
            comparisons++;
            opt = 2*(n-j);
        } else if (j == n) {
            comparisons++;
            opt = 2*(m-i);
        } else {
            comparisons++;
            if (x[i] == y[j]) {
                comparisons++;
                penalty = 0;
            }else {
                comparisons++;
                penalty = 1;
            }
            int opt1 = findOpt(i+1, j+1) + penalty;
            int opt2 = findOpt(i+1, j) + 2;
            int opt3 = findOpt(i, j+1) + 2;
            opt = Math.min(Math.min(opt1, opt2), opt3);
            comparisons++;
            comparisons++;
        }
        return opt;
    }
}


