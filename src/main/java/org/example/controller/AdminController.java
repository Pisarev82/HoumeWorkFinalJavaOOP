package org.example.controller;

import org.example.model.ListOfMovies;
import org.example.model.Movie;
import org.example.model.User;
import org.example.views.AdminMenu;

public class AdminController {
    private User user;
    private AdminMenu adminMenu;
    private ListOfMovies listOfMovies;

    public AdminController(User user, ListOfMovies listOfMovies) {
        this.user = user;
        this.adminMenu = new AdminMenu();
        this.listOfMovies = listOfMovies;
    }

    public void run() {
        int adminChoes = adminMenu.showAdminMenu();
        switch (adminChoes) {
            case (1):
                addMovie();
                run();
                break;
            case (2):
                editMovie();
                run();
                break;
            case (3):
                deleteMovie();
                run();
                break;
            case (9):
                System.out.println("Exit");
                break;
            default:
                System.out.println("Команда не распознанна попробуйте еще раз");
                run();
                System.out.println(adminChoes);
        }
    }
    private void addMovie() {
        String[] data = adminMenu.addMovie();
        listOfMovies.addMovieInList(new Movie(data[0],Integer.parseInt(data[1])));
    }
    private void editMovie() {
        String[] data = adminMenu.addMovie();
        boolean notFound = true;
        for (Movie movie: listOfMovies.getList()) {
            if(movie.getName().equals(data[0])){
                movie.setName(data[0]);
                movie.setMoviePrice(Integer.parseInt(data[1]));
                notFound = false;
                break;
            }
        }
        if (notFound) {
            System.out.println(data[0] + " нет в списке фильмов");
        }
    }
    private void deleteMovie() {
        String[] data = adminMenu.addMovie();
        listOfMovies.addMovieInList(new Movie(data[0],Integer.parseInt(data[1])));
    }
}
