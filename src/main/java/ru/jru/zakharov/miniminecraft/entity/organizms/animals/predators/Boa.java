package ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@TypeData(name = "Удав", icon = "\uD83D\uDC0D", maxWeight = 15, maxCount = 30, maxSpeed = 1, maxFood = 3)
public class Boa extends Predator {


    public Boa(String name, String icon,  Limit limit) {
        super(name, icon, limit);
    }
}
