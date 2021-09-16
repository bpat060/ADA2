/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.ada;

import java.awt.Point;

/**
 *
 * @author Owner
 */
//maybe polygon draws just 1 line and geometry repeats it if necesary.
class Polygon {

    Polygon triangle = new Polygon();
    public Point[] p;
    public int n;

    public Polygon() {
        n = 0;
        p = new Point[6];

    }

    public Polygon(Point[] p, int n) {
        this.p = p;
        this.n = n;
    }

//dont know what centroid is
    public Polygon getCentroid() {

        return triangle.getCentroid();
    }

    public double getArea() {
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum = sum + (p[i].x * p[i + 1].y) - (p[i].y * p[i + 1].x);
        }
        return 0.5 * sum;
    }

    public int getX() {
        return p[n].x;
    }

    public int getY() {
        return p[n].y;
    }

}
