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
Maillon::Maillon(double paramDonee)
{
  this->donnee = paramDonee;
  this->suivant = nullptr; //super important!!!

  /* et donc la, a la fin de mon constructeur, l'objet
  est coherent: entièrement valide! */
}

Maillon::~Maillon()
{
  // TODO Auto-generated destructor stub
}

