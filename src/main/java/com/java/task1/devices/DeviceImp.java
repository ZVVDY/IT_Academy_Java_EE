package com.java.task1.devices;

import com.java.task1.devices.deviceType.DeviceType;

import java.util.*;

public class DeviceImp implements Device {
    private DeviceType typeOfDevice;
    private int powerOfDevice;
    private boolean stateOfDevice;
    public DeviceImp(DeviceType typeOfDevice, int powerOfDevice, boolean stateOfDevice) {
        this.typeOfDevice = typeOfDevice;
        this.powerOfDevice = powerOfDevice;
        this.stateOfDevice = stateOfDevice;
    }

    /**
     * Состояние прибора вкл/откл
     * @return
     */
    @Override
    public boolean deviceStatusOnOrOff() {
                return isStateOfDevice();
    }
    /**
     * Потребление мощности в данный момент
     *
     * @return
     */
    @Override
    public int powerConsumptionNow() {
        return getPowerOfDevice();
    }

    /**
     * включение  случайных приборов в сеть
     */
    @Override
    public void turnOnTheDeviceNetwork() {
        setStateOfDevice(true);
    }
    /**
     * отключение  всех приборов из сети
     */
    @Override
    public void turnOffTheAllDeviceNetwork() {
        setStateOfDevice(false);
    }

    /**
     * Поиск прибора по заданным параметрам
     */
    @Override
    public void searchDeviceByParameters() {


    }

    @Override
    public void printDevice(Map<Integer, Device> devicesPrint) {
        System.out.println(devicesPrint);
    }

    public DeviceType getTypeOfDevice() {

        return typeOfDevice;
    }

    public void setTypeOfDevice(DeviceType typeOfDevice) {

        this.typeOfDevice = typeOfDevice;
    }

    public int getPowerOfDevice() {

        return powerOfDevice;
    }

    public void setPowerOfDevice(int powerOfDevice) {

        this.powerOfDevice = powerOfDevice;
    }

    public boolean isStateOfDevice() {

        return stateOfDevice;
    }

    public void setStateOfDevice(boolean stateOfDevice) {

        this.stateOfDevice = stateOfDevice;
    }
    public DeviceImp() {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Номер электроприбора ,").append("Тип электроприбора= ")
                .append(this.typeOfDevice).append(" ,").append("Мощность электроприбора (Вт)= ")
                .append(this.powerOfDevice).append(" , Состояние прибора включен(on)/отключен(off) в розетку - ")
                .append(this.stateOfDevice ? "on" : "off").append(")+\n");

        return stringBuilder.toString();

    }
}



