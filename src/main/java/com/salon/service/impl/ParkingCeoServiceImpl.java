package com.salon.service.impl;

import com.salon.entity.Car;
import com.salon.service.IParkingRoleService;

/**
 * Created by zyx on 2017/4/16.
 */
public class ParkingCeoServiceImpl implements IParkingRoleService {

    public int getParkCount() {
        return 0;
    }

    public boolean canParkCar() {
        return false;
    }

    public boolean containCar(Car car) {
        return false;
    }
}
