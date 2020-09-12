/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuevana.films.service.iface;

import com.cuevana.films.models.entity.Movie;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author adrian
 */
public interface MovieService {

    public void create(Movie movie, String path) throws IOException;

    public List<Movie> getMovies(String path) throws IOException;

    public void update(Movie movie, String path) throws IOException;

    public void delete(int id, String path) throws IOException;

    public Movie getMovieById(int id, String path) throws IOException;
}
