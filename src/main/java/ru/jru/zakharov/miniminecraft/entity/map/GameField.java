package ru.jru.zakharov.miniminecraft.entity.map;

import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameField {
    private final Cell[][] cells;

    public GameField(int rows, int cols) {
        this.cells = new Cell[rows][cols];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getRows() {
        return cells.length;
    }

    public int getCols() {
        return cells[0].length;
    }

    public Set<BasicItem> getAll() {
        Set<BasicItem> all = new HashSet<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                all.addAll(cell.getResidents()
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toSet()));
            }
        }
        return all;
    }
}
