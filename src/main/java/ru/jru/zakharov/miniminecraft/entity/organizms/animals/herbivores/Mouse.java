package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;


import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

@TypeData(name = "Мышка", icon = "\uD83D\uDC01", maxWeight = 0.05, maxCount = 500, maxSpeed = 1, maxFood = 0.01)
public class Mouse extends Herbivores {



    public Mouse(String name, String icon, Limit limit) {
        super(name, icon,limit);
    }
}
