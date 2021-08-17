package com.shopkeeper.room2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name="name", typeAffinity = ColumnInfo.TEXT)
    public String name;

    @ColumnInfo(name="age", typeAffinity = ColumnInfo.INTEGER)
    public int age;

    @ColumnInfo(name="sex", typeAffinity = ColumnInfo.INTEGER)
    public int sex;

    @ColumnInfo(name="bar", typeAffinity = ColumnInfo.INTEGER)
    public int bar;

    @Ignore
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age, int sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Ignore
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Ignore
    public Student(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Ignore
    public Student(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", bar=" + bar +
                '}';
    }
}
