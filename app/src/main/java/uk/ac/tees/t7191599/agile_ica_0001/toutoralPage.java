package uk.ac.tees.t7191599.agile_ica_0001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class toutoralPage extends YouTubeBaseActivity {

    YouTubePlayerView myYoutubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener myOnListner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toutoral_page);
        btnPlay = (Button) findViewById(R.id.play);
        myYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.YoutubePlay);

        myOnListner = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                List<String> videoList = new ArrayList<String>();
                videoList.add("1ibbX_2Beqs");
                videoList.add("PG-FUDusEf4");
                videoList.add("7xBJZd9mSd8");
                videoList.add("c0YChgqiJ2Y");
                videoList.add("_zJwhpU7sq0");


                youTubePlayer.loadVideos(videoList);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myYoutubePlayerView.initialize(YoutubeConfig.getApi_Key(),myOnListner);
            }
        });
    }
}
