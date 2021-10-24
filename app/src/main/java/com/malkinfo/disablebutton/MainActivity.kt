package com.malkinfo.disablebutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var logBtn:Button
    private lateinit var userName:TextInputEditText
    private lateinit var password:TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**get Id*/
        userName = findViewById(R.id.userName)
        password = findViewById(R.id.password)
        logBtn = findViewById(R.id.loginBtn)

        userName.addTextChangedListener(loginTextWatcher)
        password.addTextChangedListener(loginTextWatcher)

       /**ok now click the Button */
        logBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity,NewActivity::class.java))
        }

    }

    private val loginTextWatcher = object :TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            val user_name = userName.text.toString().trim()
            val user_password = password.text.toString().trim()

            logBtn.isEnabled = user_name.isNotEmpty() && user_password.isNotEmpty()




        }

        override fun afterTextChanged(p0: Editable?) {}

    }

}