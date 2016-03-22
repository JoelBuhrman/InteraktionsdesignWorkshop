package com.example.joelbuhrman.interaktionsdesignworkshop;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JoelBuhrman on 16-03-22.
 */
public class Compass extends Activity implements SensorEventListener {
    private ImageView image;
    private float currentDegree = 0f;
    private SensorManager sensorManager;
    TextView direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compass_activity);
        setIdentifiers();

    }


    public void setIdentifiers() {
        image = (ImageView) findViewById(R.id.compass_image);
        direction = (TextView) findViewById(R.id.compass_text);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // to stop the listener and save battery
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float degree = Math.round(sensorEvent.values[0]);

        direction.setText("Heading: " + Float.toString(degree) + " degrees");

        // create a rotation animation (reverse turn degree degrees)
        RotateAnimation ra = new RotateAnimation(
                currentDegree,
                -degree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);

        // how long the animation will take place
        ra.setDuration(210);

        // set the animation after the end of the reservation status
        ra.setFillAfter(true);

        // Start the animation
        image.startAnimation(ra);
        currentDegree = -degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
