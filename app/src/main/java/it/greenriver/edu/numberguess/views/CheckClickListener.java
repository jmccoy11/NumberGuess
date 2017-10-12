/*
 * Jonnathon McCoy
 * 10/7/2017
 *
 * package: it.greenriver.edu.numberguess.views
 * class: CheckClickListener.java
 *
 * ClickListener for the Check button on the GuessingActivity.
 */
package it.greenriver.edu.numberguess.views;

import android.view.View;
import android.widget.EditText;

import it.greenriver.edu.numberguess.R;
import it.greenriver.edu.numberguess.activity.GuessingActivity;
import it.greenriver.edu.numberguess.controller.GameLogic;

/*
 * ClickListener for the Check button on the GuessingActivity.
 */
public class CheckClickListener implements View.OnClickListener {
    private GuessingActivity activity;

    /**
     * Constructor for the CheckClickListener
     *
     * @param activity - GuessingActivity - Receives an activity so that it can find the Views in
     *                 activity to perform methods and operations on them.
     * @param logic - GameLogic - allows performing methods in the GameLogic class.
     */
    public CheckClickListener(GuessingActivity activity, GameLogic logic) {
        this.activity = activity;
    }

    /**
     * On click, get the text from the EditText input. Validate the input and compare to the
     * random number.
     *
     * @param view - View - The View object that was clicked on.
     */
    @Override
    public void onClick(View view) {
        String inputString = getText((EditText) activity.findViewById(R.id.et_input));
        int inputNum = GuessingActivity.validator.validate(inputString);

        if(inputNum != -1) {
            GuessingActivity.logic.compare(inputNum);
        }
    }

    /**
     * Pull the input from an EditText.
     *
     * @param input - EditText - View to pull the data from.
     * @return String - The string value of what is in the EditText.
     */
    private String getText(EditText input) {
        return input.getText().toString();
    }
}
