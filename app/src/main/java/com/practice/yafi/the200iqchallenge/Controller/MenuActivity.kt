package com.practice.yafi.the200iqchallenge.Controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.practice.yafi.the200iqchallenge.R

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

    }

    fun playButtonClicked(view: View) {
        val gameIntent = Intent(this, GameActivity::class.java)
        startActivity(gameIntent)
    }
}
