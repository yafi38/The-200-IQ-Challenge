package com.practice.yafi.the200iqchallenge.Controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.practice.yafi.the200iqchallenge.R

class EndActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
    }

    fun backToMenu(view: View) {
        val menuIntent = Intent(this, MenuActivity::class.java)
        startActivity(menuIntent)
    }
}
