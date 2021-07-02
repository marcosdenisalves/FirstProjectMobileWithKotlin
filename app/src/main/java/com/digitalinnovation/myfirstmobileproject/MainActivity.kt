package com.digitalinnovation.myfirstmobileproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val MIN_AVG = 6
const val MAX_ABS = 10

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton = calculateBtn
        val result = textViewResult

        calculateBtn.setOnClickListener {
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
            } else {
                result.setTextColor(Color.RED)
                result.text = """
                    Sinto muito...
                    Você foi reprovado.
                    Nota Final: $avg
                    Número de faltas: $abs
                """.trimIndent()
            }
        }
    }
}