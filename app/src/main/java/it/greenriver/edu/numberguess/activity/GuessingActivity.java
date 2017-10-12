/*
 * Jonnathon McCoy
 * 10/7/2017
 *
 * package: it.greenriver.edu.numberguess.activity
 * class: GuessingActivity.java
 *
 * Program will generate a random number between 1 and 20 and the user is asked to enter a number.
 * If the number is higher than the guess, it will display a Toast that says the number is higher.
 * If the number is lower than the guess, it will display a Toast that says the number is lower.
 *
 * Once the number is guessed, the program will go to a different activity that will display how
 * many guesses it took to complete and ask if the user wants to play again.
 */

package it.greenriver.edu.numberguess.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import it.greenriver.edu.numberguess.R;
import it.greenriver.edu.numberguess.controller.GameLogic;
import it.greenriver.edu.numberguess.controller.OnScreenMessager;
import it.greenriver.edu.numberguess.controller.Validator;
import it.greenriver.edu.numberguess.views.CheckClickListener;

/**
 * Program will generate a random number between 1 and 20 and the user is asked to enter a number.
 * If the number is higher than the guess, it will display a Toast that says the number is higher.
 * If the number is lower than the guess, it will display a Toast that says the number is lower.
 *
 * Once the number is guessed, the program will go to a different activity that will display how
 * many guesses it took to complete and ask if the user wants to play again.
 *
 * @author Jonnathon McCoy
 * @version 1.0
 */
public class GuessingActivity extends AppCompatActivity {

    public static OnScreenMessager messager;
    public static GameLogic logic;
    public static Validator validator;
    public static final String RESULT_INTENT_TAG = "results";

    GuessingActivity activity;

    EditText et_input;
    Button btn_check;

    /**
     * Entry point for GuessingActivity.
     *
     * @param savedInstanceState - The state the application is currently in.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        locateViews();
        bindFunctionality();
    }

    /**
     * Locate all the views necessary for the application to perform a task.
     */
    private void locateViews() {
        btn_check = (Button) findViewById(R.id.btn_check);
        et_input = (EditText) findViewById(R.id.et_input);
    }

    /**
     * Instantiate the variables and create/attach the functionality of the certain pieces in this
     * activity.
     */
    private void bindFunctionality() {
        //this is supposed to prevent fragments from detaching. I think...
        activity = this;

        messager = new OnScreenMessager();
        logic = new GameLogic(activity);
        validator = new Validator(activity);

        CheckClickListener listener = new CheckClickListener(activity, logic);
        btn_check.setOnClickListener(listener);
    }
}