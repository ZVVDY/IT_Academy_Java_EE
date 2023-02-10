package com.java.task1.devices;

import com.java.task1.devices.deviceType.DeviceType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DeviceImp implements Device, Comparable<Device> {
    private DeviceType typeOfDevice;
    private int powerOfDevice;
    private boolean stateOfDevice;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private List<Device> devicesSorting = new ArrayList<>();


    /**
     * Состояние прибора вкл/откл
     *
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
     * включение   приборов в сеть
     *
     * @return
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
     * Поиск прибора по мощности
     *
     * @param searchDevice
     */
    @Override
    public void searchDeviceByParameters(Map<Integer, Device> searchDevice) {
        List<Device> foundDevices = new ArrayList<>();
        System.out.println("Введите минимальную мощность");
        try {
            Integer startPower = Integer.parseInt(reader.readLine());
            System.out.println("Введите максимальную мощность");
            Integer endPower = Integer.parseInt(reader.readLine());
            System.out.println("Результат поиска");
            for (int i = 1; i <= searchDevice.size(); i++) {
                Device tempDevice = searchDevice.get(i);
                if (tempDevice.powerConsumptionNow() >= startPower
                        && tempDevice.powerConsumptionNow() <= endPower) {
                    foundDevices.add(tempDevice);
                }
            }
            System.out.println(foundDevices);
        } catch (IOException e) {
            System.out.println("Ошибка поиска");
            throw new RuntimeException(e);
        }
    }

    /**
     * Включение приборов в сеть
     *
     * @param devicesConnected
     */
    @Override
    public void selectingTheDeviceToBeConnectedToTheNetwork(Map<Integer, Device> devicesConnected) {
        Integer numberDevice;
        for (int i = 1; i <= devicesConnected.size(); i++) {
            Device powerDevice = devicesConnected.get(i);
            boolean onOrOffDevice = powerDevice.deviceStatusOnOrOff();
            if (onOrOffDevice) {
                System.out.println("Включенные электроприборы в сеть");
                System.out.println(i + " " + powerDevice);
            }
        }
        System.out.println("Не включенные электроприборы в сеть");
        for (int i = 1; i <= devicesConnected.size(); i++) {
            Device powerDevice = devicesConnected.get(i);
            boolean onOrOffDevice = powerDevice.deviceStatusOnOrOff();
            if (!onOrOffDevice) {
                System.out.println(i + " " + powerDevice);
            }
        }
        try {
            System.out.println("Введите номер прибора для включения в сеть");
            numberDevice = Integer.parseInt(reader.readLine());
            for (int i = numberDevice; i <= devicesConnected.size(); i++) {
                Device onDevice = devicesConnected.get(numberDevice);
                boolean onDeviceNetwork = onDevice.deviceStatusOnOrOff();
                if (!onDeviceNetwork) {
                    System.out.println(" Состояние прибора on/off: ");
                    System.out.println(onDevice);
                    onDevice.turnOnTheDeviceNetwork();
                    devicesConnected.replace(i, onDevice);
                    System.err.println("Прибор включен\n" + i + " " + onDevice);
                    break;
                }

            }

        } catch (IOException e) {
            System.err.println("Введите цифры 1,2,3,4,5,6,7,8, а не символы");
        }
    }

    /**
     * Сортировка приборов по мощности
     *
     * @param sortingDevices
     */
    @Override
    public void sortingByDevicePower(Map<Integer, Device> sortingDevices) {
        for (int i = 1; i <= sortingDevices.size(); i++) {
            Device sortDevice = sortingDevices.get(i);
            devicesSorting.add(sortDevice);
        }
    }

    @Override
    public int compareTo(Device compareDevice) {
        int compareQuantity = compareDevice.powerConsumptionNow();
        return this.powerOfDevice - compareQuantity;
    }

    public static Comparator<Device> deviceComparator = new Comparator<Device>() {
        @Override
        public int compare(Device o1, Device o2) {
            Integer deviceName1 = o1.powerConsumptionNow();
            Integer deviceName2 = o2.powerConsumptionNow();
            return deviceName1.compareTo(deviceName2);
        }
    };

    public void sortingDevice() {
        System.out.println("Сортировка по мощности приборов");
        Collections.sort(devicesSorting, Collections.reverseOrder());
        System.out.println(devicesSorting);
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

    public DeviceImp(DeviceType typeOfDevice, int powerOfDevice, boolean stateOfDevice) {
        this.typeOfDevice = typeOfDevice;
        this.powerOfDevice = powerOfDevice;
        this.stateOfDevice = stateOfDevice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Номер электроприбора ,").append("Тип электроприбора= ")
                .append(this.typeOfDevice).append(" ,").append("Мощность электроприбора (Вт)= ")
                .append(this.powerOfDevice).append(" , Состояние прибора включен(on)/отключен(off) в розетку - ")
                .append(this.stateOfDevice ? "on" : "off").append(")\n");

        return stringBuilder.toString();

    }

}









