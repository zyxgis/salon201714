package com.salon.choosemethod.impl;

import com.salon.choosemethod.ISelectParkingLotMethod;
import com.salon.entity.ParkingLot;

import java.util.List;

/**
 * Created by zyx on 2017/4/15.
 */
public class OccupancyRatioMinMethod  implements ISelectParkingLotMethod {
    public ParkingLot pickParkingLot(List<ParkingLot> parkingLotList) {
        double parkRatio = Double.MAX_VALUE;
        ParkingLot parkingLotRatioMin = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getParkRatio() < parkRatio) {
                parkRatio = parkingLot.getParkRatio();
                parkingLotRatioMin = parkingLot;
            }
        }
        return parkingLotRatioMin;
    }
}