/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hojjat
 */
public class Node<DataType> {
    DataType data;
    Node<DataType> next;
    Node<DataType> previous;
    public Node(DataType data, Node<DataType> next, Node<DataType> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }   
}
