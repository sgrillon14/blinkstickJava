package com.sgrillon.blinkstick.java;

import org.junit.Test;

public class BlinkstickJavaUT {
    
    @Test
    public void k2000Test() throws InterruptedException{
        BlinkstickJava.main(new String[]{"-f", "1"});
    }
    
    @Test
    public void displayAllColorsTest() throws InterruptedException{
        BlinkstickJava.main(new String[]{"-f", "2","-s", "500"});
    }
    
    @Test
    public void trafficLightTest() throws InterruptedException{
        BlinkstickJava.main(new String[]{"-f", "3", "-s", "3000"});
    }

}
