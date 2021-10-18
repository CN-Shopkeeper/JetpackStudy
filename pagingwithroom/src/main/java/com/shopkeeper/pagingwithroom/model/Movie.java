package com.shopkeeper.pagingwithroom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "movie")
public class Movie {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "no", typeAffinity = ColumnInfo.INTEGER)
    private int no;
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    private int id;
    @ColumnInfo(name = "cover", typeAffinity = ColumnInfo.TEXT)
    private String cover;
    @ColumnInfo(name = "title", typeAffinity = ColumnInfo.TEXT)
    private String title;
    @ColumnInfo(name = "rate", typeAffinity = ColumnInfo.TEXT)
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

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return no == movie.no && id == movie.id && Objects.equals(cover, movie.cover) && Objects.equals(title, movie.title) && Objects.equals(rate, movie.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, id, cover, title, rate);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "no=" + no +
                ", id=" + id +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
