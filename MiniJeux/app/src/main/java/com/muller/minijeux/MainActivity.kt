package com.muller.minijeux

import android.util.Log  // Log.v("exemple", "coucou")
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.home.*

class MainActivity : AppCompatActivity()
{
    lateinit var EditNamePlayer1:EditText
    lateinit var EditNamePlayer2:EditText
    lateinit var ButtonStart: Button

    fun VerifNomJoueur() // Permet la désactivation du bouton start, si les noms des joueurs ne sont pas saisie
    {
        if (!(EditNamePlayer1.text.isEmpty()) && !(EditNamePlayer2.text.isEmpty()))
        {
            buttonStart.isEnabled = true
        }
    }

    fun EditText.onChange () //Permet de vérifier si nos EditText sont remplis et s'ils le sont bien
    {
        this.addTextChangedListener(object: TextWatcher
        {
            override fun afterTextChanged(s: Editable?) { VerifNomJoueur()  }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)


        // Liaison des variables aux éléments xml
        EditNamePlayer1 = findViewById(R.id.editNamePlayer1)
        EditNamePlayer2 = findViewById(R.id.editNamePlayer2)
        ButtonStart  = findViewById(R.id.buttonStart)

        // Verification des EditText
        EditNamePlayer1.onChange()
        EditNamePlayer2.onChange()

        // Passe à l'activité suivante avec les noms des joueurs
        ButtonStart.setOnClickListener {
           val monIntent :Intent = Intent(this,MorpionActivity::class.java).apply {
               putExtra("Joueur1",EditNamePlayer1.text.toString())
               putExtra("Joueur2",EditNamePlayer2.text.toString())
            }
            startActivity(monIntent)
        }
    }
}