package ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores;

import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.Animal;

public abstract class Herbivores extends Animal {

    public Herbivores(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

}
