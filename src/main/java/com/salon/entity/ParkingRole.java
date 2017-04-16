package com.salon.entity;

public abstract class ParkingRole {

    private String name = null;

    public ParkingRole(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int getCapacity();

    public abstract int getOccupyCount();

    public abstract int getUnoccupiedCount();

    public abstract boolean canParkCar();

    public abstract boolean containCar(String number);

    public abstract ParkingLot allocateParkingLotToCar(Car car);

    public abstract ParkingLot takeCarFromParkingLot(String carNumber);

    public abstract String toXML();
}