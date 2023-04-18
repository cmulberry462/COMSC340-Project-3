//Author: Connor Mulberry
//Date: 4/18/23
//Sequence Alignment Using Divide and Conquer
//Finds the cost of an optimal alignment between two DNA sequences

import java.lang.Math;

public class sequenceAlignment {

    private static char[] x = {'T', 'C', 'G', 'A', 'A', 'G', 'G', 'G', 'T', 'A'};
    private static char[] y = {'C', 'T', 'G', 'T', 'G', 'T', 'A', 'C', 'A', 'A'};
    private static int m = x.length;
    private static int n = y.length;

    public static void main(String[] args) {
        int optimalCost = findOpt(0, 0);
        System.out.println("The cost of an optimal alignment is: " + optimalCost);
    }


    public static int findOpt(int i, int j) {
       int opt;
       int penalty;
        if (i==m) {
            opt = 2*(n-j);
        } else if (j == n) {
            opt = 2*(m-i);
        } else {
            if (x[i] == y[j]) {
                penalty = 0;
            }else {
                penalty = 1;
            }
            int opt1 = findOpt(i+1, j+1) + penalty;
            int opt2 = findOpt(i+1, j) + 2;
            int opt3 = findOpt(i, j+1) + 2;
            opt = Math.min(Math.min(opt1, opt2), opt3);
        }
        return opt;
    }
}


