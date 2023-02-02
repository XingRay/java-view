package com.xingray.java.view;

public interface View {

    double getWidth();

    double getHeight();

    void invalidate();

    void onDraw(Canvas canvas);
}
