package com.practice.yafi.the200iqchallenge.controller

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.practice.yafi.the200iqchallenge.R

class MenuActivity : AppCompatActivity() {
    lateinit var buttonPressSound: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        buttonPressSound = MediaPlayer.create(this, R.raw.button_press)
    }

    fun playButtonClicked(view: View) {
        buttonPressSound.start()
        Thread.sleep(100)
        val gameIntent = Intent(this, GameActivity::class.java)
        startActivity(gameIntent)
        finish()
    }

}
