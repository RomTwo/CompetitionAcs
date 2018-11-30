==============================================================================================================================================================================
                         = Projet - ACS - suivi de compétition RMI =
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Auteur...: Romain POITEVIN, Maxime COUSSEAU
Date...................: 01/12/2018

==================================== ARBORESCENCE ============================================================================================================================
L’archive comprend un répertoire src/ contenant tous le code de l’application (découper en 4 packages), le ReadMe, le Makfile et le fichier configDoc
(fichier de configuration permettant de générer la documentation Doxygen; A ne pas supprimer).
Packages :
	-> Classe
	-> Contrat
	-> Ihm 
		-> Admin
		-> Client
	-> Lanceur


=================================== LANCEMENT ================================================================================================================================

Un makefile est à disposition afin de faciliter la compilation et le lancement de l’application.
Le makefile permet de compiler le projet, lancer 3 clients différents,lancer des administrateurs différents (autant que l’on veut), 
lancer le serveur et d’effacer tous les fichiers .class une fois que l’application est hors tension.

1/ Rendez-vous dans le répertoire src/

2/ Ouvrez un terminal et tapez la commande : rmiregistry

3/ Ouvrez un terminal et tapez la commande make pour compiler l’application

4/ Dans le même terminal, entrez la commande make server afin de démarrer le serveur

5.1/ Ouvrez un terminal, entrez la commande make client1 pour lancer un client

5.2/ Ouvrez un terminal, entrez la commande make client2 pour lancer un deuxième client (dans le cas où l’on veut plusieurs client)

5.3/ Ouvrez un terminal, entrez la commande make client3 pour lancer un troisième client (dans le cas où l’on veut plusieurs client)

6/ Ouvrez un terminal, entrez la commande make admin pour lancer un admin (tapez de nouveau cette commande si vous voulez en lancer d’autres)

7/ Dans un des terminal, entrez la commande make clean pour effacer les fichiers .class

8/ Dans un terminal, entrez la commande make doc pour générer la documentation Doxygen de l'application.
   Une fois générer rendez-vous dans le dossier documentation (à la racine du répertoire src/) et lancez
   le fichier index.html.

=================================== UTILISATION ================================================================================================================================

* Client : 
Une fois dans l’interface client, vous pouvez choisir de suivre une des compétitions présente sur la page d’accueil ou de quitter l’application.
Si vous cliquez sur le bouton suivre (pour suivre une compétition), vous allez être redirigé vers une autre fenêtre comportant :
	- à gauche : un bouton pour revenir à la page d’accueil
	- au centre : les différents évènements décrivant la compétition
	- à droite : la possibilité de voter en choisissant un joueur dans la liste déroulante et en cliquant sur le bouton envoyer pour valider votre vote.
		     la possibilité de parier sur la victoire de l’équipe 1 (1), un match nul (N), la victoire de l’équipe 2 (2) en choisissant le symbole
		     correspondant à votre souhait dans la liste déroulante. Il faudra par la suite valider ce pari en cliquant sur le bouton envoyer.


* Administrateur :
Vous avez la possibilité de commenter toutes les compétitions disponibles dans la liste déroulante (un seul admin par compétition), il suffit de choisir la compétition et
de cliquer sur le bouton Start; vous pouvez également quitter l’application en cliquant sur La Croix rouge de la fenêtre.
Après avoir cliqué sur Start, plusieurs composants apparaissent : vous pouvez écrire et envoyer votre évènement, annoncer un but pour une des deux équipe en cliquant sur 
Le bouton « but pour ... » adéquat, signaler la fin du match en cliquant sur le bouton terminer.


=================================================================================================================================================================================
					2018 - 2019

