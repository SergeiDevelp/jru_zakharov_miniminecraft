package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;


@TypeData(name = "Олень", icon = "\uD83E\uDD8C", maxWeight = 300, maxCount = 20, maxSpeed = 4, maxFood = 50)
public class Deer extends Herbivores {



    public Deer(String name, String icon,  Limit limit) {
        super(name, icon,limit);
    }
}
