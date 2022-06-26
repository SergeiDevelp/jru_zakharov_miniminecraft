package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@TypeData(name = "Кролик", icon = "\uD83D\uDC07", maxWeight = 2, maxCount = 150, maxSpeed = 2, maxFood = 0.45)
public class Rabbit extends Herbivores {



    public Rabbit(String name, String icon, Limit limit) {
        super(name, icon,limit);
    }
}
