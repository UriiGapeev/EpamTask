package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Laptop extends Appliance{
	// you may add your own code here
    private int id;
    private String NameType;
    private double batteryCapacity;
    private String os;
    private int memoryRom;
    private int systemMemory;
    private double cpu;
    private int displayInchs;
    private List<SearchCriteria.Laptop> params;
    public void setParams( List<SearchCriteria.Laptop> paramEnumList) {
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

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public int getDisplayInchs() {
        return displayInchs;
    }

    public void setDisplayInchs(int displayInchs) {
        this.displayInchs = displayInchs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return id == laptop.id && batteryCapacity == laptop.batteryCapacity && memoryRom == laptop.memoryRom && systemMemory == laptop.systemMemory && Double.compare(laptop.cpu, cpu) == 0 && displayInchs == laptop.displayInchs && Objects.equals(NameType, laptop.NameType) && Objects.equals(os, laptop.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, NameType, batteryCapacity, os, memoryRom, systemMemory, cpu, displayInchs);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", NameType='" + NameType + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", os='" + os + '\'' +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", cpu=" + cpu +
                ", displayInchs=" + displayInchs;
    }
}
