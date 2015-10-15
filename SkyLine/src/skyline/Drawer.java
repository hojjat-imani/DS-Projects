/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skyline;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author 123
 */
public class Drawer extends JLabel {

    ArrayList<Box> boxs;

    public Drawer(Building b) {
        this.boxs = new ArrayList<>();
        for (int i = 0; i <= b.getNumberOfPoints() - 2; i++) {
            boxs.add(new Box(b.getPoint(i).getPosition(), b.getPoint(i + 1).getPosition(), b.getPoint(i).getHeight()));
        }
        this.setBackground(Color.white);
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        int zoom = (int) (6000 / (14 * boxs.get(boxs.size() - 1).right));
        int panelHeight = 300;
        int prevHeight = 0;
        super.paintComponent(g);
        for (Box box : boxs) {
            g.setColor(Color.blue);
            int x = (int) box.left * zoom;
            int y = (int) (panelHeight - (box.height * zoom));
            int width = (int) (box.right - box.left) * zoom;
            int height = (int) (zoom * box.height);
            g.fillRect(x, y, width, height);

            g.setColor(Color.red);
            for (int i = 0; i < 3; i++) {
                g.drawLine(x + i, panelHeight - prevHeight, x + i, panelHeight - height);
                g.drawLine(x, panelHeight - height - i, x + width, panelHeight - height - i);
            }
            prevHeight = height;
        }

        g.drawLine(zoom * (int) boxs.get(boxs.size() - 1).right, panelHeight, zoom * (int) boxs.get(boxs.size() - 1).right, panelHeight - zoom * (int) boxs.get(boxs.size() - 1).height);
        g.drawLine(zoom * (int) boxs.get(0).left, panelHeight, zoom * (int) boxs.get(boxs.size() - 1).right, panelHeight);
        g.drawLine(zoom * (int) boxs.get(0).left, panelHeight - 1, zoom * (int) boxs.get(boxs.size() - 1).right, panelHeight - 1);
    }
}
