import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.poly.polyapcsafinalproject23_24.GameActivity;
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

            ivStory.setImagesResource(R.drawable.im_winterbreak_title);
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
        ivStory.setImageResource(R.drawable.im_winterbreak_outside);

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

        ivStory.setImageResource(R.drawable.im_winterbreak_hangout);

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
        System.out.println("\nYou guys decide to prank someone, what happens next?");
        System.out.println("1. You got caught\n2. Play it off");

        if(choice == 1)
        {
            getCaught();
        }
        else if (choice == 2)
        {
            playOff();
        }
    }

    private void playOff()
    {
        System.out.println("\nYou and your friends didnt get caught and escaped flawlessly, Win");
        start();
    }

    private void getCaught()
    {
        System.out.println("\nYou guys get caught, what will you do?");
        System.out.println("1. Run away\n2. Stay and wait");

        if(choice == 1)
        {
            runAway();
        }
        else if (choice == 2)
        {
            stayWait();
        }
    }

    private void runAway()
    {
        System.out.println("\nYou decide to run away and leave your friends behind and now they dislike you. A win but at what cost");
        start();
    }

    private void stayWait()
    {
        System.out.println("\nYou wait for your friends and runaway with them but get caught, Lose");
        defeat();
    }

    private void goHome()
    {
        System.out.println("\nYou missed out on all the fun activities they had planned, Lose");
        defeat();
    }

    private void playSport()
    {
        System.out.println("\nIt starts to rain, what will you do?");
        System.out.println("1. Stay a while longer\n2. Go back home");

        if (choice == 1)
        {
            stayLonger();
        }
        else if (choice == 2)
        {
            backHome();
        }
    }

    private void backHome()
    {
        System.out.println("\nIt was too cold to be outside for any longer, Win");
        start();
    }

    private void stayLonger()
    {
        System.out.println("\nYou freeze to death because of the rain and the cold winds, Lose");
        defeat();
    }

    //________VIDEO GAMES PATH________
    private void videoGames()
    {
        System.out.println("What would you like to do?");
        System.out.println("1. Choose an owned game\n2. Download new game");

        if (choice == 1)
        {
            chooseGame();
        }
        else if (choice == 2)
        {
            downloadGame();
        }
    }

    private void chooseGame()
    {
        System.out.println("What already owned game would you like to play?");
        System.out.println("1. PG13 game\n2. R rated game");

        if (choice == 1)
        {
            pgGame();
        }
        else if (choice == 2)
        {
            rGame();
        }
    }

    private void rGame()
    {
        System.out.println("\nYour mom walks in and sees what youre playing, Lose");
        defeat();
    }

    private void pgGame()
    {
        System.out.println("You decide to play this PG13 game, what happens next?");
        System.out.println("1. Got boring\n2. Decide to eat while playing");

        if (choice == 1)
        {
            gotBoring();
        }
        else if (choice == 2)
        {
            eatPlay();
        }
    }

    private void gotBoring()
    {
        System.out.println("\nYou get off the game and go outside for the first time in 10 years, Win");
        start();
    }

    private void eatPlay()
    {
        System.out.println("You decide to eat while you game, what happens next?");
        System.out.println("1. You drop all your food\n2. Eat at table");

        if (choice == 1)
        {
            dropFood();
        }
        else if (choice == 2)
        {
            atTable();
        }
    }

    private void dropFood()
    {
        System.out.println("\nYou dropped all your food onto your pc and it explodes leaving a large hole in the earth, Lose");
        defeat();
    }

    private void atTable()
    {
        System.out.println("\nAvoided a catastrophic event that could affect the world, Win");
        start();
    }

    private void downloadGame()
    {
        System.out.println("Where would you like to download new game?");
        System.out.println("1. Click on site favourite youtuber recommends\n2. Go on steam");

        if (choice == 1)
        {
            clickSite();
        }
        else if (choice == 2)
        {
            goSteam();
        }
    }

    private void goSteam()
    {
        System.out.println("\nYou decide to just download a game on steam which is safer and you avoided world ending event, Win");
        start();
    }

    private void clickSite()
    {
        System.out.println("You get to the site, what happens next?");
        System.out.println("1. An Advertisment catches your attention\n2. Dont trust this site");

        if (choice == 1)
        {
            catchesAttention();
        }
        else if (choice == 2)
        {
            dontTrust();
        }
    }

    private void dontTrust()
    {
        System.out.println("\nYou decided it was best not to trust this site, Win");
        start();
    }

    private void catchesAttention()
    {
        System.out.println("\nYou decide to download the game and it gave your pc a virus. Which causes the pc to blow up the whole neighborhood, Lose");
        defeat();
    }

    //______TRAVEL SOMEWHERE PATH______
    private void travelSomewhere()
    {
        System.out.println("You get bored at your vacation area, what would you like to do?");
        System.out.println("1. Tell your parents your going out\n2. Go see landmarks");

        if (choice == 1)
        {
            tellParents();
        }
        else if (choice == 2)
        {
            seeLandmarks();
        }
    }

    private void seeLandmarks()
    {
        System.out.println("You get to your destination, what will you do next?");
        System.out.println("1. Go explore by yourself\n2. Make new friends");

        if (choice == 1)
        {
            goExplore();
        }
        else if (choice == 2)
        {
            newFriends();
        }
    }

    private void goExplore()
    {
        System.out.println("\nYou get lost and your parents leave you behind thinking you were in the car, Lose");
        defeat();
    }

    private void newFriends()
        System.out.println("You guys want to do something fun, what happens next?");
        System.out.println("1. Go to arcade\n2. Go explore with them");
        if (choice == 1)
        {
            goArcade();
        }
        else if (choice == 2)
        {
            exploreWith();
        }


    private void exploreWith()
    {
        Util.clearConsole();
        System.out.println("\nYou all eventually get lost and have to venture back to civilization, Lose");
        Util.pauseConsole();
        defeat();
    }

    private void goArcade()
    {
        Util.clearConsole();
        System.out.println("You guys get to the arcade, what will you do?");
        System.out.println("1. Play for fun\n2. Challenge them");
        int choice = Util.enterInt(1,2);

        if (choice == 1)
        {
            forFun();
        }
        else if (choice == 2)
        {
            challengeThem();
        }
    }

    private void forFun()
    {
        Util.clearConsole();
        System.out.println("\nYou decided it was best to just play for fun and not compete with anyone, Win");
        Util.pauseConsole();
        start();
    }

    private void challengeThem()
    {
        Util.clearConsole();
        System.out.println("\nThey are all way better than you. You stand there realizing all those hours of gaming was a waste. You stood no chance. Embarrassing, Lose");
        Util.pauseConsole();
        defeat();
    }

    private void tellParents()
    {
        Util.clearConsole();
        System.out.println("You let you parents know you are going out to explore, what will you do now?");
        System.out.println("1. Venture into woods\n2. Go to city");
        int choice = Util.enterInt(1,2);

        if (choice == 1)
        {
            ventureWoods();
        }
        else if (choice == 2)
        {
            goCity();
        }
    }

    private void goCity()
    {
        Util.clearConsole();
        System.out.println("You see a store, what would you like to do?");
        System.out.println("1. Go in it\n2. Avoid it");
        int choice = Util.enterInt(1,2);

        if (choice == 1)
        {
            goIn();
        }
        else if (choice == 2)
        {
            avoidIt();
        }
    }

    private void goIn()
    {
        Util.clearConsole();
        System.out.println("\nYou waste all your money on things you might never use, Lose");
        Util.pauseConsole();
        defeat();
    }

    private void avoidIt()
    {
        Util.clearConsole();
        System.out.println("\nYou avoided spending all your money on things you might never use, Win");
        Util.pauseConsole();
        start();
    }

    private void ventureWoods()
    {
        Util.clearConsole();
        System.out.println("You are in the woods, what will you do next?");
        System.out.println("1. You hear an odd noise\n2. You see something interesting");
        int choice = Util.enterInt(1,2);

        if (choice == 1)
        {
            oddNoise();
        }
        else if (choice == 2)
        {
            somethingInteresting();
        }
    }

    private void somethingInteresting()
    {
        Util.clearConsole();
        System.out.println("You go more near it but get a bad feeling about it, what will you do next?");
        System.out.println("1. Keep going towards it\n2. Walk away from it");
        int choice = Util.enterInt(1,2);

        if (choice == 1)
        {
            keepGoing();
        }
        else if (choice == 2)
        {
            walkAway();
        }
    }

    private void keepGoing()
    {
        Util.clearConsole();
        System.out.println("\nTurns out it was the home of bigfoot and he was not happy seeing some random rummage thru his things, Lose");
        Util.pauseConsole();
        defeat();
    }

    private void walkAway()
    {
        Util.clearConsole();
        System.out.println("\nYou avoided that eerie looking structure or whatever it was, Win");
        Util.pauseConsole();
        start();
    }

    private void oddNoise()
    {
        Util.clearConsole();
        System.out.println("You go even more near that dreadful noise, what will you do next?");
        System.out.println("1. Get closer to it\n2. GET OUT OF THERE");
        int choice = Util.enterInt(1,2);

        if (choice == 1)
        {
            getCloser();
        }
        else if (choice == 2)
        {
            outThere();
        }
    }

    private void getCloser()
    {
        Util.clearConsole();
        System.out.println("\nAs you got even closer to whatever it was. There was an odd feeling that you shoudln't be here. As you turn back it catches you..., Lose");
        Util.pauseConsole();
        defeat();
    }

    private void outThere()
    {
        Util.clearConsole();
        System.out.println("\nAs you start to rethink your choice of going towards this noise, you turn back. It gave you that sense of ease once you got out of the woods and back home. Whatever it was you avoided it. Maybe, Win");
        Util.pauseConsole();
        start();
    }

    //_____DEFEAT CODE______
    private void defeat()
    {
        //run method when defeated


        //lose a life
        numLives--;

        //clear console, display text, etc
        System.out.println("...");

        //determine if player gets to play again
        if (numLives > 0)
        {
            //if you still have lives, return to start()
            start();
        }
        else
        {
            //print game over message
            System.out.println("GAME OVER");
        }

    }
}