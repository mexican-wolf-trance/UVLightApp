package edu.charles_wyatt.UVLightChecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.charles_wyatt.UVLightChecker.UVDisplay.UVLightDisplayFragment

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewFrag = supportFragmentManager.findFragmentById(R.id.framelayout) as? UVLightDisplayFragment
        if (viewFrag == null)
            viewFrag = UVLightDisplayFragment(application)

        if (!viewFrag.isAdded)
        {
            supportFragmentManager.beginTransaction()
                .add(R.id.framelayout, viewFrag)
                .commit()
        }
    }
}
