package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@TypeData(name = "Овечка", icon = "\uD83D\uDC11", maxWeight = 70, maxCount = 140, maxSpeed = 3, maxFood = 15)
public class Sheep extends Herbivores {



    public Sheep(String name, String icon,  Limit limit) {
        super(name, icon,  limit);
    }
}
