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
public class SkyLineSolver {

    public Building getSkyLine(BuildingGroup bg) {
//        System.out.println("getSkyLine bg size : " + bg.getNumberOfBuildings());
        if (bg.getNumberOfBuildings() == 0) {
            //TODO not handled yet
            System.err.println("bg.getNumberOfBuildings() == 0");
        } else if (bg.getNumberOfBuildings() == 1) {
            return bg.getBuilding(0);
        } else {
            return mergeBuildingGroups(getSkyLine(bg.getFirstPart()), getSkyLine(bg.getSecondPart()));
        }
        return null;
    }

    public Building mergeBuildingGroups(Building b1, Building b2) {
        Building result = new Building();
        int i = 0, j = 0;
        double lastHeightB1 = -1;
        double lastHeightB2 = -1;
        while (i < b1.getNumberOfPoints() || j < b2.getNumberOfPoints()) {
            CriticalPoint p1 = b1.getPoint(i);
            CriticalPoint p2 = b2.getPoint(j);

            if (p1.getPosition() < p2.getPosition()) {
                if (p1.getHeight() != result.getLastPointHeight() && Math.max(p1.getHeight(), lastHeightB2) != result.getLastPointHeight()) {
                    result.addPoint(new CriticalPoint(p1.getPosition(), Math.max(p1.getHeight(), lastHeightB2)));
                }
                lastHeightB1 = p1.getHeight();
                i++;
            } else if (p2.getPosition() < p1.getPosition()) {
                if (p2.getHeight() != result.getLastPointHeight() && Math.max(p2.getHeight(), lastHeightB1) != result.getLastPointHeight()) {
                    result.addPoint(new CriticalPoint(p2.getPosition(), Math.max(p2.getHeight(), lastHeightB1)));
                }
                j++;
                lastHeightB2 = p2.getHeight();
            } else {

                if (Math.max(p1.getHeight(), p2.getHeight()) != result.getLastPointHeight()) {
                    result.addPoint(new CriticalPoint(p1.getPosition(), Math.max(p1.getHeight(), p2.getHeight())));
                }
                lastHeightB1 = p1.getHeight();
                lastHeightB2 = p2.getHeight();
                i++;
                j++;
            }
        }
        return result;
    }
}
