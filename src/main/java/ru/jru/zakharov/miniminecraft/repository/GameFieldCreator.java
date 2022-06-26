package ru.jru.zakharov.miniminecraft.repository;

import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.map.GameField;

import java.util.List;

public class GameFieldCreator {

    private final Factory entityFactory;

    public GameFieldCreator(Factory entityFactory) {
        this.entityFactory = entityFactory;
    }

    public GameField createRandomFilledGameMap(int rows, int cols) {
        return createRandomFilledGameMap(rows, cols, false);
    }

    public GameField createRandomFilledGameMap(int rows, int cols, boolean empty) {
        GameField gameField = new GameField(rows, cols);
        Cell[][] cells = gameField.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col] = entityFactory.createRandomCell(empty);
            }
        }
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col].updateNextCell(gameField, row, col);
            }
        }
        return gameField;
    }
}
