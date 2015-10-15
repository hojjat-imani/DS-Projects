/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skyline;

import java.util.ArrayList;

/**
 *
 * @author Hojjat
 */
public class Building {

    ArrayList<CriticalPoint> points;

    public Building() {
        points = new ArrayList<>();
    }

    public Building(double start, double end, double height) {
        points = new ArrayList<>();
        points.add(new CriticalPoint(start, height));
        points.add(new CriticalPoint(end, 0));
    }

    public int getNumberOfPoints() {
        return points.size();
    }

    public CriticalPoint getPoint(int index) {
        if (index >= points.size()) {
            return new CriticalPoint(Integer.MAX_VALUE, -1);
        }
        return points.get(index);
    }

    public double getLastPointHeight() {
        if (getNumberOfPoints() == 0) {
            return -1;
        } else {
            return points.get(points.size() - 1).getHeight();
        }
    }

    public void addPoint(CriticalPoint point) {
        points.add(point);
    }

    public void print() {
        System.out.println("-----------------------------");
        for (CriticalPoint point : points) {
            point.print();
        }
    }
}
