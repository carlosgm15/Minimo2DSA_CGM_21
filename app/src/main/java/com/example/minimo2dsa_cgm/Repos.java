package com.example.minimo2dsa_cgm;

public class Repos {

    private  String language;
    private String name;

    public Repos() {
    }

    public Repos(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getLanguage(){
        return language;
    }
    public String getName(){
        return name;
    }

}
