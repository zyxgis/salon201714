package com.salon.entity;

/**
 * ParkingBoy选择停车场的方法
 */
public enum PickTypeEnum {
    /**
     * 最大获取可用停车的位数
     */
    PARKING_EMPTY_MAX(1),

    /**
     * 最大获取可用停车的比例
     */
    PARKING_RATIO_MIN(2),

    /**
     * 最大所有停车的位数
     */
    PARKING_CAPACITY_MAX(3);

    private int value;

    PickTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
