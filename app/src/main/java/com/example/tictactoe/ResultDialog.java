package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * Custom dialog to display the result of the Tic-Tac-Toe game.
 * It shows a message indicating the winner or a draw and provides a button to restart the match.
 */
public class ResultDialog extends Dialog {

    private final String message;
    private final MainActivity mainActivity;

    /**
     * Constructs a ResultDialog.
     *
     * @param context      The context of the application.
     * @param message      The message to display (winner or draw).
     * @param mainActivity Reference to the main activity to restart the game.
     */
    public ResultDialog(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }

    /**
     * Initializes the dialog, sets the message, and handles the restart button click event.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);
        TextView messageText = findViewById(R.id.messageText);
        Button restartButton = findViewById(R.id.playAgainButton);
        messageText.setText(message);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.restartMatch();
                dismiss();
            }
        });
    }
}