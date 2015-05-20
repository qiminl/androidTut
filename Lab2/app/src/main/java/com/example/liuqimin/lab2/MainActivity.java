package com.example.liuqimin.lab2;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{
    Button playButton;
    Button stopButton;
    boolean play = false;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycleapp", "in oncreate");
        Toast.makeText(this, "in oncreate", Toast.LENGTH_LONG).show();
        playButton = (Button) findViewById(R.id.playbutton);
        playButton.setOnClickListener(this);
        stopButton = (Button) findViewById(R.id.stopbutton);
        stopButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycleapp", "in onStart");
        Toast.makeText(this, "in onStart", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycleapp", "in onResume");
        Toast.makeText(this, "in onResume", Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Lifecycleapp", "in onStop");
        Toast.makeText(this, "in onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Lifecycleapp", "in onDestroy");
        Toast.makeText(this, "in onDestroy", Toast.LENGTH_LONG).show();
        if (play) {
            mp.stop();
            play = false;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Lifecycleapp", "in onPause");
        Toast.makeText(this, "in onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playbutton){
            //do sth
            Log.d("button clicked", "play button clicked");
            Toast.makeText(this, "play button clicked", Toast.LENGTH_LONG).show();
            if (!play) {
                mp = MediaPlayer.create(this, R.raw.song);
                mp.start();
                play = true;
            }
        }
        else if (v.getId() == R.id.stopbutton){
            //do sth
            Log.d("button clicked", "stop button clicked");
            Toast.makeText(this, "stop button clicked", Toast.LENGTH_LONG).show();
            if (play) {
                mp.stop();
                play = false;
            }
        }
    }
}
