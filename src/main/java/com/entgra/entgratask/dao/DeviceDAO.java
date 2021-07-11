package com.entgra.entgratask.dao;

import com.entgra.entgratask.database.DatabaseConnection;
import com.entgra.entgratask.models.Device;
import com.entgra.entgratask.models.enums.Status;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeviceDAO implements DAO<Device> {
    private static Connection connection = DatabaseConnection.getConnection();
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static String tableName = "device";

    @Override
    public List<Device> getAll() {
        try {
            List<Device> deviceList = new ArrayList<>();
            preparedStatement = connection.prepareStatement("SELECT * FROM "+ tableName);
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
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM "+ tableName + " WHERE id = "+ id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String model = resultSet.getString("model");
                String statusString = resultSet.getString("status");
                Status status = Status.valueOf(statusString.toUpperCase());
                Date date = resultSet.getDate("enrolledTime");
                Device device = new Device(id1, name, model, status, date);
                return Optional.ofNullable(device);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean save(Device device) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO "+ tableName + "(name, model, status, enrolledTime) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, device.getName());
            preparedStatement.setString(2, device.getModel());
            preparedStatement.setString(3, device.getStatus().toString());
            preparedStatement.setDate(4, device.getEnrolledTime());
            int resultSet = preparedStatement.executeUpdate();
            if(resultSet == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Device device) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE "+ tableName + " SET name=?, model=?, status=?, enrolledTime=? WHERE id = " + device.getId());
            preparedStatement.setString(1, device.getName());
            preparedStatement.setString(2, device.getModel());
            preparedStatement.setString(3, device.getStatus().toString());
            preparedStatement.setDate(4, device.getEnrolledTime());
            int resultSet = preparedStatement.executeUpdate();
            if(resultSet == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM " + tableName +" WHERE id = " + id);
            int resultSet = preparedStatement.executeUpdate();
            if(resultSet == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
