package ru.jru.zakharov.miniminecraft.repository;

import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.map.GameField;

import java.util.List;

public class GameFieldCreator {

    private final Factory entityFactory;

    public GameFieldCreator(Factory entityFactory) {
        this.entityFactory = entityFactory;
    }

    public GameField createRandomFilledGameField(int rows, int cols) {
        GameField gameField = new GameField(rows, cols);
        Cell[][] cells = gameField.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col] = entityFactory.createRandomCell();
            }
        }
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Cell cell = cells[row][col];
                List<Cell> nextCell = cell.getNextCell();
                if (row > 0) nextCell.add(cells[row - 1][col]);
                if (col > 0) nextCell.add(cells[row][col - 1]);
                if (row < rows - 1) nextCell.add(cells[row + 1][col]);
                if (col < cols - 1) nextCell.add(cells[row][col + 1]);
            }
        }
        return gameField;
    }
}
