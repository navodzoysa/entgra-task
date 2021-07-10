package com.entgra.entgratask.models;

import com.entgra.entgratask.models.enums.Status;
import java.util.Date;

public class Device {
    private int id;
    private String name;
    private String model;
    private Status status;
    private Date enrolledTime;

    public Device() {
    }

    public Device(int id, String name, String model, Status status,  Date enrolledTime) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.status = status;
        this.enrolledTime = enrolledTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getEnrolledTime() {
        return enrolledTime;
    }

    public void setEnrolledTime(Date enrolledTime) {
        this.enrolledTime = enrolledTime;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", model='" + model + '\'' +
                ", enrolledTime=" + enrolledTime +
                '}';
    }
}
