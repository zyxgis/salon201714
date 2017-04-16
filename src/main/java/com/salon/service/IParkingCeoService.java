package com.salon.service;

import com.salon.entity.ParkingManager;

import java.util.List;

/**
 * Created by zyx on 2017/4/17.
 */
public interface IParkingCeoService {

    List<ParkingManager> getParkingManagersCanParkCar();

    ParkingManager getParkingManagerContainCar(String carNumber);
}
