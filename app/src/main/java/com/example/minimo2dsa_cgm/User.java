package com.example.minimo2dsa_cgm;

public class User {


    private String avatar_url;
    private String repos_url;
    private String name;
    private int public_repos;
    private int followers;
    private int following;

    public User() {
    }

    public User(String avatar_url,String repos_url, String name, int followers, int following) {

        this.avatar_url = avatar_url;
        this.repos_url = repos_url;
        this.name = name;
        this.public_repos = public_repos;
        this.followers = followers;
        this.following = following;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

}