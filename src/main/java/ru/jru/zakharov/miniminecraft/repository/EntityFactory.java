package ru.jru.zakharov.miniminecraft.repository;

import ru.jru.zakharov.miniminecraft.config.Setting;
import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.util.Randomaizer;

import java.util.*;

public class EntityFactory implements Factory{

    @Override
    public Cell createRandomCell(boolean empty) {
        Cell cell = new Cell();
        Map<String, Set<BasicItem>> residents = cell.getResidents();
        boolean fill = Randomaizer.get(33); //TODO need config
        if (fill && !empty) {
            for (BasicItem prototype : Setting.PROTOTYPES) {
                String type = prototype.getType();
                boolean born = Randomaizer.get(50); //TODO need config
                if (born) {
                    Set<BasicItem> organisms = residents.get(type);
                    int currentCount = organisms.size();
                    int max = prototype.getLimit().getMaxCount() - currentCount;
                    int count = Randomaizer.random(0, max);
                    for (int i = 0; i < count; i++) {
                        organisms.add(BasicItem.clone(prototype));
                    }
                }
            }
        }
        return cell;
    }

    @Override
    public List<BasicItem> getAllPrototypes() {
        return Arrays.asList(Setting.PROTOTYPES);
    }

    @Override
    public String toString() {
        return "EntityFactory{" +
                "prototypes=" + Arrays.toString(Setting.PROTOTYPES) +
                '}';
    }
}
