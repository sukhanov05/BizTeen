package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*

class MainActivity : AppCompatActivity() {

    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler= DatabaseHelper(this)

        showHome()

        registration.setOnClickListener {
            showRegistration()
        }
        login.setOnClickListener{
        showLogIN()
    }
        save.setOnClickListener{
            handler.insertUserData(name.text.toString(),email.text.toString(),Password_register.text.toString())
            showHome()
        }

        login_button.setOnClickListener{
           if( handler.userPresent(login_Email.text.toString(),login_Password.text.toString()))
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
            else
               Toast.makeText(this,"Username or Password is incorrect",Toast.LENGTH_SHORT).show()
        }


    }
   private fun showRegistration(){
       registration_layout.visibility=View.VISIBLE
       login_layout.visibility=View.GONE
       home_11.visibility=View.GONE

   }
        private fun showLogIN(){
            registration_layout.visibility=View.GONE
            login_layout.visibility=View.VISIBLE
            home_11.visibility=View.GONE
        }
    private fun showHome(){
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_11.visibility=View.VISIBLE
    }


}
