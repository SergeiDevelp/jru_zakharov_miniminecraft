package ru.jru.zakharov.miniminecraft.util;

import ru.jru.zakharov.miniminecraft.abstraction.annotations.Setting;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;
import ru.jru.zakharov.miniminecraft.entity.organizms.Limit;
import ru.jru.zakharov.miniminecraft.exceprion.AppExceprion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EntityFactoryData {

    private EntityFactoryData() {
    }
    public static BasicItem[] createPrototypes(Class<?>[] TYPES) {
        BasicItem[] organisms = new BasicItem[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            if (type.isAnnotationPresent(Setting.class)) {
                Setting setting = type.getAnnotation(Setting.class);
                String name = setting.name();
                String icon = setting.icon();
                double maxWeight = setting.maxWeight();
                double weight = Randomaizer.random(maxWeight / 2, maxWeight);
                Limit limit = new Limit(
                        setting.maxWeight(),
                        setting.maxCount(),
                        setting.maxSpeed(),
                        setting.maxFood()
                );

                organisms[index++] = generatePrototype(type, name, icon, weight, limit);
            }
        }
        return organisms;
    }

    private static BasicItem generatePrototype(Class<?> type, String name, String icon, double weight, Limit limit) {
        try {
            Constructor<?> constructor = type.getConstructor(String.class, String.class, double.class, Limit.class);
            return (BasicItem) constructor.newInstance(name, icon, weight, limit);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new AppExceprion("not found Entity constructor", e);
        }

    }
}
