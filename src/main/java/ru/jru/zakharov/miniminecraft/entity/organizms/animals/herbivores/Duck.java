package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@Setting(name = "Утка", icon = "\uD83E\uDD86", maxWeight = 1, maxCount = 200, maxSpeed = 4, maxFood = 0.15)
public class Duck extends Herbivores {



    public Duck(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
