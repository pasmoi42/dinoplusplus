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
	//Creation d'un maillon avec sa donnee
	nouveauMaillon = new Maillon(donnee);
	//Le maillon suivant du nouveau maillon pointe sur  nullptr
	nouveauMaillon->suivant = nullptr;
	//parcours de la chaine pour trouver le dernier maillon de la chaine
	while (laChaineDeMaillons->suivant != nullptr)
	{
		laChaineDeMaillons = laChaineDeMaillons->suivant;
	}
	//Le dernier maillon de la chaine actuelle pointe sur le maillon cree precedement
	laChaineDeMaillons->suivant = nouveauMaillon;

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
