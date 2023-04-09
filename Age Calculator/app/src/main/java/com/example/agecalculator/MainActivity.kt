package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var sDate : TextView? = null
    private var ageInMinutes : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.button1)
        sDate = findViewById(R.id.sDate)
        ageInMinutes= findViewById(R.id.ageInMinutes)
        btn.setOnClickListener {
            clickbtn()
        }

        }

    fun clickbtn(){

            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day = myCalendar.get(Calendar.DAY_OF_MONTH)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month,dayOfMonth ->
                Toast.makeText(this,"year was $year, month was ${month+1}, " +
                        "day of month was $dayOfMonth ", Toast.LENGTH_LONG).show()
                val selectedDate="$dayOfMonth/${month+1}/$year"
                sDate?.text = selectedDate
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate!!.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDate!!.time/60000

                val diffInMinutes = currentDateInMinutes - selectedDateInMinutes

                ageInMinutes?.text = diffInMinutes.toString()
            },
                year,
                month,
                day
            )

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }

}