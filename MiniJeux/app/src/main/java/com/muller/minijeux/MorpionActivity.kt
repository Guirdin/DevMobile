package com.muller.minijeux

import android.annotation.SuppressLint
import android.util.Log
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.morpion.*

class MorpionActivity: AppCompatActivity()
{
    private var case1 : Int = 2
    private var case2 : Int = 2
    private var case3 : Int = 2
    private var case4 : Int = 2
    private var case5 : Int = 2
    private var case6 : Int = 2
    private var case7 : Int = 2
    private var case8 : Int = 2
    private var case9 : Int = 2

    private var joueur = 0
    private var nbTour = 0
    private val imgJoueur = arrayOf(R.drawable.o, R.drawable.x)
    private var nomJoueur1 = "J1"
    private var nomJoueur2 = "J2"
    private lateinit var nomJoueur: String

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.morpion)

//        bundle val: Bundle? = intent.extras
//        var player = bundle.get ( "id_value" )

        tourDeJeu()

        button.setOnClickListener{
            it.setBackgroundResource(imgJoueur[joueur])
            case1 = if (joueur == 0) {
                0
            } else {
                1
            }

            tourDeJeu()
        }

        button2.setOnClickListener{
            it.setBackgroundResource(imgJoueur[joueur])
            case2 = if (joueur == 0) {
                0
            } else {
                1
            }
            tourDeJeu()
        }

        button3.setOnClickListener{
            it.setBackgroundResource(imgJoueur[joueur])
            case3 = if (joueur == 0) {
                0
            } else {
                1
            }
            tourDeJeu()
        }

        button4.setOnClickListener{
            it.setBackgroundResource(imgJoueur[joueur])
            case4 = if (joueur == 0) {
                0
            } else {
                1
            }
            tourDeJeu()
        }

        button5.setOnClickListener{
            it.setBackgroundResource(imgJoueur[joueur])
            case5 = if (joueur == 0) {
                0
            } else {
                1
            }
            tourDeJeu()
        }

        button6.setOnClickListener{
            it.setBackgroundResource(imgJoueur[joueur])
            case6 = if (joueur == 0) {
                0
            } else {
                1
            }
            tourDeJeu()
        }

        button7.setOnClickListener{
            it.setBackgroundResource(imgJoueur[joueur])
            case7 = if (joueur == 0) {
                0
            } else {
                1
            }
            tourDeJeu()
        }

        button8.setOnClickListener{
            it.setBackgroundResource(imgJoueur[joueur])
            case8 = if (joueur == 0) {
                0
            } else {
                1
            }
            tourDeJeu()
        }

        button9.setOnClickListener{
            it.setBackgroundResource(imgJoueur[joueur])
            case9 = if (joueur == 0) {
                0
            } else {
                1
            }
            tourDeJeu()
        }

        boutonRelancer.setOnClickListener {
            recreate()
        }

    }

    private fun tourDeJeu()
    {
        checkWin()
        if (nbTour%2 == 0)
        {
            joueur = 0
            nomJoueur = nomJoueur1
        }
        else
        {
            joueur = 1
            nomJoueur = nomJoueur2
        }
        nbTour++
    }

    @SuppressLint("SetTextI18n")
    fun checkWin()
    {
        if (case1 == 0 && case2 == 0 && case3 == 0 || case1 == 1 && case2 == 1 && case3 == 1 ||
            case1 == 0 && case4 == 0 && case7 == 0 || case1 == 1 && case4 == 1 && case7 == 1 ||
            case1 == 0 && case5 == 0 && case9 == 0 || case1 == 1 && case5 == 1 && case9 == 1 ||
            case2 == 0 && case5 == 0 && case8 == 0 || case2 == 1 && case5 == 1 && case8 == 1 ||
            case3 == 0 && case6 == 0 && case9 == 0 || case3 == 1 && case6 == 1 && case9 == 1 ||
            case3 == 0 && case5 == 0 && case7 == 0 || case3 == 1 && case5 == 1 && case7 == 1)
        {
            auTourDe.text = nomJoueur + " vous avez gagner"
        }
    }


}