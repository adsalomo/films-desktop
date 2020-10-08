package com.cuevana.films.service.impl;

import com.cuevana.films.dao.connection.ConnectionManager;
import com.cuevana.films.models.entity.Gender;
import com.cuevana.films.service.iface.GenderDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderDaoImpl implements GenderDao {

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM gender WHERE gender_id = ?";

    @Override
    public Gender getGenderById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Gender gender = null;

        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                gender = new Gender();
                gender.setId(resultSet.getInt("gender_id"));
                gender.setName(resultSet.getString("name"));
            }

            return gender;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}
