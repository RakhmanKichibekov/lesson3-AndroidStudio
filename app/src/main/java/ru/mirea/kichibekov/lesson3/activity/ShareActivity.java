package ru.mirea.kichibekov.lesson3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.kichibekov.lesson3.R;
import ru.mirea.kichibekov.lesson3.activity.FavoriteBookActivity;

public class ShareActivity extends AppCompatActivity {
    EditText textBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        textBook = findViewById(R.id.editTextMyBook);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView ageView = findViewById(R.id.textViewBook);
            String university = extras.getString(FavoriteBookActivity.KEY);
            ageView.setText(String.format("Любимая книга разработчика: %s", university));
        }


    }

    public void enter(View view) {
        String text ="Ваша любимая книга: " + textBook.getText();
        Intent data = new Intent();
        data.putExtra(FavoriteBookActivity.USER_MESSAGE, text);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}