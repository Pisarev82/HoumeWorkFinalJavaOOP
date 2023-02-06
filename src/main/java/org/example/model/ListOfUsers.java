package org.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfUsers {
    private List<User> list;
    private List<Movie> listOfMovies;

    public ListOfUsers(String filePath, List<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
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
                if (x.length >= 4) {
                    List<Movie> userMovie= new ArrayList<>();
                    if (x.length == 5) {
                        String[] moviesName = x[4].split("~");
                        for (String movieName: moviesName) {
                            Movie movie = serchMovieByName(movieName);
                            if (movie != null) {
                                userMovie.add(movie);
                            }
                        }
                    }

                    list.add(new User(x[0], Role.valueOf(x[1]), Integer.parseInt(x[2]), userMovie));
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveUsersToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, false)){
            for (User user: list) {
                StringBuilder userMovies = new StringBuilder();
                for (Movie movie:user.getUserMovies()){
                    userMovies.append(movie.getName() + "~");
                }
                writer.write(user.getName() +":" +
                        ""+ user.getRole() + ":" +
                        ""+ user.getBalance() +"" +
                        ":0:" +
                        ""+ userMovies + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getList() {
        return list;
    }

    public void addUserInList(User user) {
        list.add(user);
    }

    private Movie serchMovieByName(String movieName) {
        for (Movie movie: listOfMovies) {
            if(movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }
}
