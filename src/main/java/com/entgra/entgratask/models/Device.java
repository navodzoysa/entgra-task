package com.entgra.entgratask.models;

import com.entgra.entgratask.models.enums.Status;
import java.util.Date;

public class Device {
    private int id;
    private String name;
    private Status status;
    private String model;
    private Date enrolledTime;

    public Device() {
    }

    public Device(int id, String name, Status status, String model, Date enrolledTime) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.model = model;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
