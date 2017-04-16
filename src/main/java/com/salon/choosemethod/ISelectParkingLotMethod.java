package com.salon.choosemethod;

import com.salon.entity.ParkingLot;

import java.util.List;

/**
 * Created by zyx on 2017/4/15.
 */
public interface ISelectParkingLotMethod {
    ParkingLot pickParkingLot(List<ParkingLot> parkingLotList);
}
