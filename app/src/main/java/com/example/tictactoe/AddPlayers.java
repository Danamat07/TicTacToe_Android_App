package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The AddPlayers activity allows users to input player names before starting the game.
 * It validates that both player names are entered and then starts the MainActivity with the provided names.
 */
public class AddPlayers extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     * Initializes UI elements and sets up the button click listener.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the most recent data. Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_players);

        // Initialize UI components
        EditText playerOne = findViewById(R.id.player1);
        EditText playerTwo = findViewById(R.id.player2);
        Button startGameButton = findViewById(R.id.startGameButton);

        // Set click listener for the start game button
        startGameButton.setOnClickListener(v -> {
            String getPlayerOneName = playerOne.getText().toString();
            String getPlayerTwoName = playerTwo.getText().toString();

            // Validate that both player names are entered
            if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                Toast.makeText(AddPlayers.this, "Please enter player name", Toast.LENGTH_SHORT).show();
            } else {
                // Start MainActivity and pass player names as extras
                Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                intent.putExtra("playerOne", getPlayerOneName);
                intent.putExtra("playerTwo", getPlayerTwoName);
                startActivity(intent);
            }
        });
    }
}