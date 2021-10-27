package com.example.randomfilmk


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var movies : Array<String>;
    val r = Random()
    val m = Movie("Inception", 2010, 9.0f)


    override fun onStart() {
        super.onStart()
        Log.d("mytag", "onStart()" )
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
        // открываем файл
        val movies_stream = resources.openRawResource(R.raw.movies)
        val gson = Gson() // конвертор из JSON обратно
        val movies_data = gson.fromJson(InputStreamReader(movies_stream), Movies::class.java)
        Log.d("mytag", "Loaded movies ${movies_data.movies.size}")

        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("name", "Vasya")
        editor.apply()
        Log.d("mytag", "name:" + pref.getString("name", ""))


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