package com.example.yannis.fractionne;

public class Interval {
    private int numero;
    private String type;
    private double distance;
    private double speed;


    public Interval(int numero, String type,double distance,double speed){
        this.type=type;
        this.distance=distance;
        this.speed=speed;
    }

    public int getNumero() {
        return numero;
    }

    public double getDistance() {
        return distance;
    }



    public double getSpeed() {
        return speed;
    }

    public String getType() {
        return type;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }



    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        return type+ " distance "+ this.distance+" vitesse "+this.speed;
    }

}
