package com.example.tuse1.sensorapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    //Button btnSensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSensorList = findViewById(R.id.btnSensorList);
        btnSensorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SensorListActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button btnLightSensor = findViewById(R.id.btnLightSensor);
        btnLightSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LightSensorActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button btnProximity = findViewById(R.id.btnProximity);
        btnProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProximitySensorActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button btnAccelerometer = findViewById(R.id.btnAccelerometer);
        btnAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AccelerometerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button btnStartService = findViewById(R.id.btnStartService);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MyService.class);
                startService(intent);
                //finish();
            }
        });

        Button btnStopService = findViewById(R.id.btnStopService);
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MyService.class);
                stopService(intent);
                //finish();
            }
        });
    }
}
