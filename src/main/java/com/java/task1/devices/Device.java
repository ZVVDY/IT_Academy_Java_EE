package com.java.task1.devices;

        import java.util.Map;

public interface Device {

    boolean deviceStatusOnOrOff();
    int powerConsumptionNow();
    void turnOnTheDeviceNetwork();

    void turnOffTheAllDeviceNetwork();

    void searchDeviceByParameters();

    void printDevice(Map<Integer, Device> devices);
}

