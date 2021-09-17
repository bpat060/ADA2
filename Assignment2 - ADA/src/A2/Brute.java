package A2;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class Brute extends Polygon {

    ArrayList<Polygon> shapes = new ArrayList<Polygon>();
    Polygon hexagon = new Polygon();

    public Brute() {

    }

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

            for (int a = 0; a < x; a++) {
                boolean flag = true;
                for (int j = 0; j < y; j++) {
                    if (hexagon.pointList[j + a].x != hexagon.pointList[j].y) {
                        flag = false;
                    } else {
                        break;
                    }
                }
                if (true == flag) {
                    System.out.println("Pattern found at index: " + i);
                } else {
                    break;
                }
            }
        }

//        match(hexagon.pointList[i].getX(), hexagon.pointList[i].getY());
    }

}
