package by.tc.task01.entity;

import java.util.Objects;

public class Refrigerator extends Appliance{
	// you may add your own code here
    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double overalCapacity;
    private int height;
    private int width;

    @Override
    public String toString() {
        return "Refrigerator{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overalCapacity=" + overalCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerator that = (Refrigerator) o;
        return powerConsumption == that.powerConsumption && weight == that.weight && freezerCapacity == that.freezerCapacity && overalCapacity == that.overalCapacity && height == that.height && width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, freezerCapacity, overalCapacity, height, width);
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

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOveralCapacity() {
        return overalCapacity;
    }

    public void setOveralCapacity(int overalCapacity) {
        this.overalCapacity = overalCapacity;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
