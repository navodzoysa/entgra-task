package com.entgra.entgratask.dao;

import com.entgra.entgratask.database.DatabaseConnection;
import com.entgra.entgratask.models.Device;
import com.entgra.entgratask.utils.ApplicationUtil;
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
                Device device = ApplicationUtil.selectSQLUtil(resultSet);
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
                Device device = ApplicationUtil.selectSQLUtil(resultSet);
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
            ApplicationUtil.prepareStatementUtil(preparedStatement, device);
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
            ApplicationUtil.prepareStatementUtil(preparedStatement, device);
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
