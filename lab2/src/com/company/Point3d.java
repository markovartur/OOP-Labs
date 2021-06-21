package com.company;

public class Point3d extends Point2d {
    private double zCoord;

    public Point3d(double x, double y, double z){
        super(x, y);
        zCoord = z;
    }

    public Point3d(){
        super();
        zCoord = 0;
    }

    public double getZ() { return zCoord;}

    public void setZ(double z) { zCoord = z; }

    public double distanceTo(Point3d point){
        return (Math.round(Math.sqrt(Math.pow(point.getX()-getX(),2) + Math.pow(point.getY()-getY(),2) + Math.pow(getZ()-getZ(),2))*100.0)/100.0);
    }

}
