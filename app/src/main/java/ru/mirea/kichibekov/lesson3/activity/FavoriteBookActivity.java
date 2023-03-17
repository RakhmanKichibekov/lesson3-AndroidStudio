package ru.mirea.kichibekov.lesson3.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.kichibekov.lesson3.MainActivity;
import ru.mirea.kichibekov.lesson3.R;

public class FavoriteBookActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> activityResultLauncher;
    static final String KEY = "book_name";
    static final String USER_MESSAGE = "MESSAGE";
    private TextView textViewUserBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_book);
        textViewUserBook = findViewById(R.id.textViewBook);

        ActivityResultCallback<ActivityResult> callback = new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();

                    String userBook = data.getStringExtra(USER_MESSAGE);

                    textViewUserBook.setText(userBook);
                }
            }
        };
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), callback);
    }

    public void getInfoAboutBook(View view) {
        Intent intent = new Intent(this, ShareActivity.class);
        intent.putExtra(KEY, "Анабасис");
        activityResultLauncher.launch(intent);
    }

    public void goFirst(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goFavoriteBook(View view) {
        Intent intent = new Intent(this, FavoriteBookActivity.class);
        startActivity(intent);
    }

    public void goSystem(View view) {
        Intent intent = new Intent(this, SystemIntentsAppActivity.class);
        startActivity(intent);
    }
}