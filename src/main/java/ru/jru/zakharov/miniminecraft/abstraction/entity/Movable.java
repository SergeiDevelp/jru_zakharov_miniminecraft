package ru.jru.zakharov.miniminecraft.abstraction.entity;


import ru.jru.zakharov.miniminecraft.entity.map.Cell;

@FunctionalInterface
public interface Movable {
    boolean move(Cell startCell);

}
