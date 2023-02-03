package ru.laneboy.smarthomeonwatch.presentation.activities

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import ru.laneboy.smarthomeonwatch.R
import ru.laneboy.smarthomeonwatch.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : Activity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startAnimation()
    }

    private fun startAnimation() {
        val animation =
            AnimatorInflater.loadAnimator(this, R.animator.animator_logo) as AnimatorSet
        animation.setTarget(binding.ivLogo)
        animation.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {
            }

            override fun onAnimationEnd(p0: Animator) {
                launchMainScreen()
            }

            override fun onAnimationCancel(p0: Animator) {
            }

            override fun onAnimationRepeat(p0: Animator) {
            }
        })
        animation.start()
    }

    private fun launchMainScreen() {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}