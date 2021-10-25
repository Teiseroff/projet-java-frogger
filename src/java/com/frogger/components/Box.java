package com.frogger.components;

public class Box {
    // Je voulais faire public class Box implement Ibox {} mais ca a pas l'air de marcher
    // soit je met Box en abstract et il veut plus l'instancier, soit il veut pas implementer Ibox

    private int xbox ;
    private int ybox ;
    private int box_id ;

    public Box (int xbox, int ybox, int box_id) {
        this.xbox = xbox ;
        this.ybox = ybox ;
        this.box_id = box_id ;
    }

    public int getXbox() {
        return xbox;
    }

    public int getYbox() {
        return ybox;
    }

    public int getBox_id() {
        return box_id;
    }

    public void setXbox(int xbox) {
        this.xbox = xbox;
    }

    public void setYbox(int ybox) {
        this.ybox = ybox;
    }

    public void setBox_id(int box_id) {
        this.box_id = box_id;
    }
}
