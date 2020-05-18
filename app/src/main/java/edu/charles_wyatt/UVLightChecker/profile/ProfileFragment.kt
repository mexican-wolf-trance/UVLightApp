package edu.charles_wyatt.UVLightChecker.profile

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import edu.charles_wyatt.UVLightChecker.R
import edu.charles_wyatt.UVLightChecker.UVDisplay.UVLightDisplayFragment
import edu.charles_wyatt.UVLightChecker.buttons.MyBounceInterpolator
import kotlinx.android.synthetic.main.profile_frag.view.*

class ProfileFragment(private val app: Application): Fragment()
{
    fun didTapButton(button: Button)
    {
//        val button: Button = view?.findViewById(R.id.signin_dialog) as Button
        val myAnim: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.bounce)
        button.startAnimation(myAnim)

        val interpolator = MyBounceInterpolator(0.2, 20.0)
        myAnim.interpolator = interpolator

        button.startAnimation(myAnim)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.profile_frag, container, false)

        val signInButton = view.signin_dialog
        val registerButton = view.register_dialog

        signInButton.setOnClickListener()
        {
            didTapButton(signInButton)

            val newProfFrag = parentFragmentManager.beginTransaction()
            val prev = parentFragmentManager.findFragmentByTag("dialog")
            if (prev != null)
            { newProfFrag.remove(prev) }

            newProfFrag.addToBackStack(null)

            val diagFrag = SignInDialog()
            diagFrag.setTargetFragment(this, Activity.RESULT_OK)
            diagFrag.show(newProfFrag, "dialog")
        }

        registerButton.setOnClickListener()
        {
            didTapButton(registerButton)

            val signInFrag = parentFragmentManager.beginTransaction()
            val prev = parentFragmentManager.findFragmentByTag("dialog")
            if (prev != null)
            { signInFrag.remove(prev) }

            signInFrag.addToBackStack(null)
            val diagFrag = NewProfileDialog()

            diagFrag.setTargetFragment(this, Activity.RESULT_OK)
            diagFrag.show(signInFrag, "dialog")
        }


        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        val newProf = data?.getStringExtra("newProf").toString()
        if (newProf === "1")
        {
            Log.e("TAG", "Data? $data")
//            val firstName = data?.getStringExtra("firstName").toString()
//            val lastName = data?.getStringExtra("lastName").toString()
//            val email = data?.getStringExtra("email").toString()
//            val userName = data?.getStringExtra("userName").toString()
//            val passWord = data?.getStringExtra("passWord").toString()
//            appModel.createNewProfile(firstName, lastName, email, userName, passWord)
            activity?.let {Toast.makeText(it, "You created a new profile!", Toast.LENGTH_SHORT).show()}

            var viewFrag = parentFragmentManager.findFragmentById(R.id.framelayout) as? UVLightDisplayFragment
            if (viewFrag == null)
                viewFrag = UVLightDisplayFragment(app)

            if (!viewFrag.isAdded)
            {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, viewFrag)
                    .commit()
            }
        }
        val signIn = data?.getStringExtra("signIn").toString()
        if (signIn === "1")
        {
            Log.e("TAG", "Data? $data")
//            val uName = data?.getStringExtra("uName").toString()
//            val lastName = data?.getStringExtra("pWord").toString()

            activity?.let { Toast.makeText(it, "You signed in!", Toast.LENGTH_SHORT ).show()}

            var viewFrag = parentFragmentManager.findFragmentById(R.id.framelayout) as? UVLightDisplayFragment
            if (viewFrag == null)
                viewFrag = UVLightDisplayFragment(app)

            if (!viewFrag.isAdded)
            {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, viewFrag)
                    .commit()
            }
        }

    }
}