package com.salon.choosemethod.impl;

import com.salon.choosemethod.ISelectParkingLotMethod;
import com.salon.entity.ParkingLot;

import java.util.List;

/**
 * Created by zyx on 2017/4/15.
 */
public class VacancyMaxMethod  implements ISelectParkingLotMethod {
    public ParkingLot pickParkingLot(List<ParkingLot> parkingLotList) {
        int parkCount = 0;
        ParkingLot parkingLotMaxCount = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getParkCount() > parkCount) {
                parkCount = parkingLot.getParkCount();
                parkingLotMaxCount = parkingLot;
            }
        }
        return parkingLotMaxCount;
    }
}
