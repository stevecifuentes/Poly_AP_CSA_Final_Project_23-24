package com.poly.polyapcsafinalproject23_24;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameLaborDayAdventure extends GameActivity {


    private TextView tvTitle, tvSubtitle, tvStoryText;
    private ImageView ivStory;
    private Button btn1, btn2, btn3, btn4;
    private boolean isWon;
    private int numLives;

    @Override
    protected void run() {
        setContentView(R.layout.activity_game_4_button);

        tvTitle = findViewById(R.id.tv_title_txt);
        tvSubtitle = findViewById(R.id.tv_subtitle);
        tvStoryText = findViewById(R.id.tv_story);
        ivStory = findViewById(R.id.iv_story);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);

        tvTitle.setText("LABOR DAY");
        tvSubtitle.setText("High School Edition");

        numLives = 4;
        start();
    }


    private void setAllBtnsVisible()
    {
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
    }


    public void start()
    {
        isWon = false;

        ivStory.setImageResource(R.drawable.im_laborday_title);
        playAudio(R.raw.audio_laborday_bass);

        tvStoryText.setText("Its labor day, lets go! Mom knows its the most important day of the year for a a high schooler, so she loaded up the car with a full tank of gas and gave you the keys. The world is your oyster. Where would you like to go?");

        setAllBtnsVisible();
        btn1.setText("Go to the beach");
        btn2.setText("Go to the park");
        btn3.setText("Go to a restaurant");
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBeach();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPark();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRestaurant();
            }
        });


    }



    //________BEACH PATH________
    private void goToBeach()
    {
        ivStory.setImageResource(R.drawable.im_laborday_beach);

        tvStoryText.setText("What would you like to do at the beach?");

        setAllBtnsVisible();
        btn1.setText("Go Swimming");
        btn2.setText("Lay out and tan");
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 goSwimming();
             }
         });

         btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 layOut();
             }
         });
    }


    private void goSwimming()
    {

        tvStoryText.setText("You see a shark, what do you do?");

        ivStory.setImageResource(R.drawable.im_laborday_swimming);

        setAllBtnsVisible();
        btn1.setText("Call the lifeguard");
        btn2.setText("Punch it in the nose");
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLifeguard();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                punchShark();
            }
        });

    }

    private void callLifeguard()
    {

        isWon = true;
        tvStoryText.setText("The lifeguard saves you, you don't die, congrats.");

        ivStory.setImageResource(R.drawable.im_laborday_lifeguard_shark);

        setAllBtnsVisible();
        btn1.setText("Next");
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end();
            }
        });

    }

    private void punchShark()
    {

        tvStoryText.setText("You punch the shark but injure you hand. You can't play football. Game over.");

        ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

        setAllBtnsVisible();
        btn1.setText("Next");
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end();
            }
        });
    }

    private void layOut()
    {

        tvStoryText.setText("For how long?");

        ivStory.setImageResource(R.drawable.im_laborday_arrive_at_beach);

        setAllBtnsVisible();
        btn1.setText("20 minutes");
        btn2.setText("5 hours");
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tan20Mins();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tan5Hours();
            }
        });
    }

    private void tan20Mins()
    {

        isWon = false;
        tvStoryText.setText("You are white. Might as well have stayed home. Game over.");

        ivStory.setImageResource(R.drawable.im_laborday_tan20);

        setAllBtnsVisible();
        btn1.setText("Next");
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end();
            }
        });
    }

    private void tan5Hours()
    {
        isWon = false;
        tvStoryText.setText("You are burned. Too much of a good thing is bad. Learn from this experience. Game over.");

        ivStory.setImageResource(R.drawable.im_laborday_tan5hours);

        setAllBtnsVisible();
        btn1.setText("Next");
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end();
            }
        });

    }

    //________PARK PATH________
    private void goToPark()
    {

        tvStoryText.setText("What would you like to do at the park?");

        ivStory.setImageResource(R.drawable.im_laborday_whaley_park);

        setAllBtnsVisible();
        btn1.setText("Go play soccer");
        btn2.setText("Go on the slide");
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSoccer();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slide();
            }
        });
    }

    private void playSoccer()
    {

        tvStoryText.setText("You see a baby, what do you do?");

        ivStory.setImageResource(R.drawable.im_laborday_soccer_baby);

        setAllBtnsVisible();
        btn1.setText("Call the mom");
        btn2.setText("Don't call the mom");
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMom();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dontCallMom();
            }
        });
    }

    private void callMom()
    {

        isWon = true;
        tvStoryText.setText("The mom gives you the baby, you are a parent now, congrats. You win.");

        ivStory.setImageResource(R.drawable.im_laborday_take_baby);

        setAllBtnsVisible();
        btn1.setText("Next");
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end();
            }
        });
    }

    private void dontCallMom()
    {

        isWon = false;
        tvStoryText.setText("The baby cries, your team loses from distraction. Game over.");

        ivStory.setImageResource(R.drawable.im_laborday_baby_lose_game);


        setAllBtnsVisible();
        btn1.setText("Next");
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end();
            }
        });


    }

    private void slide()
    {

        isWon = false;
        tvStoryText.setText("Bad idea, its raining now. You can't play soccer. Game over.");

        ivStory.setImageResource(R.drawable.im_laborday_rain);

        setAllBtnsVisible();
        btn1.setText("Next");
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end();
            }
        });
    }


    //________RESTAURANT PATH________
    private void goToRestaurant()
    {
        double chance = Math.random();
        if (chance < 0.5)
        {
            isWon = true;
            tvStoryText.setText("You go to the restaurant. The food is very good. But you forgot your wallet. They totally understand, free meal, you win.");
            ivStory.setImageResource(R.drawable.im_laborday_free_meal);


        }
        else
        {
            isWon = false;
            tvStoryText.setText("You go to the restaurant. The food is aweful, you wasted your time and hard earned money\nGame over.");
            ivStory.setImageResource(R.drawable.im_laborday_bad_food);
        }

        setAllBtnsVisible();
        btn1.setText("Next");
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end();
            }
        });
    }

    private void end()
    {
        if (isWon)
        {
            tvStoryText.setText("Its a labor day miracle! You get to live the whole day over again!");

            ivStory.setImageResource(R.drawable.im_laborday_miracle);
        }
        else
        {
            numLives--;
            String text = "You wasted an entire year of high school. You have " + numLives + " years remaining";
            tvStoryText.setText(text);
        }

        if (numLives > 0)
        {
            btn1.setText("Play again!");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    start();
                }
            });
        }
        else
        {
            tvStoryText.setText("High school is over. Permenant Game over.");
            btn1.setText("Back to menu");

            ivStory.setImageResource(R.drawable.im_laborday_high_school_over);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(GameLaborDayAdventure.this, MainActivity.class));
                }
            });
        }
    }


}
