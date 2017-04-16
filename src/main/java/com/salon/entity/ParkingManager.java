package com.salon.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 停车Manager
 */
public class ParkingManager extends ParkingRole {

    public ParkingManager(String name) {
        super(name);
    }

    /**
     * 停车负责人：5
     */
    private List<ParkingBoy> parkingBoyList = new ArrayList<ParkingBoy>(5);

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    public void setParkingBoyList(List<ParkingBoy> parkingBoyList) {
        this.parkingBoyList = parkingBoyList;
    }

    @Override
    public int getCapacity() {
        int count = 0;
        for (ParkingBoy parkingBoy : parkingBoyList) {
            count += parkingBoy.getCapacity();
        }
        return count;
    }

    /**
     * 停车位数目
     *
     * @return
     */
    @Override
    public int getOccupyCount() {
        int count = 0;
        for (ParkingBoy parkingBoy : parkingBoyList) {
            count += parkingBoy.getOccupyCount();
        }
        return count;
    }

    @Override
    public int getUnoccupiedCount() {
        int count = 0;
        for (ParkingBoy parkingBoy : parkingBoyList) {
            count += parkingBoy.getUnoccupiedCount();
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
        for (ParkingBoy parkingBoy : parkingBoyList) {
            if (parkingBoy.canParkCar()) {
                return true;
            }
        }
        return false;
    }


    public List<ParkingBoy> getParkingBoyCanParkCarList() {
        List<ParkingBoy> parkingBoyCanParkCarList = new LinkedList<ParkingBoy>();
        for (ParkingBoy parkingBoy : parkingBoyList) {
            if (parkingBoy.canParkCar()) {
                parkingBoyCanParkCarList.add(parkingBoy);
            }
        }
        return parkingBoyCanParkCarList;
    }

    @Override
    public boolean containCar(String number) {
        return getParkingBoyContainCar(number) != null;
    }

    public ParkingBoy getParkingBoyContainCar(String number) {
        for (ParkingBoy parkingBoy : parkingBoyList) {
            if (parkingBoy.containCar(number)) {
                return parkingBoy;
            }
        }
        return null;
    }

    public ParkingLot allocateParkingLotToCar(Car car) {
        for (ParkingBoy parkingBoy : parkingBoyList) {
            if (parkingBoy.canParkCar()) {
                return parkingBoy.allocateParkingLotToCar(car);
            }
        }
        return null;
    }

    public ParkingLot takeCarFromParkingLot(String carNumber) {
        ParkingBoy parkingBoy = getParkingBoyContainCar(carNumber);
        if (parkingBoy != null) {
            return parkingBoy.takeCarFromParkingLot(carNumber);
        }
        return null;
    }

    public String toXML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ParkingManager>");
        stringBuilder.append("<Name>");
        stringBuilder.append("</Name>");
        stringBuilder.append("<ParkingBoys>");
        for (ParkingBoy parkingBoy : this.parkingBoyList) {
            stringBuilder.append(parkingBoy.toXML());
        }
        stringBuilder.append("</ParkingBoys>");
        stringBuilder.append("</ParkingManager>");
        return stringBuilder.toString();
    }
}