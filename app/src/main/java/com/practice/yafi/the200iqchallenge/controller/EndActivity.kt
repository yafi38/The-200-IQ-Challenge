package com.practice.yafi.the200iqchallenge.controller

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.practice.yafi.the200iqchallenge.R

class EndActivity : AppCompatActivity() {
    lateinit var buttonPressSound: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        buttonPressSound = MediaPlayer.create(this, R.raw.button_press)
    }

    fun backToMenu(view: View) {
        buttonPressSound.start()
        Thread.sleep(100)
        val menuIntent = Intent(this, MenuActivity::class.java)
        startActivity(menuIntent)
        finish()
    }
}
