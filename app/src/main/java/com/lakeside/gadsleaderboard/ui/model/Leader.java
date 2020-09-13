package com.lakeside.gadsleaderboard.ui.model;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Leader {

    @SerializedName("name")
    private String name;

    @SerializedName("score")
    private int score;

    @SerializedName("hours")
    private int hours;

    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @NotNull
    @Override
    public String toString() {
        return "Hour{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }
}
