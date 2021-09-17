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
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GUI extends JPanel implements ActionListener {

    private JButton addPolygonButton;
    private DrawPanel drawPanel;
    private Timer timer;
    private JLabel l;
    //list of triangles to be drawn
    ArrayList<Polygon> shapes = new ArrayList<Polygon>();

    public GUI() {
        super(new BorderLayout());

        JLabel label = new JLabel();
        add(label, BorderLayout.NORTH);

        l = new JLabel("Text");
        l.setText("label text");
        l.setForeground(Color.BLACK);
        label.add(l);

        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);

        addPolygonButton = new JButton("Add Polygon");
        addPolygonButton.addActionListener((ActionListener) this);
        southPanel.add(addPolygonButton);

        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        timer = new Timer(100, this);
        timer.start();

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addPolygonButton) {

            //creates a hexagon and loop fills in hegon points automatically
            Polygon hexagon = new Polygon();
            for (int i = 0; i < 6; i++) {
                hexagon.addPoint(new Point((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 6)), (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 6))));
            }
            //adding the hexagon to the list of Polygons
            shapes.add(hexagon);

            System.out.println("Points: " + hexagon);

            // int x = getX();
            for (int i = 0; i < 6; i++) {

                System.out.println(hexagon.getX());
            }

            System.out.println(l);

            //tip - how to make a polygon
            // make a emppty polygon......Polygon triangle = new Prolygon();
            //create points for it(im just making one so you know) by......Point p1 = new Point(0,2); 0 being the x coordinate and 2 being the y.
            //now add the point to the shape by.....triangle.addPoint(p1);
            //add that shape to the points list made above by......shapes.add(triangle);
        }

        if (source == timer) {
            drawPanel.repaint();
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
            //works when printing directly(without using button, recommend using the button tho)......
            // ......just uncomment the code below and comment out the for code under it.

//            Polygon hexagon = new Polygon();
//            for (int i = 0; i < 6; i++) {
//                hexagon.addPoint(new Point((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 6)), (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 6))));
//            }
//            hexagon.paint(g);
            ///
            //
            //prints polygon list shapes when button clicked.
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
