/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skyline;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 123
 */
public class FileReader{
    
    private ArrayList<Building> buildings;
    public int BuildCount;
    
    public FileReader(){
        buildings=null;
        BuildCount=0;
    }
    
    public ArrayList<Building> readFile(String fileName){
        try{
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            if((line = br.readLine()) != null){
                BuildCount=Integer.parseInt(line);
            }
            buildings=new ArrayList<Building>();
            for(int i=0; i<BuildCount && (line = br.readLine()) != null; i++){
                addBuilding(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        }catch (Exception ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buildings;
    }
    
    private void addBuilding(String building){
        String[] buildingPro=building.split(" ");
        
        double left=Double.parseDouble(buildingPro[0]);
        double right=Double.parseDouble(buildingPro[1]);
        double height=Double.parseDouble(buildingPro[2]);
        
        buildings.add(new Building(left, right, height));
    }
}