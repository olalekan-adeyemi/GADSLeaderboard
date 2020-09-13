package com.lakeside.gadsleaderboard.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.lakeside.gadsleaderboard.model.Leader;
import com.lakeside.gadsleaderboard.service.LeaderBoardAPI;
import com.lakeside.gadsleaderboard.service.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderRepository {

    private static final String TAG = "LeaderRepository";

    private LeaderBoardAPI leaderBoardApi;
    private MutableLiveData<List<Leader>> hours;
    private MutableLiveData<List<Leader>> skillIQ;

    public LeaderRepository() {

        hours = new MutableLiveData<>();
        skillIQ = new MutableLiveData<>();
        leaderBoardApi = ServiceBuilder.buildService(LeaderBoardAPI.class);
        init();
    }

    private void init() {
        setHours();
        setSkillIQ();
    }

    public MutableLiveData<List<Leader>> getHours() {
        return hours;
    }

    public void setHours() {
        Log.d(TAG, "onChange, calling API service for top hours");

        leaderBoardApi.getHours().enqueue(new Callback<List<Leader>>() {
            @Override
            public void onResponse(Call<List<Leader>> call, Response<List<Leader>> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        //Log.d(TAG, "onChange, response from API: " + response.body().toString());
                        hours.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Leader>> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<List<Leader>> getSkillIQ() {
        return skillIQ;
    }

    public void setSkillIQ() {
        Log.d(TAG, "onChange, calling API service for top skillIQ");
        leaderBoardApi.getSkills().enqueue(new Callback<List<Leader>>() {
            @Override
            public void onResponse(Call<List<Leader>> call, Response<List<Leader>> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {

                        //Log.d(TAG, "onChange, response from API: " + response.body().toString());
                        skillIQ.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Leader>> call, Throwable t) {

            }
        });
    }
}
