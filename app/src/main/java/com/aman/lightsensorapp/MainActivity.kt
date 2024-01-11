package com.aman.lightsensorapp

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mySensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val lightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        if (lightSensor != null) {
            available!!.text = "LIGHT Available"
            mySensorManager.registerListener(
                lightSensorListener,
                lightSensor,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        } else {
            available!!.text = "LIGHT NOT Available"
        }
    }

    private val lightSensorListener: SensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            // TODO Auto-generated method stub
        }

        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_LIGHT) {
                intensity!!.text = "" + event.values[0]

                if (event.values[0] in 0.0..50.0) {
                    light!!.text = "Switch On Lights"

                    circularProgressBar.apply {
                        // Set Progress
                        progress = 65f

                        // or with animation
                        setProgressWithAnimation(65f, 1000) // =1s

                        // Set Progress Max
                        progressMax = 200f

                        // Set ProgressBar Color
                        progressBarColor = Color.BLACK

                        // or with gradient
                        progressBarColorStart = Color.GRAY
                        progressBarColorEnd = Color.WHITE
                        progressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set background ProgressBar Color
                        backgroundProgressBarColor = Color.GRAY

                        // or with gradient
                        backgroundProgressBarColorStart = Color.WHITE
                        backgroundProgressBarColorEnd = Color.WHITE
                        backgroundProgressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set Width
                        progressBarWidth = 7f // in DP
                        backgroundProgressBarWidth = 3f // in DP

                        // Other
                        roundBorder = true
                        startAngle = 180f
                        progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
                    }

                } else if (event.values[0] in 50.0..100.0) {

                    light!!.text = "Dim Light"
                    circularProgressBar.apply {
                        // Set Progress
                        progress = 65f

                        // or with animation
                        setProgressWithAnimation(65f, 1000) // =1s

                        // Set Progress Max
                        progressMax = 200f

                        // Set ProgressBar Color
                        progressBarColor = Color.BLACK

                        // or with gradient
                        progressBarColorStart = Color.GRAY
                        progressBarColorEnd = Color.RED
                        progressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set background ProgressBar Color
                        backgroundProgressBarColor = Color.GRAY

                        // or with gradient
                        backgroundProgressBarColorStart = Color.WHITE
                        backgroundProgressBarColorEnd = Color.WHITE
                        backgroundProgressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set Width
                        progressBarWidth = 7f // in DP
                        backgroundProgressBarWidth = 3f // in DP

                        // Other
                        roundBorder = true
                        startAngle = 180f
                        progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
                    }
                } else if (event.values[0] in 100.0..200.0) {
                    light!!.text = "Bright Light"

                    circularProgressBar.apply {
                        // Set Progress
                        progress = 65f

                        // or with animation
                        setProgressWithAnimation(65f, 20000) // =2s

                        // Set Progress Max
                        progressMax = 200f

                        // Set ProgressBar Color
                        progressBarColor = Color.BLACK

                        // or with gradient
                        progressBarColorStart = Color.GRAY
                        progressBarColorEnd = Color.RED
                        progressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set background ProgressBar Color
                        backgroundProgressBarColor = Color.GRAY

                        // or with gradient
                        backgroundProgressBarColorStart = Color.WHITE
                        backgroundProgressBarColorEnd = Color.RED
                        backgroundProgressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set Width
                        progressBarWidth = 7f // in DP
                        backgroundProgressBarWidth = 3f // in DP

                        // Other
                        roundBorder = true
                        startAngle = 180f
                        progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
                    }

                } else {

                    circularProgressBar.apply {
                        light!!.text = "Very Bright Light"
                        progress = 65f

                        // or with animation
                        setProgressWithAnimation(65f, 1000) // =1s

                        // Set Progress Max
                        progressMax = 200f

                        // Set ProgressBar Color
                        progressBarColor = Color.BLACK

                        // or with gradient
                        progressBarColorStart = Color.GRAY
                        progressBarColorEnd = Color.RED
                        progressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set background ProgressBar Color
                        backgroundProgressBarColor = Color.GRAY

                        // or with gradient
                        backgroundProgressBarColorStart = Color.WHITE
                        backgroundProgressBarColorEnd = Color.MAGENTA
                        backgroundProgressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set Width
                        progressBarWidth = 7f // in DP
                        backgroundProgressBarWidth = 3f // in DP

                        // Other
                        roundBorder = true
                        startAngle = 180f
                        progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
                    }
                }
            }
        }
    }
}
