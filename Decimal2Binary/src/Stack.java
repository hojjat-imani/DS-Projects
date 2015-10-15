/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 */
public class Stack {

    int[] stack;
    int topOfStack = 0;

    //size: inital size for the stack
    public Stack(int size) {
        stack = new int[size];
    }

    public boolean push(int i) {
        if (isFull()) {
            return false;
        }
        stack[topOfStack] = i;
        topOfStack++;
        return true;
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        topOfStack--;
        return stack[topOfStack];
    }

    public boolean isEmpty() {
        if (topOfStack == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (stack.length == topOfStack) {
            return true;
        }
        return false;
    }
}
