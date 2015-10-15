
import java.util.ArrayList;
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
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Enter the first num: ");
        String input1 = inputReader.next();
        checkValidity(input1);
        System.out.println("Enter the second num: ");
        String input2 = inputReader.next();
        checkValidity(input2);
        LinkedList num1 = makeLinkList(input1);
        LinkedList num2 = makeLinkList(input2);
        LinkedList result = sum(num1, num2);
        System.out.println("The result is: ");
        result.print();
    }

    private static LinkedList makeLinkList(String num) {
        LinkedList linkedList = new LinkedList();
        if (num.length() % 3 != 0) {
            linkedList.add(Integer.parseInt(num.substring(0, num.length() % 3)));
        }
        for (int i = num.length() % 3; i < num.length(); i += 3) {
            linkedList.add(Integer.parseInt(num.substring(i, i + 3)));
        }
        return linkedList;
    }

    private static void checkValidity(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                System.err.println("Invalid number!!!");
                System.exit(-1);
            }
        }
    }

    private static LinkedList sum(LinkedList num1, LinkedList num2) {
        LinkedList result = new LinkedList();
        int carry = 0;
        Node num1ProcessingNode = num1.first;
        Node num2ProcessingNode = num2.first;
        int num1ProcessingNodeValue;
        int num2ProcessingNodeValue;
        ArrayList<Integer> stack = new ArrayList<>();
        while (num1ProcessingNode != null || num2ProcessingNode != null) {
            num1ProcessingNodeValue = (num1ProcessingNode == null ? 0 : num1ProcessingNode.value);
            num2ProcessingNodeValue = (num2ProcessingNode == null ? 0 : num2ProcessingNode.value);
            stack.add((num1ProcessingNodeValue + num2ProcessingNodeValue + carry) % 1000);
            carry = (num1ProcessingNodeValue + num2ProcessingNodeValue + carry) / 1000;
            num1ProcessingNode = (num1ProcessingNode == null ? null : num1ProcessingNode.next);
            num2ProcessingNode = (num2ProcessingNode == null ? null : num2ProcessingNode.next);
        }
        if (carry != 0) {
            stack.add(carry);
        }
        for (int i = stack.size() - 1; i > -1; i--) {
            result.add(stack.get(i));
        }
        return result;
    }
}
