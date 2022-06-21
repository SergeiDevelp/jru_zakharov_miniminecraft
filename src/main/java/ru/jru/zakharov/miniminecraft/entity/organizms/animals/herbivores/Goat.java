package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores.Herbivores;



@Setting(name = "Коза", icon = "\uD83D\uDC10", maxWeight = 60, maxCount = 140, maxSpeed = 3, maxFood = 10)
public class Goat extends Herbivores {



    public Goat(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
