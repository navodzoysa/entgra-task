package com.entgra.entgratask.services;

import com.entgra.entgratask.models.Device;

import java.util.Collection;
import java.util.List;

public interface DeviceService {
    Collection<Device> findAll();

    Device findById(int id);

    Device save(Device device);

    Device update(Device device);

    Device deleteById(int id);
}
