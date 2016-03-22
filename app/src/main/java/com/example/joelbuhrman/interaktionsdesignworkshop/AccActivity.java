package com.example.joelbuhrman.interaktionsdesignworkshop;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by JoelBuhrman on 16-03-22.
 */
public class AccActivity extends Activity implements SensorEventListener {
    private TextView xValue, yValue, zValue;
    Sensor accelerometer;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accelerator_activity);
        setIdentifiers();

    }

    public void setIdentifiers() {
        xValue = (TextView) findViewById(R.id.x_text_value);
        yValue = (TextView) findViewById(R.id.y_text_value);
        zValue = (TextView) findViewById(R.id.z_text_value);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        if (x > 0) {
            xValue.setText("X: +" +x);
        }
        else{
            xValue.setText("X: " +x);
        }

        if (y > 0) {
            yValue.setText("Y: +" +y);
        }
        else{
            yValue.setText("Y: " +y);
        }

        if (z > 0) {
            zValue.setText("Z: +" +z);
        }
        else{
            zValue.setText("Z: " +z);
        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
