package com.practice.yafi.the200iqchallenge.Controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.practice.yafi.the200iqchallenge.Model.Question
import com.practice.yafi.the200iqchallenge.R
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {
    var currentQuestionNo = 0;
    private val questions = Vector<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        applicationContext.assets.open("QuestionFile.txt").reader().forEachLine {
            println(it)
            val strings = it.split(";")
            questions.add(Question(strings[0], arrayOf(strings[1], strings[2], strings[3], strings[4]), strings[5].toInt()))
        }
        loadQuestion()
    }

    private fun loadQuestion() {
        val currentQuestion =  questions[currentQuestionNo]
        questionText.text = currentQuestion.question
        optionButton1.text = currentQuestion.options[0]
        optionButton2.text = currentQuestion.options[1]
        optionButton3.text = currentQuestion.options[2]
        optionButton4.text = currentQuestion.options[3]
    }

    fun optionButton1Clicked(view: View) {
        if(questions[currentQuestionNo].answer == 1) {
            currentQuestionNo++
            loadQuestion()
        } else {
            wrongAnswer()
        }
    }

    fun optionButton2Clicked(view: View) {
        if(questions[currentQuestionNo].answer == 2) {
            currentQuestionNo++
            loadQuestion()
        } else {
            wrongAnswer()
        }
    }

    fun optionButton3Clicked(view: View) {
        if(questions[currentQuestionNo].answer == 3) {
            currentQuestionNo++
            loadQuestion()
        } else {
            wrongAnswer()
        }
    }

    fun optionButton4Clicked(view: View) {
        if(questions[currentQuestionNo].answer == 4) {
            currentQuestionNo++
            loadQuestion()
        } else {
            wrongAnswer()
        }
    }

    fun wrongAnswer() {
        Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
    }
}
