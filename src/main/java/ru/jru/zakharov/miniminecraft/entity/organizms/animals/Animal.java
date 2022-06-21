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

    public Animal(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public void eat(Cell currentCell) {

    }

    @Override
    public Cell move(Cell startCell) {
        int countCellForStep = this.getLimit().getMaxSpeed();
        Cell last = findLastCell(startCell, countCellForStep);
        removeMe(startCell);
        addMe(last);
        return last;
    }

    @Override
    public void spawn(Cell currentCell) {
        Type type = this.getClass();
        Map<Type, Set<BasicItem>> residents = currentCell.getResidents();
        Set<BasicItem> basicItems = residents.get(type);
        if (Objects.nonNull(basicItems) && basicItems.contains(this) && basicItems.size() > 2) {
            bornClone(currentCell);
        }
    }

    private Cell findLastCell(Cell startCell, int countCellForStep) {

        Set<Cell> visitedCells = new HashSet<>();
        while (visitedCells.size() < countCellForStep){
            var nextCells = startCell
                    .getNextCell()
                    .stream()
                    .filter(cell -> !visitedCells.contains(cell))
                    .toList();
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                startCell = nextCells.get(ThreadLocalRandom.current().nextInt(countDirections));
                visitedCells.add(startCell);
            } else {
                break;
            }
        }
        return startCell;
    }

    private void addMe(Cell cell) {
        safeModification(cell, c -> c.getResidents().get(this.getClass()).add(this));
    }

    private void removeMe(Cell cell) {

        safeModification(cell, c -> c.getResidents().get(this.getClass()).remove(this));
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
