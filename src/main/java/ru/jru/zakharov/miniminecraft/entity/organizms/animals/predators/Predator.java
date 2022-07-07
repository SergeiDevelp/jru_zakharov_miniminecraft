package ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators;

import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.Animal;

public abstract class Predator extends Animal {

    public Predator(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
