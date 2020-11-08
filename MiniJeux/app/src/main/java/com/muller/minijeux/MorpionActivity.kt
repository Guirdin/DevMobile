package com.muller.minijeux

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates
import kotlin.random.Random

class MorpionActivity: AppCompatActivity()
{
    lateinit var buttonRelancer: Button
    var NumeroDuJoueurEnCour: Int = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.morpion)
    }

    fun initPartie(plateau:ArrayList<Button>)
    {
        buttonRelancer.isEnabled = false
        User = initOrdreJoueur (intent.getStringExtra("Joueur1"),intent.getStringExtra("Joueur2"))
        AlertJoueurEnCours.text = "c'est au tour de "+User[NumeroDuJoueurEnCour].nom
        var tableau = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)

        loop@ plateau.forEach{
            it.setBackgroundDrawable(null)
            it.isClickable = true
        }
        tourDeJeu(plateau)
    }

    fun initialisationOrdreJoueur(pseudo1:String,pseudo2:String): ArrayList<Joueur> {
        //val rand = Random()
        val nbAleatoire = Random.nextInt(0,2)

        if (nbAleatoire === 1)
        {
            val joueur1 = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Joueur(pseudo2,getDrawable(R.drawable.o))
            } else {
                TODO("VERSION.SDK_INT < LOLLIPOP")
            }
            val joueur2 = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Joueur(pseudo1,getDrawable(R.drawable.x))
            } else {
                TODO("VERSION.SDK_INT < LOLLIPOP")
            }
            val Joueurs = arrayListOf<Joueur>(joueur1,joueur2)
            return Joueurs
        }else
        {
            val joueur1 = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Joueur(pseudo2,getDrawable(R.drawable.o))
            } else {
                TODO("VERSION.SDK_INT < LOLLIPOP")
            }
            val joueur2 = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Joueur(pseudo1,getDrawable(R.drawable.x))
            } else {
                TODO("VERSION.SDK_INT < LOLLIPOP")
            }
            val Joueurs = arrayListOf<Joueur>(joueur1,joueur2)
            return Joueurs
        }

    }

    fun tourDeJeu(plateau:ArrayList<Button>)
    {
        var  nbCaseRemplis : Int = 0
        loop@ plateau.forEach{
            it.setOnClickListener {

                it.setBackgroundDrawable(User[NumeroDuJoueurEnCour].symbole)
                it.isClickable = false
                remplirPlateau(it as Button)
                nbCaseRemplis++
                if (!verification3MemeSymbole()){
                    if (NumeroDuJoueurEnCour === 0)
                    {
                        NumeroDuJoueurEnCour=1
                    } else {
                        NumeroDuJoueurEnCour=0
                    }
                    AlertJoueurEnCours.text = "c'est au tour de "+User[NumeroDuJoueurEnCour].nom
                } else {
                    AlertJoueurEnCours.text = User[NumeroDuJoueurEnCour].nom+" a gagné"
                    buttonRelancer.isEnabled = true
                    return@setOnClickListener
                }
                if ((nbCaseRemplis === 9)){
                    AlertJoueurEnCours.text = " égalité !"
                    buttonRelancer.isEnabled = true
                    return@setOnClickListener
                }
            }
        }
    }

    fun remplirPlateau(idButton:Button){
        when (idButton.id)
        {
            R.id.button ->  {tableau[0] = NumeroDuJoueurEnCour}
            R.id.button2 -> {tableau[1] = NumeroDuJoueurEnCour}
            R.id.button3 -> {tableau[2] = NumeroDuJoueurEnCour}
            R.id.button4 -> {tableau[3] = NumeroDuJoueurEnCour}
            R.id.button5 -> {tableau[4] = NumeroDuJoueurEnCour}
            R.id.button6 -> {tableau[5] = NumeroDuJoueurEnCour}
            R.id.button7 -> {tableau[6] = NumeroDuJoueurEnCour}
            R.id.button8 -> {tableau[7] = NumeroDuJoueurEnCour}
            R.id.button9 -> {tableau[8] = NumeroDuJoueurEnCour}
        }
    }

    fun verif3MemeSymbole () :Boolean
    {
        if(verif3MemeSymboleDiagonal()){ return true }
        if (verif3MemeSymboleVertical()){ return true }
        if (verif3MemeSymboleHorizontale()){ return true }
        return false
    }

    fun verif3MemeSymboleHorizontale () :Boolean
    {
        if (tableau[0] === NumeroDuJoueurEnCour && tableau[3] === NumeroDuJoueurEnCour && tableau[6] === NumeroDuJoueurEnCour )
        { return true }
        if (tableau[1] === NumeroDuJoueurEnCour && tableau[4] === NumeroDuJoueurEnCour && tableau[7] === NumeroDuJoueurEnCour )
        { return true }
        if (tableau[2] === NumeroDuJoueurEnCour && tableau[5] === NumeroDuJoueurEnCour && tableau[8] === NumeroDuJoueurEnCour )
        { return true }
        return false
    }

    fun verif3MemeSymboleVertical () :Boolean
    {
        if (tableau[0] === NumeroDuJoueurEnCour && tableau[1] === NumeroDuJoueurEnCour && tableau[2] === NumeroDuJoueurEnCour )
        { return true }
        if (tableau[3] === NumeroDuJoueurEnCour && tableau[4] === NumeroDuJoueurEnCour && tableau[5] === NumeroDuJoueurEnCour )
        { return true }
        if (tableau[6] === NumeroDuJoueurEnCour && tableau[7] === NumeroDuJoueurEnCour && tableau[8] === NumeroDuJoueurEnCour )
        { return true }
        return false
    }

    fun verif3MemeSymboleDiagonal () :Boolean
    {
        if (tableau[0] === NumeroDuJoueurEnCour && tableau[4] === NumeroDuJoueurEnCour && tableau[8] === NumeroDuJoueurEnCour )
        { return true }
        if (tableau[2] === NumeroDuJoueurEnCour && tableau[4] === NumeroDuJoueurEnCour && tableau[6] === NumeroDuJoueurEnCour )
        { return true }
        return false
    }
}