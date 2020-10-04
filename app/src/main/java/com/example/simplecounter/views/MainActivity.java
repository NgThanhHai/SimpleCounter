package com.example.simplecounter.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.simplecounter.R;
import com.example.simplecounter.databinding.ActivityMainBinding;
import com.example.simplecounter.models.CounterModels;
import com.example.simplecounter.viewmodels.CounterViewModels;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    public CounterViewModels counterViewModels;
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counterViewModels = ViewModelProviders.of(this).get(CounterViewModels.class);
        binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setCounterViewModels(counterViewModels);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        counterViewModels.onClickRefresh();
        return super.onOptionsItemSelected(item);
    }
}