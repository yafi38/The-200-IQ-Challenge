package com.practice.yafi.the200iqchallenge.controller

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.practice.yafi.the200iqchallenge.R
import com.practice.yafi.the200iqchallenge.model.Question
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {
    var currentQuestionNo = 0
    private val questions = Vector<Question>()
    var lives = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        applicationContext.assets.open("QuestionFile.txt").reader().forEachLine {
            val strings = it.split(";")
            questions.add(Question(strings[0], arrayOf(strings[1], strings[2], strings[3], strings[4]), strings[5].toInt()))
        }
        loadQuestion()
    }

    private fun loadQuestion() {

        val currentQuestion = questions[currentQuestionNo]
        questionText.text = currentQuestion.question
        optionButton1.text = currentQuestion.options[0]
        optionButton2.text = currentQuestion.options[1]
        optionButton3.text = currentQuestion.options[2]
        optionButton4.text = currentQuestion.options[3]

    }

    fun optionButton1Clicked(view: View) {
        Thread.sleep(100)
        if (questions[currentQuestionNo].answer == 1) {
            rightAnswer()
        } else {
            wrongAnswer()
        }
    }

    fun optionButton2Clicked(view: View) {
        Thread.sleep(100)
        if (questions[currentQuestionNo].answer == 2) {
            rightAnswer()
        } else {
            wrongAnswer()
        }
    }

    fun optionButton3Clicked(view: View) {
        Thread.sleep(100)
        if (questions[currentQuestionNo].answer == 3) {
            rightAnswer()
        } else {
            wrongAnswer()
        }
    }

    fun optionButton4Clicked(view: View) {
        Thread.sleep(100)
        if (questions[currentQuestionNo].answer == 4) {
            rightAnswer()
        } else {
            wrongAnswer()
        }
    }

    private fun rightAnswer() {
        val rightSound = MediaPlayer.create(this, R.raw.right_answer)
        rightSound.start()
        currentQuestionNo++
        if (currentQuestionNo == questions.size) {
            val endIntent = Intent(this, EndActivity::class.java)
            startActivity(endIntent)
            finish()
        } else {
            showRightAnswerDialog()
            loadQuestion()
        }

    }

    private fun wrongAnswer() {
        val wrongSound = MediaPlayer.create(this, R.raw.wrong_answer)
        lives--
        if(lives == 2) {
            heart1.visibility = View.INVISIBLE
        } else if(lives == 1) {
            heart2.visibility = View.INVISIBLE
        } else {
            wrongSound.start()
            gameOver()
            return
        }
        wrongSound.start()
        showWrongAnswerDialog()
    }

    private fun showRightAnswerDialog() {
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.right_answer_dialog, null)
        dialog.setView(dialogView)
        val alert = dialog.create()
        alert.show()
        alert.setCancelable(false)
        alert.setCanceledOnTouchOutside(false)

        Handler().postDelayed({
            if (alert.isShowing)
                alert.dismiss()
        }, 1000)

    }

    private fun showWrongAnswerDialog() {
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.wrong_answer_dialog, null)
        dialog.setView(dialogView)
        val alert = dialog.create()
        alert.show()
        alert.setCancelable(false)
        alert.setCanceledOnTouchOutside(false)

        Handler().postDelayed({
            if (alert.isShowing)
                alert.dismiss()
        }, 1000)
    }

    private fun gameOver() {
        val gameOverIntent = Intent(this, GameOverActivity::class.java)
        startActivity(gameOverIntent)
        finish()
    }

    override fun onBackPressed() {
        val menuIntent = Intent(this, MenuActivity::class.java)
        startActivity(menuIntent)
        finish()
    }
}
