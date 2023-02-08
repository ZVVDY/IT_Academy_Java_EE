package com.java.task1.controller;

import com.java.task1.devices.Device;
import com.java.task1.devices.DeviceImp;
import com.java.task1.devices.deviceController.DeviceController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Controller {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Integer number;
    private Device device = new DeviceImp();
    private  DeviceController deviceController= new DeviceController();
    private Map<Integer, Device> allDevice = deviceController.initializationAllDevices();
    public void menuHomeAppliances() {
        System.out.println("Добро пожаловать в программу Домашние Электроприборы");
        System.out.println("Войти (Enter)" + "\n" +
                "1 - Посмотреть перечень всех электроприборов в квартире(их состояние on/off) " + "\n" +
                "2 - Включить случайные приборы в сеть" + "\n" +
                "3 - Посмотреть включенные приборы в квартире" + "\n" +
                "4 - Выбрать прибор для включения в сеть" + "\n" +
                "5 - Посмотреть потребляемую мощность(Вт)" + "\n" +
                "6 - Произвести сортировку приборов в квартире по мощности" + "\n" +
                "7 - Поиск прибора по параметрам" + "\n" +
                "8 - Отключить все приборы, из розеток" + "\n" +
                "0 - Выйти из приложения(Exit the application)");
        try {
            number = Integer.parseInt(reader.readLine());
            switch (number) {
                case 1:
                    device.printDevice(allDevice);
                    break;
                case 2:
                    deviceController.turnOnTheRandomDeviceNetwork();
                    break;
                case 3:
                    deviceController.includedAppliancesInTheFlat();
                    break;
                case 4:
                    //device.turnOnTheDeviceNetwork();
                    break;
                case 5:
                    deviceController.powerConsumptionNow();
                    break;
                case 6:
                    //device.turnOnTheDeviceNetwork();
                    break;
                case 7:
                    //device.turnOnTheDeviceNetwork();
                    break;
                case 8:
                    deviceController.turnOffAllDeviceNetwork();
                    break;
                case 0:
                    System.out.println("Вы вышли из программы  (You are out of the program)");
                    break;
                default:
                    System.out.println("Введите номер меню 0,1,2 (Enter menu number 0,1,2)");
                    menuHomeAppliances();
            }
        } catch (Exception e) {
            System.err.println("Введите цифры 0,1,2, а не символы(Enter the number 0,1,2, not symbols)");
        } finally {
            menuHomeAppliances();
        }
    }
}


