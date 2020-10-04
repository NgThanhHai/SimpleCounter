package com.example.simplecounter.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.simplecounter.R;
import com.example.simplecounter.databinding.ActivityMainBinding;
import com.example.simplecounter.viewmodels.CounterViewModels;

public class MainActivity extends AppCompatActivity {


    public CounterViewModels counterViewModels;
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ViewModelProvides.of() is deprecated, use as below instead
        counterViewModels = new ViewModelProvider(this).get(CounterViewModels.class);
        binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setCounterViewModels(counterViewModels);

        // Observe the changed of live data to update the UI
        counterViewModels.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer integer) {
                // Use binding instead of findViewById in ViewModel
                binding.txtCounter.setText(integer.toString());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        counterViewModels.resetCounter();
        return super.onOptionsItemSelected(item);
    }
}