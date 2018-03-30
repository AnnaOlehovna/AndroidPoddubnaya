package com.olehovnagmail.anya.presentation.screens.homework9;


public class User {

    private String imageUrl;
    private String surnameName;
    private String firstName;
    private String secondName ;
    private int age;
    private boolean isMan;

    public User() {
    }

    public User(String imageUrl, String surnameName,
                String firstName, String secondName, int age, boolean isMan) {
        this.imageUrl = imageUrl;
        this.surnameName = surnameName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.isMan = isMan;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSurnameName(String surnameName) {
        this.surnameName = surnameName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public String getSurnameName() {
        return surnameName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public boolean isMan() {
        return isMan;
    }
}
