package com.salon.service;

import com.salon.entity.ParkingLot;

import java.util.List;

/**
 * Created by zyx on 2017/4/17.
 */
public interface IParkingBoyService {
    List<ParkingLot> getParkingLotsCanParkCar();

    ParkingLot getParkingLotContainCar(String carNumber);
}
