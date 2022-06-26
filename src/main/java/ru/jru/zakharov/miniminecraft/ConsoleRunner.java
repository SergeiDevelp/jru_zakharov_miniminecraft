package ru.jru.zakharov.miniminecraft;

import ru.jru.zakharov.miniminecraft.config.Setting;
import ru.jru.zakharov.miniminecraft.entity.Game;
import ru.jru.zakharov.miniminecraft.entity.map.GameField;
import ru.jru.zakharov.miniminecraft.repository.EntityFactory;
import ru.jru.zakharov.miniminecraft.repository.Factory;
import ru.jru.zakharov.miniminecraft.repository.GameFieldCreator;
import ru.jru.zakharov.miniminecraft.service.GameWorker;
import ru.jru.zakharov.miniminecraft.view.ConsoleView;
import ru.jru.zakharov.miniminecraft.view.View;

public class ConsoleRunner {

    public static void main(String[] args) {
        Factory entityFactory = new EntityFactory();
        GameFieldCreator gameMapCreator = new GameFieldCreator(entityFactory);
        int rows = Setting.get().getRows();
        int cols = Setting.get().getCols();
        GameField gameField = gameMapCreator.createRandomFilledGameMap(rows, cols, false);
        View view=new ConsoleView(gameField);
        Game game = new Game(gameField, entityFactory,view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
