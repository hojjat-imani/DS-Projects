/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motevazen;

import java.util.ArrayList;

/**
 *
 */
public class Stack {

    char[] stack;
    int topOfStack = 0;

    //size: inital size for the stack
    public Stack(int size) {
        stack = new char[size];
    }

    public boolean push(char c) {
        if (isFull()) {
            return false;
        }
        stack[topOfStack] = c;
        topOfStack++;
        return true;
    }

    public Character pop() {
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
