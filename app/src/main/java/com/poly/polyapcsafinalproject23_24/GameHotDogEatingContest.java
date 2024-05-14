package com.poly.polyapcsafinalproject23_24;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameHotDogEatingContest extends AppCompatActivity {

    /**
     * player in game
     */
    private Contestant player;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        run();
    }

    /**
     * Method that runs the contest. Calls createPlayer() and runContest()
     */
    public void run()
    {
        createPlayer();
    }

    /**
     * Method that creates the player. Method asks for user name and uses
     * it to create a contenstant
     */
    private void createPlayer()
    {
        setContentView(R.layout.activity_hot_dog_contest_intro);

        EditText etName = findViewById(R.id.et_name);
        Button btnNext = findViewById(R.id.btn_next);
        btnNext.setClickable(false);
        btnNext.setVisibility(View.INVISIBLE);

        ImageView ivMain = findViewById(R.id.iv_main);
        ivMain.setImageResource(R.drawable.im_hotdog_3);

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0)
                {
                    btnNext.setClickable(true);
                    btnNext.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player = new Contestant(etName.getText().toString());
                etName.setText("");
                etName.setHint("Enter number of hot dogs");
                beginContest();
            }
        });

    }

    /**
     * Greets the player, asks them to guess how many hot dogs they will eat.
     */
    private void beginContest()
    {
        TextView tvMain = findViewById(R.id.tv_main);
        TextView tvPrompt = findViewById(R.id.tv_prompt);
        EditText editText = findViewById(R.id.et_name);
        Button btnNext = findViewById(R.id.btn_next);

        tvMain.setText("Hello " + player.getName() + ", you have entered a Hot Dog Eating Contest!");
        tvPrompt.setText("How many Hot Dogs do you think you can eat?");

        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        btnNext.setClickable(false);
        btnNext.setVisibility(View.INVISIBLE);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnNext.setClickable(true);
                btnNext.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int guess = Integer.parseInt(editText.getText().toString());
                int maxCaloriesConsumed = 2500 + (int) (1000 * (Math.sin(guess * Math.PI/4 ) + 1));
                player.setMaxCaloriesConsumed(maxCaloriesConsumed);

                tvMain.setText("Alright, lets see if you can do it!");
                setContentView(R.layout.activity_hot_dog_contest_play);
                runContest();
            }
        });
    }

    /**
     * Method that runs the contest. The contest runs in a loop where a player
     *   either eats a hot dog or drinks a soda. The contest ends when the contestant's
     *   mouth reaches dryness of 10 or higher, or when they have consumed at least 2000
     *   calories.
     */
    private void runContest()
    {
        displayStats();
        if (player.getMouthDryness() < 10 && player.getCaloriesConsumed() < player.getMaxCaloriesConsumed()) {
            chooseOption();
        }
        else {
            endOfContest();
        }

    }



    /**
     * Displays player's stats at the beginning of each round
     */
    private void displayStats()
    {
        TextView tvName = findViewById(R.id.tv_name_prompt);
        TextView tvHotDogs = findViewById(R.id.tv_hot_dogs);
        TextView tvSodasDranken = findViewById(R.id.tv_sodas);
        ProgressBar pbMouthDryness = findViewById(R.id.progressBar_mouth_dryness);
        ProgressBar pbCaloriesConsumed = findViewById(R.id.progressBar_calories_consumed);

        tvName.setText(player.getName());
        tvHotDogs.setText(Integer.toString(player.getHotDogsEaten()));
        tvSodasDranken.setText(Integer.toString(player.getSodasDranken()));

        pbMouthDryness.setMin(0);
        pbMouthDryness.setMax(10);
        pbMouthDryness.setProgress(player.getMouthDryness());
        pbCaloriesConsumed.setMin(0);
        pbCaloriesConsumed.setMax(player.getMaxCaloriesConsumed());
        pbCaloriesConsumed.setProgress(player.getCaloriesConsumed());

    }

    /**
     * Player chooses to eat a hot dog or drink a soda
     */
    private void chooseOption()
    {
        ImageButton btnHotDog = findViewById(R.id.btn_hot_dog);
        ImageButton btnSoda = findViewById(R.id.btn_soda);
        ImageView ivMain = findViewById(R.id.iv_main);

        btnHotDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.eatHotDog();
                ivMain.setImageResource(R.drawable.im_hotdog_2);
                runContest();
            }
        });

        btnSoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.drinkSoda();
                ivMain.setImageResource(R.drawable.im_hotdog_soda_4);
                runContest();
            }
        });

    }

    /**
     * After player's mouth dryness is 10 or higher, or after they have consumed at least
     *    2000 calories, the contest ends. Messages are displayed to indicate why the
     *    contest ended. Player is told how many hot dogs they ate. Player may choose to
     *    play again.
     */
    private void endOfContest()
    {
        setContentView(R.layout.activity_hot_dog_contest_end);
        ImageView[] ivHotDogs = new ImageView[12];
        ivHotDogs[0] = findViewById(R.id.im_hd1);
        ivHotDogs[1] = findViewById(R.id.im_hd2);
        ivHotDogs[2] = findViewById(R.id.im_hd3);
        ivHotDogs[3] = findViewById(R.id.im_hd4);
        ivHotDogs[4] = findViewById(R.id.im_hd5);
        ivHotDogs[5] = findViewById(R.id.im_hd6);
        ivHotDogs[6] = findViewById(R.id.im_hd7);
        ivHotDogs[7] = findViewById(R.id.im_hd8);
        ivHotDogs[8] = findViewById(R.id.im_hd9);
        ivHotDogs[9] = findViewById(R.id.im_hd10);
        ivHotDogs[10] = findViewById(R.id.im_hd11);
        ivHotDogs[11] = findViewById(R.id.im_hd12);

        TextView tvYouAte, tvHotDogs, tvOhNo, tvLoseCondition;
        tvYouAte = findViewById(R.id.tv_you_ate);
        tvHotDogs = findViewById(R.id.tv_hot_dogs);
        tvOhNo = findViewById(R.id.tv_oh_no);
        tvLoseCondition = findViewById(R.id.tv_lose_condition);

        Button btnNext = findViewById(R.id.btn_next);
        Button btnPlayAgain = findViewById(R.id.btn_playAgain);

        btnPlayAgain.setVisibility(View.INVISIBLE);

        //turn off hot dogs
        for (ImageView img:ivHotDogs) {
            img.setVisibility(View.INVISIBLE);
            img.setImageResource(R.drawable.im_hotdog_0);
        }
        tvYouAte.setVisibility(View.INVISIBLE);
        tvHotDogs.setVisibility(View.INVISIBLE);
        if(player.getCaloriesConsumed() >= player.getMaxCaloriesConsumed()) {
            tvLoseCondition.setText("YOU ARE FULL");
        }
        else {
            tvLoseCondition.setText("YOUR MOUTH IS TOO DRY");
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvOhNo.setVisibility(View.INVISIBLE);
                tvLoseCondition.setVisibility(View.INVISIBLE);

                tvYouAte.setVisibility(View.VISIBLE);
                for (int i=0; i<player.getHotDogsEaten(); i++) {
                    ivHotDogs[i].setVisibility(View.VISIBLE);
                }
                tvHotDogs.setVisibility(View.VISIBLE);


                btnNext.setText("Main Menu");

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(GameHotDogEatingContest.this, MainActivity.class));
                    }
                });

                btnPlayAgain.setVisibility(View.VISIBLE);
                btnPlayAgain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        createPlayer();
                    }
                });
            }
        });

        /*
        if (player.getCaloriesConsumed() >= player.getMaxCaloriesConsumed())
        {
            System.out.println("Oh no, you are full!");
        }
        if (player.getMouthDryness() >= 10)
        {
            System.out.println("You give up because your mouth is too dry.");
        }
        Util.pauseConsole();
        Util.clearConsole();
        System.out.println("Congradulations, you ate " + player.getHotDogsEaten() + " hot dogs!");
        Util.pauseConsole();
        System.out.println("Compete again?\n1. YES!!!\n2. No, I'm too full");
        int option = Util.enterInt(1,2);
        if (option == 1)
        {
            player = new Contestant(player.getName());
            runContest();
        }
        */

    }

}