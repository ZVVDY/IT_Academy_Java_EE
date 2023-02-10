package com.java.task1.devices;

import java.util.Map;

public interface Device {

    boolean deviceStatusOnOrOff();

    int powerConsumptionNow();

    void turnOnTheDeviceNetwork();

    void turnOffTheAllDeviceNetwork();

    void searchDeviceByParameters(Map<Integer, Device> searchDevice);

    void selectingTheDeviceToBeConnectedToTheNetwork(Map<Integer, Device> devicesConnected);

    void printDevice(Map<Integer, Device> devices);

    void sortingByDevicePower(Map<Integer, Device> sortingDevices);

    void sortingDevice();
}

