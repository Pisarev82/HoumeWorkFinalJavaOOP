package org.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfMovies {

    private List<Movie> list;

    public ListOfMovies(String filePath) {
        readUsersFromFile(filePath);
    }

    private void readUsersFromFile(String filePath){
        list = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] x = line.split(":");
                if (x.length == 2) {
                    list.add(new Movie(x[0], Integer.parseInt(x[1])));
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveMoviesToFile (String filePath) {
        try (FileWriter writer = new FileWriter(filePath, false)){
            for (Movie movie: list) {

                writer.write(movie.getName() +":" +
                        ""+ movie.getMoviePrice() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> getList() {
        return list;
    }

    public void addMovieInList(Movie movie) {
        list.add(movie);
    }
    public void deleteMovie(Movie movie) {
        list.remove(movie);
    }
}
