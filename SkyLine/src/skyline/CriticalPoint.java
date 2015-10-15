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
public class CriticalPoint {

    private double position;
    private double height;

    public CriticalPoint(double position, double height) {
        this.position = position;
        this.height = height;
    }

    /**
     * @return the position
     */
    public double getPosition() {
        return position;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    public void print() {
        System.out.println("-position : " + position + "        -height : " + height);
    }

    @Override
    public String toString() {
        return position + " " + height;
    }
}
