package com.salon.service.impl;

import com.salon.entity.Car;
import com.salon.entity.ParkingLot;
import com.salon.service.IParkingBoyService;
import com.salon.service.IParkingRoleService;

import java.util.List;

/**
 * Created by zyx on 2017/4/17.
 */
public class ParkingManagerServiceImpl implements IParkingRoleService, IParkingBoyService {
    public int getCapacity() {
        return 0;
    }

    public int getOccupyCount() {
        return 0;
    }

    public int getUnoccupiedCount() {
        return 0;
    }

    public boolean canParkCar() {
        return false;
    }

    public boolean containCar(Car car) {
        return false;
    }

    public ParkingLot allocateParkingLotToCar(Car car) {
        return null;
    }

    public ParkingLot takeCarFromParkingLot(String carNumber) {
        return null;
    }

    public String toXML() {
        return null;
    }

    public List<ParkingLot> getParkingLotsCanParkCar() {
        return null;
    }

    public ParkingLot getParkingLotContainCar(String carNumber) {
        return null;
    }
}
