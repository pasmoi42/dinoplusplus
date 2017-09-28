/*
 * ListeDoublementChainee.cpp
 *
 *  Created on: 27 sept. 2017
 *      Author: doria
 */

#include "ListeDoublementChainee.h"
#include <iostream>

using namespace std;
template <typename T>
ListeDoublementChainee<T>::ListeDoublementChainee()
{
  laChaineDoubleDeMaillons = nullptr;
}
template <typename T>
ListeDoublementChainee<T>::~ListeDoublementChainee()
{
  // TODO Auto-generated destructor stub
}
template <typename T>
void ListeDoublementChainee<T>::AfficheDebug()
{
  cout << "Debut de la liste: " << endl;
  //Maillon *parcours;
  shared_ptr<Maillon<T>> parcours;


  parcours = this->laChaineDoubleDeMaillons;
  while ( parcours != nullptr )
  {
    cout << "Un maillon: " << parcours->donnee << endl;
    parcours = parcours->suivant;
  }

  cout << "Fin de la liste!" << endl;
}
template <typename T>
void ListeDoublementChainee<T>::ajouteEnFin(const T & donnee)
{
	shared_ptr<Maillon<T>> nouveauMaillon;

	//Creation d'un maillon avec sa donnee et son suivant pointe sur  nullptr
	nouveauMaillon = new Maillon<T>(donnee);
	//déclaration du pointeur qui va parcourir la liste chainée
	//Maillon *parcour = laChaineDeMaillons ;
	shared_ptr<Maillon<T>> parcour = laChaineDoubleDeMaillons ;
	//parcours de la chaine pour trouver le dernier maillon de la chaine
	while (parcour->suivant != nullptr)
	{
		//passage au maillon suivant
		parcour = parcour->suivant;
	}
	//Le dernier maillon de la chaine actuelle pointe sur le maillon cree precedement
	parcour->suivant = nouveauMaillon;
	//on fait pointer le precedent du nouveau maillon sur l'ancien dernier element de la liste
	nouveauMaillon->precedent = parcour;


}

/*
  bla bla
 */
template <typename T>
void ListeDoublementChainee<T>::ajouteAuDebut(const T & donnee)
{
  //Maillon *nouveauMaillon;
	shared_ptr<Maillon<T>> nouveauMaillon ;
    nouveauMaillon = new Maillon<T>(donnee);

  nouveauMaillon->suivant = this->laChaineDoubleDeMaillons;
  //on fixer le precedent de l'ancien premier maillon sur le nouveau
  this->laChaineDoubleDeMaillons->precedent = nouveauMaillon;
  this->laChaineDoubleDeMaillons = nouveauMaillon;

}
template <typename T>
int ListeDoublementChainee<T>::echangesMaillons(shared_ptr<Maillon<T>> m1, shared_ptr<Maillon<T>> m2)
{
	//déclaration du pointeur temporaire 1 qui parcour la chaine pour trouver le maillon precendent m1
	shared_ptr<Maillon<T>> tmp1;
	//déclaration du pointeur temporaire 2 qui parcour la chaine pour trouver le precedent maillon m2
	shared_ptr<Maillon<T>> tmp2;
	//déclaration du pointeur temporaire 3 qui se positionne sur le suivant de m1
	shared_ptr<Maillon<T>> tmp3;
	if (m1->suivant != nullptr && m1 != nullptr)
		 tmp3 = m1->suivant;
	else return 1;
	//déclaration du pointeur temporaire 4 qui se positionne sur le precedent de m2
	shared_ptr<Maillon<T>> tmp4 = m2->precedent;

	//déclaration d'un pointeur de parcour
	shared_ptr<Maillon<T>> parcour = laChaineDoubleDeMaillons;
	//parcour de la chaine pour trouver  maillon (m1)
	//parcour de la chaine pour trouver  maillon (m2)
	while(!(tmp1 == m1) || !(tmp2 == m2))
	{
		if (parcour == m1)
			tmp1 = parcour;
		else if (parcour == m2)
			tmp2 = parcour;
		if (parcour->suivant != nullptr)
			parcour = parcour->suivant;
		else return 1;
	}
	//on fait pointer  m1 sur le suivant de m2
	tmp1->suivant->suivant = tmp2->suivant->suivant;
	//on fait pointer m2 sur tmp 3
	tmp2->suivant->suivant = tmp3;
	//réaffectation de tmp 3 sur le suivant de tmp1
	tmp3 = tmp1->suivant;
	//on fait pointer  tmp1 sur m2
	tmp1->suivant = tmp2->suivant;
	//on fait pointer tmp 2 sur tmp3
	tmp2->suivant = tmp3;
	return 0;
}
