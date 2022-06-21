package ru.jru.zakharov.miniminecraft.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomaizer {

    private Randomaizer() {
    }
    public static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static double random(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }


    public static boolean get(int percentRandoma) {
        return random(0, 100) < percentRandoma;
    }
}
