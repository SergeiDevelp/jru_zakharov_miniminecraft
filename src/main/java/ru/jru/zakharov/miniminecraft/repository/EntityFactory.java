package ru.jru.zakharov.miniminecraft.repository;

import ru.jru.zakharov.miniminecraft.entity.map.Cell;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores.Caterpillar;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores.Duck;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.herbivores.Horse;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators.Bear;
import ru.jru.zakharov.miniminecraft.entity.organizms.animals.predators.Wolf;
import ru.jru.zakharov.miniminecraft.entity.organizms.plants.Herb;
import ru.jru.zakharov.miniminecraft.util.EntityFactoryData;
import ru.jru.zakharov.miniminecraft.util.Randomaizer;

import java.lang.reflect.Type;
import java.util.*;

public class EntityFactory implements Factory{

    private static final Class<?>[] TYPES = {Bear.class, Wolf.class, Herb.class, Horse.class, Caterpillar.class, Duck.class};
    private static final BasicItem[] PROTOTYPES = EntityFactoryData.createPrototypes(TYPES);

    public EntityFactory() {

    }

    @Override
    public Cell createRandomCell() {
        Map<Type, Set<BasicItem>> residents = new HashMap<>();
        boolean fill = Randomaizer.get(50);//TODO need config
        if (fill){
            for (BasicItem prototype : PROTOTYPES) {
                Type type = prototype.getClass();
                boolean born = Randomaizer.get(50); //TODO need config
                if (born){
                    residents.putIfAbsent(type, new HashSet<>());
                    Set<BasicItem> basicItems = residents.get(prototype.getClass());
                    int currentCount = basicItems.size();
                    int max = prototype.getLimit().getMaxCount() - currentCount;
                    int count = Randomaizer.random(0, max);
                    for (int i = 0; i < count; i++) {
                        basicItems.add(prototype.clone());
                    }
                }
            }
        }
        Cell cell = new Cell(residents);
        cell.setNextCell(new ArrayList<>());
        return cell;
    }

    @Override
    public List<BasicItem> getAllPrototypes() {
        return Arrays.asList(PROTOTYPES);
    }

    @Override
    public String toString() {
        return "EntityFactory{" +
                "prototypes=" + Arrays.toString(PROTOTYPES) +
                '}';
    }
}
