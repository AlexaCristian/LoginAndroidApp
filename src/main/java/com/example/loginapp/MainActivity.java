package com.example.loginapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.text.InputType;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private VideoView catVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catVideoView = findViewById(R.id.catVideoView);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        ImageView togglePasswordVisibility = findViewById(R.id.togglePasswordVisibility);

        Button loginButton = findViewById(R.id.loginButton);

        // Toggle password visibility
        togglePasswordVisibility.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Show the password
                        passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        passwordEditText.setSelection(passwordEditText.getText().length());
                        return true; // return true to indicate the event was handled
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Hide the password
                        passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        passwordEditText.setSelection(passwordEditText.getText().length());
                        return true;
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

// Check the user's credentials
                if ("Cristian".equals(username) && "cristian123".equals(password)) {
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void playCatVideo() {
        // Make the VideoView visible
        catVideoView.setVisibility(View.VISIBLE);
        // Set the video URI using the raw resource
        String path = "android.resource://" + getPackageName() + "/" + R.raw.cats;
        catVideoView.setVideoURI(Uri.parse(path));
        catVideoView.start();

        catVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // Hide the VideoView or do something else when the video is finished
                catVideoView.setVisibility(View.GONE);
            }
        });
    }
}
