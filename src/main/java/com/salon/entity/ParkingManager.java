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
     * Ceo批下来有待进行停的车
     */
    private List<Car> needToAllocateCarList = new LinkedList<Car>();

    /**
     * Ceo批下来有待取走的车
     */
    private List<Car> needToTakeCarList = new LinkedList<Car>();


    /**
     * 停车负责人：5
     */
    private List<ParkingBoy> parkingBoyList = new ArrayList<ParkingBoy>(5);

    /**
     * 停车位数目
     *
     * @return
     */
    @Override
    public int getParkCount() {
        int count = 0;
        for (ParkingBoy boy : parkingBoyList) {
            count += boy.getParkCount();
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

    public ParkingBoy allocatePark(Car car) {
        for (ParkingBoy parkingBoy : parkingBoyList) {
            if (parkingBoy.canParkCar()) {
                parkingBoy.allocatePark(car);
                return parkingBoy;
            }
        }
        return null;
    }

    public ParkingBoy takeCar(String number) {
        ParkingBoy parkingBoy = getParkingBoyContainCar(number);
        if (parkingBoy != null) {
            parkingBoy.takeCar(number);
        }
        return parkingBoy;
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