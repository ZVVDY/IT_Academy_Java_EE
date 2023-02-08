package com.java.task1.devices.deviceController;

import com.java.task1.devices.Device;
import com.java.task1.devices.DeviceImp;
import com.java.task1.devices.deviceType.DeviceType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DeviceController {
    private Device device = new DeviceImp();
    private Map<Integer, Device> devices = new HashMap<>();
    private int powerOnDevices = 0;

    /**
     * Создание приборов
     */
    public Map<Integer, Device> initializationAllDevices() {
        devices.put(1, new DeviceImp(DeviceType.WASHING_MACHINE, 1500, false));
        devices.put(2, new DeviceImp(DeviceType.FRIDGE, 180, false));
        devices.put(3, new DeviceImp(DeviceType.COMPUTER, 400, false));
        devices.put(4, new DeviceImp(DeviceType.KETTLE, 1800, false));
        devices.put(5, new DeviceImp(DeviceType.TV_LED, 150, false));
        devices.put(6, new DeviceImp(DeviceType.LUMINAIRE_LED, 200, false));
        devices.put(7, new DeviceImp(DeviceType.COFFE_MAKER, 800, false));
        return devices;
    }

    /**
     * Включение случайных приборов в сеть
     */
    public void turnOnTheRandomDeviceNetwork() {
        Random random = new Random();
        int numberOfRandomDevices = random.nextInt(1, 8);
        for (int i = 0; i < numberOfRandomDevices; i++) {
            int numberDevice = random.nextInt(1, devices.size());
            Device temporaryDevice = devices.get(numberDevice);
            if (!temporaryDevice.deviceStatusOnOrOff()) {
                System.out.println(" Выбран прибор для включения:");
                System.out.println(temporaryDevice);
                temporaryDevice.turnOnTheDeviceNetwork();
                System.out.println(" Состояние прибора on/off: ");
                System.out.println(temporaryDevice);
                devices.replace(numberDevice, temporaryDevice);
            }
        }
    }

    /**
     * Отключение всех  приборов из сети
     */
    public void turnOffAllDeviceNetwork() {
        for (int i = 1; i < devices.size(); i++) {
            Device offDevice = devices.get(i);
            offDevice.turnOffTheAllDeviceNetwork();
            System.out.println(" Состояние прибора on/off: ");
            System.out.println(offDevice);
            devices.replace(i, offDevice);
        }
        powerOnDevices = 0;
        System.out.println(device);
    }

    /**
     * Потребляемая мощность в квартире
     */
    public void powerConsumptionNow() {
        for (int i = 1; i < devices.size(); i++) {
            Device powerDevice = devices.get(i);
            boolean onOrOffDevice = powerDevice.deviceStatusOnOrOff();
            if (onOrOffDevice) {
                powerOnDevices = powerOnDevices + powerDevice.powerConsumptionNow();
            }
            else {
                System.out.println("Нет включенных электроприборов");
                break;
            }
        }
        System.out.println("Потребляемая мощность в квартире = " + powerOnDevices + " Вт");
    }

    /**
     * Посмотреть включенные приборы в квартире
     */
    public void includedAppliancesInTheFlat() {
        System.out.println("Включенные приборы в квартире ");
        for (int i = 1; i < devices.size(); i++) {
            Device powerDevice = devices.get(i);
            boolean onOrOffDevice = powerDevice.deviceStatusOnOrOff();
            if (onOrOffDevice) {
                System.out.println(powerDevice);
            }
        }

    }


}






