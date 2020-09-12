package com.lakeside.gadsleaderboard.ui.service;

import com.lakeside.gadsleaderboard.ui.model.Leader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface leaderBoardAPI {

    @GET("/api/hours")
    Call<List<Leader>> getHours();

    @GET("/api/skilliq")
    Call<List<Leader>> getSkills();
}
