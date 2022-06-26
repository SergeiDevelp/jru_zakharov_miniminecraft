package ru.jru.zakharov.miniminecraft.entity.map;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.field.Matrix;
import ru.jru.zakharov.miniminecraft.util.Randomaizer;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
public class Cell {

    private final List<Cell> nextCell = new ArrayList<>();
    @Getter
    private final Lock lock = new ReentrantLock(true);
    @Getter
    private final Map<String, Set<BasicItem>> residents = new HashMap<>() {
        private void checkNull(Object key) {
            this.putIfAbsent(key.toString(), new HashSet<>());
        }

        @Override
        public Set<BasicItem> get(Object key) {
            checkNull(key);
            return super.get(key);
        }

        @Override
        public Set<BasicItem> put(String key, Set<BasicItem> value) {
            checkNull(key);
            return super.put(key, value);
        }
    };


    public void updateNextCell(GameField gameField, int row, int col) {
        Cell[][] cells = gameField.getCells();
        if (row > 0) nextCell.add(cells[row - 1][col]);
        if (col > 0) nextCell.add(cells[row][col - 1]);
        if (row < gameField.getRows() - 1) nextCell.add(cells[row + 1][col]);
        if (col < gameField.getCols() - 1) nextCell.add(cells[row][col + 1]);
    }

    public Cell getNextCell(int countStep) {
        Set<Cell> visitedCells = new HashSet<>();
        Cell currentCell = this;
        while (visitedCells.size() < countStep) {
            var nextCells = currentCell
                    .nextCell
                    .stream()
                    .filter(cell -> !visitedCells.contains(cell))
                    .toList();
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                int index = Randomaizer.random(0, countDirections);
                currentCell = nextCells.get(index);
                visitedCells.add(currentCell);
            } else {
                break;
            }
        }
        return currentCell;
    }

    public int getNextCellCount(){
        return nextCell.size();
    }

    @Override
    public String toString() {
        return getResidents().values().stream()
                .filter((list) -> list.size() > 0)
                .sorted((o1, o2) -> o2.size() - o1.size())
                .map(set -> set.stream().findAny().get().getLetter())
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
