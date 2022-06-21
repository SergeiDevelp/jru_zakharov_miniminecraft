package ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@Setting(name = "Орел", icon = "\uD83E\uDD85", maxWeight = 6, maxCount = 20, maxSpeed = 3, maxFood = 1)
public class Eagle extends Predator {


    public Eagle(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
