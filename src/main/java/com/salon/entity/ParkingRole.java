package com.salon.entity;

public abstract class ParkingRole {

    private String name = null;

    public ParkingRole(String name){
        this.name = name;
    }

    public abstract int getParkCount();

    public abstract boolean canParkCar();

    public abstract boolean containCar(String number);

}