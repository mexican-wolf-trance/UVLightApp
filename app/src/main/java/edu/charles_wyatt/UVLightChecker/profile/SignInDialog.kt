package edu.charles_wyatt.UVLightChecker.profile

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import edu.charles_wyatt.UVLightChecker.R
import kotlinx.android.synthetic.*

class SignInDialog : DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        return AlertDialog.Builder(requireContext())
            .setView(R.layout.sign_in_dialog)
            .setPositiveButton(android.R.string.ok) { dialog, buttonid ->
                val username = (dialog as AlertDialog).findViewById<EditText>(R.id.enter_user_name)
                val password = dialog.findViewById<EditText>(R.id.enter_pass_word)

                val intent = Intent()
                intent.putExtra("username", username?.text.toString())
                intent.putExtra("password", password?.text.toString())

                intent.putExtra("signIn", "1")

                targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            }
            .create()
    }
}