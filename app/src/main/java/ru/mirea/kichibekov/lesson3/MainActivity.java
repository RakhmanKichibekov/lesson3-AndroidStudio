package ru.mirea.kichibekov.lesson3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import ru.mirea.kichibekov.lesson3.activity.FavoriteBookActivity;
import ru.mirea.kichibekov.lesson3.activity.IntentApp;
import ru.mirea.kichibekov.lesson3.activity.SimpleFragmentAppActivity;
import ru.mirea.kichibekov.lesson3.activity.SystemIntentsAppActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSecondActivity = findViewById(R.id.go_second_button);
    }


    public void goSecond(View view) {
        long dateInMillis = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateString = sdf.format(new Date(dateInMillis));
        Intent intent = new Intent(this, IntentApp.class);
        intent.putExtra("key", "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ " +
                "СОСТАВЛЯЕТ " + (int)Math.pow(12, 2) + ", а текущее время по часовому поясу UTC+0, составляет " + dateString);
        startActivity(intent);
    }

    public void goActionSend(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Mirea");
        startActivity(Intent.createChooser(intent, "Выбор за вами!"));
    }

    public void goActionSend2(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("*/*");

        ActivityResultCallback<ActivityResult> callback =
                new ActivityResultCallback<ActivityResult>() {

            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    Log.d(MainActivity.class.getSimpleName(), "Data:" + data.getDataString());
                }
            }
        };
        ActivityResultLauncher<Intent> imageActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                callback);
        imageActivityResultLauncher.launch(intent);
    }

    public void goFavoriteBook(View view) {
        Intent intent = new Intent(this, FavoriteBookActivity.class);
        startActivity(intent);
    }

    public void goFirst(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goSystem(View view) {
        Intent intent = new Intent(this, SystemIntentsAppActivity.class);
        startActivity(intent);
    }

    public void goFragments(View view) {
        Intent intent = new Intent(this, SimpleFragmentAppActivity.class);
        startActivity(intent);
    }
}