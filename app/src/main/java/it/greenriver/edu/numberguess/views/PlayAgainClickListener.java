/*
 * Jonnathon McCoy
 * 10/7/2017
 *
 * package: it.greenriver.edu.numberguess.views
 * class: PlayAgainClickListener.java
 *
 * ClickListener for the Play Again button on the ResultsActivity.
 */
package it.greenriver.edu.numberguess.views;

import android.content.Intent;
import android.view.View;

import it.greenriver.edu.numberguess.activity.LandingActivity;
import it.greenriver.edu.numberguess.activity.ResultsActivity;

/*
 * ClickListener for the Play Again button on the ResultsActivity.
 */
public class PlayAgainClickListener implements View.OnClickListener{
    public static String PLAY_AGAIN_INTENT_TAG = "playAgain";
    private ResultsActivity activity;

    /**
     * Constructor for the PlayAgainClickListener
     *
     * @param activity - ResultsActivity - Receives an activity so that it can find the Views in
     *                 activity to perform methods and operations on them.
     */
    public PlayAgainClickListener(ResultsActivity activity) {
        this.activity = activity;
    }

    /**
     * On click, initiate the LandingActivity.
     *
     * @param view - View - The View object that was clicked on.
     */
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity.getApplicationContext(), LandingActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
