package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@Setting(name = "Овечка", icon = "\uD83D\uDC11", maxWeight = 70, maxCount = 140, maxSpeed = 3, maxFood = 15)
public class Sheep extends Herbivores {



    public Sheep(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
