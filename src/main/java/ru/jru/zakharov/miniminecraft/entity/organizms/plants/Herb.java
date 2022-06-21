package ru.jru.zakharov.miniminecraft.entity.organizms.plants;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;

import java.util.function.Consumer;


@Setting(name = "Трава",icon = "\uD83C\uDF31", maxWeight = 1, maxCount = 200, maxSpeed = 0, maxFood = 0)
public class Herb extends BasicItem {


    public Herb(String name, String icon, double weight, Limit limit){
        super(name,icon,weight,limit);
    }

    @Override
    public void spawn(Cell currentCell) {
        bornClone(currentCell);
    }

    private void bornClone(Cell cell) {
        safeModification(cell, c -> c.getResidents().get(this.getClass()).add(this.clone()));
    }

    private void safeModification(Cell cell, Consumer<Cell> operation) {
        cell.getLock().lock();
        try {
            operation.accept(cell);
        } finally {
            cell.getLock().unlock();
        }
    }
}
