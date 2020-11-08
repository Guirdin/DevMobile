package com.muller.minijeux

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Joueur  (var nom:String, var symbole: Drawable)
{
    lateinit var Cases : Array<Button>
    lateinit var case1 : Button
    lateinit var case2 : Button
    lateinit var case3 : Button
    lateinit var case4 : Button
    lateinit var case5 : Button
    lateinit var case6 : Button
    lateinit var case7 : Button
    lateinit var case8 : Button
    lateinit var case9 : Button
    lateinit var AvertisseurJoueurEnCours : TextView
    lateinit var User:ArrayList<Joueur>
    lateinit var buttonRelancer: Button
    var NumeroDuJoueurEnCour = 0

    lateinit var tableau: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
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

        buttonRelancer = findViewById(R.id.buttonRelancer)
        AvertisseurJoueurEnCours = findViewById(R.id.auTourDe)
        var plateau = arrayListOf(case1, case2, case3, case4, case5, case6, case7, case8, case9)

        initPartie(plateau)

        buttonRelancer.setOnClickListener {
            buttonRelancer.isEnabled = false
            initPartie(plateau)
        }
    }
}