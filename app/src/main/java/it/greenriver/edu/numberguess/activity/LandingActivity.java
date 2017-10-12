/*
 * Jonnathon McCoy
 * 10/7/2017
 *
 * package: it.greenriver.edu.numberguess.activity
 * class: LandingActivity.java
 *
 * Simple landing page with a button to start the game.
 */
package it.greenriver.edu.numberguess.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import it.greenriver.edu.numberguess.R;
import it.greenriver.edu.numberguess.views.StartClickListener;

/**
 * Simple landing page with a button to start the game.
 *
 * @author Jonnathon McCoy
 * @version 1.0
 */
public class LandingActivity extends AppCompatActivity {
    LandingActivity activity;
    Button btn_start;

    /**
     * Entry point for LandingActivity.
     *
     * @param savedInstanceState - The state the application is currently in.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        locateViews();
        bindFunctionality();
    }

    /**
     * Locate all the views necessary for the application to perform a task.
     */
    private void locateViews() {
        btn_start = (Button) findViewById(R.id.btn_start);
    }

    /**
     * Instantiate the variables and create/attach the functionality of the certain pieces in this
     * activity.
     */
    private void bindFunctionality() {
        //this is supposed to prevent fragments from detaching. I think...
        activity = this;

        StartClickListener listener = new StartClickListener(activity);
        btn_start.setOnClickListener(listener);
    }
}
