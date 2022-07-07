package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;


@TypeData(name = "Буйвол", icon = "\uD83D\uDC03", maxWeight = 700, maxCount = 10, maxSpeed = 3, maxFood = 100)
public class Buffalo extends Herbivores {



    public Buffalo(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
