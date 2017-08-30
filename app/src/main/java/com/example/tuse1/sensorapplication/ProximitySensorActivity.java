package com.example.tuse1.sensorapplication;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tuse1 on 09-Aug-17.
 */

public class ProximitySensorActivity extends Activity implements SensorEventListener {
    SensorManager mSensorManager;
    Sensor mproximity;
    TextView textView;
    Button back;
    MediaPlayer mediaPlayer;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        textView =(TextView)findViewById(R.id.textView3);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mproximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mediaPlayer = MediaPlayer.create(this,R.raw.rihana);
        mediaPlayer.start();

        back=findViewById(R.id.btnBack3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            textView.setText(" "+event.values[0]);
            double tmp=event.values[0];
            if(tmp<=0.0){
                mediaPlayer.pause();
            }
            else {
                if(mediaPlayer.isPlaying()){

                }
                else{
                    mediaPlayer.start();
                }
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mproximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
