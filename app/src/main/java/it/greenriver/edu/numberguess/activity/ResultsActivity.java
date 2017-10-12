/*
 * Jonnathon McCoy
 * 10/7/2017
 *
 * package: it.greenriver.edu.numberguess.activity
 * class: LandingActivity.java
 *
 * Receives results from GuessingAcivity and displays them here. Also has a button that asks the
 * user if they would like to play again. Returns to LandingActivity.
 */
package it.greenriver.edu.numberguess.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import it.greenriver.edu.numberguess.R;
import it.greenriver.edu.numberguess.views.PlayAgainClickListener;

 /* Receives results from GuessingAcivity and displays them here. Also has a button that asks the
  * user if they would like to play again. Returns to LandingActivity.
  */
public class ResultsActivity extends AppCompatActivity {
    Button btn_playAgain;
    TextView tv_numberOfGuesses;

     /**
      * Entry point for LandingActivity.
      *
      * @param savedInstanceState - The state the application is currently in.
      */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        locateViews();
        bindFunctionality();
    }

     /**
      * Locate all the views necessary for the application to perform a task.
      */
    private void locateViews() {
        btn_playAgain = (Button) findViewById(R.id.btn_playAgain);
        tv_numberOfGuesses = (TextView) findViewById(R.id.tv_numberOfGuesses);
    }

     /**
      * Instantiate the variables and create/attach the functionality of the certain pieces in this
      * activity.
      */
    private void bindFunctionality() {
        if(getIntent().hasExtra(GuessingActivity.RESULT_INTENT_TAG))
        {
            String results = getIntent().getStringExtra(GuessingActivity.RESULT_INTENT_TAG);
            tv_numberOfGuesses.setText(results);
        }

        PlayAgainClickListener listener = new PlayAgainClickListener(this);
        btn_playAgain.setOnClickListener(listener);
    }
}
