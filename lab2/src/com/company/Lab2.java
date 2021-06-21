package com.company;

import java.util.Arrays;

public class Lab2 {

    public static void main(String[] args) {
	    Point3d a = new Point3d(3,0,0);//(3, 0, 0);
	    Point3d b = new Point3d(5,-3,0);//(5, -3, 0);
	    Point3d c = new Point3d(5,6,0);//(-5, 0, 0);
	    //Point2d pp= new Point2d();
        //System.out.println(pp);

	    try{
	        System.out.println("S = "+computeArea(a,b,c));
        }
	    catch (Exception e){
	        System.out.println(e.getMessage());
        }
    }

    public static double computeArea(Point3d a, Point3d b, Point3d c) throws  Exception{
        if (a.equals(b) || b.equals(c) || c.equals(a)){
            throw new Exception("Some points are equal");
        }
        double sideA = a.distanceTo(b);
        double sideB = b.distanceTo(c);
        double sideC = c.distanceTo(a);
        double semiPerimeter = (sideA+sideB+sideC) / 2;
        //double triangle =
        //формула Герона
        System.out.println(sideA);
        System.out.println(sideB);
        System.out.println(sideC);

        return (Math.round(Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC))*100.0)/100.0); //semiPerimeter - sideC=0
    }


}
