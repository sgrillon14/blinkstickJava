package com.sgrillon.blinkstick.java;


public class BlinkstickJava {

    public static void main(String[] args) throws InterruptedException {
        
        boolean verbose = false;
        String feature = null;
        int speed = 1000;
        
        if (args.length == 0 || (args.length == 1 && args[0].equals("-h"))) {
            System.out.println("-h: Display this help");
            System.out.println("--verbose: Add debug informations in console.");
            System.out.println("-f: features 1 => Display all colors (16.777.215 of colors)");
            System.out.println("             2 => Display 147 colors");
            System.out.println("             3 => Display a traffic light sample");
        }

        for (int i = 0; i < args.length; i++) {
            if ("--verbose".equals(args[i])) {
                verbose = true;
            } else if ("-f".equals(args[i])) {
                feature = args[i + 1];
            } else if ("-s".equals(args[i])) {
                speed = Integer.parseInt(args[i + 1]);
            }
        }

        BlinkStick device = BlinkStick.findFirst();
        if (device == null) {
            System.out.println("BlinkStick Not found...");
        } else {
            if ("1".equals(feature)) {
                BlinkstickJavaFeature.k2000(device, verbose);
            } else if ("2".equals(feature)) {
                BlinkstickJavaFeature.displayAllColors(device, speed,verbose);
            } else if ("3".equals(feature)) {
                BlinkstickJavaFeature.trafficLight(device, speed, verbose);
            }
            device.turnOff();
        }
        return;
    }

}
