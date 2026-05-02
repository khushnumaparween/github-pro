package com.githubpro.dto;

public class RepoDTO {

    private String name;
    private String language;
    private int stargazers_count;

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }
}
