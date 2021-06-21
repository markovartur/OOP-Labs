package com.company;

public class Point2d {

    /** координата X **/
    private double xCoord;
/** координата Y **/
    private double yCoord;
/** Конструктор инициализации **/
    public Point2d ( double x, double y) {
        xCoord = x;
        yCoord = y;
    }
/** Конструктор по умолчанию. **/
    public Point2d () {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }
/** Возвращение координаты X **/
    public double getX () {return xCoord;}
/** Возвращение координаты Y **/
    public double getY () { return yCoord; }
/** Установка значения координаты X. **/
    public void setX ( double val) { xCoord = val; }
/** Установка значения координаты Y. **/
    public void setY ( double val) { yCoord = val; }

    public double distanceTo(Point2d point) {
        //return Math.round(Math.abs((point.xCoord - xCoord)+(point.yCoord - yCoord)));
        return Math.round(Math.sqrt(Math.pow(point.getX() - getX(), 2)+Math.pow(point.getY() - getY(), 2)));
    }
///////////////////////////////
    void print(){
        System.out.println("{x="+xCoord+ ", {y="+yCoord);
    }
}
