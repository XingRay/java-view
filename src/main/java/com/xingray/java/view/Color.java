package com.xingray.java.view;

import java.util.Objects;

public class Color {

    private int value;


    public Color() {
    }

    public Color(int value) {
        this.value = value;
    }

    public Color(int red, int green, int blue) {
        this(0xff, red, green, blue);
    }

    public Color(int alpha, int red, int green, int blue) {
        value = argbToValue(alpha, red, green, blue);
    }

    public int getAlpha() {
        return getAlpha(value);
    }

    public void setAlpha(int alpha) {
        value = setAlpha(value, alpha);
    }

    public double getOpacity() {
        return alphaToOpacity(getAlpha());
    }

    public int getRed() {
        return getRed(value);
    }

    public void setRed(int red) {
        value = setRed(value, red);
    }

    public int getGreen() {
        return getGreen(value);
    }

    public void setGreen(int green) {
        value = setGreen(green, value);
    }

    public int getBlue() {
        return getBlue(value);
    }

    public void setBlue(int blue) {
        value = setBlue(value, blue);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        int alpha = getAlpha();
        int red = getRed();
        int green = getGreen();
        int blue = getBlue();

        return "Color{" +
                " value=" + value + "(0x" + Integer.toHexString(value) + ")" +
                " alpha=" + alpha + "(0x" + Integer.toHexString(alpha) + ")" +
                " red=" + red + "(0x" + Integer.toHexString(red) + ")" +
                " green=" + green + "(0x" + Integer.toHexString(green) + ")" +
                " blue=" + blue + "(0x" + Integer.toHexString(blue) + ")" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return value == color.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static int argbToValue(int alpha, int red, int green, int blue) {
        return ((alpha & 0xff) << 24)
                + ((red & 0xff) << 16)
                + ((green & 0xff) << 8)
                + (blue & 0xff);
    }

    public static int getAlpha(int value) {
        return (value >> 24) & 0xff;
    }

    public static int setAlpha(int value, int alpha) {
        return ((alpha & 0xff) << 24) + (value & 0x00ffffff);
    }

    public static int getRed(int value) {
        return (value >> 16) & 0xff;
    }

    public static int setRed(int value, int red) {
        return ((red & 0xff) << 16) + (value & 0xff00ffff);
    }

    public static int getGreen(int value) {
        return (value >> 8) & 0xff;
    }

    public static int setGreen(int green, int value) {
        return ((green & 0xff) << 8) + (value & 0xffff00ff);
    }

    public static int getBlue(int value) {
        return value & 0xff;
    }

    public static int setBlue(int value, int blue) {
        return (blue & 0xff) + (value & 0xffffff00);
    }

    public static int opacityToAlpha(double opacity) {
        return ((int) (opacity * 0xff) & 0xff);
    }

    public static double alphaToOpacity(int alpha) {
        return ((alpha & 0xff) * 1.0) / 0xff;
    }

    public static Color rgb(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public static Color rgb(int alpha, int red, int green, int blue) {
        return new Color(alpha, red, green, blue);
    }

    public static Color rgb(double opacity, int red, int green, int blue) {
        return new Color(opacityToAlpha(opacity), red, green, blue);
    }
}
