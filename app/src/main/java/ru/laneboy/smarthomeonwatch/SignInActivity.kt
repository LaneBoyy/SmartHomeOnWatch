package ru.laneboy.smarthomeonwatch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import ru.laneboy.smarthomeonwatch.databinding.ActivitySignInBinding

class SignInActivity : Activity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickButtonEnter()
    }

    private fun onClickButtonEnter() {
        binding.btnEnterYourHouse.setOnClickListener {
            validateAndStart()
        }
    }

    private fun validateAndStart() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        if (email.isEmailValid()) {
            if (password.isNotEmpty()) {
                val intent = Intent(this, BoxesActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.toast_sign_in), Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Toast.makeText(this, getString(R.string.toast_invalid_email), Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this)
                && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}