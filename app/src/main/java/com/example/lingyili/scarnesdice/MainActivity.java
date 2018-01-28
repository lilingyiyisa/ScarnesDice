package com.example.lingyili.scarnesdice;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Integer USER_OVERALL;
    public Integer USER_TURN;
    public Integer COMPUTER_OVERALL;
    public Integer COMPUTER_TURN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickRoll(View view) {
        rollHelper("user");
    }

    public void rollHelper(String player) {
        //randomly select a dice value
        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        if(dice!=1)
        {
            if(player.equals("user"))
            {
                USER_TURN += dice;
            }
            else
            {
                COMPUTER_TURN += dice;
            }
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText("Your score: " + USER_OVERALL + " computer score: " + COMPUTER_OVERALL + " your turn score: " + USER_TURN);
            ImageView image = (ImageView)findViewById(R.id.imageView2);
            if(dice == 2)
            {
                image.setImageResource(R.drawable.dice2);
            }
            else if(dice == 3)
            {
                image.setImageResource(R.drawable.dice3);
            }
            else if(dice == 4)
            {
                image.setImageResource(R.drawable.dice4);
            }
            else if(dice == 5)
            {
                image.setImageResource(R.drawable.dice5);
            }
            else if(dice == 6)
            {
                image.setImageResource(R.drawable.dice6);
            }

        }
        else
        {
            if(player.equals("user"))
            {
                USER_TURN = 0;
            }
            else
            {
                COMPUTER_TURN = 0;
            }
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText("Your score: " + USER_OVERALL + " computer score: " + COMPUTER_OVERALL + " your turn score: " + USER_TURN);
            ImageView image = (ImageView)findViewById(R.id.imageView2);
            image.setImageResource(R.drawable.dice1);
            computerTurn();
        }

    }

    public void clickHold(View view) {
        USER_OVERALL += USER_TURN;
        USER_TURN = 0;
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("Your score: " + USER_OVERALL + " computer score: " + COMPUTER_OVERALL + " your turn score: 0");
        computerTurn();
    }

    public void clickReset(View view) {
        USER_OVERALL = 0;
        USER_TURN = 0;
        COMPUTER_OVERALL = 0;
        COMPUTER_TURN = 0;
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("Your score: 0 computer score: 0 your turn score: 0");
    }

    public void computerTurn() {
        Button rollbutton = (Button) findViewById(R.id.button4);
        rollbutton.setEnabled(false);
        Button holdbutton = (Button) findViewById(R.id.button5);
        holdbutton.setEnabled(false);
        while(COMPUTER_TURN < 20)
        {
            rollHelper("computer");
        }
    }
}
