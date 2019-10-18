package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int currentScore = 0;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private int on_button_click_enterValue()
    {
        TextView tv = this.findViewById(R.id.enteredText);
        int number = Integer.parseInt(tv.getText().toString());
        return number;

    }

    public void on_button_click(View view){

        TextView tv = this.findViewById(R.id.numberTextView);
        TextView congrats = this.findViewById(R.id.congratulations);
        TextView userScoreText = this.findViewById(R.id.userScore);
        congrats.setText("");
        Random r = new Random();
        int number = (r.nextInt(6 ) + 1);
        tv.setText(Integer.toString(number));
        int enteredNumber = on_button_click_enterValue();
        if (enteredNumber == number)
        {
            congrats.setText("Congratulations!");
            currentScore++;
            userScoreText.setText("Your score: "+ currentScore);
        }
    }
}
