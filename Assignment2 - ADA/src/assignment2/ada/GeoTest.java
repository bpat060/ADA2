/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.ada;

/**
 *
 * @author Sheetal
 */
import java.awt.Polygon;
import java.util.HashSet;

public class GeoTest

    refinedTriangulation(Geometry g, int nRefinements, double tolerance


        ) {

    DelaunayTriangulationBuilder builder = new DelaunayTriangulationBuilder();
        Geometry g;
        builder.setSites(g); // set vertex sites
        builder.setTolerance(tolerance); // set tolerance for initial triangulation only

        Geometry triangulation = builder.getTriangles(geometryFactory); // initial triangulation

        HashSet<Coordinate> sites = new HashSet<>();
        for (int i = 0; i < triangulation.getCoordinates().length; i++) {
            sites.add(triangulation.getCoordinates()[i]);
        }

        for (int refinement = 0; refinement < nRefinements; refinement++) {
            for (int i = 0; i < triangulation.getNumGeometries(); i++) {
                Polygon triangle = (Polygon) triangulation.getGeometryN(i);

                if (triangle.getArea() > 50) { // skip small triangles
                    sites.add(new Coordinate(triangle.getCentroid().getX(), triangle.getCentroid().getY()));
                }
            }
            builder = new DelaunayTriangulationBuilder();
            builder.setSites(sites);
            triangulation = builder.getTriangles(geometryFactory); // re-triangulate using new centroid sites
        }

        triangulation = triangulation.intersection(g); // restore concave hull and any holes
    }

    private static class DelaunayTriangulationBuilder {

        public DelaunayTriangulationBuilder() {
        }

        private void setTolerance(double tolerance) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setSites(HashSet<Coordinate> sites) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setSites(Geometry g) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}