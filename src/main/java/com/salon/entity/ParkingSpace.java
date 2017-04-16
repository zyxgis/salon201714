package com.salon.entity;

/**
 * 停车位
 */
public class ParkingSpace {
    /**
     * 停车车位的编号
     */
    private String number = null;

    /**
     * 停车车位的所停汽车
     */
    private Car car = null;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean containCar(Car car) {
        return this.car!=null && this.car.getNumber().equalsIgnoreCase(car.getNumber());
    }

}
