package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores.Herbivores;


@Setting(name = "Буйвол", icon = "\uD83D\uDC03", maxWeight = 700, maxCount = 10, maxSpeed = 3, maxFood = 100)
public class Buffalo extends Herbivores {



    public Buffalo(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
