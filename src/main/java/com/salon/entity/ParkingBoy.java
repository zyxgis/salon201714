package com.salon.entity;

import com.salon.choosemethod.ISelectParkingLotMethod;
import com.salon.choosemethod.impl.VacancyMaxMethod;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 停车负责人
 */
public class ParkingBoy extends ParkingRole {
    private ISelectParkingLotMethod pSelectParkingLotMethod;

    /**
     * Manager批下来有待进行停的车
     */
    private List<Car> needToAllocateCarList = new LinkedList<Car>();

    /**
     * Manager批下来有待取走的车
     */
    private List<Car> needToTakeCarList = new LinkedList<Car>();


    /**
     * 停车场数：3-5
     */
    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(5);

    public ParkingBoy(String name) {
        super(name);
        this.pSelectParkingLotMethod = new VacancyMaxMethod();
    }

    public ParkingBoy(String name, ISelectParkingLotMethod pSelectParkingLotMethod) {
        super(name);
        this.pSelectParkingLotMethod = pSelectParkingLotMethod;
    }

    /**
     * 已停车位数目
     *
     * @return
     */
    @Override
    public int getParkCount() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            count += parkingLot.getParkCount();
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
     * @param number
     * @return
     */
    @Override
    public boolean containCar(String number) {
        return getParkingLotContainCar(number) != null;
    }

    /**
     * 分配停车位
     *
     * @param car
     * @return
     */
    public ParkingLot allocatePark(Car car) {
        ParkingLot parkingLot = pickParkingLot();
        parkingLot.parkCar(car);
        return parkingLot;
    }

    /**
     * 取车
     *
     * @param number
     * @return
     */
    public ParkingLot takeCar(String number) {
        ParkingLot parkingLot = getParkingLotContainCar(number);
        if (parkingLot != null) {
            parkingLot.takeCar(number);
        }
        return parkingLot;
    }


    public ParkingLot getParkingLotContainCar(String number) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.containCar(number)) {
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
    public ParkingLot pickParkingLot() {
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