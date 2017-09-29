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

//#if(0)
template <typename T>
ListeDoublementChainee<T>::~ListeDoublementChainee()
{
  // TODO Auto-generated destructor stub
}
//#endif

template <class T>
void ListeDoublementChainee<T>::AfficheDebug()
{
  cout << "Debut de la liste: " << endl;
  //Maillon<T> *parcours;
  shared_ptr<Maillon<T>> parcours;


  parcours = this->laChaineDoubleDeMaillons;
  while ( parcours != nullptr )
  {
    cout << "Un maillon: " << parcours->donnee << endl;
    parcours = parcours->suivant;
  }

  cout << "Fin de la liste!" << endl;
}


template <class T>
void ListeDoublementChainee<T>::ajouteEnFin(const T & donnee)
{
  shared_ptr<Maillon<T>> nouveauMaillon;
  //Maillon<T> *nouveauMaillon;

  //Creation d'un maillon avec sa donnee et son suivant pointe sur  nullptr
  nouveauMaillon = std::make_shared<Maillon<T>>(donnee);

  //declaration du pointeur qui va parcourir la liste chain�e
  shared_ptr<Maillon<T>> parcour = laChaineDoubleDeMaillons;

  //parcours de la chaine pour trouver le dernier maillon de la chaine
  while (parcour->suivant != nullptr) //on s'arrete sur le dernier
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
template <class T>
void ListeDoublementChainee<T>::ajouteAuDebut(const T & donnee)
{
  //Maillon *nouveauMaillon;
  shared_ptr<Maillon<T>> nouveauMaillon ;
  nouveauMaillon = std::make_shared<Maillon<T>>(donnee);

  nouveauMaillon->suivant = this->laChaineDoubleDeMaillons; //si c'est null ... ca marche!
  //on fixer le precedent de l'ancien premier maillon sur le nouveau
  /*
  correction de bug: lors du premier ajoute (ajout d'un maillon a une liste juste que la vide,
    this->laChaineDoubleDeMaillons est a null,
    donc this->laChaineDoubleDeMaillons->precedent == NULL->precedent
    ce qui crash.
    fix: ajoute d'un if non null.
  */
  if (this->laChaineDoubleDeMaillons != nullptr)
    this->laChaineDoubleDeMaillons->precedent = nouveauMaillon;

  this->laChaineDoubleDeMaillons = nouveauMaillon;

}
template <class T>
int ListeDoublementChainee<T>::echangesMaillons(shared_ptr<Maillon<T>> m1, shared_ptr<Maillon<T>> m2)
{
  //declaration du pointeur temporaire 1 qui parcour la chaine pour trouver le maillon  m1
  shared_ptr<Maillon<T>> tmp1;
  //declaration du pointeur temporaire 2 qui parcour la chaine pour trouver le precedent m2
  shared_ptr<Maillon<T>> tmp2;
  //declaration du pointeur temporaire 3 qui se positionne sur le suivant de m1
  shared_ptr<Maillon<T>> tmp3;
  if (m1->suivant != nullptr && m1 != nullptr)
    tmp3 = m1->suivant;
  else return 1;
  //declaration du pointeur temporaire 4 qui se positionne sur le precedent de m2
  shared_ptr<Maillon<T>> tmp4 = m2->precedent;

  //declaration d'un pointeur de parcour
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
    else
      return 1;
  }

  //on fait pointer precedent du maillon suivant de m2 sur m1
  tmp2->suivant->precedent = tmp1;//TODO: cas particulier si tmp2 est fin de liste
  //on fait pointer le suivant de m1 sur sur le maillon suivant de m2
  tmp1->suivant = tmp2->suivant;
  if ( tmp1->precedent == nullptr )
  {
    //alors tmp1 n'a pas de precedent
    //donc c'est le premier de la liste
    //donc c'est la tete de la liste qu'on fait pointer sur tmp2
    this->laChaineDoubleDeMaillons = tmp2;
  }
  else
  {
    //on fait pointer le suivant du maillon precedent m1 sur tmp2
    tmp1->precedent->suivant = tmp2;
  }
  //on fait pointer le precedent du maillon tmp3 sur tmp2
  tmp3->precedent = tmp2;

  //on fait pointer le suivant du maillon tmp 4 sur tmp3 // heu ... toujours pas ...
  //c'est sur tmp1, d'apres le dessins ...
  //tmp4->suivant = tmp3;
  tmp4->suivant = tmp1;

  //on fait pointer le precedent du maillon tmp 2 sur le maillon precedent de tmp 1
  tmp2->precedent = tmp1->precedent; //donc null si tmp1 est la tete de la liste.

  //on fait pointer le precedent de tmp 1 sur tmp4
  tmp1->precedent = tmp4;

  //on fait pointer le suivant de tmp2 sur le maillon tmp3
  tmp2->suivant = tmp3;

  return 0;
}

//on ajoute ca car le makefile genere par eclipse est pouris!
template class ListeDoublementChainee<std::string>;
template class ListeDoublementChainee<double>;
//template void ListeDoublementChainee<std::string>::ajouteEnFin(const std::string & donnee);
//(et qu'on a tout melange, c'est pour ca qu'il se foire)...
