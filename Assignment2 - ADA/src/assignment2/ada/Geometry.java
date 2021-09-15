/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.ada;

import java.awt.Polygon;
import java.util.HashSet;

/**
 *
 * @author Sheetal
 */
class Geometry<Polygon> {

    public static Geometry refinedTessellation(Geometry g, int nRefinements, double tolerance) {

        DelaunayTessellationBuilder builder = new DelaunayTessellationBuilder();
        builder.setSites(g); // set vertex sites
        builder.setTolerance(tolerance); // set tolerance for initial tessellation only

        Geometry tessellation = builder.getTriangles(geometryFactory);

        HashSet<Coordinate> sites = new HashSet<>();
        for (int i = 0; i < tessellation.getCoordinates().length; i++) {
            sites.add(tessellation.getCoordinates()[i]);
        }

        for (int refinement = 0; refinement < nRefinements; refinement++) {
            for (int i = 0; i < tessellation.getNumGeometries(); i++) {
                Polygon triangle = (Polygon) tessellation.getGeometryN(i);

                if (triangle.getArea() > 50) { // skip small triangle
                    sites.add(new Coordinate(triangle.getCentroid().getX(), triangle.getCentroid().getY()));
                }
            }
            builder = new DelaunayTessellationBuilder();
            builder.setSites(sites);
            tessellation = builder.getTriangles(geometryFactory); // re-triangulate using new centroid sites
        }

        tessellation = tessellation.intersection(g); // restore concave hull and any holes
        return tessellation;
    }

    public Polygon getCentroid() {

        return null;

    }

    public int getAread() {

        return 0;

    }

    private static class DelaunayTessellationBuilder {

        public DelaunayTessellationBuilder() {
        }

        private void setSites(Geometry g) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setTolerance(double tolerance) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setSites(HashSet<Coordinate> sites) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    Object getCoordinates() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getNumGeometries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Geometry intersection(Geometry g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
