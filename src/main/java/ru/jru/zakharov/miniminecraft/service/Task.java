package ru.jru.zakharov.miniminecraft.service;


import lombok.Getter;
import ru.jru.zakharov.miniminecraft.entity.organizms.BasicItem;

import java.util.function.Consumer;

@Getter
public class Task {

    private final BasicItem organism;
    private final Consumer<BasicItem> operation;

    public Task(BasicItem organism, Consumer<BasicItem> operation) {
        this.organism = organism;
        this.operation = operation;
    }

    public void run() {
        operation.accept(organism);
    }

}
