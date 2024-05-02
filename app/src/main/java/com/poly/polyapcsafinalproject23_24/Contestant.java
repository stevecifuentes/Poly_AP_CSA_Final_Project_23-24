package com.poly.polyapcsafinalproject23_24;
/**
 * Contestant for a hot dog eating contest
 * @author Bryan Burke
 * @since 12/8/2023
 * @version 1.0
 */
public class Contestant {

    /**
     * contestant's name
     */
    private String name;
    /**
     * number of hot dogs eaten
     */
    private int hotDogsEaten;
    /**
     * number ofsodas dranken
     */
    private int sodasDranken;
    /**
     * factor of how dry the contestant's mouth is,
     * must remain less than 10 for the player to compete
     */
    private int mouthDryness;
    /**
     * number of calories consumed
     */
    private int caloriesConsumed;
    /**
     * maximum number of calories consumed
     * (when the contestant is full)
     */
    private int maxCaloriesConsumed;
    /**
     * ID of the contestant, assigned in constructor
     */
    private final int ID;
    /**
     * tracks number of contestants created
     */
    private static int numContestants;

    /**
     * default constructor
     * <br>Postconditions: contestant with name as empty string,
     *     hotDogsEaten, sodasDranken, mouthDryness, caloriesConsumed set to 0, ID assigned
     */
    public Contestant()
    {
        this.name = "";
        this.hotDogsEaten = 0;
        this.sodasDranken = 0;
        this.mouthDryness = 0;
        this.caloriesConsumed = 0;
        this.maxCaloriesConsumed = 2000;
        numContestants++;
        this.ID = numContestants;
    }

    /**
     * Constructor that initializes name
     * <br>Preconditions: name must be nonnull
     * <br>Postconditions: contestant with given name,
     *     hotDogsEaten, sodasDranken, mouthDryness, caloriesConsumed set to 0, ID assigned
     * @param  name    name of contestant
     */
    public Contestant(String name)
    {
        this.name = name;
        this.hotDogsEaten = 0;
        this.sodasDranken = 0;
        this.mouthDryness = 0;
        this.caloriesConsumed = 0;
        this.maxCaloriesConsumed = 2000;
        numContestants++;
        this.ID = numContestants;
    }

    /**
     * Constructor that initializes all attributes
     * <br>Preconditions: name must be nonnull, all other values must be non-negative
     * <br>Postconditions: contestant with given name,
     *     hotDogsEaten, sodasDranken, mouthDryness, caloriesConsumed, ID assigned
     * @param  name                name of contestant
     * @param  hotDogsEaten        number of hot dogs eaten ( >= 0)
     * @param  sodasDranken        number of sodas dranken ( >= 0)
     * @param  mouthDryness        mouth dryness factor ( >= 0)
     * @param  caloriesConsumed    number of califories consumed ( >= 0)
     */
    public Contestant(String name, int hotDogsEaten, int sodasDranken, int mouthDryness, int caloriesConsumed, int maxCaloriesConsumed)
    {
        this.name = name;
        this.hotDogsEaten = hotDogsEaten;
        this.sodasDranken = sodasDranken;
        this.mouthDryness = mouthDryness;
        this.caloriesConsumed = caloriesConsumed;
        this.maxCaloriesConsumed = maxCaloriesConsumed;
        numContestants++;
        this.ID = numContestants;
    }

    /**
     * gets the contestant's name
     * @return    name of contestant
     */
    public String getName()
    {
        return name;
    }

    /**
     * sets the contestant's name
     * <br>Precondition: newName is a non-empty string
     * <br>Postcondition: name set to newName
     * @param    newName    new name for the contestant
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    /**
     * gets the number of hot dogs eaten
     * @return    number of hot dogs eaten
     */
    public int getHotDogsEaten()
    {
        return hotDogsEaten;
    }

    /**
     * sets the number of hot dogs eaten
     * <br>Precondition: numHotDogs greater than or equal to 0
     * <br>Postcondition: hotDogsEaten set
     * @param    numHotDogs    number of hot dogs eaten (>=0)
     */
    public void setHotDogsEaten(int numHotDogs)
    {
        this.hotDogsEaten = numHotDogs;
    }

    /**
     * gets the number of sodas dranken
     * @return    number of sodas dranken
     */
    public int getSodasDranken()
    {
        return sodasDranken;
    }

    /**
     * sets the number of sodas dranken
     * <br>Precondition: numSodas greater than or equal to 0
     * <br>Postcondition: sodasDranken set
     * @param    numSodas    number of sodas dranken (>=0)
     */
    public void setSodasDranken(int numSodas)
    {
        this.sodasDranken = numSodas;
    }

    /**
     * gets the mouth dryness factor
     * @return    mouth dryness factor
     */
    public int getMouthDryness()
    {
        return mouthDryness;
    }

    /**
     * sets the mouth dryness factor
     * <br>Precondition: level greater than or equal to 0
     * <br>Postcondition: mouthDryness set
     * @param    level    new mouth dryness factor (>=0)
     */
    public void setMouthDryness(int level)
    {
        this.mouthDryness = level;
    }

    /**
     * gets the number of calories consumed
     * @return    calories consumed
     */
    public int getCaloriesConsumed()
    {
        return caloriesConsumed;
    }

    /**
     * sets the number of calories consumed
     * <br>Precondition: numCalories greater than or equal to 0
     * <br>Postcondition: caloriesConsumed set
     * @param    numCalories    new number of calories consumed (>=0)
     */
    public void setCaloriesConsumed(int numCalories)
    {
        this.caloriesConsumed = numCalories;
    }

    /**
     * gets the maximum number of calories consumed
     * (when the player is full)
     * @return    maximum calories a contestant can consume
     */
    public int getMaxCaloriesConsumed()
    {
        return maxCaloriesConsumed;
    }

    /**
     * gets the contestant ID
     * (created when player is initialized)
     * @return    contestant ID
     */
    public int getID()
    {
        return ID;
    }

    /**
     * sets the maximum number of calories consumed
     * (when the player is full)
     * <br>Precondition: numCalories greater than or equal to 0
     * <br>Postcondition: maxCaloriesConsumed set
     * @param    numCalories    new number of calories consumed (>=0)
     */
    public void setMaxCaloriesConsumed(int numCalories)
    {
        this.maxCaloriesConsumed = numCalories;
    }

    /**
     * gets the number of contestants
     * @return    total number of contestants created
     */
    public static int getNumContestants()
    {
        return numContestants;
    }


    /**
     * toString method
     * @return    contestant as a string
     */
    @Override
    public String toString()
    {
        return
                "Contestant name:\t" + name +
                        "\nHot Dogs Eaten:\t\t" + hotDogsEaten +
                        "\nSodas Dranken:\t\t" + sodasDranken +
                        "\nCalories Consumed:\t" + caloriesConsumed +
                        "\nMouth Dryness:\t\t" + mouthDryness +
                        "\nContestant ID:\t" + ID;
    }

    /**
     * returns true if all attributes match between two contestants
     * <br>Precondition: anotherContestant must be non-null
     * @param    anotherContestant    another contestant object
     * @return   true if contestants are equal
     */
    public boolean equals(Contestant anotherContestant)
    {
        if (this.name.equals(anotherContestant.name) &&
                this.hotDogsEaten == anotherContestant.hotDogsEaten &&
                this.sodasDranken == anotherContestant.sodasDranken &&
                this.caloriesConsumed == anotherContestant.caloriesConsumed &&
                this.mouthDryness == anotherContestant.mouthDryness &&
                this.ID == anotherContestant.ID
        )
        {
            return true;
        }
        return false;
    }

    /**
     * run this method when the contestant eats a hot dog
     * <br>Postcondition:
     * <br>hotDogsEaten increased by 1
     * <br>mouthDryness increased by 3
     * <br>caloriesConsumed increased by 275
     */
    public void eatHotDog()
    {
        hotDogsEaten++;
        mouthDryness += 3;
        caloriesConsumed += 275;
    }

    /**
     * run this method when the contestant drinks a soda
     * <br>Postcondition:
     * <br>sodasDranken increased by 1
     * <br>mouthDryness decreased by 1
     * <br>caloriesConsumed increased by 125
     */
    public void drinkSoda()
    {
        sodasDranken++;
        if (mouthDryness > 0)
        {
            mouthDryness--;
        }
        caloriesConsumed += 125;
    }

}