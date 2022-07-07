package ru.jru.zakharov.miniminecraft.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.jru.zakharov.miniminecraft.entity.BoxAnimal;
import ru.jru.zakharov.miniminecraft.entity.map.GameField;
import ru.jru.zakharov.miniminecraft.repository.Factory;
import ru.jru.zakharov.miniminecraft.view.View;


@Data
@AllArgsConstructor
public class Game {

    private final GameField gameField;
    private final Factory entityFactory;
    private final View view;
}
