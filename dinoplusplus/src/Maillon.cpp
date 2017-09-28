/*
 * Maillon.cpp
 *
 *  Created on: 24 sept. 2017
 *      Author: pm
 */

#include "Maillon.h"

/**
 * Initialisation complete du nouveau maillon cree
 */
template <typename T>
Maillon<T>::Maillon(double paramDonee)
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

