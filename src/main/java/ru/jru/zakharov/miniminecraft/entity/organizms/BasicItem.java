package ru.jru.zakharov.miniminecraft.entity.organizms;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.jru.zakharov.miniminecraft.abstraction.entity.Reproducible;

import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings("unused")
@Getter
@Setter
@AllArgsConstructor

public abstract class BasicItem implements Reproducible, Cloneable {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());

    private final long id = idCounter.incrementAndGet();
    private String name;
    private String icon;
    private double weight;
    private Limit limit;

    @Override
    public BasicItem clone() {
        try {
            return (BasicItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("cannot clone " + this);
        }
    }

    @Override
    public String toString() {
        return icon;
    }
}
