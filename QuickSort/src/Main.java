
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
        Random randomGenerator = new Random();
        QuickSorter sorter = new QuickSorter();
        int[] array = new int[10000];
        for(int i = 0 ; i < array.length ; i++){
            array[i] = randomGenerator.nextInt();
        }
        Long start = System.nanoTime();
        int compares = sorter.sort(array);
        Long end = System.nanoTime();
        Long durarionTime = end - start;
        System.out.println("time : " + durarionTime);
        System.out.println("compares : " + compares);
        System.out.println("");
    }
    
}
