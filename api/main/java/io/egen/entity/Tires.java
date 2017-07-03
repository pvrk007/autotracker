package main.java.io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Rama on 7/2/2017.
 */
@Entity
public class Tires {
    @Id
    private String vin;
    private int frontLeft;
    private int frontRight;
    private int rearLeft;

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    private int rearRight;
}
