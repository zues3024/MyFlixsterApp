package com.codepath.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codepath.myapplication.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.content, NowPlayingMoviesFragment(), null).commit()
    }
}