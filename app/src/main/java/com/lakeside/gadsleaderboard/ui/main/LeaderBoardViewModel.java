package com.lakeside.gadsleaderboard.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.lakeside.gadsleaderboard.ui.model.Leader;
import com.lakeside.gadsleaderboard.ui.repository.LeaderRepository;

import java.util.List;

public class LeaderBoardViewModel extends ViewModel {

    private MutableLiveData<List<Leader>> hours;
    private MutableLiveData<List<Leader>> skillIQ;
    private LeaderRepository repository;

    public LeaderBoardViewModel() {
        init();
    }

    private void init() {
        repository = new LeaderRepository();
        hours = repository.getHours();
        skillIQ = repository.getSkillIQ();
    }

    public LiveData<List<Leader>> getHours() {
        return hours;
    }

    public LiveData<List<Leader>> getSkillIQ() {
        return skillIQ;
    }

    //private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    /*private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });*/

    /*public void setIndex(int index) {
        mIndex.setValue(index);
    }*/

    /*public LiveData<String> getText() {
        return mText;
    }*/
}