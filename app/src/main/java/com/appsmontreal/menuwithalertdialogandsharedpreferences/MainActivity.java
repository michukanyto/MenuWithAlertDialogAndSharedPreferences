package com.appsmontreal.menuwithalertdialogandsharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         new AlertDialog.Builder(this)
                 .setIcon(android.R.drawable.ic_menu_edit)
                 .setTitle("Language")
                 .setMessage("Which language do you prefer?")
                 .setPositiveButton("English", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     }
                 })
                 .setNegativeButton("Français", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     }
                 })
                 .show();
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

            case R.id.exit:
                finish();

            default:
                return false;
        }

    }
}
