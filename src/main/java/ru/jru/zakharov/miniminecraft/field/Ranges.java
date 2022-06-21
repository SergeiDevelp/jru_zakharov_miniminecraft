package ru.jru.zakharov.miniminecraft.field;

import java.util.ArrayList;
import java.util.List;

public class Ranges {

    private static Coord size;
    private static List<Coord> allCoord;

    static void setSize(Coord size1) {
        size = size1;
        allCoord = new ArrayList<Coord>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoord.add(new Coord(x,y));
            }
        }
    }

    public static Coord getSize() {
        return size;
    }

    public static List<Coord> getAllCoord(){
        return allCoord;
    }

    public static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x < size.x &&
               coord.y >= 0 && coord.y < size.y;
    }
}
