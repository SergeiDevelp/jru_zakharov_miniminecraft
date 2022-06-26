package ru.jru.zakharov.miniminecraft.entity.organizms.plants;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators.Bear;

import java.util.Set;
import java.util.function.Consumer;


@TypeData(name = "Трава",icon = "\uD83C\uDF31", maxWeight = 1, maxCount = 200, maxSpeed = 0, maxFood = 0)
public class Herb extends BasicItem {


    public Herb(String name, String icon, Limit limit){
        super(name,icon,limit);
    }

    @Override
    public boolean spawn(Cell cell) {
        Cell neighborCell = cell.getNextCell(1);
        return safePlantPropagation(neighborCell);
    }

    private boolean safePlantPropagation(Cell cell) {
        cell.getLock().lock();
        try {
            this.safeChangeWeight(cell, 75);
            Set<BasicItem> plants = cell.getResidents().get(getType());
            if (plants.size() < getLimit().getMaxCount() &&
                    getWeight() > getLimit().getMaxWeight() / 20
            ) {
                BasicItem newPlant = BasicItem.clone(this);
                double childWeight = getWeight()/5;
                newPlant.setWeight(childWeight);
                return plants.add(newPlant);
            }
        } finally {
            cell.getLock().unlock();
        }
        return false;
    }
}
