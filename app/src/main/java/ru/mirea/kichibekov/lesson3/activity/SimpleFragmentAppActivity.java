package ru.mirea.kichibekov.lesson3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ru.mirea.kichibekov.lesson3.MainActivity;
import ru.mirea.kichibekov.lesson3.R;
import ru.mirea.kichibekov.lesson3.fragments.FirstFragment;
import ru.mirea.kichibekov.lesson3.fragments.SecondFragment;

public class SimpleFragmentAppActivity extends AppCompatActivity {
    Fragment fragment1, fragment2;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment_app);
        fragment1 = new FirstFragment();
        fragment2 = new SecondFragment();
    }

    public void onClick(View view) {
        fragmentManager = getSupportFragmentManager();
        switch (view.getId()){
            case R.id.btnFirstFragment:

                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment1).commit();

                break;
            case R.id.btnSecondFragment:

                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment2).commit();

                break;
            default:
                break;
        }
    }

    public void goFirst(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}