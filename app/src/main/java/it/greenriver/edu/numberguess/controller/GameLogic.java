/*
 * Jonnathon McCoy
 * 10/7/2017
 *
 * package: it.greenriver.edu.numberguess.controller
 * class: LandingActivity.java
 *
 * Contains the logic for running the game.
 */
package it.greenriver.edu.numberguess.controller;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

import it.greenriver.edu.numberguess.R;
import it.greenriver.edu.numberguess.activity.GuessingActivity;
import it.greenriver.edu.numberguess.activity.ResultsActivity;

/*
 * Contains the logic for running the game.
 */
public class GameLogic {
    private GuessingActivity activity;

    private int lowerLimit = 1;
    private int upperLimit = 20;
    private int randomNum;

    private ArrayList<Integer> guesses = new ArrayList<>(0);

    /**
     * Constructor for the Game Logic
     *
     * @param activity - GuessingActivity. Receives an activity so that it can find the Views in
     *                 activity to perform methods and operations on them.
     */
    public GameLogic(GuessingActivity activity) {
        this.activity = activity;
        generateRandomNumber();
    }

    /**
     * Create random number and set this to randomNum.
     */
    private void generateRandomNumber() {
        this.randomNum = (int)(Math.random() * upperLimit + 1);
    }

    /**
     * Receive input and add to guesses[]
     *
     * @param input - String - The user's input from GuessingGame.
     */
    private boolean addGuess(int input) {
        return guesses.add(input);
    }

    /**
     * Reset the guesses[].
     */
    private void resetGuesses() {
        guesses.clear();
    }

    /**
     * Check that the input is in the proper range.
     *
     * @param input - String - The user's input from GuessingGame.
     * @return True if between lowerLimit and upperLimit, false if otherwise.
     */
    boolean isInRange(int input) {
        return input >= lowerLimit && input <= upperLimit;
    }

    /**
     * Compare the input to the random number.
     *
     * @param input - String - The user's input from GuessingGame.
     */
    public void compare(int input) {
        addGuess(input);

        if (input < randomNum) {
            GuessingActivity.messager.displayMessage(activity, activity.getString(R.string.higher));

            Log.d("GameLogic: ", toString());
        }
        else if (input > randomNum){
            GuessingActivity.messager.displayMessage(activity, activity.getString(R.string.lower));

            Log.d("GameLogic: ", toString());
        }
        else //input == randomNum
        {
            Intent intent = new Intent(activity.getApplicationContext(), ResultsActivity.class);
            intent.putExtra(GuessingActivity.RESULT_INTENT_TAG, Integer.toString(getNumberOfGuesses()));
            activity.startActivity(intent);
            activity.finish();
        }
    }

    /**
     * Getter for lowerLimit.
     *
     * @return int - lowerLimit.
     */
    public int getLowerLimit() {
        return lowerLimit;
    }

    /**
     * Setter for lowerLimit.
     *
     * @param lowerLimit - int - new lowerLimit value.
     */
    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    /**
     * Getter for upperLimit.
     *
     * @return int - upperLimit.
     */
    public int getUpperLimit() {
        return upperLimit;
    }

    /**
     * Setter for upperLimit.
     *
     * @param upperLimit - int - new lowerLimit value.
     */
    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    /**
     * Get the number of guesses that have been made.
     *
     * @return - int - size of the guesses[]
     */
    private int getNumberOfGuesses() {
        return guesses.size();
    }

    /**
     * String representation of the GameLogic object.
     *
     * @return - String - String representation of the GameLogic object.
     */
    public String toString() {
        String s = "lowerLimit: " + lowerLimit + " | upperLimit: " + upperLimit + " | randomNum: "
                + randomNum + " | Guesses size: " + guesses.size() + " | In array: ";

        for (Integer i: guesses) {
            s += i.toString() + ", ";
        }

        return s;
    }
}