/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuevana.films.controller.util;

import com.cuevana.films.models.entity.Movie;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author adrian
 */
public class GridMovie {

    private TableModelMovie tableModelMovie;

    public void initTable(JTable jTable, String[] columns) {
        tableModelMovie = new TableModelMovie();

        for (String column : columns) {
            tableModelMovie.addColumn(column);
        }

        jTable.setModel(tableModelMovie);
    }

    public TableModelMovie getTableModelMovie() {
        return tableModelMovie;
    }
    
    public void fillGrid(List<Movie> movies) {
        tableModelMovie.setRowCount(movies.size());
        int row = 0;
        for (Movie movie : movies) {
            tableModelMovie.setValueAt(movie.getId(), row, 0);
            tableModelMovie.setValueAt(movie.getName(), row, 1);
            tableModelMovie.setValueAt(movie.getDescription(), row, 2);
            tableModelMovie.setValueAt(movie.getGender(), row, 3);
            tableModelMovie.setValueAt(movie.getImage(), row, 4);
            tableModelMovie.setValueAt(movie.getActors(), row, 5);
            tableModelMovie.setValueAt(movie.getReleaseDate(), row, 6);
            row++;
        }
      
    }
}
