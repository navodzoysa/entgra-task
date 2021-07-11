package com.entgra.entgratask.services;

import com.entgra.entgratask.dao.DeviceDAO;
import com.entgra.entgratask.models.Device;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DeviceServiceImpl implements DeviceService {
    private static DeviceDAO deviceDAO = new DeviceDAO();

    @Override
    public Collection<Device> findAll() {
        return deviceDAO.getAll();
    }

    @Override
    public Device findById(int id) {
        return deviceDAO.get(id).orElse(null);
    }

    @Override
    public String save(Device device) {
        boolean saved = deviceDAO.save(device);
        if(saved) {
            return "Successfully saved device with id " + device.getId();
        }
        return "false";
    }

    @Override
    public String update(Device device) {
        boolean updated = deviceDAO.update(device);
        if(updated) {
            return "Successfully updated device with id " + device.getId();
        }
        return "false";
    }

    @Override
    public String deleteById(int id) {
        boolean deleted = deviceDAO.delete(id);
        if(deleted) {
            return "Successfully deleted device with id = " + id;
        }
        return "Device was not found";
    }
}
