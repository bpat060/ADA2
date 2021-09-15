/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.ada;

import static assignment2.ada.sites.geometryFactory;
import java.awt.Polygon;
import java.util.HashSet;

import java.util.HashSet;

import java.util.HashSet;

import static assignment2.ada.sites.geometryFactory;

import java.util.HashSet;

/**
 *
 * @author Sheetal
 */
class Geometry<Polygon> {

    public Geometry refinedTessellation(Geometry g, int nRefinements, double tolerance, Geometry geometryFactory) {

        DelaunayTessellationBuilder builder = new DelaunayTessellationBuilder();
        builder.setSites(g); // set vertex sites
        builder.setTolerance(tolerance); // set tolerance for initial tessellation only

        Geometry tessellation = builder.getTriangles(geometryFactory);

        HashSet<Coordinate> sites = new HashSet<>();
        for (int i = 0; i < tessellation.getCoordinates().length; i++) { // maybe there needs to be a list of tesselations
            sites.add(tessellation.getCoordinates()[i]);
        }

        for (int refinement = 0; refinement < nRefinements; refinement++) {
            for (int i = 0; i < tessellation.getNumGeometries(); i++) {
                Polygon triangle = (Polygon) tessellation.getGeometryN(i);

                if (50 <= triangle.getArea()) { // skip small triangle
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

    public int getArea() {

        return 0;

    }

    private Polygon getGeometryN(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        private Geometry getTriangles(Geometry geometryFactory) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    Object getCoordinates() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getNumGeometries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Geometry getGeometryN(int i) {
        return null;
    }

    Geometry intersection(Geometry g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
