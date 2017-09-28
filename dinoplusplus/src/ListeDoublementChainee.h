/*
 * ListeDoublementChainee.h
 *
 *  Created on: 27 sept. 2017
 *      Author: doria
 */

#ifndef LISTEDOUBLEMENTCHAINEE_H_
#define LISTEDOUBLEMENTCHAINEE_H_

#include <memory>
#include <iostream>
#include "Maillon.h"

template <typename T>
class ListeDoublementChainee
{


public:
  /* on met laChaineDeMaillons en plublic: on l'encapsulera apres. */
/*
	Maillon *laChaineDeMaillons;
*/
	std::shared_ptr<Maillon<T>> laChaineDoubleDeMaillons;

	ListeDoublementChainee();
	virtual ~ListeDoublementChainee();
	void AfficheDebug();

	void ajouteEnFin(const T & donnee);
	void ajouteAuDebut(const T & donnee);

  /**
   * Cette fonction echange la position dans la liste des
   * maillons pointes par m1 et m2.
   * Si m1 ou m2 ne sont par dans la liste, la fonction return 1
   * Si l'echange se passe bien, la fonction return 0.
   */
  int echangesMaillons(std::shared_ptr<Maillon<T>> m1, std::shared_ptr<Maillon<T>> m2);
};




#endif /* LISTEDOUBLEMENTCHAINEE_H_ */
