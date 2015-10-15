
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hojjat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Matrix> matrixs = new ArrayList<>();
        matrixs.add(new Matrix("A1", 30, 35));
        matrixs.add(new Matrix("A2", 35, 15));
        matrixs.add(new Matrix("A3", 15, 5));
        matrixs.add(new Matrix("A4", 5, 10));
        matrixs.add(new Matrix("A5", 10, 20));
        matrixs.add(new Matrix("A6", 20, 25));
        MatrixMultiply solver = new MatrixMultiply(matrixs);
        solver.getBestMultiplyOrder();
        solver.printResult();
    }   
}