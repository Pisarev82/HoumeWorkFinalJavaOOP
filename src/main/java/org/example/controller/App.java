package org.example.controller;


import org.example.model.*;
import org.example.views.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class App {
    private MainMenu mainMenu = new MainMenu();
    private User user;
    private ListOfMovies listOfMovies;
    private ListOfUsers listOfUsersObj;


    public App() {
        this.listOfMovies = new ListOfMovies("src/netflix.txt");;
        this.listOfUsersObj = new ListOfUsers("src/users.txt", listOfMovies.getList());;
    }

    public void run() {
        String name = mainMenu.authorize();
        if(isAdmin(name)) {
            adminMenu();
        }
        else {
            userMenu();
        }
        listOfUsersObj.saveUsersToFile("src/users.txt");
        listOfMovies.saveMoviesToFile("src/netflix.txt");
    }

    private void userMenu() {
        UserController userController = new UserController(user, listOfMovies);
        userController.run();
    }
    private void adminMenu(){
        AdminController adminController = new AdminController(user, listOfMovies);
        adminController.run();
    }
    private boolean isAdmin(String name){
        user = serchUser(name);
        return user.getRole().equals(Role.admin);
    }

    private User serchUser(String name){

        List<User> Users = listOfUsersObj.getList();
        for (User user: Users) {
            if(name.equals(user.getName())){
                this.user = user;
                return user;
            }
        }
        this.user = newUserRegistration(name);
        listOfUsersObj.addUserInList(user);
        System.out.printf("Пользователь %s зарегистрирован\n", name);
        return user;
    }
    private User newUserRegistration(String name) {
        int choese = mainMenu.newUserRegistration(name);
        if (choese == 2){
            return new User(name, Role.user, 100, new ArrayList<Movie>());
        } else if (choese == 1) {
            run();
        } else if (choese == 3) {
            System.out.println("До свидания.");
        }
        throw new RuntimeException("Надо было вводить 1, 2 bkb 3(((. До свидания.");
    }

}
