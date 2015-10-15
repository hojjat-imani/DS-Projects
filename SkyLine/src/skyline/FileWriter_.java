/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skyline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author 123
 */
public class FileWriter_ {
    public void writeFile(String fileName, Building result, int num){
        try {
          File file = new File(fileName);
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          output.write(num+"\r\n");
          for(int i=0; i<result.getNumberOfPoints(); i++){
                output.write(result.getPoint(i).toString()+"\r\n");
            }
          output.close();
        } catch ( IOException e ) {
           e.printStackTrace();
        }
    }
}
