package com.example.randomfilmk


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var movies : Array<String>;
    val r = Random()

    override fun onStart() {
        super.onStart()
        Log.d("mytag", "onStart()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mytag", "onStop()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movies = resources.getStringArray(R.array.movies)
        Log.d("mytag", movies[0])
    }

    fun onNextClick(view: View) {
        val tvTitle = findViewById<TextView>(R.id.title)
        tvTitle.text= movies[r.nextInt(movies.size)]
        // TODO: сделать так, чтобы фильмы не повторялись

    }

    fun onNextActivity(view: View) {
        val intent = Intent(this, GameActivity::class.java);

        intent.putExtra("name", "Petya")
        intent.putExtra("age", 19)
        startActivity(intent)
    }

    // TODO: определить функцию onClearClick
}