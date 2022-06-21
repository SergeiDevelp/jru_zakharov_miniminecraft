package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores.Herbivores;


@Setting(name = "Кабан", icon = "\uD83D\uDC17", maxWeight = 400, maxCount = 50, maxSpeed = 2, maxFood = 50)
public class Boar extends Herbivores {



    public Boar(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
