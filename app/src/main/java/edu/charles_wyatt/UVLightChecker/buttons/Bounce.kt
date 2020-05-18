package edu.charles_wyatt.UVLightChecker.buttons

import android.view.animation.Interpolator
import kotlin.math.cos

internal class MyBounceInterpolator(amplitude: Double, frequency: Double): Interpolator
    {
        private var mAmplitude = 1.0
        private var mFrequency = 10.0
        override fun getInterpolation(time: Float): Float
        {
            return (-1 * Math.pow(Math.E, -time / mAmplitude) *
                    cos(mFrequency * time) + 1).toFloat()
        }

    init
    {
        mAmplitude = amplitude
        mFrequency = frequency
    }
}