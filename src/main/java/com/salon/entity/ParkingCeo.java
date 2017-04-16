package com.salon.entity;

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

    public List<ParkingManager> getParkingManagerList() {
        return parkingManagerList;
    }

    public void setParkingManagerList(List<ParkingManager> parkingManagerList) {
        this.parkingManagerList = parkingManagerList;
    }

    @Override
    public int getCapacity() {
        int count = 0;
        for (ParkingManager parkingManager : parkingManagerList) {
            count += parkingManager.getCapacity();
        }
        return count;
    }

    @Override
    public int getOccupyCount() {
        int count = 0;
        for (ParkingManager parkingManager : parkingManagerList) {
            count += parkingManager.getOccupyCount();
        }
        return count;
    }

    @Override
    public int getUnoccupiedCount() {
        int count = 0;
        for (ParkingManager parkingManager : parkingManagerList) {
            count += parkingManager.getUnoccupiedCount();
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
    public boolean containCar(String carNumber) {
        return getParkingManagerContainCar(carNumber) != null;
    }

    public List<ParkingManager> getParkingManagersCanParkCar() {
        List<ParkingManager> parkingManagerCanParkCarList = new LinkedList<ParkingManager>();
        for (ParkingManager parkingManager : this.parkingManagerList) {
            if (parkingManager.canParkCar()) {
                parkingManagerCanParkCarList.add(parkingManager);
            }
        }
        return parkingManagerCanParkCarList;
    }

    public ParkingManager getParkingManagerContainCar(String carNumber) {
        for (ParkingManager parkingManager : this.parkingManagerList) {
            if (parkingManager.containCar(carNumber)) {
                return parkingManager;
            }
        }
        return null;
    }

    @Override
    public ParkingLot allocateParkingLotToCar(Car car) {
        for (ParkingManager parkingManager : this.parkingManagerList) {
            if (parkingManager.canParkCar()) {
                return parkingManager.allocateParkingLotToCar(car);
            }
        }
        return null;
    }

    @Override
    public ParkingLot takeCarFromParkingLot(String carNumber) {
        ParkingManager parkingManager = getParkingManagerContainCar(carNumber);
        if (parkingManager != null) {
            return parkingManager.takeCarFromParkingLot(carNumber);
        }
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
