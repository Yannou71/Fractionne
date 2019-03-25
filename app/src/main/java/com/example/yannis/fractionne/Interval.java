package com.example.yannis.fractionne;

public class Interval {
    private int time;
    private String type;
    private float distance;
    private float speed;


    public Interval(int time,String type,float distance,float speed){
        this.time=time;
        this.type=type;
    }

    public float getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public float getSpeed() {
        return speed;
    }

    public String getType() {
        return type;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
