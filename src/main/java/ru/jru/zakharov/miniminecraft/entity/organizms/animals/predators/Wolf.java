package ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@Setting(name = "Волк", icon = "\uD83D\uDC3A", maxWeight = 50, maxCount = 30, maxSpeed = 3, maxFood = 8)
public class Wolf extends Predator {
//    int weight = 50;
//    int speedMove = 3;
//    int health = 8; //килограммы пищи нужно животному для полного насыщения

    public Wolf(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
