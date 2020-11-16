# Présentation du projet d'Android
 * C'est une application qui permet de jouer à un **morpion**, qui est un jeu tour par tour où son but est d'aligner, avant son adversaire, un même symbole horizontalement, verticalement ou diagonalement. Un joueur possède un seul symbole et ne peux le changer avant la fin de la partie.
* Ce projet a été réalisé par : 
> [MULLER Jimmy](https://github.com/Guirdin), 
> [LIEUTAUD Céline](https://github.com/OphisDgn)

# Technologies utilisées : 
 * Android Studio
 * Kotlin
 * Téléphone Android

# A installer 
 * [Android Studio](https://developer.android.com/studio?gclid=Cj0KCQiA48j9BRC-ARIsAMQu3WRVR1DYBBHrzhjJIL6kr66iqHjgrLRwN_Evc2sOGhDUS_aCEuaMoDwaAkyAEALw_wcB&gclsrc=aw.ds)
 * Git

# Télécharger le projet
* [Github](https://github.com/Guirdin/DevMobile)


# Structure du projet 
```
/DevMobile
	|- .idea/
	|- app/
		|- src/
	|- gradle/wrapper
	|- build.gradle
	|- gradle.properties
	|- gradlew
	|- gradlew.bat
	|- settings.gradle
```

## Configuration

* Target SDK
	> Version 30
* Min SDK
	> Version 16
* Production réalisé : 
	> Emulateur Android Nexus 5, API 30
	> Téléphone physique Samsung S9+

## Lancement du projet

* Ouvrir le dossier /MiniJeux dans Android Studio


# Application
### Saisie des noms
![Page de saisie sans rentrant de nom](https://github.com/Guirdin/DevMobile/blob/main/imgReadme/Screenshot_1.png)

![Page de saisie en rentrant des noms](https://github.com/Guirdin/DevMobile/blob/main/imgReadme/Screenshot_2.png)

* La page ci-dessus sert à renseigner les noms que les deux joueurs souhaitent utiliser lors de leur partie. S'ils n'ont rentrés aucun noms, ils ne peuvent pas cliquer sur le bouton *START* puisqu'il n'enlève son grisage que lorsque les deux EditText sont remplis.

### Jeu du morpion

![Page du jeu](https://github.com/Guirdin/DevMobile/blob/main/imgReadme/Screenshot_3.png)
* Après avoir rentré les noms et cliqué sur *START*, la grille du jeu est affiché et un message indique quel est le joueur qui commence. Une fois que l'un des joueurs clique sur une case, cette dernière devient inutilisable, ainsi l'autres joueur ne pourra pas cliquer dessus pour changer le dessin.
* Deux cas peuvent se présenter aux joueur pendant le jeu. 

#### En cas de victoire
![En cas de victoire](https://github.com/Guirdin/DevMobile/blob/main/imgReadme/Screenshot_4.png)
* Soit un cas de victoire d'un des joueurs, auquel cas un message s'affiche pour dire quel joueur a gagné, les boutons ne sont plus utilisables. Deux boutons s'affichent en bas de l'écran, à gauche le bouton *BACK TO MENU* qui renvoie à la page de saisie des noms et à droite le bouton *RESTART THE GAME* pour refaire une partie avec les mêmes noms.

#### En cas d'égalité
![En cas d'égalité](https://github.com/Guirdin/DevMobile/blob/main/imgReadme/Screenshot_5.png)
* Soit un cas d'égalité, c'est à dire que les joueurs n'ont pas réussi à réaliser une ligne entière horizontalement, verticalement ou diagonalement. Ils sont donc à égalité car aucun n'a pu battre l'autre. Un message l'indiquant s'affiche et les mêmes boutons que lors de la victoire s'affichent.


### Changer son icône
![Changer son icône](https://github.com/Guirdin/DevMobile/blob/main/imgReadme/Screenshot_6.png)
* Une fonctionnalité qui rencontre quelques erreurs est quand même présente, c'est celle de changer son icône. En effet, lors du démarrage du jeu, le joueur 1 a l'idée du rond et le deuxième a la croix. Cependant nous souhaitons pouvoir laisser la possibilité de changer son icône parmi les suivantes : 
	 > Rond,
	 > Croix,
	 > Triangle,
	 > Losange