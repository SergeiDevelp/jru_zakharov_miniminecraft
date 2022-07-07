package ru.jru.zakharov.miniminecraft.service;

import ru.jru.zakharov.miniminecraft.config.Setting;
import ru.jru.zakharov.miniminecraft.entity.Game;
import lombok.RequiredArgsConstructor;
import ru.jru.zakharov.miniminecraft.view.View;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class GameWorker extends Thread {
    private final Game game;
    private final int PERIOD = Setting.get().getPeriod();

    @Override
    public void run() {
        View view = game.getView();
        view.showMap();
        view.showStatistics();
        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);

        List<OrganismWorker> workers = game
                .getEntityFactory()
                .getAllPrototypes()
                .stream()
                .map(o -> new OrganismWorker(o, game.getGameField()))
                .toList();
        mainPool.scheduleAtFixedRate(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(4);
            workers.forEach(servicePool::submit);
            servicePool.shutdown();
            try {
                if (servicePool.awaitTermination(PERIOD, TimeUnit.MILLISECONDS)) {
                    view.showMap();
                    view.showStatistics();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS);
    }
}