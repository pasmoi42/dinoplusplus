/*
 * ListeChainee.cpp
 *
 *  Created on: 24 sept. 2017
 *      Author: pm
 */

#include "ListeChainee.h"
#include <iostream>

using namespace std;

ListeChainee::ListeChainee()
{
  laChaineDeMaillons = nullptr;
}

ListeChainee::~ListeChainee()
{
  // TODO Auto-generated destructor stub
}

void ListeChainee::AfficheDebug()
{
  cout << "Debut de la liste: " << endl;
  Maillon *parcours;


  parcours = this->laChaineDeMaillons;
  while ( parcours != nullptr )
  {
    cout << "Un maillon: " << parcours->donnee << endl;
    parcours = parcours->suivant;
  }

  cout << "Fin de la liste!" << endl;
}

void ListeChainee::ajouteEnFin(double donnee)
{
	Maillon *nouveauMaillon;
	//Creation d'un maillon avec sa donnee et son suivant pointe sur  nullptr
	nouveauMaillon = new Maillon(donnee);
	//déclaration du pointeur qui va parcourir la liste chainée
	Maillon *parcour = laChaineDeMaillons ;
	//parcours de la chaine pour trouver le dernier maillon de la chaine
	while (parcour->suivant != nullptr)
	{
		//passage au maillon suivant
		parcour = parcour->suivant;
	}
	//Le dernier maillon de la chaine actuelle pointe sur le maillon cree precedement
	parcour->suivant = nouveauMaillon;


}

/*
  bla bla
 */
void ListeChainee::ajouteAuDebut(double donnee)
{
  Maillon *nouveauMaillon;

  nouveauMaillon = new Maillon(donnee);

  nouveauMaillon->suivant = this->laChaineDeMaillons;
  this->laChaineDeMaillons = nouveauMaillon;
}

int ListeChainee::echangesMaillons(Maillon *m1, Maillon *m2)
{
	//déclaration du pointeur temporaire 1 qui parcour la chaine pour trouver le maillon precendent m1

	//déclaration du pointeur temporaire 2 qui parcour la chaine pour trouver le precedent maillon m2

	//déclaration du pointeur temporaire 3 qui se positionne sur le suivant de m1

	//parcour de la chaine pour trouver le precedent du premier maillon (m1)

	//parcour de la chaine pour trouver le precedent du deuxieme maillon (m2)

	//on fait pointer  m1 sur le suivant de m2

	//on fait pointer m2 sur tmp 3

	//réaffectation de tmp 3 sur le suivant de tmp1

	//on fait pointer  tmp1 sur m2

	//on fait pointer tmp 2 sur tmp3
}
