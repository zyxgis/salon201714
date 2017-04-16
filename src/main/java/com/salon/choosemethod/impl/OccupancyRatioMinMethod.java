package com.salon.choosemethod.impl;

import com.salon.choosemethod.ISelectParkingLotMethod;
import com.salon.entity.ParkingLot;

import java.util.List;

/**
 * Created by zyx on 2017/4/15.
 */
public class OccupancyRatioMinMethod  implements ISelectParkingLotMethod {
    public ParkingLot pickParkingLot(List<ParkingLot> parkingLotList) {
        double occupancyRatioMin = Double.MAX_VALUE;
        ParkingLot parkingLotOccupancyRatioMin = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getOccupiedRatio() < occupancyRatioMin) {
                occupancyRatioMin = parkingLot.getOccupiedRatio();
                parkingLotOccupancyRatioMin = parkingLot;
            }
        }
        return parkingLotOccupancyRatioMin;
    }
}