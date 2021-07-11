package com.entgra.entgratask.services;

import com.entgra.entgratask.models.Device;
import java.util.Collection;

public interface DeviceService {
    Collection<Device> findAll();

    Device findById(int id);

    String save(Device device);

    String update(Device device);

    String deleteById(int id);
}
