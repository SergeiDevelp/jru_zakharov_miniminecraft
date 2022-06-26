package ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@TypeData(name = "Медведь", icon = "\uD83D\uDC3B", maxWeight = 500.0, maxCount = 5, maxSpeed = 2, maxFood = 80.0)
public class Bear extends Predator {
//    private final int weight = 500;
//    private final int speedMove = 2;
//    private final int health = 80; //килограммы пищи нужно животному для полного насыщения
//    private final String name = "\uD83D\uDC3B";

    public Bear(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
