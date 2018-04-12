package com.practice.yafi.the200iqchallenge.Controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.practice.yafi.the200iqchallenge.R
import com.practice.yafi.the200iqchallenge.Services.DataService

import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    var currentQuestionNo = 0;
    val questions = DataService.questions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        init()
    }

    fun init() {
        val currentQuestion =  questions[currentQuestionNo]
        questionText.text = currentQuestion.question
        optionButton1.text = currentQuestion.options[0]
        optionButton2.text = currentQuestion.options[1]
        optionButton3.text = currentQuestion.options[2]
        optionButton4.text = currentQuestion.options[3]
    }

    fun optionButton1Clicked(view: View) {
        if(questions[currentQuestionNo].answer == 1) {
            currentQuestionNo++;
            init();
        }
    }

    fun optionButton2Clicked(view: View) {
        if(questions[currentQuestionNo].answer == 2) {
            currentQuestionNo++;
            init();
        }
    }

    fun optionButton3Clicked(view: View) {
        if(questions[currentQuestionNo].answer == 3) {
            currentQuestionNo++;
            init();
        }
    }

    fun optionButton4Clicked(view: View) {
        if(questions[currentQuestionNo].answer == 4) {
            currentQuestionNo++;
            init();
        }
    }

}
