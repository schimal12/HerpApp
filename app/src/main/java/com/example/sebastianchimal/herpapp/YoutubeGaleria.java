package com.example.sebastianchimal.herpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class YoutubeGaleria extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    public static final String DEVELOPER_KEY = "AIzaSyCvaDb1GjYJke3hROPsk7o7WrduNNBGpOY";
    private static final String VIDEO_ID = "4NOo5tLPzB8";
    private YouTubePlayerFragment youTubePlayerFragment;
    private static  String youtube = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_galeria);
        Bundle extras = getIntent().getExtras();
        youtube = extras.getString("youtube");
        System.out.println("YOUTUBE:"+youtube);
        youTubePlayerFragment=(YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtubefragmente);
        youTubePlayerFragment.initialize(DEVELOPER_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(VIDEO_ID);
        youTubePlayer.play();
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
