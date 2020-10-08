package com.cuevana.films.controller;

import com.cuevana.films.controller.util.GridMovie;
import com.cuevana.films.models.entity.Gender;
import com.cuevana.films.models.entity.Movie;
import com.cuevana.films.service.iface.GenderDao;
import com.cuevana.films.service.iface.MovieDao;
import com.cuevana.films.service.iface.MovieService;
import com.cuevana.films.service.impl.GenderDaoImpl;
import com.cuevana.films.service.impl.MovieDaoImpl;
import com.cuevana.films.service.impl.MovieServiceImpl;
import com.cuevana.films.util.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FilmsApplicationController {

    private final static String[] COLUMNS = {"ID", "NOMBRE", "DESCRIPCIÓN",
        "GENERO", "IMAGEN", "ACTORES", "FECHA ESTRENO", "ELIMINAR", "EDITAR"};
    private final GridMovie gridMovie;
    private static FilmsApplicationController instance;
    private final MovieService movieService;
    private final MovieDao movieDao;
    private final GenderDao genderDao;

    public static FilmsApplicationController getInstance() {
        if (instance == null) {
            instance = new FilmsApplicationController();
        }
        return instance;
    }

    private FilmsApplicationController() {
        gridMovie = new GridMovie();
        movieService = new MovieServiceImpl();
        movieDao = new MovieDaoImpl();
        genderDao = new GenderDaoImpl();
    }

    private void initTable(JTable jTable) {
        jTable.setRowHeight(25);
        gridMovie.initTable(jTable, COLUMNS);
    }

    public String validateFields(String id, String name, String description, String gender,
            String image, String actors, String releaseDate) {
        StringBuilder builder = new StringBuilder();

//        if (!validateField(id)) {
//            builder.append("ID de la pelicula es requerido\n");
//        } else if (!id.trim().matches(Utils.REGULAR_EXPRESSION_ONLY_NUMBERS)) {
//            builder.append("ID de la pelicula solo permite números");
//        }
        if (!validateField(name)) {
            builder.append("Nombre de la pelicula es requerido\n");
        }

        if (!validateField(description)) {
            builder.append("Descripción de la pelicula es requerido\n");
        }

//        if (!validateField(gender)) {
//            builder.append("Genero de la pelicula es requerido\n");
//        }
        if (!validateField(gender)) {
            builder.append("Genero de la pelicula es requerido\n");
        } else if (!gender.trim().matches(Utils.REGULAR_EXPRESSION_ONLY_NUMBERS)) {
            builder.append("Genero de la pelicula solo permite números");
        }

        if (!validateField(image)) {
            builder.append("Imagen de la pelicula es requerido\n");
        }

        if (!validateField(actors)) {
            builder.append("Actores de la pelicula es requerido\n");
        }

        if (!validateField(releaseDate)) {
            builder.append("Fecha de estreno de la pelicula es requerido\n");
        } else if (!releaseDate.trim().matches(Utils.REGULAR_EXPRESSION_DATE)) {
            builder.append("Fecha de estreno invalida. Recuerde que la fecha debe tener el formato yyyy-MM-dd\n");
        }

        return builder.toString();
    }

    private boolean validateField(String value) {
        if (value == null || value.trim().length() == 0) {
            return false;
        }
        return true;
    }

    public void createMovie(String id, String name, String description, String gender, String image,
            String actors, String releaseDate, String path) throws IOException, SQLException {
        Movie movie = new Movie();
        //movie.setId(Integer.parseInt(id.trim()));
        movie.setName(name.trim());
        movie.setDescription(description.trim());
        movie.setImage(image.trim());
        movie.setGender(gender.trim());
        movie.setActors(actors.trim());
        movie.setReleaseDate(LocalDate.parse(releaseDate.trim()));
        movieDao.create(movie);
        //movieService.create(movie, path);
    }

    public Movie getMovie(int id, String path) throws IOException {
        return movieService.getMovieById(id, path);
    }

    public Gender getGender(int id) throws SQLException {
        return genderDao.getGenderById(id);
    }

    public void loadMovies(JTable jTable, String path) throws IOException, SQLException {
        List<Movie> movies = movieDao.getMovies(); //movieService.getMovies(path);
        initTable(jTable);
        if (movies.isEmpty()) {
            return;
        }
        gridMovie.fillGrid(movies);
    }

    public void clearText(JTextField jTextField) {
        jTextField.setText("");
    }
}
