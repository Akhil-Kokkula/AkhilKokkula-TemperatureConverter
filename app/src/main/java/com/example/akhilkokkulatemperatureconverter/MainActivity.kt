package com.example.akhilkokkulatemperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val celsiusSeekBar = findViewById<SeekBar>(R.id.celsiusSeekBar)
        val fahrenheitSeekBar = findViewById<SeekBar>(R.id.farenheitSeekBar)
        val celsiusDisplay = findViewById<TextView>(R.id.celsius_value)
        val fahrenheitDisplay = findViewById<TextView>(R.id.farenheit_value)
        val messageDisplay = findViewById<TextView>(R.id.messageDisplay)

        celsiusSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    val fahrenheitVal = (progress * (9.0/5.0) + 32).toInt()
                    celsiusDisplay.text = progress.toString()
                    fahrenheitSeekBar.progress = fahrenheitVal
                    fahrenheitDisplay.text = fahrenheitVal.toString()
                }

                if (progress <= 20) {
                    messageDisplay.setText(R.string.warmer_message)
                } else {
                    messageDisplay.setText(R.string.colder_message)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        fahrenheitSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if (progress < 32) {
                    fahrenheitSeekBar.progress = 32

                }

                if (fromUser) {
                    if (progress < 32) {
                        fahrenheitDisplay.setText(R.string.default_fahrenheit)
                        celsiusDisplay.setText(R.string.default_celsius)
                        celsiusSeekBar.progress = 0
                    } else {
                        val celsiusVal = ((progress - 32) * (5.0/9.0)).toInt()
                        fahrenheitDisplay.text = progress.toString()
                        celsiusSeekBar.progress = celsiusVal
                        celsiusDisplay.text = celsiusVal.toString()
                    }
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }
}