/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hojjat
 */
public class LinkedList<DataType> {

    Node<DataType> first;

    public void add(DataType data) {
        Node<DataType> node = new Node<>(data, null, null);
        if (first == null) {
            first = node;
        } else {
            Node<DataType> p = first;
            boolean flag1 = false;
            while (((Student) p.data).grade < ((Student) data).grade) {
                if (p.next == null) {
                    flag1 = true;
                    break;
                }
                p = p.next;
            }
            if (flag1) {
                if (((Student) p.data).grade < ((Student) data).grade) {
                    node.previous = p;
                    p.next = node;
                } else if (p != first) {
                    p.previous.next = node;
                    node.previous = p.previous;
                    node.next = p;
                    p.previous = node;
                } else {
                    p.previous = node;
                    node.next = p;
                    first = node;
                }
            } else if (p == first) {
                p.previous = node;
                node.next = p;
                first = node;
            } else {
                p.previous.next = node;
                node.previous = p.previous;
                node.next = p;
                p.previous = node;
            }
        }
    }

    public void print() {
        if (first == null) {
            System.out.println("List is Empty.");
            return;
        }
        Node<DataType> p = first;
        while (p != null) {
            ((Student) p.data).print();
            p = p.next;
        }
    }

    public boolean show(int grade) {
        Node<DataType> p = first;
        boolean noResult = true;
        while (p != null && ((Student) p.data).grade <= grade) {
            if (((Student) p.data).grade == grade) {
                ((Student) p.data).print();
                noResult = false;
            }
            p = p.next;
        }
        return noResult;
    }

    public int showNext(int g) {
        int grade = g;
        boolean noResult = true;
        while (grade < 20) {
            grade++;
            if (!show(grade)) {
                noResult = false;
                break;
            }
        }
        if (noResult) {
            return g;
        }
        return grade;
    }

    public int showPrev(int g) {
        int grade = g;
        boolean noResult = true;
        while (grade > 0) {
            grade--;
            if (!show(grade)) {
                noResult = false;
                break;
            }
        }
        if (noResult) {
            return g;
        }
        return grade;
    }
}
