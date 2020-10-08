package com.cuevana.films.service.iface;

import com.cuevana.films.models.entity.Movie;
import java.sql.SQLException;
import java.util.List;

public interface MovieDao {
 
    public void create(Movie movie) throws SQLException;
    
    public List<Movie> getMovies() throws SQLException;
    
    public void update(int id, Movie movie);
    
    public void delete(int id);
    
    public Movie getMovieById(int id) throws SQLException;
    
}
