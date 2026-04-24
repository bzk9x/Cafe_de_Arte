package com.bzk9x.cafdearte

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.content.edit
import com.bzk9x.cafdearte.home.HomeActivity
import com.bzk9x.cafdearte.onboarding.OnboardingActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences("CDA_prefs", MODE_PRIVATE)
        val isFirstRun = sharedPref.getBoolean("isFirstRun", true)

        if (isFirstRun) {
            sharedPref.edit { putBoolean("isFirstRun", false) }
            startActivity(Intent(this, OnboardingActivity::class.java))
        } else {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}