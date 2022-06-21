package ru.jru.zakharov.miniminecraft.service;

import ru.jru.zakharov.miniminecraft.entity.Game;
import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.map.GameField;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.Animal;
import ru.jru.zakharov.miniminecraft.view.ConsoleView;

import java.lang.reflect.Type;
import java.util.Set;

public class OrganismWorker implements Runnable{

    private final BasicItem prototype;
    private final GameField gameField;


    public OrganismWorker(BasicItem prototype, GameField gameField) {
        this.prototype = prototype;
        this.gameField = gameField;

    }

    @Override
    public void run() {
        Cell[][] cells = gameField.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Type type = prototype.getClass();
                Set<BasicItem> organisms = cell.getResidents().get(type);
                for (BasicItem organism : organisms) {
                    if (organism instanceof Animal animal) {
                        Cell destination = animal.move(cell);
                        System.out.println("what s happen is it)))");
                        //animal.eat(destination);
                        animal.move(destination);
                        animal.move(cell);
                        animal.spawn(destination);
                    } else {
                        prototype.spawn(cell);
                    }
                }
            }
        }
    }
}
