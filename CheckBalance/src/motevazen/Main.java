/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motevazen;

import java.util.Scanner;

/**
 *
 * @author Hojjat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack stack = new Stack(15);
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Enter the statement: ");
        String input = inputReader.next();
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '{':
                case '(':
                case '[':
                    if (!stack.push(input.charAt(i))) {
                        System.err.println("Stack Size Is Not Enough!");
                        System.exit(-1);
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || '{' != stack.pop()) {
                        System.err.println("The statement is not balanced!");
                        System.exit(0);
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || '[' != stack.pop()) {
                    stack.pop();
                        System.err.println("The statement is not balanced!");
                        System.exit(0);
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || '(' != stack.pop()) {
                        System.err.println("The statement is not balanced!");
                        System.exit(0);
                    }
            }
        }
        if(stack.isEmpty()){
            System.out.println("The statement is balanced!");
        }else{
            System.err.println("The statement is not balanced!");
        }
    }
}
