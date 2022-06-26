package ru.jru.zakharov.miniminecraft.service;



import ru.jru.zakharov.miniminecraft.entity.Game;
import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.map.GameField;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.Animal;
import ru.jru.zakharov.miniminecraft.view.ConsoleView;

import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements Runnable{

    private final BasicItem prototype;
    private final GameField gameField;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();


    public OrganismWorker(BasicItem prototype, GameField gameField) {
        this.prototype = prototype;
        this.gameField = gameField;

    }

    @Override
    public void run() {
        Cell[][] cells = gameField.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                try {
                    processOneCell(cell);
                } catch (Exception e) {
                    //TODO replace it -> throw...
                    e.printStackTrace();
                    System.err.println("OMG. Debug it!");
                    System.exit(0);
                }
            }
        }
    }

    private void processOneCell(Cell cell) {
        String type = prototype.getType();
        Set<BasicItem> organisms = cell.getResidents().get(type);
        if (Objects.nonNull(organisms)) {
            //build tasks (need correct iteration, without any modification)
            cell.getLock().lock(); //ONLY READ
            try {
                organisms.forEach(organism -> {
                    //here possible action-cycle for entity (enum, collection or array)
                    Task task = new Task(organism, o -> {
                        o.spawn(cell);
                        if (organism instanceof Animal animal) {
                            animal.eat(cell);
                            animal.move(cell);
                        }
                    });
                    tasks.add(task);
                });
            } finally {
                cell.getLock().unlock();
            }

            //run tasks
            //see CQRS pattern or CommandBus pattern and Producer-Consumer problem.
            //This cycle can to run in other thread or threads (pool)
            tasks.forEach(Task::run);
            tasks.clear();
        }
    }
}
