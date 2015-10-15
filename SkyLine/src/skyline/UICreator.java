/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skyline;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author 123
 */
public class UICreator{
    ArrayList<Building> buildings=null;
    FileReader reader;
    JPanel drawerPannel;
    JFrame frame;
    Building result;
    public UICreator(){
        createUI();
    }
     private void createUI() {
         reader=new FileReader();
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(500, 500));        
//        Drawer drawer = new Drawer(null);
        frame.setLayout(new BorderLayout());
//        drawerPannel.setPreferredSize(new Dimension(500, 400));
//        drawerPannel.setSize(new Dimension(500, 400));        
        JButton saveBtn = new JButton("Save");
        JButton openBtn = new JButton("Open");
        drawerPannel = new JPanel();
        drawerPannel.setVisible(true);
        drawerPannel.setLayout(new BorderLayout());

        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(result != null){
                JFileChooser saveFile = new JFileChooser();
                saveFile.showSaveDialog(null);
                    new FileWriter_().writeFile(saveFile.getSelectedFile().getAbsolutePath(), result, reader.BuildCount);
                }                
            }
        });

        openBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser openFile = new JFileChooser();
                openFile.showOpenDialog(null);
                try {
                    buildings=new ArrayList<Building>();
                    buildings= reader.readFile(openFile.getSelectedFile().getAbsolutePath());
                } catch (Exception ex) {
                    Logger.getLogger(UICreator.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(!buildings.isEmpty()){
                   drawerPannel.removeAll();
                   result = new SkyLineSolver().getSkyLine(new BuildingGroup(buildings));
                   result.print();
                   drawerPannel.add(new Drawer(result), BorderLayout.CENTER);
                   frame.pack();
                   frame.setVisible(true);
                }
            }
        });

        //frame.add(new Drawer(points), BorderLayout.CENTER);
        frame.add(new JLabel("File Chooser"), BorderLayout.NORTH);
        frame.add(saveBtn, BorderLayout.SOUTH);
        frame.add(openBtn, BorderLayout.NORTH);
        frame.add(drawerPannel, BorderLayout.CENTER);
        frame.setTitle("File Chooser");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}