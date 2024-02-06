package com.example.loginapp;

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

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VideoActivity extends AppCompatActivity {

    private VideoView fullscreenVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        fullscreenVideoView = findViewById(R.id.fullscreenVideoView);

        // Set the video URI using the raw resource
        String path = "android.resource://" + getPackageName() + "/" + R.raw.cats; // Make sure the name is lowercase
        fullscreenVideoView.setVideoURI(Uri.parse(path));
        fullscreenVideoView.start();

        fullscreenVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // You can close the activity when the video is finished
                finish();
            }
        });
    }
}
