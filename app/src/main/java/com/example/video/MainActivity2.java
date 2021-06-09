package com.example.video;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class MainActivity2 extends AppCompatActivity {

    String videoURL;
    PlayerView playerView;
    SimpleExoPlayer player;

    private  boolean playWhenReady = true;
    private  int currentWindow = 0;
    private  long playBackPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        playerView = findViewById(R.id.video_view);
        videoURL = getIntent().getStringExtra("url");

    }
    public void initVideo(){
        //player
        player = ExoPlayerFactory.newSimpleInstance(this);
        //connect player with player view
        playerView.setPlayer(player);
        //media source
        Uri uri = Uri.parse(videoURL);
        DataSource.Factory dataSource = new DefaultDataSourceFactory(this,"exoplayer-codelab");
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSource).createMediaSource(uri);
        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow,playBackPosition);
        player.prepare(mediaSource,false,false);
    }
    public void releasesVideo(){
        if (player !=null){
            playWhenReady= player.getPlayWhenReady();
            playBackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        initVideo();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (player != null){
            initVideo();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releasesVideo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasesVideo();
    }
}