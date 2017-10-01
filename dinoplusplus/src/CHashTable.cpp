/*
 * CHashTable.cpp
 *
 *  Created on: 1 oct. 2017
 *      Author: pm
 */

#include "CHashTable.h"
#include <memory>

C2Links::C2Links(std::string unMot)
{
  this->donnee = unMot;
}

C2Links::~C2Links()
{

}

CHashTable::CHashTable(unsigned VSize)
{
  m_hashtable = std::vector<std::pair<C2Links*, C2Links*>>(VSize);
}



void detruitUneListe(std::pair<C2Links*, C2Links*> uneListe)
{

}

CHashTable::~CHashTable()
{
  unsigned int i;

  for ( i = 0; i < m_hashtable.size() ; ++i )
  {
    detruitUneListe(m_hashtable[i]);
  }
}

int CHashTable::fonctionDeHashage(const std::string &mot)
{
  return mot[0] - 'a';
}

void CHashTable::ajouteAListe_push_front(std::pair<C2Links*, C2Links*> listeDouble, const std::string &mot)
{
  C2Links *leMaillon = new  C2Links(mot);

  //listeDouble.first
  //listeDouble.second
  //Maillon *nouveauMaillon;
  shared_ptr<C2Links> nouveauMaillon ;
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

void CHashTable::push_front(const std::string &mot)
{
  ajouteAListe_push_front(m_hashtable[fonctionDeHashage(mot)], mot);
}

