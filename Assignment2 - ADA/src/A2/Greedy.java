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

            double x = hexagon.pointList[i].getX();
            double y = hexagon.pointList[i].getY();

            //Check condition
            if (Polygon.class == !isFound) {
                //Check condition
                if (IsValidOne(qBoard, i1, j1)) {
                    //Initialize
                    qBoard[i1][j1] = 1;

                    //Check condition
                    if (i1 == N - 1) {
                        //Update
                        isFound = true;

                        //Function call
                        ShowBoard(qBoard);
                    }

                    //Function call
                    NQueenFunc(N, qBoard, i1 + 1, 0, isFound);
                } //Otherwise
                else {
                    //Loop
                    while (j1 >= N - 1) {
                        //Function call
                        int[] arr = BackTrackingDFSGreedy(qBoard, i1, j1);

                        //Update
                        i1 = arr[0];
                        j1 = arr[1];
                    }

                    //Function call
                    NQueenFunc(N, qBoard, i1, j1 + 1, false);
                }
            }
        }
    }
}
