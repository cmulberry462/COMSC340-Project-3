//Derek J. Trevens
//Date: 4/20/23
//Sequence Alignment using Dynamic Programming
//Find the cost of an optimal DNA sequence alignment

import java.lang.Math;

//Sequence alignment utilizing dynamic programming

public class sequence_alignment {
    
    private static char[] x = {'T', 'A', 'A', 'G', 'G', 'T', 'C', 'A'};
    private static char[] y = {'A', 'A', 'C', 'A', 'G', 'T', 'T', 'A', 'C', 'C'};
    private static int m = x.length;
    private static int n = y.length;
    private static int[][] resultTable = new int[n + 1][m + 1];
    
    public static void main(String[] args){

        int optimalCost = opt(0, 0);
        printResultTable();
        System.out.println("\nThe optimal cost of alignment is " + optimalCost);
    }

    public static int opt(int i, int j){
        //Base cases

        System.out.print(i + "; " + j + "\n");
        if (resultTable[i][j] != 0){
            System.out.print("Found\n");
            return resultTable[i][j];
        }
        

        if (i == n){//Bottom Row Base Case
            System.out.print("Bottom\n");
            resultTable[i][j] = 2 * (m - j);
        } else if (j == m){//Right Row Base Case
            System.out.print("Right\n");
            resultTable[i][j] = 2 * (n - i);
        } else {
            int penalty = (x[j] == y[i] ? 0 : 1);
            resultTable[i][j] = Math.min(opt(i + 1, j + 1) + penalty, Math.min(opt(i + 1, j) + 2, opt(i, j + 1) + 2));
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