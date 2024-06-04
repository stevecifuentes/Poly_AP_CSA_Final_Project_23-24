import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.poly.polyapcsafinalproject23_24.GameActivity;
import com.poly.polyapcsafinalproject23_24.GameLaborDayAdventure;
import com.poly.polyapcsafinalproject23_24.MainActivity;
import com.poly.polyapcsafinalproject23_24.R;

import java.util.Scanner;

    public class GameWinterBreakAdventure extends GameActivity {

        private TextView tvTitle, tvSubtitle, tvStoryText;
        private ImageView ivStory;
        private Button btn1, btn2, btn3;
        private boolean isWon;
        private int numLives;

        @Override
        protected void run() {
            setContentView(R.layout.activity_game_3_button);

            tvTitle = findViewById(R.id.tv_title_txt);
            tvSubtitle = findViewById(R.id.tv_subtitle);
            tvStoryText = findViewById(R.id.tv_story);
            ivStory = findViewById(R.id.iv_story);
            btn1 = findViewById(R.id.btn_1);
            btn2 = findViewById(R.id.btn_2);
            btn3 = findViewById(R.id.btn_3);

            tvTitle.setText("WINTER BREAK");
            tvSubtitle.setText("...Random Story...");

            numLives = 5;
            start();
        }


        private void setAllBtnsVisible()
        {
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
        }


        private void start()
        {
            isWon = false;

            ivStory.setImagesResource(R.drawable.im_cifuentessteve_winterbreak);
            playAudio(R.raw.audio_winterbreak_bass);

            tvStoryText.setText("Its winter break, lets go! Now we are able to do fun stuff, What would you like to do?");

            setAllBtnsVisible();
            btn1.setText("Go outside");
            btn2.setText("Play video games");
            btn3.setText("Travel somewhere");


            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){goOutside();}
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){videoGames();}
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){travelSomewhere();}
            });

        }

    //_________GOING OUTSIDE PATH__________
    private void goOutside()
    {
        ivStory.setImageResource(R.drawable.im_cifuentessteve_outside);

        tvStoryText.setText("What would you like to do outside?");

        setAllBtnsVisible();
        btn1.setText("Play a sport");
        btn2.setText("Hang out with friends");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){playSport();}
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){hangOut();}
        });


    }

    private void hangOut()
    {
        tvStoryText.setText("You guys decide to do something fun, what would it be?");

        ivStory.setImageResource(R.drawable.im_cifuentessteve_hangout);

        setAllBtnsVisible();
        btn1.setText("Prank someone");
        btn2.setText("Go home");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {prankSomeone();}
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {goHome();}
        });

    }

        private void prankSomeone()
        {
            tvStoryText.setText("You guys decide to prank someone, what happens next?");

            ivStory.setImageResource(R.drawable.im_winterbreak_pranksomeone);

            setAllBtnsVisible();
            btn1.setText("You get caught");
            btn2.setText("Play it off");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {getCaught();}
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {playOff();}
            });

        }

        private void playOff()
        {

            isWon = true;
            tvStoryText.setText("You and your friends didnt get caught and escaped flawlessly, congrats");

            ivStory.setImageResource(R.drawable.im_winterbreak_playoff);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {end();}
            });

        }

        private void getCaught()
        {

            tvStoryText.setText("You guys get caught, what will you do?");

            ivStory.setImageResource(R.drawable.im_laborday_getcaught);

            setAllBtnsVisible();
            btn1.setText("Run away");
            btn2.setText("Stay and wait");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    runAway();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stayWait();
                }
            });

        }

        private void runAway()
        {

            isWon = true;
            tvStoryText.setText("You decide to run away and leave your friends behind and now they dislike you. A win but at what cost");

            ivStory.setImageResource(R.drawable.im_winterbreak_runaway);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {end();}
            });

        }

        private void stayWait()
        {

            tvStoryText.setText("You wait for your friends and runaway with them but get caught, Game over.");

            ivStory.setImageResource(R.drawable.im_winterbreak_staywait);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }


        private void goHome()
        {

            tvStoryText.setText("You missed out on all the fun activities they had planned, Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }

        private void playSport()
        {

            tvStoryText.setText("It starts to rain, what will you do?");

            ivStory.setImageResource(R.drawable.im_laborday_playing_sport);

            setAllBtnsVisible();
            btn1.setText("Stay a while longer");
            btn2.setText("Go back home");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stayLonger();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    backHome();
                }
            });
        }

        private void backHome()
        {

            isWon = true;
            tvStoryText.setText("It was too cold to be outside for any longer, congrats.");

            ivStory.setImageResource(R.drawable.im_laborday_back_home);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });

        }

        private void stayLonger()
        {

            tvStoryText.setText("You freeze to death because of the rain and the cold winds, Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_staylonger);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }

    //________VIDEO GAMES PATH________
        private void videoGames()
        {

            tvStoryText.setText("What would you like to do?");

            ivStory.setImageResource(R.drawable.im_laborday_videogames);

            setAllBtnsVisible();
            btn1.setText("Choose an owned games");
            btn2.setText("Download new game");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chooseGame();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    downloadGame();
                }
            });
        }

        private void chooseGame()
        {

            tvStoryText.setText("What already owned game would you like to play?");

            ivStory.setImageResource(R.drawable.im_winterbreak_choosegames);

            setAllBtnsVisible();
            btn1.setText("PG game");
            btn2.setText("R rated game");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pgGame();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rGame();
                }
            });
        }


        private void rGame()
        {

            tvStoryText.setText("Your mom walks in and sees what youre playing. Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }


        private void pgGame()
        {

            tvStoryText.setText("You decide to play this PG13 game, what happens next?");

            ivStory.setImageResource(R.drawable.im_laborday_soccer_baby);

            setAllBtnsVisible();
            btn1.setText("Got boring");
            btn2.setText("Decide to eat while playing");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotBoring();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eatPlay();
                }
            });
        }


        private void gotBoring()
        {

            isWon = true;
            tvStoryText.setText("You get off the game and go outside for the first time in 10 years, congrats.");

            ivStory.setImageResource(R.drawable.im_laborday_lifeguard_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });

        }


        private void eatPlay()
        {

            tvStoryText.setText("You decide to eat while you game, what happens next?");

            ivStory.setImageResource(R.drawable.im_laborday_soccer_baby);

            setAllBtnsVisible();
            btn1.setText("You drop all your food");
            btn2.setText("Eat at table");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dropFood();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    atTable();
                }
            });
        }


        private void dropFood()
        {

            tvStoryText.setText("You dropped all your food onto your pc and it explodes leaving a large hole in the earth, Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }


        private void atTable()
        {

            isWon = true;
            tvStoryText.setText("Avoided a catastrophic event that could affect the world, congrats.");

            ivStory.setImageResource(R.drawable.im_laborday_lifeguard_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });

        }


        private void downloadGame()
        {

            tvStoryText.setText("Where would you like to download new game?");

            ivStory.setImageResource(R.drawable.im_laborday_soccer_baby);

            setAllBtnsVisible();
            btn1.setText("Click on site favourite youtuber recommends");
            btn2.setText("Go on steam");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickSite();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goSteam();
                }
            });
        }


        private void goSteam()
        {

            isWon = true;
            tvStoryText.setText("You decide to just download a game on steam which is safer and you avoided world ending event, congrats.");

            ivStory.setImageResource(R.drawable.im_laborday_lifeguard_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });

        }


        private void clickSite()
        {

            tvStoryText.setText("You get to the site, what happens next?");

            ivStory.setImageResource(R.drawable.im_laborday_soccer_baby);

            setAllBtnsVisible();
            btn1.setText("Click on Advertisment");
            btn2.setText("Dont trust this site");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    catchesAttention();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dontTrust();
                }
            });
        }


        private void dontTrust()
        {

            isWon = true;
            tvStoryText.setText("You decided it was best not to trust this site, congrats.");

            ivStory.setImageResource(R.drawable.im_laborday_lifeguard_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });

        }


        private void catchesAttention()
        {

            tvStoryText.setText("You decide to download the game and it gave your pc a virus. Which causes the pc to blow up the whole neighborhood, Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }

    //______TRAVEL SOMEWHERE PATH______
        private void travelSomewhere()
        {

            tvStoryText.setText("You get bored at your vacation area, what would you like to do?");

            ivStory.setImageResource(R.drawable.im_laborday_swimming);

            setAllBtnsVisible();
            btn1.setText("Tell your parents your going out");
            btn2.setText("Go see landmarks");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {tellParents();}
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    seeLandmarks();
                }
            });

        }


        private void seeLandmarks()
        {

            tvStoryText.setText("You get to your destination, what will you do next?");

            ivStory.setImageResource(R.drawable.im_laborday_swimming);

            setAllBtnsVisible();
            btn1.setText("Go explore by yourself");
            btn2.setText("Make new friends");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {goExplore();}
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newFriends();
                }
            });

        }


        private void goExplore()
        {

            tvStoryText.setText("You get lost and your parents leave you behind thinking you were in the car. Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }


        private void newFriends()
        {

            tvStoryText.setText("You guys want to do something fun, what happens next?");

            ivStory.setImageResource(R.drawable.im_laborday_swimming);

            setAllBtnsVisible();
            btn1.setText("Go to arcade");
            btn2.setText("Go explore with them");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {goArcade();}
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    exploreWith();
                }
            });

        }


        private void exploreWith()
        {

            tvStoryText.setText("You all eventually get lost and have to venture back to civilization, Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");


            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }


        private void goArcade()
        {

            tvStoryText.setText("You guys get to the arcade, what will you do?");

            ivStory.setImageResource(R.drawable.im_laborday_swimming);

            setAllBtnsVisible();
            btn1.setText("Play for fun");
            btn2.setText("Challenge them");
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    forFun();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    challengeThem();
                }
            });

        }

        private void forFun()
        {

            isWon = true;
            tvStoryText.setText("You decided it was best to just play for fun and not compete with anyone, congrats.");

            ivStory.setImageResource(R.drawable.im_laborday_lifeguard_shark);

            setAllBtnsVisible();
            btn1.setText("Next");


            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });

        }


        private void challengeThem()
        {

            tvStoryText.setText("They are all way better than you. You stand there realizing all those hours of gaming was a waste. You stood no chance. Embarrassing. Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }


        private void tellParents()
        {

            tvStoryText.setText("You let you parents know you are going out to explore, what will you do now?");

            ivStory.setImageResource(R.drawable.im_laborday_swimming);

            setAllBtnsVisible();
            btn1.setText("Venture into woods");
            btn2.setText("Go to city");
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {ventureWoods();}
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goCity();
                }
            });

        }


        private void goCity()
        {

            tvStoryText.setText("You see a store, what would you like to do?");

            ivStory.setImageResource(R.drawable.im_laborday_swimming);

            setAllBtnsVisible();
            btn1.setText("Go in it");
            btn2.setText("Avoid it");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goIn();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avoidIt();
                }
            });

        }


        private void goIn()
        {

            tvStoryText.setText("You waste all your money on things you might never use, Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }


        private void avoidIt()
        {

            isWon = true;
            tvStoryText.setText("You avoided spending all your money on things you might never use, congrats.");

            ivStory.setImageResource(R.drawable.im_laborday_lifeguard_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });

        }


        private void ventureWoods()
        {

            tvStoryText.setText("You are in the woods, what will you do next?");

            ivStory.setImageResource(R.drawable.im_laborday_swimming);

            setAllBtnsVisible();
            btn1.setText("You hear an odd noise");
            btn2.setText("You see something interesting");
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    oddNoise();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    somethingInteresting();
                }
            });

        }


        private void somethingInteresting()
        {

            tvStoryText.setText("You go more near it but get a bad feeling about it, what will you do next?");

            ivStory.setImageResource(R.drawable.im_laborday_swimming);

            setAllBtnsVisible();
            btn1.setText("Keep going towards it");
            btn2.setText("Walk away from it");
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    keepGoing();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    walkAway();
                }
            });

        }


        private void keepGoing()
        {

            tvStoryText.setText("Turns out it was the home of bigfoot and he was not happy seeing some random rummage thru his things, Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }


        private void walkAway()
        {

            isWon = true;
            tvStoryText.setText("You avoided that eerie looking structure or whatever it was, congrats.");

            ivStory.setImageResource(R.drawable.im_laborday_lifeguard_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });

        }


        private void oddNoise()
        {

            tvStoryText.setText("You go even more near that dreadful noise, what will you do next?");

            ivStory.setImageResource(R.drawable.im_laborday_swimming);

            setAllBtnsVisible();
            btn1.setText("Get closer to it");
            btn2.setText("GET OUT OF THERE");
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getCloser();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    outThere();
                }
            });

        }


        private void getCloser()
        {

            tvStoryText.setText("As you got even closer to whatever it was. There was an odd feeling that you shoudln't be here. As you turn back you get this feeling of something watching you as it reaches for you... Game over.");

            ivStory.setImageResource(R.drawable.im_laborday_punch_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });
        }

        private void outThere()
        {

            isWon = true;
            tvStoryText.setText("As you start to rethink your choice of going towards this noise, you turn back. It gave you that sense of ease once you got out of the woods and back home. Whatever it was you avoided it, Maybe. Win");

            ivStory.setImageResource(R.drawable.im_laborday_lifeguard_shark);

            setAllBtnsVisible();
            btn1.setText("Next");

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end();
                }
            });

        }


        //_______END CODE________
        private void end()
        {
            if (isWon)
            {
                tvStoryText.setText("Its a Winter Break miracle, you get to relive every moment again");

                ivStory.setImageResource(R.drawable.im_laborday_miracle);
            }
            else
            {
                numLives--;
                String text = "You wasted your chance of having a nice break. You have " + numLives + " days remaining";
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
                tvStoryText.setText("Winter Break is over. RIP");
                btn1.setText("Back to menu");

                ivStory.setImageResource(R.drawable.im_laborday_winter_break_over);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(GameWinterBreakAdventure.this, MainActivity.class));
                    }
                });
            }
        }
