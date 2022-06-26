package ru.jru.zakharov.miniminecraft.entity.organizms.animals;

import ru.jru.zakharov.miniminecraft.abstraction.entity.Eating;
import ru.jru.zakharov.miniminecraft.abstraction.entity.Movable;
import ru.jru.zakharov.miniminecraft.abstraction.entity.Reproducible;
import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public abstract class Animal extends BasicItem implements Eating, Reproducible, Movable {

    public Animal(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

    @Override
    public boolean eat(Cell currentCell) {
        if (safeFindFood(currentCell)) {
            return true;
        }
        if (getWeight() > 0) {
            return safeChangeWeight(currentCell, -5);
        }
        return !safeDie(currentCell);

    }


    @Override
    public boolean move(Cell startCell) {
        int countStep = this.getLimit().getMaxSpeed();
        Cell destinationCell = startCell.getNextCell(countStep);
        return safeMove(startCell, destinationCell);
    }

    @Override
    public boolean spawn(Cell cell) {
        return safeSpawnAnimal(cell);
    }

    private boolean safeSpawnAnimal(Cell cell) {
        cell.getLock().lock();
        try {
            Set<BasicItem> organisms = cell.getResidents().get(getType());
            double maxWeight = getLimit().getMaxWeight();
            if (getWeight() > maxWeight / 2 &&
                    organisms.contains(this) &&
                    organisms.size() >= 2 &&
                    organisms.size() < getLimit().getMaxCount()
            ) {
                //all animals lose weight after the birth of offspring
                double childWeight = getWeight() / 2;
                setWeight(childWeight / 2);
                BasicItem clone = BasicItem.clone(this);
                clone.setWeight(childWeight);
                organisms.add(clone);
                return true;
            }
        } finally {
            cell.getLock().unlock();
        }
        return false;
    }
}
