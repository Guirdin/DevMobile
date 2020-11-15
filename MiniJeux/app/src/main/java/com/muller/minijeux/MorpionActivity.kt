package com.muller.minijeux

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.morpion.*

class MorpionActivity: AppCompatActivity()
{

    lateinit var case1 : Button
    lateinit var case2 : Button
    lateinit var case3 : Button
    lateinit var case4 : Button
    lateinit var case5 : Button
    lateinit var case6 : Button
    lateinit var case7 : Button
    lateinit var case8 : Button
    lateinit var case9 : Button

    var Joueur = 0
    var nb_tour = 0;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.morpion)

        //initialisation de tous les boutons
        case1 = findViewById(R.id.button)
        case2 = findViewById(R.id.button2)
        case3 = findViewById(R.id.button3)
        case4 = findViewById(R.id.button4)
        case5 = findViewById(R.id.button5)
        case6 = findViewById(R.id.button6)
        case7 = findViewById(R.id.button7)
        case8 = findViewById(R.id.button8)
        case9 = findViewById(R.id.button9)


        case1.setOnClickListener{
            case1.setBackgroundResource(R.drawable.o)
            case1.setBackgroundResource(R.drawable.x)
            Tour_De_Jeu()
        }
        case2.setOnClickListener{
            case1.setBackgroundResource(R.drawable.o)
            case1.setBackgroundResource(R.drawable.x)
            Tour_De_Jeu()
        }

        case3.setOnClickListener{
            case1.setBackgroundResource(R.drawable.o)
            case1.setBackgroundResource(R.drawable.x)
            Tour_De_Jeu()
        }

        case4.setOnClickListener{
            case1.setBackgroundResource(R.drawable.o)
            case1.setBackgroundResource(R.drawable.x)
            Tour_De_Jeu()
        }

        case5.setOnClickListener{
            case1.setBackgroundResource(R.drawable.o)
            case1.setBackgroundResource(R.drawable.x)
            Tour_De_Jeu()
        }

        case6.setOnClickListener{
            case1.setBackgroundResource(R.drawable.o)
            case1.setBackgroundResource(R.drawable.x)
            Tour_De_Jeu()
        }

        case7.setOnClickListener{
            case1.setBackgroundResource(R.drawable.o)
            case1.setBackgroundResource(R.drawable.x)
            Tour_De_Jeu()
        }

        case8.setOnClickListener{
            case1.setBackgroundResource(R.drawable.o)
            case1.setBackgroundResource(R.drawable.x)
            Tour_De_Jeu()
        }

        case9.setOnClickListener{
            case1.setBackgroundResource(R.drawable.o)
            case1.setBackgroundResource(R.drawable.x)
            Tour_De_Jeu()
        }

        boutonRelancer.setOnClickListener {
            recreate()
        }

    }

    fun Tour_De_Jeu()
    {
        nb_tour++;
        Joueur = if (nb_tour%2 == 0){
            2;
        } else {
            1;
        }
    }



}