package com.app.waveflowanimation



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.keshavpassi.waveflow.view.WaveView

/**
 * Main Activity
 * Entry point of application.
 * Displays custom water wave animation view.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set custom animation view as content
        setContentView(WaveView(this))
    }
}
