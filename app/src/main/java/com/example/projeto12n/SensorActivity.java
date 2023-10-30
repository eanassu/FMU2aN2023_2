package com.example.projeto12n;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;

public class SensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        SensorManager mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        System.out.println("Sensores:");
        List<Sensor> lista = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for( Sensor sensor: lista ) {
            System.out.println(sensor.getName());
        }
    }
}