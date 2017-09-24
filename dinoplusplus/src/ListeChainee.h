/*
 * ListeChainee.h
 *
 *  Created on: 24 sept. 2017
 *      Author: pm
 */

#ifndef LISTECHAINEE_H_
#define LISTECHAINEE_H_

#include "Maillon.h"

/* bla bla structure de liste de chainnee */
class ListeChainee
{
  /* contient une chaine de maillons  */
  /* contient de quoi faire une nouvelle liste chainee: son constructeur*/
  /* contient les methodes de manipulation de la chaine de maillons:
   * * Ajouter un maillon.
   *gg
   *  */
public:
  /* on met laChaineDeMaillons en plublic: on l'encapsulera apres. */
  Maillon *laChaineDeMaillons;
  ListeChainee();
  virtual ~ListeChainee();
  void AfficheDebug();

  void ajouteEnFin(double donnee);
  void ajouteAuDebut(double donnee);
};

#endif /* LISTECHAINEE_H_ */
