package edu.charles_wyatt.UVLightChecker

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.charles_wyatt.UVLightChecker.UVDisplay.UVLightDisplayFragment
import edu.charles_wyatt.UVLightChecker.profile.ProfileFragment

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewFrag = supportFragmentManager.findFragmentById(R.id.framelayout) as? ProfileFragment
        if (viewFrag == null)
            viewFrag = ProfileFragment(application)

        if (!viewFrag.isAdded)
        {
            supportFragmentManager.beginTransaction()
                .add(R.id.framelayout, viewFrag)
                .commit()
        }
    }
}
