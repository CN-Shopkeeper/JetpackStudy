package com.shopkeeper.paging.model;

import java.util.Objects;

public class Movie {
    private int id;
    private String cover;
    private String title;
    private String rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && cover.equals(movie.cover) && title.equals(movie.title) && rate.equals(movie.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cover, title, rate);
    }
}
