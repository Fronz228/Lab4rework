package com.company;

import java.io.Serializable;

public class IsoscelesTrapezoid extends Quadrangle implements IQuadrangle, Serializable {
    public IsoscelesTrapezoid(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public IsoscelesTrapezoid(Coordinates pointOne, Coordinates pointTwo, Coordinates pointThree, Coordinates pointFour) {
        super(pointOne, pointTwo, pointThree, pointFour);
    }

    protected boolean isIsoscelesTrapezoid() {
       if(findDiagonalOne() == findDiagonalTwo())
           return true;
       else
           return false;
    }


}
