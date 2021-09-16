/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.ada;

/**
 *
 * @author Owner
 */
//maybe polygon draws just 1 line and geometry repeats it if necesary.
class Polygon {

    Polygon triangle = new Polygon();
//dont know what centroid is

    public Polygon getCentroid() {

        return triangle.getCentroid();
    }

    public int getArea() {

        return triangle.getArea();

    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }

}
