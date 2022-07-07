package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@TypeData(name = "Лошадь", icon = "\uD83D\uDC0E", maxWeight = 400, maxCount = 20, maxSpeed = 4, maxFood = 60)
public class Horse extends Herbivores {



    public Horse(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
