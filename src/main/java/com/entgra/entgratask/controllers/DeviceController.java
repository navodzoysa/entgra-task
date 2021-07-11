package com.entgra.entgratask.controllers;

import com.entgra.entgratask.models.Device;
import com.entgra.entgratask.services.DeviceService;
import com.entgra.entgratask.utils.ApplicationUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    ObjectNode findAll() {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.convertValue(deviceService.findAll(), JsonNode.class);
        return ApplicationUtil.createResponse(jsonNode, true);
    }

    @GetMapping("{id}")
    ObjectNode findById(@PathVariable int id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.convertValue(deviceService.findById(id), JsonNode.class);
        return ApplicationUtil.createResponse(jsonNode, true);
    }

    @PostMapping
    ObjectNode save(@RequestBody Device device) {
        return ApplicationUtil.createResponse(deviceService.save(device), true);
    }

    @PutMapping
    ObjectNode update(@RequestBody Device device) {
        return ApplicationUtil.createResponse(deviceService.update(device), true);
    }

    @DeleteMapping("{id}")
    ObjectNode deleteById(@PathVariable int id) {
        return ApplicationUtil.createResponse(deviceService.deleteById(id), true);
    }
}
