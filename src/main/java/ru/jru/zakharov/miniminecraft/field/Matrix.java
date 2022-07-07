package ru.jru.zakharov.miniminecraft.field;

import ru.jru.zakharov.miniminecraft.entity.BoxAnimal;

public class Matrix {
    private BoxAnimal[][] matrix;

    Matrix(BoxAnimal defaultBoxAnimal){
        matrix = new BoxAnimal[Ranges.getSize().x][Ranges.getSize().y];
        for (Coord coord : Ranges.getAllCoord()) {
            matrix[coord.x][coord.y] = defaultBoxAnimal;
        }
    }

    BoxAnimal getterBoxAnimalMatrix(Coord coord){
        if (Ranges.inRange(coord))
            return matrix[coord.x][coord.y];
        return null;
    }
    void setterBoxAnimalMatrix(Coord coord, BoxAnimal boxAnimal){
        if (Ranges.inRange(coord))
            matrix[coord.x][coord.y] = boxAnimal;
    }
}
