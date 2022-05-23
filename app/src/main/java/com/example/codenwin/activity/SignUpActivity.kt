package com.example.codenwin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.example.codenwin.R
import com.example.codenwin.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    var constraintsTrue:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        accountCreatedBtn.setOnClickListener {
            Log.i("check",password.text.toString())
            Log.i("check",reTypePassword.text.toString())
            if(password.text.toString() == reTypePassword.text.toString() && constraintsTrue) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                constraintsTrue =false
                reTypePassword.error = "Incorrect password"
            }
        }
        password.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.apply {

                    if (validatePassword(this) && toString().length>=8 || password.text.isBlank() && constraintsTrue) {
                        password.error == null
                        constraintsTrue = true
                    }else{
                        constraintsTrue = false
                        password.error = "invalid password."
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        mailId.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.apply {

                    if (validateEmail(this) && toString().length>=8 || mailId.text.isBlank()) {
                        mailId.error == null
                        constraintsTrue = true
                    }else{
                        constraintsTrue = false
                        mailId.error = "invalid password."
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }
    fun validatePassword(password:CharSequence):Boolean{
        var PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        var pattern = Pattern.compile(PASSWORD_PATTERN)
        var matcher = pattern.matcher(password)
        return matcher.matches()
    }
    fun validateEmail(email:CharSequence):Boolean{
        var EMAIL_PATTERN = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
        var pattern = Pattern.compile(EMAIL_PATTERN)
        var matcher = pattern.matcher(email)
        return matcher.matches()
    }
}