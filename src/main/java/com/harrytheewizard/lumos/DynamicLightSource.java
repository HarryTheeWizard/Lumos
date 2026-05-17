package com.harrytheewizard.lumos;

public class DynamicLightSource {
    private double x, y, z;
    public DynamicLightSource(double x, double y, double z, int lightLevel) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.lightLevel = lightLevel;
    }

    public double getX() {return x;}
    public double getY() {return y;}
    public double getZ() {return z;}
    public int getLightLevel() {return lightLevel;}

    private int lightLevel;
}

