package com.salon.choosemethod.impl;

import com.salon.choosemethod.ISelectParkingLotMethod;
import com.salon.entity.ParkingLot;

import java.util.List;

/**
 * Created by zyx on 2017/4/15.
 */
public class CapacityMaxMethod implements ISelectParkingLotMethod {
    public ParkingLot pickParkingLot(List<ParkingLot> parkingLotList) {
        double capacityMax = 0;
        ParkingLot parkingLotCapacityMax = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getParkCapacity() > capacityMax) {
                capacityMax = parkingLot.getParkCapacity();
                parkingLotCapacityMax = parkingLot;
            }
        }
        return parkingLotCapacityMax;
    }
}
