package com.example.simplecounter.viewmodels;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.simplecounter.models.CounterModels;

public class CounterViewModels extends ViewModel {

    // No need another modal class, TAKE IT EASY
//    public MutableLiveData<String> counter = new MutableLiveData<>(0 + "");
//    public int count;
//    public MutableLiveData<CounterModels> counterViewModelsMutableLiveData;
//
//    public MutableLiveData<CounterModels> getCounterViewModelsMutableLiveData()
//    {
//        if (counterViewModelsMutableLiveData == null)
//        {
//            count = 0;
//            CounterModels counterModels = new CounterModels(count);
//            counterViewModelsMutableLiveData.setValue(counterModels);
//            counterViewModelsMutableLiveData = new MutableLiveData<>();
//
//        }
//        return counterViewModelsMutableLiveData;
//    }
//
//    public void setCounter(MutableLiveData<String> counter) {
//        this.counter = counter;
//    }
//
//    public MutableLiveData<String> getCounter() {
//        return counter;
//    }
//
//    public void onClickFab(View v)
//    {
//        count += 1;
//        counter.setValue(count + "");
//    }
//
//    public void onClickRefresh()
//    {
//        count = 0;
//        counter.setValue(count + "");
//    }

    private int clickCounter = 0;
    MutableLiveData<Integer> counterLiveData = new MutableLiveData<>(clickCounter);

    public LiveData<Integer> getCounter(){
        return counterLiveData;
    }

    public void incCount(){
        clickCounter++;
        counterLiveData.postValue(clickCounter);
    }

    public void resetCounter(){
        clickCounter = 0;
        counterLiveData.postValue(clickCounter);
    }
}
