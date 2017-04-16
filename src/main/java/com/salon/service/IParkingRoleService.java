package com.salon.service;

import com.salon.entity.Car;
import com.salon.entity.ParkingLot;

/**
 * Created by zyx on 2017/4/16.
 */
public interface IParkingRoleService {
    int getCapacity();

    int getOccupyCount();

    int getUnoccupiedCount();

    boolean canParkCar();

    boolean containCar(Car car);

    ParkingLot allocateParkingLotToCar(Car car) ;

    /**
     * 取车
     *
     * @param carNumber
     * @return
     */
    ParkingLot takeCarFromParkingLot(String carNumber);

    String toXML();



}
