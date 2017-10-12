/*
 * Jonnathon McCoy
 * 10/7/2017
 *
 * package: it.greenriver.edu.numberguess.controller
 * class: Validator.java
 *
 * Contains the methods validating input.
 */

package it.greenriver.edu.numberguess.controller;

import it.greenriver.edu.numberguess.R;
import it.greenriver.edu.numberguess.activity.GuessingActivity;

/*
 * Contains the methods for displaying Toasts on the screen.
 */
public class Validator {
    private GuessingActivity activity;

    /**
     * Constructor for the validator
     *
     * @param activity - GuessingActivity - Receives an activity so that it can find the Views in
     *                 activity to perform methods and operations on them.
     */
    public Validator(GuessingActivity activity) {
        this.activity = activity;
    }

    /**
     * Validate user input.
     *
     * @param input - int - The input from the user
     * @return int - return the user input if valid or -1 if not.
     */
    public int validate (String input) {
       return parseInput(input);
    }

    /**
     * Parse the data.
     *
     * @param input - int - The input from the user
     * @return int - return the user input if valid or -1 if not.
     */
    private int parseInput(String input) {
        int inputNum = -1;

        if (input.isEmpty()) {
            GuessingActivity.messager.displayMessage(activity, activity.getString(R.string.empty));
            return -1;
        }

        try {
            inputNum = Integer.parseInt(input);

            if(!GuessingActivity.logic.isInRange(inputNum)) {
                GuessingActivity.messager.displayMessage(activity, activity.getString(R.string.out_of_range));
                return -1;
            }
        }
        catch (NumberFormatException exc) {
            GuessingActivity.messager.displayMessage(activity, activity.getString(R.string.NAN));
            return -1;
        }

        return inputNum;
    }
}
