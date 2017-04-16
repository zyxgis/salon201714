package com.salon.entity;

import com.salon.choosemethod.ISelectParkingLotMethod;
import com.salon.choosemethod.impl.UnoccupiedMaxMethod;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 停车负责人
 */
public class ParkingBoy extends ParkingRole {
    /**
     * 选择停车场的方法
     */
    private ISelectParkingLotMethod pSelectParkingLotMethod;

    /**
     * 停车场数：3-5
     */
    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(5);

    public ParkingBoy(String name) {
        super(name);
        this.pSelectParkingLotMethod = new UnoccupiedMaxMethod();
    }

    public ParkingBoy(String name, ISelectParkingLotMethod pSelectParkingLotMethod) {
        super(name);
        this.pSelectParkingLotMethod = pSelectParkingLotMethod;
    }

    public ISelectParkingLotMethod getpSelectParkingLotMethod() {
        return pSelectParkingLotMethod;
    }

    public void setpSelectParkingLotMethod(ISelectParkingLotMethod pSelectParkingLotMethod) {
        this.pSelectParkingLotMethod = pSelectParkingLotMethod;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public int getCapacity() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            count += parkingLot.getCapacity();
        }
        return count;
    }

    /**
     * 已停车位数目
     *
     * @return
     */
    @Override
    public int getOccupyCount() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            count += parkingLot.getOccupyCount();
        }
        return count;
    }

    @Override
    public int getUnoccupiedCount() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            count += parkingLot.getUnoccupiedCount();
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
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.canParkCar()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否已将车停在此处
     *
     * @param carNumber
     * @return
     */
    @Override
    public boolean containCar(String carNumber) {
        return getParkingLotContainCar(carNumber) != null;
    }

    /**
     * 分配停车位
     *
     * @param car
     * @return
     */
    public ParkingLot allocateParkingLotToCar(Car car) {
        ParkingLot parkingLot = pickParkingLot();
        parkingLot.parkCar(car);
        return parkingLot;
    }

    /**
     * 取车
     *
     * @param carNumber
     * @return
     */
    public ParkingLot takeCarFromParkingLot(String carNumber) {
        ParkingLot parkingLot = getParkingLotContainCar(carNumber);
        if (parkingLot != null) {
            parkingLot.takeCar(carNumber);
        }
        return parkingLot;
    }

    /**
     * 获取停有该车版的停车场
     *
     * @return
     */
    public ParkingLot getParkingLotContainCar(String carNumber) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.containCar(carNumber)) {
                return parkingLot;
            }
        }
        return null;
    }

    /**
     * 获取所有可以停车的停车场
     *
     * @return
     */
    public List<ParkingLot> getParkingLotsCanParkCar() {
        List<ParkingLot> parkingLotListResult = new LinkedList<ParkingLot>();
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.canParkCar()) {
                parkingLotListResult.add(parkingLot);
            }
        }
        return parkingLotListResult;
    }

    /**
     * 挑选一个停车场
     *
     * @return
     */
    private ParkingLot pickParkingLot() {
        List<ParkingLot> parkingLotList = getParkingLotsCanParkCar();
        ParkingLot parkingLot = pSelectParkingLotMethod.pickParkingLot(parkingLotList);
        return parkingLot;
    }

    public String toXML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ParkingBoy>");
        stringBuilder.append("<Name>");
        stringBuilder.append("</Name>");
        stringBuilder.append("<ParkingLots>");
        for (ParkingLot parkingLot : this.parkingLotList) {
            stringBuilder.append(parkingLot.toXML());
        }
        stringBuilder.append("</ParkingLots>");
        stringBuilder.append("</ParkingBoy>");
        return stringBuilder.toString();
    }
}