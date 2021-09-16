/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
import java.awt.geom.Path2D;

public class Path extends Path2D.Double {

    private static final long serialVersionUID = 1L;

    public Path(Point point) {
        super();
        moveTo(point.getX(), point.getY());
    }

    public void lineTo(Point point) {
        lineTo(point.getX(), point.getY());
    }

}
