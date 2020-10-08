package com.cuevana.films.service.impl;

import com.cuevana.films.dao.connection.ConnectionManager;
import com.cuevana.films.models.entity.Movie;
import com.cuevana.films.service.iface.MovieDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {

    private static final String SQL_INSERT = "insert into movie(name, description, image, created_at, "
            + "release_date, actors, gender_id, rating) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT = "select m.*, g.name genderName "
            + "from movie m "
            + "inner join gender g on m.gender_id = g.gender_id";
    private static final String SQL_SELECT_BY_ID = "select m.*, g.name genderName "
            + "from movie m "
            + "inner join gender g on m.gender_id = g.gender_id "
            + "WHERE m.movie_id = ?";

    @Override
    public void create(Movie movie) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setString(3, movie.getImage());
            preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setDate(5, java.sql.Date.valueOf(movie.getReleaseDate()));
            preparedStatement.setString(6, movie.getActors());
            preparedStatement.setInt(7, Integer.parseInt(movie.getGender()));
            preparedStatement.setInt(8, movie.getRating());
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Movie> getMovies() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movies = new ArrayList<>();

        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("movie_id"));
                movie.setName(resultSet.getString("name"));
                movie.setDescription(resultSet.getString("description"));
                movie.setImage(resultSet.getString("image"));
                movie.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                movie.setReleaseDate(resultSet.getDate("release_date").toLocalDate());
                movie.setActors(resultSet.getString("actors"));
                movie.setGender(resultSet.getString("gender_id"));
                movie.setGenderName(resultSet.getString("genderName"));
                movies.add(movie);
            }

            return movies;
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

    @Override
    public void update(int id, Movie movie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movie getMovieById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movie movie = null;

        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                movie = new Movie();
                movie.setId(resultSet.getInt("movie_id"));
                movie.setName(resultSet.getString("name"));
                movie.setDescription(resultSet.getString("description"));
                movie.setImage(resultSet.getString("image"));
                movie.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                movie.setReleaseDate(resultSet.getDate("release_date").toLocalDate());
                movie.setActors(resultSet.getString("actors"));
                movie.setGender(resultSet.getString("gender_id"));
                movie.setGenderName(resultSet.getString("genderName"));
            }

            return movie;
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
