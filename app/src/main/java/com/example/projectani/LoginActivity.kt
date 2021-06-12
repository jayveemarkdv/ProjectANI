package com.example.projectani

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


private var mAuth: FirebaseAuth? = null
class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val mEmail = findViewById<EditText>(R.id.emailText)
        val mPassword = findViewById<EditText>(R.id.passwordText)
        val loginBtn = findViewById<Button>(R.id.button)
        mAuth = FirebaseAuth.getInstance()
        FirebaseAuth.getInstance().signOut()
        loginBtn.setOnClickListener {
            val email: String = mEmail.getText().toString().trim { it <= ' ' }
            val password: String = mPassword.getText().toString().trim { it <= ' ' }
            mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = mAuth!!.currentUser
                        startActivity(Intent(applicationContext, DashboardActivity::class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            this@LoginActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

}