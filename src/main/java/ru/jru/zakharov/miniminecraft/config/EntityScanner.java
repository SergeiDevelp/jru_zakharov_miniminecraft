package ru.jru.zakharov.miniminecraft.config;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.TypeData;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;
import ru.jru.zakharov.miniminecraft.exceprion.AppExceprion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class EntityScanner {

    private EntityScanner() {
    }

    public static BasicItem[] createPrototypes(Class<?>[] TYPES) {
        BasicItem[] organisms = new BasicItem[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            if (type.isAnnotationPresent(TypeData.class)) {
                TypeData typeData = type.getAnnotation(TypeData.class);
                String name = typeData.name();
                String icon = typeData.icon();
                Limit limit = new Limit(
                        typeData.maxWeight(),
                        typeData.maxCount(),
                        typeData.maxSpeed(),
                        typeData.maxFood()
                );

                organisms[index++] = generatePrototype(type, name, icon, limit);
            }
        }
        return organisms;
    }

    private static BasicItem generatePrototype(Class<?> type, String name, String icon, Limit limit) {
        try {
            Constructor<?> constructor = type.getConstructor(String.class, String.class, Limit.class);
            return (BasicItem) constructor.newInstance(name, icon, limit);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new AppExceprion("not found Entity constructor", e);
        }
    }
}
