/*
 * Maillon.h
 *
 *  Created on: 24 sept. 2017
 *      Author: ...
 */

#ifndef MAILLON_H_
#define MAILLON_H_

#include <memory>
#include <iostream>
/**
 * Cette classe represente un maillon d'une liste chainnee
 */
template <typename T>
class Maillon
{
  /* doit contenir: un champs donnee pour stocker les donnes:
   * pour l'instant les donnees seront des doubles
   *
   * pour commencer on va mettre ca en public, et plus
   * tard on encapsulera
    */


  /* doit contenir un "lien" vers le maillon suivant */


public:
  T donnee;
  std::shared_ptr<Maillon<T>> suivant;
  std::shared_ptr<Maillon<T>> precedent;

  Maillon(T paramDonee);
  virtual ~Maillon();
};

#endif /* MAILLON_H_ */
