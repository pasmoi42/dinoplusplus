/*
 * Maillon.cpp
 *
 *  Created on: 24 sept. 2017
 *      Author: ...
 */

#include "Maillon.h"

/**
 * Initialisation complete du nouveau maillon cree
 */
//TODO: remettre template <typename T>
template <typename T>
Maillon<T>::Maillon(T paramDonee)
{
  this->donnee = paramDonee;
  this->suivant = nullptr;
  this->precedent = nullptr;//super important!!!

  /* et donc la, a la fin de mon constructeur, l'objet
  est coherent: entierement valide! */
}
template <typename T>
Maillon<T>::~Maillon()
{
  // TODO Auto-generated destructor stub
}

//on ajoute ca car le makefile genere par eclipse est pouris!
template class Maillon<std::string>;
template class Maillon<double>;
//(et qu'on a tout melange, c'est pour ca qu'il se foire)...
