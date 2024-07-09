package com.gy.mapapitest.vmTest;

import java.util.ArrayList;
import java.util.Random;

/**
 * -Xms600m -Xmx600m -XX:SurvivorRatio=8
 */
public class VmTest {
    byte[] buffer = new byte[new Random().nextInt(1024*100)];

    public static void main(String[] args) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ArrayList<VmTest> list = new ArrayList<>();
        while(true) {
            list.add(new VmTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
