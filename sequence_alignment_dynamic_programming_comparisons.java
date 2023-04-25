//Derek J. Trevens
//Date: 4/20/23
//Sequence Alignment using Dynamic Programming
//Find the cost of an optimal DNA sequence alignment

import java.lang.Math;

import javax.lang.model.util.ElementScanner14;

//Sequence alignment utilizing dynamic programming

public class sequence_alignment_dynamic_programming_comparisons{
    
    private static int comparisons = 0;
    private static char[] x = {'T', 'A', 'A', 'G', 'G', 'T', 'C', 'A'};
    private static char[] y = {'A', 'A', 'C', 'A', 'G', 'T', 'T', 'A', 'C', 'C'};
    private static int m = x.length;
    private static int n = y.length;
    private static int[][] resultTable = new int[n + 1][m + 1];
    
    public static void main(String[] args){
        long start = System.nanoTime();
        int optimalCost = opt(0, 0);
        long end = System.nanoTime();
        System.out.println("Time elapsed: " + Long.toString(end - start) + " nanoseconds");
        System.out.println("There were " + comparisons + " comparisons in the algorithm");
        printResultTable();
        System.out.println("\nThe optimal cost of alignment is " + optimalCost);
    }

    public static int opt(int i, int j){
        if (resultTable[i][j] != 0){
            comparisons++;
            return resultTable[i][j];
        }
        
        if (i == n){//Bottom Row Base Case
            comparisons++;
            resultTable[i][j] = 2 * (m - j);
        } else if (j == m){//Right Row Base Case
            comparisons++;
            resultTable[i][j] = 2 * (n - i);
        } else {
            comparisons++;

            int penalty = (x[j] == y[i] ? 0 : 1);
            comparisons++;

            resultTable[i][j] = Math.min(opt(i + 1, j + 1) + penalty, Math.min(opt(i + 1, j) + 2, opt(i, j + 1) + 2));
            comparisons += 2;
        }

        return resultTable[i][j];
    }

    public static void printResultTable(){
        System.out.print("\t\t");
        for (int xv: x){
            System.out.print("\t");
            System.out.print(Character.toString(xv));
        }
        
        for (int i = 0; i <= n; i++){
            if (i < n){
                System.out.print("\n " + Character.toString(y[i]) + "\t" + i + "\t|\t");
            } else {
                System.out.print("\n\t" + i + "\t|\t");
            }
            
            for (int j = 0; j <= m; j++){
                System.out.print(resultTable[i][j] + "\t");
            }
        }
    }
}