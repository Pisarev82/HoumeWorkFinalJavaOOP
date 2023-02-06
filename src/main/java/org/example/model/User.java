package org.example.model;

import java.util.List;

public class User {
    // balans < cost -> то фильм не одобряем
        private Role role;
        private String name;
        private int balance;
        private List<Movie> userMovies;
        public User(String name, Role role, int balance, List<Movie> userMovies) {
            this.name = name;
            this.role = role;
            this.balance = balance;
            this.userMovies = userMovies;
        }

        public String getName() {
            return name;
        }

        public Role getRole() {
            return role;
        }

        public int getBalance() {
            return balance;
        }


        public void setBalance(int balance) {
            this.balance = balance;
        }

        public void addMovie(Movie movie) {
            userMovies.add(movie);
        }
        public void removeMovie(Movie movie) {
            userMovies.remove(movie);
        }

    public List<Movie> getUserMovies() {
        return userMovies;
    }

    @Override
        public String toString() {
            return "User{" +
                    "role=" + role +
                    ", name='" + name + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }

