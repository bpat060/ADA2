/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Owner
 */
public class Polygon {

    //list of points aka point[1] can consist of x=1, y=2....whatever we set it to be.
    //adding a new point is all done in GUI class
    public Point[] pointList;
    // number of points in the polygon
    public int numPoints;

    //default constructor of a polygon
    public Polygon() {
        numPoints = 0;
        //point number doesnt really matter for now.
        pointList = new Point[6];

    }

    public Polygon(Point[] p, int n) {
        this.pointList = p;
        this.numPoints = n;
    }

    public int size() {
        return numPoints;
    }

    //getting total perimeter of the polygon
    public double perimeter() {
        double sum = 0.0;
        for (int i = 0; i < numPoints; i++) {
            sum = sum + pointList[i].distance(pointList[i + 1]);
        }
        return sum;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        //joining the first to last points
        for (int i = 0; i < numPoints - 1; i++) {
            g.drawLine(pointList[i].x, pointList[i].y, pointList[i + 1].x, pointList[i + 1].y);
        }
        //joininig first and last point
        g.drawLine(pointList[0].x, pointList[0].y, pointList[numPoints - 1].x, pointList[numPoints - 1].y);
    }

    //calculating area of polygon
    public double getArea() {
        double sum = 0.0;
        for (int i = 0; i < numPoints; i++) {
            sum = sum + (pointList[i].x * pointList[i + 1].y) - (pointList[i].y * pointList[i + 1].x);
        }
        return 0.5 * sum;
    }

    //resizing point array
    private void resize() {
        Point[] temp = new Point[2 * numPoints + 1];
        for (int i = 0; i <= numPoints; i++) {
            temp[i] = pointList[i];
        }
        pointList = temp;
    }

    public void addPoint(Point name) {
        //resizing array if needed
        if (numPoints >= pointList.length - 1) {
            resize();
        }
        //adding point
        pointList[numPoints++] = name;
        //closing polygon
        pointList[numPoints] = pointList[0];
    }

    public double getX(Point x) {
        Point pointX = null;
        for (int i = 0; i <= numPoints; i++) {
            if (pointList[i].equals(x)) {
                pointX = pointList[i];
            }
        }
        return pointX.x;
    }

    public double getY(Point y) {
        Point pointY = null;
        for (int i = 0; i <= numPoints; i++) {
            if (pointList[i].equals(y)) {
                pointY = pointList[i];
            }
        }
        return pointY.y;
    }

    public String toString() {
        if (numPoints == 0) {
            return "[ ]";
        }
        String s = "";
        s = s + "[";
        for (int i = 0; i <= numPoints; i++) {
            s = s + pointList[i].x + ", " + pointList[i].y + "] [";
        }
        s = s + "]";
        return s;
    }
}
