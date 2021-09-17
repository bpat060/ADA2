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

    public static void main(String[] arg) {

        ArrayList<Polygon> shapes = new ArrayList<Polygon>();
        Polygon hexagon = new Polygon();

        for (int i = 0; i < 6; i++) {
            hexagon.addPoint(new Point((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 6)), (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 6))));
        }

        shapes.add(hexagon);

        for (int i = 0; i < 7; i++) {
            Point location = hexagon.pointList[i];
            String locationString = "v" + i + " = [" + location.x + "," + location.y + "]";
            System.out.println(locationString);

            int x = (int) hexagon.pointList[i].getX();
            int y = (int) hexagon.pointList[i].getY();
            int N = hexagon.numPoints;

            //Check condition
            if (IsValidOne(hexagon, x, y)) {
                //Initialize
                hexagon.pointList[x][y] = 1;
                //Check condition
                if (x == N - 1) {
                    //Update
                    isFound = true;

                    //Function call
                    ShowBoard(hexagon);
                }
                //Function call
                NQueenFunc(N, hexagon, x + 1, 0, isFound);
            } //Otherwise
            else {
                //Loop
                while (y >= N - 1) {
                    //Function call
                    int[] arr = BackTrackingDFSGreedy(hexagon, x, y);
                    //Update
                    x = arr[0];
                    y = arr[1];
                }
                //Function call
                NQueenFunc(N, hexagon, x, y + 1, false);
            }
        }
    }

    private static void ShowBoard(Polygon hexagon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int[] BackTrackingDFSGreedy(Polygon hexagon, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean IsValidOne(Polygon hexagon, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
