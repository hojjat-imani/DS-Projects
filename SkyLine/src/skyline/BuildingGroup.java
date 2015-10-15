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
public class BuildingGroup {

    ArrayList<Building> buildings;

    public BuildingGroup() {
        buildings = new ArrayList<>();
    }

    public BuildingGroup(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public int getNumberOfBuildings() {
        return buildings.size();
    }
    
    public Building getBuilding(int index){
        return buildings.get(index);
    }
    
    public BuildingGroup getFirstPart(){
        ArrayList<Building> firstPartBuildings = new ArrayList<>();
        for(int i = 0; i < buildings.size() / 2 ; i++){
            firstPartBuildings.add(buildings.get(i));
        }
        return new BuildingGroup(firstPartBuildings);
    }
    
    public BuildingGroup getSecondPart(){
        ArrayList<Building> secondPartBuildings = new ArrayList<>();
        for(int i = buildings.size() - 1; i >= buildings.size() / 2 ; i--){
            secondPartBuildings.add(buildings.get(i));
        }
        return new BuildingGroup(secondPartBuildings);
    }
}
