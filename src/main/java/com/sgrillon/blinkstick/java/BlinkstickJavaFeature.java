package com.sgrillon.blinkstick.java;

import java.util.Map;

public class BlinkstickJavaFeature {

    public static void k2000(BlinkStick device, boolean verbose) throws InterruptedException {
        k2000(device, 0, 0, 1);
        k2000(device, 0, 1, 0);
        k2000(device, 0, 1, 1);
        k2000(device, 1, 0, 0);
        k2000(device, 1, 0, 1);
        k2000(device, 1, 1, 0);
        k2000(device, 1, 1, 1);
    }

    public static void displayAllColors(BlinkStick device, int speed, boolean verbose) throws InterruptedException {
        for (Map.Entry<String, String> entry : device.COLORS.entrySet()) {
            device.setColor(entry.getValue());
            Thread.sleep(speed);
        }
    }

    public static void trafficLight(BlinkStick device, int speed, boolean verbose) throws InterruptedException {
        device.setColor("red");
        Thread.sleep(speed);
        device.setColor("orangered");
        Thread.sleep(speed);
        device.setColor("green");
        Thread.sleep(speed);
    }

    private static void k2000(BlinkStick device, int a, int b, int c) throws InterruptedException {
        for (int i = 0; i < 255; i++) {
            device.setColor(i * a, i * b, i * c);
            Thread.sleep(10);
        }
        for (int i = 255; i >= 0; i--) {
            device.setColor(i * a, i * b, i * c);
            Thread.sleep(10);
        }
    }
}
