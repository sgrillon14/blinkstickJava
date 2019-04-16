/*
 * Copyright (c) 2017 Stéphane GRILLON https://github.com/sgrillon14/blinkstickJava
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of the <organization> nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.github.sgrillon14.blinkstick.java;

public class BlinkstickJava {

    public static void main(String[] args) throws InterruptedException {

        boolean verbose = false;
        String feature = null;
        int speed = 1000;

        if (args.length == 0 || args.length == 1 && args[0].equals("-h")) {
            System.out.println("-h: Display this help");
            System.out.println("--verbose: Add debug informations in console.");
            System.out.println("-f: features 1 => Display all colors (16.777.215 of colors)");
            System.out.println(" 2 => Display 147 colors");
            System.out.println(" 3 => Display a traffic light sample");
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
                BlinkstickJavaFeature.displayAllColors(device, speed, verbose);
            } else if ("3".equals(feature)) {
                BlinkstickJavaFeature.trafficLight(device, speed, verbose);
            }
        }
        System.exit(1);
    }

}
