package ru.jru.zakharov.miniminecraft.entity.map;

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

}
