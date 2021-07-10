package com.entgra.entgratask.services;

import com.entgra.entgratask.models.Device;
import com.entgra.entgratask.models.enums.Status;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeviceServiceImpl implements DeviceService {

    private int deviceId = 1;
    private Map<Integer, Device> deviceMap = new HashMap<>();

    {
        Device device = new Device();
        device.setId(deviceId);
        device.setName("myphone");
        device.setModel("Oneplus 6");
        device.setStatus(Status.ACTIVE);
        device.setEnrolledTime(new Date(System.currentTimeMillis()));
        deviceMap.put(device.getId(), device);
    }

    @Override
    public Collection<Device> findAll() {
        return deviceMap.values();
    }

    @Override
    public Device findById(int id) {
        return deviceMap.get(id);
    }

    @Override
    public Device save(Device device) {
        int newDeviceId = deviceId + 1;
        device.setId(newDeviceId);
        deviceMap.put(device.getId(), device);
        return deviceMap.get(newDeviceId);
    }

    @Override
    public Device update(Device device) {
        deviceId = device.getId();
        if(deviceMap.get(deviceId) != null) {
            deviceMap.put(deviceId, device);
            return device;
        }
        return null;
    }

    @Override
    public Device deleteById(int id) {
        if(deviceMap.get(id) != null) {
            return deviceMap.remove(id);
        }
        return null;
    }
}
