package com.company;

import java.io.Serializable;

public class Quadrangle implements IQuadrangle, Serializable {
    protected Coordinates pointA;
    protected Coordinates pointB;
    protected Coordinates pointC;
    protected Coordinates pointD;

    public Quadrangle(Coordinates pointA, Coordinates pointB, Coordinates pointC, Coordinates pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public Quadrangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        pointA = new Coordinates(x1, y1);
        pointB = new Coordinates(x2, y2);
        pointC = new Coordinates(x3, y3);
        pointD = new Coordinates(x4, y4);
    }

    public Coordinates setPointA() {
        return pointA;
    }

    public Coordinates getPointA() {
        return pointA;
    }

    public Coordinates setPointB() {
        return pointB;
    }

    public Coordinates getPointB() {
        return pointB;
    }

    public Coordinates setPointC() {
        return pointC;
    }

    public Coordinates getPointC() {
        return pointC;
    }

    public Coordinates setPointD() {
        return pointD;
    }

    public Coordinates getPointD() {
        return pointD;
    }

    public double findSideOne() {
        return Math.sqrt(Math.pow((pointB.getX() - pointA.getX()), 2) + Math.pow((pointB.getY() - pointA.getY()), 2));
    }

    public double findSideTwo() {
        return Math.sqrt(Math.pow((pointC.getX() - pointB.getX()), 2) + Math.pow((pointC.getY() - pointB.getY()), 2));
    }

    public double findSideThree() {
        return Math.sqrt(Math.pow((pointD.getX() - pointC.getX()), 2) + Math.pow((pointD.getY() - pointC.getY()), 2));
    }

    public double findSideFour() {
        return Math.sqrt(Math.pow((pointA.getX() - pointD.getX()), 2) + Math.pow((pointA.getY() - pointD.getY()), 2));
    }

    public double findDiagonalOne() {
        return Math.sqrt(Math.pow((pointC.getX() - pointA.getX()), 2) + Math.pow((pointC.getY() - pointA.getY()), 2));
    }

    public double findDiagonalTwo() {
        return Math.sqrt(Math.pow((pointD.getX() - pointB.getX()), 2) + Math.pow((pointD.getY() - pointB.getY()), 2));
    }

    public double findPerimeter() {
        return findSideOne() + findSideTwo() + findSideThree() + findSideFour();
    }

    public double findArea() {
        return Math.sqrt(((findPerimeter() / 2) - findSideOne()) * ((findPerimeter() / 2) - findSideTwo()) * ((findPerimeter() / 2) - findSideThree()) * ((findPerimeter() / 2) - findSideFour()));
    }

    public double findTheBiggestSide(){
        if (findSideOne() < findSideTwo() && findSideThree() < findSideTwo() && findSideFour() < findSideTwo())
            return findSideTwo();
        else if (findSideOne() < findSideThree() && findSideFour() < findSideThree() && findSideTwo() < findSideThree())
            return findSideThree();
        else if (findSideTwo() < findSideOne() && findSideFour() < findSideOne() && findSideFour() < findSideOne())
            return findSideOne();
        else
            return findSideFour();
    }

    public boolean isExists() {
        if (findTheBiggestSide() == findSideOne())
            return (findSideOne() + findSideFour() + findSideThree() > findSideOne());
        else if (findTheBiggestSide() == findSideTwo())
            return (findSideOne() + findSideThree() + findSideFour() > findSideTwo());
        else if (findTheBiggestSide() == findSideThree())
            return (findSideOne() + findSideTwo() + findSideFour() > findSideThree());
        else if (findTheBiggestSide() == findSideFour())
            return (findSideOne() + findSideTwo() + findSideThree() > findSideFour());
        else
            return false;
    }

    @Override
    public String toString() {
        return "Quadrangle {" +
                "Side one = " + findSideOne() +
                ", Side two = " + findSideTwo() +
                ", Side three = " + findSideThree() +
                ", Side four = " + findSideFour() +
                ", Area = " + findArea() +
                ", Diagonal one = " + findDiagonalOne() +
                ", Diagonal two = " + findDiagonalTwo() +
                '}' + "\n";
    }
}
