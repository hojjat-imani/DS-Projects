
import java.util.Scanner;

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
        Stack stack = new Stack(50);
        int input = 0;
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Enter the decimal: ");
        try {
            input = inputReader.nextInt();
        } catch (Exception e) {
            System.err.println("Something was wrong while getting the number.\nMake sure the number is not larger than " + Integer.MAX_VALUE);
            System.exit(-1);
        }
        if (input < 0) {
            System.out.println(" :-|  :-|   negative?????");
            System.exit(-1);
        }
        do {
            if (!stack.push(input % 2)) {
                System.err.println("Stack Size Is Not Enough!");
                System.exit(-1);
            }
            input /= 2;
        } while (input != 0);
        System.out.print("Binary: ");
        while (!stack.isEmpty()) {
            System.out.print("" + stack.pop());
        }
        System.out.println();
    }
}
