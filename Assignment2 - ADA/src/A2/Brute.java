/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2;

import java.awt.Point;

/**
 *
 * @author Owner
 */
public class Brute {

    Polygon hexagon = new Polygon();

    public Brute() {
        for (int i = 0; i < 6; i++) {
            hexagon.addPoint(new Point((int) (100 + 50 * Math.cos(n * 2 * Math.PI / 6)), (int) (100 + 50 * Math.sin(n * 2 * Math.PI / 6))));
        }

        shapes.add(hexagon);

        for (int i = 0;
                i < 7; i++) {
            Point location = hexagon.pointList[n];
            String locationString = "v" + n + " = [" + location.x + "," + location.y + "]";
            System.out.println(locationString);

        }

    }

}
