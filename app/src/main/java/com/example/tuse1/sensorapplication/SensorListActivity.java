package com.example.tuse1.sensorapplication;


import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SensorListActivity extends Activity {

    SensorManager sensorManager;
    List<Sensor> sensorList;
    TextView textView;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        textView =(TextView)findViewById(R.id.textView);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(Sensor sensor:sensorList){
            textView.append("\n\n"+"Name: "+sensor.getName().toString()+"\n"+"Vendor Name: "+sensor.getVendor().toString());
        }

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
