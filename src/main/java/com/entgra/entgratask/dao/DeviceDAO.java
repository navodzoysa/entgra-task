package com.entgra.entgratask.dao;

import com.entgra.entgratask.database.DatabaseConnection;
import com.entgra.entgratask.models.Device;
import com.entgra.entgratask.models.enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DeviceDAO implements DAO<Device> {
    private static Connection connection = DatabaseConnection.getConnection();
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    @Override
    public List<Device> getAll() {
        try {
            List<Device> deviceList = new ArrayList<>();
            preparedStatement = connection.prepareStatement("SELECT * FROM device");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String model = resultSet.getString("model");
                String statusString = resultSet.getString("status");
                Status status = Status.valueOf(statusString.toUpperCase());
                Date date = resultSet.getDate("enrolledTime");
                Device device = new Device(id, name, model, status, date);
                deviceList.add(device);
            }
            return deviceList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Device> get(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Device device) {

    }

    @Override
    public void update(Device device) {

    }

    @Override
    public void delete(int id) {

    }
}
