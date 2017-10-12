/*
 * Jonnathon McCoy
 * 10/7/2017
 *
 * package: it.greenriver.edu.numberguess.views
 * class: PlayAgainClickListener.java
 *
 * ClickListener for the Start button on the LandingActivity.
 */
package it.greenriver.edu.numberguess.views;

import android.content.Intent;
import android.view.View;

import it.greenriver.edu.numberguess.activity.GuessingActivity;
import it.greenriver.edu.numberguess.activity.LandingActivity;

/*
 * ClickListener for the Start button on the LandingActivity.
 */
public class StartClickListener implements View.OnClickListener{
    private LandingActivity activity;

    /**
     * Constructor for the StartClickListener
     *
     * @param activity - LandingActivity - Receives an activity so that it can find the Views in
     *                 activity to perform methods and operations on them.
     */
    public StartClickListener(LandingActivity activity) {
        this.activity = activity;
    }

    /**
     * On click, initiate the GuessingActivity.
     *
     * @param view - View - The View object that was clicked on.
     */
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity.getApplicationContext(), GuessingActivity.class);
        activity.startActivity(intent);
    }
}
