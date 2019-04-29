package com.example.applimusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.seekBar = findViewById(R.id.sound_bar);
        //Pour les musiques qui son déjà dans l'application
        this.mediaPlayer = (MediaPlayer) mediaPlayer.create(getApplicationContext(), R.raw.creed2);

        //Pour aller chercher sur internet une musique

        /*String url = "https://www.youtube.com/watch?v=VZuaMPFZeIU";
        this.mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition() / 1000);
            }
        }, 1000, 1000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayer.seekTo(seekBar.getProgress() * 1000);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void playSound(View view) {

        Button button = (Button) view;
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            button.setText(getString(R.string.play_music_btn));
        }
        else{
            mediaPlayer.start();
            button.setText(getString(R.string.pause_music_btn));
        }
    }
}
