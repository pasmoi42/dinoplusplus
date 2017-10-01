/*
 * CHashTable.cpp
 *
 *  Created on: 1 oct. 2017
 *      Author: pm
 */

#include "CHashTable.h"

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

void CHashTable::ajouteAListe(std::pair<C2Links*, C2Links*> listeDouble, const std::string &mot)
{

}

void CHashTable::push_front(const std::string &mot)
{
  ajouteAListe(m_hashtable[fonctionDeHashage(mot)], mot);
}

