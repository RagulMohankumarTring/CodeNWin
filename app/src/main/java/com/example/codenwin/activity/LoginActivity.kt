package com.example.codenwin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.codenwin.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    var constraintsTrue = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_btn.setOnClickListener {
            if(constraintsTrue) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                editTextTextPassword.error = "Incorrect"
                editTextTextEmailAddress.error = "Invalid"
            }
        }
        editTextTextEmailAddress.addTextChangedListener(object  :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.apply {

                    if (validateEmail(this) && toString().length>=8 || editTextTextEmailAddress.text.isBlank() && constraintsTrue) {
                        editTextTextEmailAddress.error == null
                        constraintsTrue = true
                    }else{
                        constraintsTrue = false
                        editTextTextEmailAddress.error = "invalid password."
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        editTextTextPassword.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.apply {

                    if (validatePassword(this) && toString().length>=8 || editTextTextPassword.text.isBlank() && constraintsTrue) {
                        editTextTextPassword.error == null
                        constraintsTrue = true
                    }else{
                        constraintsTrue = false
                        editTextTextPassword.error = "invalid password."
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        sign_up.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateEmail(email:CharSequence):Boolean{
        var EMAIL_PATTERN = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
        var pattern = Pattern.compile(EMAIL_PATTERN)
        var matcher = pattern.matcher(email)
        return matcher.matches()
    }
    fun validatePassword(password:CharSequence):Boolean{
        var PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        var pattern = Pattern.compile(PASSWORD_PATTERN)
        var matcher = pattern.matcher(password)
        return matcher.matches()
    }
}