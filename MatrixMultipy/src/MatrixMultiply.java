
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hojjat
 */
public class MatrixMultiply {

    int[][] minCosts;
    int[][] bestDividers;

    ArrayList<Matrix> matrixs;

    public MatrixMultiply(ArrayList<Matrix> matrixs) {
        this.matrixs = matrixs;
        minCosts = new int[matrixs.size()][matrixs.size()];
        bestDividers = new int[matrixs.size()][matrixs.size()];
    }

    public void getBestMultiplyOrder() {
        int n = matrixs.size() - 1;
        for (int i = 0; i < matrixs.size(); i++) {
            minCosts[i][i] = 0;
        }
        for (int length = 2; length <= matrixs.size(); length++) {
            for (int i = 0; i <= matrixs.size() - length; i++) {
                int j = i + length - 1;
                minCosts[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = minCosts[i][k] + minCosts[k + 1][j] + matrixs.get(i).rows * matrixs.get(k).columns * matrixs.get(j).columns;
                    if (cost < minCosts[i][j]) {
                        minCosts[i][j] = cost;
                        bestDividers[i][j] = k;
                    }
                }
            }
        }
    }

    public void printResult(int i, int j) {
        if(i == j){
            System.out.print(matrixs.get(i).name);
        }else{
            System.out.print("(");
            printResult(i, bestDividers[i][j]);
            printResult(bestDividers[i][j] + 1, j);
            System.out.print(")");
        }
    }
    
    public void printResult(){
        printResult(0, matrixs.size() - 1);
    }
}
