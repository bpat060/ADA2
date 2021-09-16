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
class Polygon {

    //list of points aka point[1] can consist of x=1, y=2....whatever we set it to be.
    //adding a new point is all done in GUI class
    public Point[] p;
    // number of points in the polygon
    public int n;

    //default constructor of a polygon
    public Polygon() {
        n = 0;
        //point number doesnt really matter for now.
        p = new Point[6];

    }

    public Polygon(Point[] p, int n) {
        this.p = p;
        this.n = n;
    }

    public int size() {
        return n;
    }

    //getting total perimeter of the polygon
    public double perimeter() {
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum = sum + p[i].distance(p[i + 1]);
        }
        return sum;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        //joining the first to last points
        for (int i = 0; i < n - 1; i++) {
            g.drawLine(p[i].x, p[i].y, p[i + 1].x, p[i + 1].y);
        }
        //joininig first and last point
        g.drawLine(p[0].x, p[0].y, p[n - 1].x, p[n - 1].y);
    }

    //calculating area of polygon
    public double getArea() {
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum = sum + (p[i].x * p[i + 1].y) - (p[i].y * p[i + 1].x);
        }
        return 0.5 * sum;
    }

    //resizing point array
    private void resize() {
        Point[] temp = new Point[2 * n + 1];
        for (int i = 0; i <= n; i++) {
            temp[i] = p[i];
        }
        p = temp;
    }

    public void addPoint(Point name) {
        //resizing array if needed
        if (n >= p.length - 1) {
            resize();
        }
        //adding point
        p[n++] = name;
        //closing polygon
        p[n] = p[0];

    }

}
