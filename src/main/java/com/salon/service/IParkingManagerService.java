package com.salon.service;

import com.salon.entity.ParkingBoy;

import java.util.List;

/**
 * Created by zyx on 2017/4/17.
 */
public interface IParkingManagerService {
    List<ParkingBoy> getParkingBoysCanParkCar();

    ParkingBoy getParkingBoyContainCar(String number);
}
