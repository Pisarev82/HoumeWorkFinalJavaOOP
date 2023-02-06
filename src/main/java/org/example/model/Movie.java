package org.example.model;

import java.util.Objects;

public class Movie {
    private String name;

    private int moviePrice;

    public Movie(String name, int moviePrice) {
        this.name = name;
        this.moviePrice = moviePrice;
    }

    public String getName() {
        return name;
    }

    public int getMoviePrice() {
        return moviePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoviePrice(int moviePrice) {
        this.moviePrice = moviePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return name.equals(movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
