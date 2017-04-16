package com.salon.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * 停车场
 */
public class ParkingLot {

    private String name = null;

    /**
     * 已占用的停车位数
     */
    private int occupyCount = 0;

    /**
     * 总的停车位数：10-100
     */
    private int capacity = -1;

    private List<Car> carList = null;

    public ParkingLot(String name, int capacity) throws Exception {
        this.name = name;
        init(capacity);
    }

    private boolean validCapacity(int capacity){
        return (capacity>=10 && capacity<=100);
    }

    private void init(int capacity) throws Exception{
        if(validCapacity(capacity)) {
            this.capacity = capacity;
            carList = new LinkedList<Car>();
        }
        else{
            throw new Exception("parking lot's capacity must in [10, 100]");
        }
    }

    public boolean containCar(String carNumber) {
        return getCar(carNumber) != null;
    }

    /**
     * 是否可以停车
     *
     * @return
     */
    public boolean canParkCar() {
        return this.capacity > this.occupyCount;
    }

    public void parkCar(Car car){
        carList.add(car);
    }

    public boolean takeCar(String carNumber) {
        Car car = getCar(carNumber);
        if(car != null){
            carList.remove(car);
            occupyCount--;
            return true;
        }
        return false;
    }

    private Car getCar(String carNumber) {
        for (int index = 0; index < carList.size(); index++) {
            Car car = carList.get(index);
            if (car.getNumber().equalsIgnoreCase(carNumber))
                return car;
        }
        return null;
    }

    /**
     * 获取所有停车的位数
     *
     * @return
     */
    public int getParkCapacity() {
        return this.capacity;
    }

    /**
     * 获取可用停车的位数
     *
     * @return
     */
    public int getParkCount() {
        return this.capacity - this.occupyCount;
    }

    /**
     * 获取停车的比例
     *
     * @return
     */
    public double getParkRatio() {
        return this.occupyCount * 1.0 / this.capacity;
    }

    public String toXML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ParkingLot>");
        stringBuilder.append("<Name>" + this.name + "</Name>");
        stringBuilder.append("<Count>" + this.occupyCount + "</Count>");
        stringBuilder.append("<Capacity>" + this.capacity + "</Capacity>");
        stringBuilder.append("</ParkingLot>");
        return stringBuilder.toString();
    }

}