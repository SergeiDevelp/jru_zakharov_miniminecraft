package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@TypeData(name = "Утка", icon = "\uD83E\uDD86", maxWeight = 1, maxCount = 200, maxSpeed = 4, maxFood = 0.15)
public class Duck extends Herbivores {



    public Duck(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
