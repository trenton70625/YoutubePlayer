package com.example.trentearley.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandAloneActivity extends AppCompatActivity implements View.OnClickListener {

    private String GOOGLE_API_KEY = "AIzaSyCJj7zeLNpxz7-wC4Z4z2Ia9HEOtl0GvTI";
    private String YOUTUBE_VIDEO_ID = "L-nOY_d-vJU";
    private String YOUTUBE_PLAYLIST = "PLpunK869ImED9YIOrQuqyzGE-rHwv-WOW";

    private Button btnPlayVideo;
    private Button btnPlayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand_alone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayList = (Button) findViewById(R.id.btnPlayList);
        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);

        btnPlayVideo.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            default:

        }
        if(intent != null){
            startActivity(intent);
        }
    }
}
