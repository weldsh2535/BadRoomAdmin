package com.version1.badroomAdmin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.version1.badroomAdmin.prefreces.Constants


class LauncherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val i: Intent
        val pref = getSharedPreferences(Constants.APPLICATION_TAG, MODE_PRIVATE)
        val username = pref.getString("username", "")
        val password = pref.getString("password", "")
        if (username!!.isEmpty() && password!!.isEmpty())
      {
            i = Intent(this@LauncherActivity, LoginActivity::class.java)
            startActivity(i)
        } else {
            i = Intent(this@LauncherActivity, MainActivity::class.java)
            startActivity(i)
        }
        finish()
    }
}