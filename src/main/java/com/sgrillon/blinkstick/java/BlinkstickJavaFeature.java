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

package com.sgrillon.blinkstick.java;

import java.util.Map;

public class BlinkstickJavaFeature {

    public static void k2000(BlinkStick blinkStick, boolean verbose) throws InterruptedException {
        k2000(blinkStick, 0, 0, 1);
        k2000(blinkStick, 0, 1, 0);
        k2000(blinkStick, 0, 1, 1);
        k2000(blinkStick, 1, 0, 0);
        k2000(blinkStick, 1, 0, 1);
        k2000(blinkStick, 1, 1, 0);
        k2000(blinkStick, 1, 1, 1);
        blinkStick.turnOff();
    }

    public static void displayAllColors(BlinkStick blinkStick, int speed, boolean verbose) throws InterruptedException {
        for (Map.Entry<String, String> entry : BlinkStick.COLORS.entrySet()) {
            blinkStick.setColor(entry.getValue());
            Thread.sleep(speed);
        }
        blinkStick.turnOff();
    }

    public static void trafficLight(BlinkStick blinkStick, int speed, boolean verbose) throws InterruptedException {
        blinkStick.setColor("red");
        Thread.sleep(speed);
        blinkStick.setColor("orangered");
        Thread.sleep(speed);
        blinkStick.setColor("green");
        Thread.sleep(speed);
        blinkStick.turnOff();
    }

    private static void k2000(BlinkStick blinkStick, int a, int b, int c) throws InterruptedException {
        for (int i = 0; i < 255; i++) {
            blinkStick.setColor(i * a, i * b, i * c);
            Thread.sleep(10);
        }
        for (int i = 255; i >= 0; i--) {
            blinkStick.setColor(i * a, i * b, i * c);
            Thread.sleep(10);
        }
    }
}
