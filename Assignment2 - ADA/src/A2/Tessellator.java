/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2;

import java.util.List;

/**
 *
 * @author Owner
 */
//implement code for tesselating the hexagon with triangles.
//
public final class Tessellator extends Object {

    protected static class Node {

        protected Node(Polygon polygon, int index, int vertexIndex) {

        }

        //simple deep copy constructor
        protected Node(Tessellator.Node other) {

        }

        //compare nodes by y then x
        public int compare(Tessellator.Node other) {

            return 0;

        }

        //get the latitude value
        public double getLat() {

            return 0;

        }

        //get the longitude value
        public double getLon() {

            return 0;

        }

        //get the x value
        public double getX() {

            return 0;

        }

        //get the y value
        public double getY() {

            return 0;

        }

        //toString in class Object
        @Override
        public String toString() {

            return null;

        }
    }

    private static class Triangle {

        protected Triangle(Tessellator.Node a, Tessellator.Node b, Tessellator.Node c) {

        }

        //utility method to compute whether the point is in the triangle
        protected boolean containsPoint(double lat, double lon) {

            return false;

        }

        //get quantized x value for the given vertex
        public int getEncodedX(int vertex) {

            return 0;

        }

        //get quantized y value for the given vertex
        public int getEncodedY(int vertex) {

            return 0;

        }

        //get latitude value for the given vertex
        public double getLat(int vertex) {

            return 0;

        }

        //get longitude value for the given vertex
        public double getLon(int vertex) {

            return 0;

        }

        //toString in class Object
        @Override
        public String toString() {

            return null;

        }
    }

    //Determines whether two line segments intersect.
    public static boolean linesIntersect(double aX0, double aY0, double aX1, double aY1, double bX0, double bY0, double bX1, double bY1) {

        return false;

    }

    //Brute force compute if a point is in the polygon by traversing entire triangulation todo: speed this up using either binary tree or prefix coding (filtering by bounding box of triangle)
    public static boolean pointInPolygon(List<Tessellator.Triangle> tessellation, double lat, double lon) {

        return false;

    }

    //compute whether the given x, y point is in a triangle; uses the winding order method
    public static boolean pointInTriangle(double x, double y, double ax, double ay, double bx, double by, double cx, double cy) {

        return false;

    }

    //Produces an array of vertices representing the triangulated result set of the Points array
    public static List<Tessellator.Triangle> tessellate(Polygon polygon) {

        return null;

    }

}
