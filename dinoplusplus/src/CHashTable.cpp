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
  unsigned int i;
  std::shared_ptr<C2Links> teteFictive;
  std::shared_ptr<C2Links> queueFictive;

  m_hashtable = std::vector<std::pair<std::shared_ptr<C2Links>, std::shared_ptr<C2Links>>>(VSize);

  for ( i = 0; i < m_hashtable.size() ; ++i )
  {
    teteFictive = std::make_shared<C2Links>("Tete Fictive"); //fait le new C2Links("Tete Fictive");
    queueFictive = std::make_shared<C2Links>("Queue Fictive"); //fait le new C2Links("Tete Fictive");

    m_hashtable[i].first = teteFictive;
    m_hashtable[i].second = queueFictive;

    teteFictive->suivant = queueFictive;
    teteFictive->precedent = nullptr;

    queueFictive->suivant = nullptr;
    queueFictive->precedent = teteFictive;

  }

}



void detruitUneListe(std::pair<std::shared_ptr<C2Links>, std::shared_ptr<C2Links>> uneListe)
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

void CHashTable::ajouteAListe_push_front(std::pair<std::shared_ptr<C2Links>, std::shared_ptr<C2Links>> listeDouble, const std::string &mot)
{
  //C2Links *leMaillon = new  C2Links(mot);
  std::shared_ptr<C2Links> nouveauMaillon  = std::make_shared<C2Links>(mot); // fait le new  C2Links(mot)

  //listeDouble.first // est suivant
  //listeDouble.second //precedent

  nouveauMaillon->suivant = listeDouble.first->suivant; //si c'est null ... ca marche!
  listeDouble.first->suivant = nouveauMaillon;

  nouveauMaillon->precedent = listeDouble.first;
  nouveauMaillon->suivant->precedent = nouveauMaillon;

}

void CHashTable::push_front(const std::string &mot)
{
  ajouteAListe_push_front(m_hashtable[fonctionDeHashage(mot)], mot);
}

