package com.example.randomfilmk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class GameActivity : AppCompatActivity() {
    var lowBound: Int = Int.MIN_VALUE
    var highBound: Int = Int.MAX_VALUE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val age = intent.getIntExtra("age", -1) // если нет значения, будет default
        val name = intent.getStringExtra("name") // будет null, если не передали параметр
        Log.d("mytag", "age $age")
        Log.d("mytag", "name $name")
    }

    fun onYesNoClick(view: View) {
        when (view.id) {
            R.id.yes -> println() // сдвигаем нижнюю границу диапазона
            R.id.no -> println()  // сдвигаем верхнюю границу диапазона
        }

    }
}