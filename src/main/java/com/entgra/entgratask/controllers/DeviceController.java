package com.entgra.entgratask.controllers;

import com.entgra.entgratask.models.Device;
import com.entgra.entgratask.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public Collection<Device> findAll() {
        return deviceService.findAll();
    }

    @GetMapping("{id}")
    Device findById(@PathVariable int id) {
        return deviceService.findById(id);
    }

    @PostMapping
    Device save(@RequestBody Device device) {
        return deviceService.save(device);
    }

    @PutMapping
    Device update(@RequestBody Device device) {
        return deviceService.update(device);
    }

    @DeleteMapping("{id}")
    Device deleteById(@PathVariable int id) {
        return deviceService.deleteById(id);
    }
}
