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
  //TODO: parcourir la liste pour afficher chaque element

  cout << "Fin de la liste!" << endl;
}

void ListeChainee::ajouteEnFin(double donnee)
{

}

void ListeChainee::ajouteAuDebut(double donnee)
{
  Maillon *nouveauMaillon;

  nouveauMaillon = new Maillon(donnee);

  nouveauMaillon->suivant = this->laChaineDeMaillons;
  this->laChaineDeMaillons = nouveauMaillon;


}
