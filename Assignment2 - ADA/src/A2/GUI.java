/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2;

/**
 *
 * @author ynb9219
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel implements ActionListener {

    private JButton addPolygonButton;
    private DrawPanel drawPanel;
    //list of triangles to be drawn
    ArrayList<Polygon> shapes = new ArrayList<Polygon>();

    public GUI() {
        super(new BorderLayout());

        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);

        addPolygonButton = new JButton("Add Polygon");
        addPolygonButton.addActionListener((ActionListener) this);
        southPanel.add(addPolygonButton);

        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addPolygonButton) {

            //creates a hexagon and loop fills in hegon points automatically
            Polygon hexagon = new Polygon();
            for (int i = 0; i < 6; i++) {
                hexagon.add(new Point((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 6)), (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 6))));
            }
            //adding the hexagon to the list of Polygons
            shapes.add(hexagon);

            //tip - how to make a polygon
            // make a emppty polygon......Polygon triangle = new Prolygon();
            //create points for it(im just making one so you know) by......Point p1 = new Point(0,2); 0 being the x coordinate and 2 being the y.
            //now add the point to the shape by.....triangle.add(p1);
            //add that shape to the points list made above by......shapes.add(triangle);
        }

    }

    private class DrawPanel extends JPanel {

        private Random random = new Random();

        public DrawPanel() {
            super();
            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.WHITE);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //works when printing directly....just uncomment the code below and comment out the for code under it.

//            Polygon hexagon = new Polygon();
//            for (int i = 0; i < 6; i++) {
//                hexagon.add(new Point((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 6)), (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 6))));
//            }
//            hexagon.paint(g);
            //the one above works but then we have to code each polygon seperately here instead of having a button add one. 
            //trying to make it work when the polygon is put into a list.
            for (Polygon p : shapes) {
                p.paint(g);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Polygon Tessallation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GUI());
        frame.pack();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = frame.getSize();
        frame.setLocation((screenDimension.width - frameDimension.width) / 2, (screenDimension.height - frameDimension.height) / 2);
        frame.setVisible(true);
    }
}
