package com.example.bego.mvvm.ui;

import com.example.bego.mvvm.pojo.MovieModle;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

// this class get movie name from data base
// second thing it tell us it has the movie name and do no thing
public class MovieViewModel extends ViewModel {

   // LiveData<String> movieLiveData;  // this type cant edit on the data
    MutableLiveData<String> movieMutableLiveData = new MutableLiveData<>(); // this type can edit on data

    public void getMovieName(){

       String moviename = getMovieFromDatabase().getName();
       movieMutableLiveData.setValue(moviename);
    }


    private MovieModle getMovieFromDatabase(){
        return new MovieModle("cast away" , "28-8-1998" , "good movie" , 1);
    }

}
