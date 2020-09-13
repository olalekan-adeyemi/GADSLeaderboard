package com.lakeside.gadsleaderboard.service;

import com.lakeside.gadsleaderboard.model.Leader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardAPI {

    @GET("/api/hours")
    Call<List<Leader>> getHours();

    @GET("/api/skilliq")
    Call<List<Leader>> getSkills();
}
