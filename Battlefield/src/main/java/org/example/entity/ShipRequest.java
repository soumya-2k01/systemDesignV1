package org.example.entity;

public class ShipRequest {
    int size;
    int xStart;
    int yStart;

    public ShipRequest(int size, int xStart, int yStart) {
        this.size = size;
        this.xStart = xStart;
        this.yStart = yStart;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getxStart() {
        return xStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }
}
