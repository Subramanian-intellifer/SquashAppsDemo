package com.example.sqaushappsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {

    VideoView videoView;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView=findViewById(R.id.videoView);


        position=getIntent().getIntExtra("POSITION",0);

        if(position==0||position==3)
        {
            Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample_one_video);
            videoView.setVideoURI(uri);
            videoView.start();
        }
        else if(position==1||position==4)
        {
            Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample_two_video);
            videoView.setVideoURI(uri);
            videoView.start();
        }
        else if(position==2||position==5)
        {
            Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample_three_video);
            videoView.setVideoURI(uri);
            videoView.start();
        }













    }
}