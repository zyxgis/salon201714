package com.salon.entity;

import com.salon.choosemethod.impl.VacancyMaxMethod;

import java.util.LinkedList;
import java.util.List;

/**
 * 停车CEO：1
 */
public class ParkingCeo extends ParkingRole {

    public ParkingCeo(String name) {
        super(name);
    }

    /**
     * 停车场数：3-5
     */
    private List<ParkingManager> parkingManagerList = new LinkedList<ParkingManager>();

    @Override
    public int getParkCount() {
        int count = 0;
        for (ParkingManager parkingManager : parkingManagerList) {
            count += parkingManager.getParkCount();
        }
        return count;
    }

    /**
     * 是否可以停车
     *
     * @return
     */
    @Override
    public boolean canParkCar() {
        for (ParkingManager parkingManager : parkingManagerList) {
            if (parkingManager.canParkCar()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containCar(String number) {
        return getParkingManagerContainCar(number) != null;
    }

    public List<ParkingManager> getParkingManagerCanParkCarList() {
        List<ParkingManager> parkingManagerCanParkCarList = new LinkedList<ParkingManager>();
        for (ParkingManager parkingManager : this.parkingManagerList) {
            if (parkingManager.canParkCar()) {
                parkingManagerCanParkCarList.add(parkingManager);
            }
        }
        return parkingManagerCanParkCarList;
    }

    public ParkingManager getParkingManagerContainCar(String number) {
        for (ParkingManager parkingManager : this.parkingManagerList) {
            if (parkingManager.containCar(number)) {
                return parkingManager;
            }
        }
        return null;
    }

    public ParkingManager allocatePark(Car car) {
        for (ParkingManager parkingManager : this.parkingManagerList) {
            if (parkingManager.canParkCar()) {
                parkingManager.allocatePark(car);
                return parkingManager;
            }
        }
        return null;
    }


    public ParkingLot takeCar(String number) {
        return null;
    }

    public String toXML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ParkingCEO>");
        stringBuilder.append("<ParkingManagers>");
        for (ParkingManager parkingManager : this.parkingManagerList) {
            stringBuilder.append(parkingManager.toXML());
        }
        stringBuilder.append("</ParkingManagers>");
        stringBuilder.append("</ParkingCEO>");
        return stringBuilder.toString();
    }

}
