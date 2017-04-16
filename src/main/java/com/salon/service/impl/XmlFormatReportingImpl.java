package com.salon.service.impl;

import com.salon.entity.ParkingBoy;
import com.salon.entity.ParkingCeo;
import com.salon.entity.ParkingLot;
import com.salon.entity.ParkingManager;
import com.salon.service.IReporting;

/**
 * Created by zyx on 2017/4/17.
 */
public class XmlFormatReportingImpl implements IReporting {

    public String reportOutput(ParkingCeo parkingCeo) {
        return parkingCeoToXML(parkingCeo);
    }

    public String parkingCeoToXML(ParkingCeo parkingCeo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ParkingCEO>");
        stringBuilder.append("<ParkingManagers>");
        for (ParkingManager parkingManager : parkingCeo.getParkingManagerList()) {
            stringBuilder.append(parkingManagerToXML(parkingManager));
        }
        stringBuilder.append("</ParkingManagers>");
        stringBuilder.append("</ParkingCEO>");
        return stringBuilder.toString();
    }

    public String parkingManagerToXML(ParkingManager parkingManager) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ParkingManager>");
        stringBuilder.append("<Name>");
        stringBuilder.append(parkingManager.getName());
        stringBuilder.append("</Name>");
        stringBuilder.append("<ParkingBoys>");
        for (ParkingBoy parkingBoy : parkingManager.getParkingBoyList()) {
            stringBuilder.append(parkingLotToXML(parkingBoy));
        }
        stringBuilder.append("</ParkingBoys>");
        stringBuilder.append("</ParkingManager>");
        return stringBuilder.toString();
    }


    public String parkingLotToXML(ParkingBoy parkingBoy) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ParkingBoy>");
        stringBuilder.append("<Name>");
        stringBuilder.append(parkingBoy.getName());
        stringBuilder.append("</Name>");
        stringBuilder.append("<ParkingLots>");
        for (ParkingLot parkingLot : parkingBoy.getParkingLotList()) {
            stringBuilder.append(parkingLotToXML(parkingLot));
        }
        stringBuilder.append("</ParkingLots>");
        stringBuilder.append("</ParkingBoy>");
        return stringBuilder.toString();
    }

    public String parkingLotToXML(ParkingLot parkingLot) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ParkingLot>");
        stringBuilder.append("<Name>" + parkingLot.getName() + "</Name>");
        stringBuilder.append("<Count>" + parkingLot.getOccupyCount() + "</Count>");
        stringBuilder.append("<Capacity>" + parkingLot.getCapacity() + "</Capacity>");
        stringBuilder.append("</ParkingLot>");
        return stringBuilder.toString();
    }
}
