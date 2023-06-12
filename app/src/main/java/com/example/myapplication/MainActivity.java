package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.media.SoundPool;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int a,b,c,d,e,f,g;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(7)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else {
            soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC,0);
        }

        a = soundPool.load(this,R.raw.a,1);
        b = soundPool.load(this,R.raw.b,1);
        c = soundPool.load(this,R.raw.c,1);
        d = soundPool.load(this,R.raw.d,1);
        e = soundPool.load(this,R.raw.e,1);
        f = soundPool.load(this,R.raw.f,1);
        g = soundPool.load(this,R.raw.g,1);
    }

    public void playSound(View v){
        switch (v.getId()){
            case R.id.button:
                soundPool.play(c,1,1,0,0,1);
                break;
            case R.id.button2:
                soundPool.play(d,1,1,0,0,1);
                break;
            case R.id.button3:
                soundPool.play(e,1,1,0,0,1);
                break;
            case R.id.button4:
                soundPool.play(f,1,1,0,0,1);
                break;
            case R.id.button5:
                soundPool.play(g,1,1,0,0,1);
                break;
            case R.id.button6:
                soundPool.play(a,1,1,0,0,1);
                break;
            case R.id.button7:
                soundPool.play(b,1,1,0,0,1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}