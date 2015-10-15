
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
public class LinkedList {

    Node first;

    public void add(int value) {
        Node n = new Node(value, first);
        first = n;
    }

    public void print() {
        Node processingNode = first;
        ArrayList<Integer> stack = new ArrayList<>();
        for (; processingNode != null; processingNode = processingNode.next) {
            stack.add(processingNode.value);
        }
        for (int i = stack.size() - 1; i > -1; i--) {
            if (i == stack.size() - 1) {
                System.out.print("" + stack.get(i));
            } else {
                System.out.print("" + (stack.get(i) > 99 ? stack.get(i) : (stack.get(i) > 9 ? "0" + stack.get(i) : "00" + stack.get(i))));
            }
        }
        System.out.println("");
    }
}
