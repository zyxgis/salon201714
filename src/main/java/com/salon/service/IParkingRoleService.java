package com.salon.service;

import com.salon.entity.Car;

/**
 * Created by zyx on 2017/4/16.
 */
public interface IParkingRoleService {
    int getParkCount();

    boolean canParkCar();

    boolean containCar(Car car);



}
