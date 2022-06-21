package ru.jru.zakharov.miniminecraft.abstraction.entity;


import ru.jru.zakharov.miniminecraft.entity.map.Cell;

@FunctionalInterface
public interface Movable {
    @FunctionalInterface
    interface Finder{
        int getRating(Cell currentCell);
    }

    Cell move(Cell startCell);

}
