package com.lasercrafter.bikevitals;

import android.os.Bundle;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor accelerometer;

private SensorManager x;

public void onCreate(){
    x = (SensorManager) getSystemService(SENSOR_SERVICE);
    Sensor accelerometer = x.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    x.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }


@Override
public final void onAccuracyChanged(Sensor sensor, int accuracy){}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}