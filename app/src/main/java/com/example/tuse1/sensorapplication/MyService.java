package com.example.tuse1.sensorapplication;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import static com.example.tuse1.sensorapplication.R.id.textView;

/**
 * Created by tuse1 on 09-Aug-17.
 */

public class MyService extends Service implements SensorEventListener {

    SensorManager mSensorManager;
    AudioManager audioManager;
    Sensor maccelerometer;
    Sensor mLight;
    Sensor mproximity;

    MediaPlayer mediaPlayer;




    @Override
    public void onCreate(){
        super.onCreate();
        Toast.makeText(getApplicationContext(),"Service Started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        maccelerometer= mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mproximity= mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, maccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mproximity, SensorManager.SENSOR_DELAY_NORMAL);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        return START_STICKY;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        /*if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            //textView.setText(" "+event.values[0]);
            double tmp=event.values[0];
            if(tmp<=10.0){
                //mediaPlayer.pause();
            }
            else {
                if(mediaPlayer.isPlaying()){

                }
                else{
                    //mediaPlayer.start();
                }
            }
        }*/


        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER ) {
            //textView.setText("X: "+event.values[0]+"\n"+"Y: "+event.values[1]+"\n"+"Z: "+event.values[2]);
            /*if(event.values[1]>7 && event.values[1]<11){
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }*/
            if(event.values[2]<0){
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }
            else {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        }

        /*if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            //textView.setText(" "+event.values[0]);
            double tmp=event.values[0];
            if(tmp<=0.0){
                //mediaPlayer.pause();
            }
            else {
                if(mediaPlayer.isPlaying()){

                }
                else{
                    //mediaPlayer.start();
                }
            }
        }*/

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void onDestroy(){
        super.onDestroy();
        mSensorManager.unregisterListener(this);
        Toast.makeText(getApplicationContext(),"Service Stopped", Toast.LENGTH_SHORT).show();
    }
}
