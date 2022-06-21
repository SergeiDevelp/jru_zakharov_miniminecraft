package ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@Setting(name = "Лиса", icon = "\uD83E\uDD8A", maxWeight = 8, maxCount = 30, maxSpeed = 2, maxFood = 2)
public class Fox extends Predator {


    public Fox(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
