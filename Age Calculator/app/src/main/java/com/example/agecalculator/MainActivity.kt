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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.button1)
        sDate = findViewById(R.id.sDate)
        btn.setOnClickListener {
            clickbtn()
        }

        }

    fun clickbtn(){

            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, selectedyear, selectedmonth, selecteddayOfMonth ->
            Toast.makeText(this,"year was $selectedyear, month was ${selectedmonth+1}, " +
                    "day of month was $selecteddayOfMonth ", Toast.LENGTH_LONG).show()
            val selectedDate="$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
            sDate?.text = selectedDate
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)
        },
        year,
        month,
        day
        ).show()

    }

}