package ru.mirea.kichibekov.lesson3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ru.mirea.kichibekov.lesson3.MainActivity;
import ru.mirea.kichibekov.lesson3.R;

public class IntentApp extends AppCompatActivity {
    TextView textFromFirstActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_app);
        textFromFirstActivity = findViewById(R.id.textFromFirstActivity);
        String text = (String) getIntent().getSerializableExtra("key");
        textFromFirstActivity.setText(text);
    }

    public void goFirst(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}