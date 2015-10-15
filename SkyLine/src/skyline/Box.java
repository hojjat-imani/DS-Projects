/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skyline;

/**
 *
 * @author Hojjat
 */
public class Box {
    double height, left, right;
    public Box(double left, double right, double height) {
        this.left = left;
        this.right = right;
        this.height = height;
    }
    
    @Override
    public String toString() {
        return left+" "+height;
    }
}
