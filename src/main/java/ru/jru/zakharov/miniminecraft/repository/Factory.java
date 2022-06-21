package ru.jru.zakharov.miniminecraft.repository;

import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;

import java.util.List;

public interface Factory {

    Cell createRandomCell();

    List<BasicItem> getAllPrototypes();
}
