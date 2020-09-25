package com.cuevana.films.service.impl;

import com.cuevana.films.models.entity.Movie;
import com.cuevana.films.service.iface.MovieService;
import com.cuevana.films.util.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * BufferedReader es una clase de Java para leer el texto de una secuencia de
 * entrada (como un archivo) almacenando en el búfer caracteres que leen a la
 * perfección caracteres, matrices o líneas.
 *
 * @author adrian
 */
public class MovieServiceImpl implements MovieService {

    @Override
    public void create(Movie movie, String path) throws IOException {
        if (!Utils.existsFile(path)) {
            File file = new File(path);
            file.createNewFile();
        }

        movie.setCreatedAt(LocalDateTime.now());

        FileWriter fileWriter = new FileWriter(path, true);
        fileWriter.write(movie.toString());
        fileWriter.close();
    }

    @Override
    public List<Movie> getMovies(String path) throws IOException {
        if (!Utils.existsFile(path)) {
            throw new FileNotFoundException("Archivo no existe");
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        List<Movie> movies = new ArrayList<>();
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] contents = currentLine.split(";");
            Movie movie = new Movie();
            movie.setId(Integer.parseInt(contents[0]));
            movie.setName(contents[1]);
            movie.setDescription(contents[2]);
            movie.setGender(contents[3]);
            movie.setImage(contents[4]);
            movie.setCreatedAt(LocalDateTime.parse(contents[5]));
            movie.setReleaseDate(LocalDate.parse(contents[6]));
            movie.setActors(contents[7]);
            movie.setRating(Integer.parseInt(contents[8]));
            movies.add(movie);
        }
        
        bufferedReader.close();
        
        return movies;
    }

    @Override
    public void update(Movie movie, String path) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id, String path) throws IOException {
       BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;

        try {
            if (!Utils.existsFile(path)) {
                return;
            }

            bufferedReader = new BufferedReader(new FileReader(path));

            List<Movie> movies = new ArrayList();
            
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] contents = currentLine.split(";");
                Movie movie = new Movie();
                movie.setId(Integer.parseInt(contents[0])); // Convertir a int
                movie.setName(contents[1]);
                movie.setDescription(contents[2]);
                movie.setGender(contents[3]);
                movie.setImage(contents[4]);
                movie.setCreatedAt(LocalDateTime.parse(contents[5])); // Convertir a LocalDateTime
                movie.setReleaseDate(LocalDate.parse(contents[6])); // Convertir a LocalDate
                movie.setActors(contents[7]);
                movie.setRating(Integer.parseInt(contents[8])); // Convertir a int
                movies.add(movie);
            }

            if (movies.size() > 0) {
                File file = new File(Utils.PATH_FILE_TMP);
                if (!file.exists()) {
                    file.createNewFile();
                }

                fileWriter = new FileWriter(Utils.PATH_FILE_TMP);
                
                for (Movie movie : movies) {
                    if (movie.getId() != id) {
                        fileWriter.write(movie.toString());
                    }
                }
            }
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            Utils.renameFile(path, Utils.PATH_FILE_TMP);
        }
    }

    @Override
    public Movie getMovieById(int id, String path) throws IOException {
        if (!Utils.existsFile(path)) {
            return null;
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] contents = currentLine.split(";");
            if (Integer.parseInt(contents[0]) == id) {
                Movie movie = new Movie();
                movie.setId(Integer.parseInt(contents[0]));
                movie.setName(contents[1]);
                movie.setDescription(contents[2]);
                movie.setGender(contents[3]);
                movie.setImage(contents[4]);
                movie.setCreatedAt(LocalDateTime.parse(contents[5]));
                movie.setReleaseDate(LocalDate.parse(contents[6]));
                movie.setActors(contents[7]);
                movie.setRating(Integer.parseInt(contents[8]));
                return movie;
            }
        }

        return null;
    }

}
