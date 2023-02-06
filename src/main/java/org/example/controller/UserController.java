package org.example.controller;

import org.example.model.ListOfMovies;
import org.example.model.User;
import org.example.model.Movie;
import org.example.views.UserMenu;

public class UserController {
    private User user;
    UserMenu userMenu;
    ListOfMovies listOfMovies;

    public UserController(User user, ListOfMovies listOfMovies){
        this.user = user;
        this.userMenu = new UserMenu();
        this.listOfMovies = listOfMovies;
    }

    public void run(){
        int userchoese = userMenu.showUserMenu();
        switch (userchoese) {
            case (1):
                allMovies();
                run();
                break;
            case (2):
                filmApplication();
                run();
                break;
            case (3):
                returnMovie();
                run();
                break;
            case (4):
                userMovies();
                run();
                break;
            case (9):
                System.out.println("Exit");
                break;
            default:
                System.out.println("Команда не распознанна попробуйте еще раз");
                run();
        }
    }


    private void filmApplication(){
        String movieName = userMenu.showSubmitMenu();
        boolean notFound = true;
        for (Movie movie: listOfMovies.getList()) {
            if(movie.getName().equals(movieName)){
                if (userPay(movie)){
                    user.addMovie(movie);
                };
                notFound = false;
                break;
            }
        }
        if (notFound) {
        System.out.println(movieName + " нет в списке фильмов доступных для покупки");
        }
    }

    private void returnMovie(){
        String movie = userMenu.showReturnMenu();
        boolean notFound = true;
        for (Movie m :
                user.getUserMovies()) {
            if (m.getName().equals(movie)) {
                user.setBalance(user.getBalance()+m.getMoviePrice());
                user.removeMovie(m);
                System.out.println("Из ваших покупок удален " + movie);
                notFound = false;
                break;
            }
        }
        if (notFound) {
            System.out.println(movie + " нет в списке ваших фильмов");
        }
    }

    private boolean userPay(Movie movie){
        if(user.getBalance()>movie.getMoviePrice()){
            user.setBalance(user.getBalance()-movie.getMoviePrice());
            userMenu.showMovie(movie.getName());
            return true;
        } else {
            return false;
        }
    }

    private void allMovies(){
        for (Movie movie:listOfMovies.getList()) {
            userMenu.showAllMovie(movie.getName());
        }
    }

    private void userMovies(){
        for (Movie movie: user.getUserMovies()) {
            userMenu.showAllMovie(movie.getName());
        }
    }

}
