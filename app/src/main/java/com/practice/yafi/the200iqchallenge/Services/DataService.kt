package com.practice.yafi.the200iqchallenge.Services

import com.practice.yafi.the200iqchallenge.Model.Question

object DataService {
    val questions = listOf(
            Question("What is your name?", arrayOf("A", "B", "C", "D"), 1),
            Question("What is your age?", arrayOf("A", "B", "C", "D"), 2)
    )
}