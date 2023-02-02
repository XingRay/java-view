package com.xingray.java.view;

public interface Canvas {

    void setWidth(double width);

    void setHeight(double height);

    void clear();

    void clearRect(double x, double y, double w, double h);

    Paint getPaint();

    void drawLine(double x1, double y1, double x2, double y2);

    void drawText(String text, double x, double y);

    void drawRect(double x, double y, double w, double h);

    void fillRect(double x, double y, double w, double h);

    void drawPolyline(double[] xPoints, double[] yPoints, int pointCount);
}
