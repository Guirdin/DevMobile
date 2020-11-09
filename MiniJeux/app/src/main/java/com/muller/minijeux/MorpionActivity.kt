package com.muller.minijeux

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.morpion.*

class MorpionActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.morpion)

        boutonRelancer.setOnClickListener {
            recreate()
        }

    }



}