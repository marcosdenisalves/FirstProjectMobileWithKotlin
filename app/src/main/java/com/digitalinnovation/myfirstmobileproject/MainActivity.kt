package com.digitalinnovation.myfirstmobileproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

const val MIN_AVG = 6
const val MAX_ABS = 10

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val currentThread = Thread.currentThread()
        currentThread.setUncaughtExceptionHandler {_, throwable->
            val x = throwable.message
            val cause = throwable.cause
        }
        ""
        val calculateButton = calculateBtn
        val result = textViewResult

        calculateBtn.setOnClickListener {
            try {
                val gradeOne = Integer.parseInt(editTextStudentGradeOne.text.toString())
                val gradeTwo = Integer.parseInt(editTextStudentGradeTwo.text.toString())
                val avg = (gradeOne + gradeTwo) / 2
                val abs = Integer.parseInt(editTextAttendStudent.text.toString())

                if (avg >= MIN_AVG && abs <= MAX_ABS) {
                    result.setTextColor(Color.GREEN)
                    result.text = """
                    Parabéns!! 
                    Você foi aprovado.
                    Nota Final: $avg 
                    Número de faltas: $abs
                """.trimIndent()
                    Log.i("click", "Deu certo!")
                } else {
                    Log.e("click", "Deu Ruim!")
                    result.setTextColor(Color.RED)
                    result.text = """
                    Sinto muito...
                    Você foi reprovado.
                    Nota Final: $avg
                    Número de faltas: $abs  
                """.trimIndent()
                }
            } catch (e: NumberFormatException) {
                Log.i("Error!", "Valores informados estão vazios")
            }
        }
    }
}