/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Sheetal
 */
public class Greedy {

    int num, x, y;
    Polygon hexagon;
    boolean isFound;

    public Greedy(int num, Polygon hexagon, int x, int y, boolean isFound) {
        this.num = num;
        this.hexagon = hexagon;
        this.x = x;
        this.y = y;
        this.isFound = isFound;
    }

    public void GreedyFunction(int num, Polygon hexagon, int x, int y, boolean isFound) {
        ArrayList<Polygon> shapes = new ArrayList<Polygon>();
        hexagon = new Polygon();

        for (int i = 0; i < 6; i++) {
            hexagon.addPoint(new Point((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 6)), (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 6))));
        }

        shapes.add(hexagon);

        for (int i = 0; i < 7; i++) {
            Point location = hexagon.pointList[i];
            String locationString = "v" + i + " = [" + location.x + "," + location.y + "]";
            System.out.println(locationString);

            x = (int) hexagon.pointList[i].getX();
            y = (int) hexagon.pointList[i].getY();
            num = hexagon.numPoints;
            isFound = false;

            //Check condition
            if (IsValidOne(hexagon, x, y)) {
                //Initialize
                hexagon.pointList[x].x = 1;
                hexagon.pointList[y].y = 1;
                //Check condition
                if (x == num - 1) {
                    //Update
                    isFound = true;

                    //Function call
                    Greedy(hexagon);
                }
                //Function call
                GreedyFunction(num, hexagon, x + 1, 0, isFound);
            } //Otherwise
            else {
                //Loop
                while (y >= num - 1) {
                    //Function call
                    int[] arr = TrackingGreedy(hexagon, x, y);
                    //Update
                    x = arr[0];
                    y = arr[1];
                }
                //Function call
                GreedyFunction(num, hexagon, x, y + 1, false);
            }
        }
    }

    public static void main(String[] arg) {

    }

    private static void Greedy(Polygon hexagon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int[] TrackingGreedy(Polygon hexagon, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean IsValidOne(Polygon hexagon, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
