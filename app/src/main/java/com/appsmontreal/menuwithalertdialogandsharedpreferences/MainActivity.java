package com.appsmontreal.menuwithalertdialogandsharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private TextView textView;
    String language;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        launchAlert();
        sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        textView = findViewById(R.id.textView);
        language = sharedPreferences.getString("language","Error");
        textView.setText(language);
        // Controlling that the message just appear the first time
        if (language.equals("Error")) {
            launchAlert();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.profile:
                Log.i("----------------->", "you pressed profile");
                return true;

            case R.id.settings:
                Log.i("----------------->", "you pressed settings");
                return true;

            case R.id.language:
                launchAlert();
                return true;

            case R.id.exit:
                finish();

            default:
                return false;
        }
    }

    private void launchAlert() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_menu_edit)
                .setTitle("Language")
                .setMessage("Which language do you prefer?")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setLanguage("English");
                    }
                })
                .setNegativeButton("Français", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setLanguage("Français");
                    }
                })
                .show();
    }

    private void setLanguage(String language) {
        editor.putString("language",language).apply();
        textView.setText(language);
    }

}
