/*
 * CHashTable.cpp
 *
 *  Created on: 1 oct. 2017
 *      Author: pm
 */

#include "CHashTable.h"
#include <memory>
#include <iostream>

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
  std::shared_ptr<C2Links> parcours;

  parcours = uneListe.first;
  while ( parcours != uneListe.second)
  {
    uneListe.first = parcours->suivant;
    //pas de delete en shared_ptr: c'est automatique, tant que plus rien ne pointe sur l'objet
    //donc on enleve tous les pointeurs de la liste:
    parcours->suivant = nullptr;
    parcours->precedent = nullptr;
    //on se positionne sur la nouvelle tete
    parcours = uneListe.first;
  }
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

  //listeDouble.first // tete de liste
  //listeDouble.second //queue de liste

  nouveauMaillon->suivant = listeDouble.first->suivant; //si c'est null ... ca marche!
  nouveauMaillon->precedent = listeDouble.first;

  listeDouble.first->suivant = nouveauMaillon;
  nouveauMaillon->suivant->precedent = nouveauMaillon;
}

void CHashTable::ajouteAListe_push_back(std::pair<std::shared_ptr<C2Links>, std::shared_ptr<C2Links>> listeDouble, const std::string &mot)
{
  //C2Links *leMaillon = new  C2Links(mot);
  std::shared_ptr<C2Links> nouveauMaillon  = std::make_shared<C2Links>(mot); // fait le new  C2Links(mot)

  //listeDouble.first // tete de liste
  //listeDouble.second //queue de liste

  nouveauMaillon->suivant = listeDouble.second;
  nouveauMaillon->precedent = listeDouble.second->precedent; //si c'est null ... ca marche!

  listeDouble.second->precedent = nouveauMaillon;
  nouveauMaillon->precedent->suivant = nouveauMaillon;
}

void CHashTable::push_front(const std::string &mot)
{
  ajouteAListe_push_front(m_hashtable[fonctionDeHashage(mot)], mot);
}

void CHashTable::push_back(const std::string &mot)
{
  ajouteAListe_push_back(m_hashtable[fonctionDeHashage(mot)], mot);
}

std::shared_ptr<C2Links> CHashTable::Find(const std::string &celuiQuonCherche)
{
  std::shared_ptr<C2Links> parcours;
  std::shared_ptr<C2Links> trouve;
  std::shared_ptr<C2Links> plusGrandPrecedent;
  std::pair<std::shared_ptr<C2Links>, std::shared_ptr<C2Links>> listeDouble;

  listeDouble = m_hashtable[fonctionDeHashage(celuiQuonCherche)];

  trouve = nullptr;
  plusGrandPrecedent = listeDouble.first; //tete fictive
  parcours = listeDouble.first->suivant;
  while ( parcours != listeDouble.second)
  {
    /*
      std::string::compare(string celuiQuonCherche) compare 2 string par ordre alpahbetiques:
      ici, dans
        parcours->donnee.compare(celuiQuonCherche)
      Si les strings: donne et celuiQuonCherche continennet le meme texte: ca renvoie 0.
      Si donne est avant celuiQuonCherche dans l'ordre alphabetique, ca renvoie un int negatif (par exemple -1).
      Si donne est apres celuiQuonCherche dans l'ordre alphabetique, ca renvoie un int posisif (par exemple 1).
     */
    if (parcours->donnee.compare(celuiQuonCherche) == 0) // si donne et celuiQuonCherche contiennent le meme texte
    {
      trouve = parcours;
      break;
    }
    else if (parcours->donnee.compare(celuiQuonCherche) < 0) // si donne est avant celuiQuonCherche selon l'ordre alphabtique
    {
      plusGrandPrecedent = parcours;
    }
    parcours = parcours->suivant;
  }

  if (trouve != nullptr)
    return trouve; //repond au premier tiret de la question 2.7
  else
    return plusGrandPrecedent; //repond au deuxieme tiret de la question 2.7
}

/**
 * ajout en trie par ordre alphabetique dans la liste doublement chainne de la lettre.
 */
void CHashTable::add(const std::string &mot)
{
  std::shared_ptr<C2Links> emplacement;
  std::shared_ptr<C2Links> nouveauMaillon;

  emplacement = Find(mot);
  if (emplacement != nullptr)
  {
    if (emplacement->donnee.compare(mot) == 0 ) //mot deja dans la hashtable
      return; //permet de quitter la fonction sans rien faire (et sans rien retourner car elle retourne void
    else
    {
      //ajout apres l'element emplacement:
      nouveauMaillon = std::make_shared<C2Links>(mot); // fait le new  C2Links(mot)
      nouveauMaillon->precedent = emplacement; //on commence par link nouveau maillon, car ca ne perd aucun ancien pointeur.
      nouveauMaillon->suivant = emplacement->suivant;
      //puis on relink le precedent et le suivant:
      emplacement->suivant = nouveauMaillon;
      nouveauMaillon->suivant->precedent = nouveauMaillon;
    }
  }
}

void CHashTable::debugAffiche()
{
  unsigned int i;
  std::shared_ptr<C2Links> parcours;

  for (i = 0 ; i < m_hashtable.size() ; ++i)
  {
    std::cout << "case "<< i << std::endl;
    parcours = m_hashtable[i].first;
    while ( parcours != nullptr )
    {
      std::cout << "  " << parcours->donnee << std::endl;
      parcours = parcours->suivant;
    }
  }
}
