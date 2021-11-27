package by.tc.task4.dao.entity;

import java.util.Objects;

public class Auto{
    private int auto_id;
    private String model;
    private String number;
    private String images_url;
    private String vehicle_haracteristics;
    private String color;

    public Auto(String model, String number, String images_url, String vehicle_haracteristics, String color) {
       this.model = model;
        this.number = number;
        this.images_url = images_url;
        this.vehicle_haracteristics = vehicle_haracteristics;
        this.color = color;
    }

    public int getAuto_id() {
        return auto_id;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImages_url() {
        return images_url;
    }

    public void setImages_url(String images_url) {
        this.images_url = images_url;
    }

    public String getVehicle_haracteristics() {
        return vehicle_haracteristics;
    }

    public void setVehicle_haracteristics(String vehicle_haracteristics) {
        this.vehicle_haracteristics = vehicle_haracteristics;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "auto_id=" + auto_id +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", images_url='" + images_url + '\'' +
                ", vehicle_haracteristics='" + vehicle_haracteristics + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return auto_id == auto.auto_id && Objects.equals(model, auto.model) && Objects.equals(number, auto.number) && Objects.equals(images_url, auto.images_url) && Objects.equals(vehicle_haracteristics, auto.vehicle_haracteristics) && Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auto_id, model, number, images_url, vehicle_haracteristics, color);
    }
}
