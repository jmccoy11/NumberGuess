/*
 * Jonnathon McCoy
 * 10/7/2017
 *
 * package: it.greenriver.edu.numberguess.controller
 * class: OnScreenMessager.java
 *
 * Contains the method for displaying Toasts on the screen.
 */
package it.greenriver.edu.numberguess.controller;

import android.content.Context;
import android.widget.Toast;

/*
 * Contains the method for displaying Toasts on the screen.
 */
public class OnScreenMessager {

    /**
     * Display a Toast message on the screen.
     *
     * @param activity - Context - The activity the Toast was called from.
     * @param message - String - The message to display.
     */
    public void displayMessage(Context activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}
