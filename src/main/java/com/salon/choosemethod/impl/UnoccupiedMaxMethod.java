package com.salon.choosemethod.impl;

import com.salon.choosemethod.ISelectParkingLotMethod;
import com.salon.entity.ParkingLot;

import java.util.List;

/**
 * Created by zyx on 2017/4/15.
 */
public class UnoccupiedMaxMethod implements ISelectParkingLotMethod {
    public ParkingLot pickParkingLot(List<ParkingLot> parkingLotList) {
        int unoccupiedMax = 0;
        ParkingLot parkingLotUnoccupiedMax = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getUnoccupiedCount() > unoccupiedMax) {
                unoccupiedMax = parkingLot.getUnoccupiedCount();
                parkingLotUnoccupiedMax = parkingLot;
            }
        }
        return parkingLotUnoccupiedMax;
    }
}
