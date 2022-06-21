package ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@Setting(name = "Медведь", icon = "\uD83D\uDC3B", maxWeight = 500, maxCount = 5, maxSpeed = 2, maxFood = 80)
public class Bear extends Predator {
//    private final int weight = 500;
//    private final int speedMove = 2;
//    private final int health = 80; //килограммы пищи нужно животному для полного насыщения
//    private final String name = "\uD83D\uDC3B";

    public Bear(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
