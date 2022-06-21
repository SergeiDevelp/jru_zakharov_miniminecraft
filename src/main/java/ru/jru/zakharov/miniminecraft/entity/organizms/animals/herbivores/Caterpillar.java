package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@Setting(name = "Гусеница", icon = "\uD83D\uDC1B", maxWeight = 0.01, maxCount = 1000, maxSpeed = 0, maxFood = 0)//TODO my be something change?
public class Caterpillar extends Herbivores {



    public Caterpillar(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
