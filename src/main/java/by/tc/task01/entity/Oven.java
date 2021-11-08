package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Oven extends Appliance{
	// you may add your own code here
    private int id;
    private String NameType;
    private int powerConsumption;
    private int weight;
    private int capacity;
    private int depth;
    private double height;
    private double width;
    private List<SearchCriteria.Oven>  params;

    public void setParams( List<SearchCriteria.Oven> paramEnumList) {
        this.params = paramEnumList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameType() {
        return NameType;
    }

    public void setNameType(String nameType) {
        NameType = nameType;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oven oven = (Oven) o;
        return id == oven.id && powerConsumption == oven.powerConsumption && weight == oven.weight && capacity == oven.capacity && depth == oven.depth && Double.compare(oven.height, height) == 0 && Double.compare(oven.width, width) == 0 && Objects.equals(NameType, oven.NameType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, NameType, powerConsumption, weight, capacity, depth, height, width);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", NameType='" + NameType + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", depth=" + depth +
                ", height=" + height +
                ", width=" + width;
    }
}
