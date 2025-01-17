package com.muller.minijeux

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.morpion.*

class MorpionActivity: AppCompatActivity() {
    private var case1: Int = 2
    private var case2: Int = 2
    private var case3: Int = 2
    private var case4: Int = 2
    private var case5: Int = 2
    private var case6: Int = 2
    private var case7: Int = 2
    private var case8: Int = 2
    private var case9: Int = 2

    private var joueur = 0
    private var nbTour = 0
    private val imgJoueur = arrayOf(R.drawable.o, R.drawable.x)
    private lateinit var nomJoueur: String
    private var joueur1: String? = ""
    private var joueur2: String? = ""
    private var victoire : Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.morpion)



        val intent = intent
        if (intent != null) {
            if (intent.hasExtra("EditNamePlayer1") && intent.hasExtra("EditNamePlayer2")) {
                joueur1 = intent.getStringExtra("EditNamePlayer1")
                joueur2 = intent.getStringExtra("EditNamePlayer2")
            }
        }
        tourDeJeu()

        button1.setOnClickListener {
            it.setBackgroundResource(imgJoueur[joueur])
            case1 = if (joueur == 0) {
                0
            } else {
                1
            }
            it.isEnabled = false
            tourDeJeu()
        }

        button2.setOnClickListener {
            it.setBackgroundResource(imgJoueur[joueur])
            case2 = if (joueur == 0) {
                0
            } else {
                1
            }
            it.isEnabled = false
            tourDeJeu()
        }

        button3.setOnClickListener {
            it.setBackgroundResource(imgJoueur[joueur])
            case3 = if (joueur == 0) {
                0
            } else {
                1
            }
            it.isEnabled = false
            tourDeJeu()
        }

        button4.setOnClickListener {
            it.setBackgroundResource(imgJoueur[joueur])
            case4 = if (joueur == 0) {
                0
            } else {
                1
            }
            it.isEnabled = false
            tourDeJeu()
        }

        button5.setOnClickListener {
            it.setBackgroundResource(imgJoueur[joueur])
            case5 = if (joueur == 0) {
                0
            } else {
                1
            }
            it.isEnabled = false
            tourDeJeu()
        }

        button6.setOnClickListener {
            it.setBackgroundResource(imgJoueur[joueur])
            case6 = if (joueur == 0) {
                0
            } else {
                1
            }
            it.isEnabled = false
            tourDeJeu()
        }

        button7.setOnClickListener {
            it.setBackgroundResource(imgJoueur[joueur])
            case7 = if (joueur == 0) {
                0
            } else {
                1
            }
            it.isEnabled = false
            tourDeJeu()
        }

        button8.setOnClickListener {
            it.setBackgroundResource(imgJoueur[joueur])
            case8 = if (joueur == 0) {
                0
            } else {
                1
            }
            it.isEnabled = false
            tourDeJeu()
        }

        button9.setOnClickListener {
            it.setBackgroundResource(imgJoueur[joueur])
            case9 = if (joueur == 0) {
                0
            } else {
                1
            }
            it.isEnabled = false
            tourDeJeu()
        }

        boutonRelancer.setOnClickListener {
            recreate()
        }
        boutonRetour.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@MorpionActivity, MainActivity::class.java))
            }
        })
    }
    
    @SuppressLint("SetTextI18n")
    private fun tourDeJeu() {
        finDeJeu()
        if (victoire == null)
        {
            if (nbTour % 2 == 0) {
                joueur = 0
                nomJoueur = joueur1.toString()
            } else {
                joueur = 1
                nomJoueur = joueur2.toString()

            }
            auTourDe.text = "It's your turn to play $nomJoueur"
            nbTour++
        }
    }

    private fun Button.toggleVisibility() {
        visibility = if (visibility == Button.VISIBLE) {
            Button.INVISIBLE
        } else {
            Button.VISIBLE
        }
    }

    @SuppressLint("SetTextI18n")
    fun finDeJeu() {
        if (case1 == 0 && case2 == 0 && case3 == 0 || case1 == 1 && case2 == 1 && case3 == 1 ||
            case1 == 0 && case4 == 0 && case7 == 0 || case1 == 1 && case4 == 1 && case7 == 1 ||
            case1 == 0 && case5 == 0 && case9 == 0 || case1 == 1 && case5 == 1 && case9 == 1 ||
            case2 == 0 && case5 == 0 && case8 == 0 || case2 == 1 && case5 == 1 && case8 == 1 ||
            case3 == 0 && case6 == 0 && case9 == 0 || case3 == 1 && case6 == 1 && case9 == 1 ||
            case3 == 0 && case5 == 0 && case7 == 0 || case3 == 1 && case5 == 1 && case7 == 1 ||
            case4 == 0 && case5 == 0 && case6 == 0 || case4 == 1 && case5 == 1 && case6 == 1 ||
            case7 == 0 && case8 == 0 && case9 == 0 || case7 == 1 && case8 == 1 && case9 == 1)
        {
            victoire = true
            boutonRelancer.toggleVisibility()
            boutonRetour.toggleVisibility()

            val boutons : Array<Button> = arrayOf(button1,button2,button3,button4,button5,button6,button7,button8,button9)
            for (i in 0..8)
            {
                boutons[i].isEnabled = false
            }

            auTourDe.text = "$nomJoueur won !"
        }
        else if (case1 != 2 && case2 != 2 && case3 != 2 && case4 != 2 &&
            case5 != 2 && case6 != 2 && case7 != 2 && case8 != 2 && case9 != 2)
        {
            victoire = false
            boutonRelancer.toggleVisibility()
            boutonRetour.toggleVisibility()

            auTourDe.text = "Equality !"
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_morpion,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item?.itemId)
        {
            R.id.configuration -> { changerIcone() }
            else -> { Toast.makeText(this,"action inconnue",Toast.LENGTH_LONG).show() }
        }
        return true
    }
    private fun changerIcone() {
        val nameArray = resources.getStringArray(R.array.icon)
        val imgArray = intArrayOf(R.drawable.o, R.drawable.x, R.drawable.t, R.drawable.l)
        val listItem = arrayListOf<Items>(
            Items(imgArray[0], nameArray[0]),
            Items(imgArray[1], nameArray[1]),
            Items(imgArray[2], nameArray[2]),
            Items(imgArray[3], nameArray[3])
        )
        startActivity(Intent(this@MorpionActivity,ListAdapter(listItem)::class.java))
    }

}