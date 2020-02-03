package com.example.bego.mvvm.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.bego.mvvm.databinding.ActivityMainBinding;

import com.example.bego.mvvm.R;



public class MainActivity extends AppCompatActivity {

    MovieViewModel movieViewModel;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);



        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.movieMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.textView.setText(s);

            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieViewModel.getMovieName();

            }
        });

    }




}
