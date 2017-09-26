#include <iostream>
#include "Maillon.h"
#include "ListeChainee.h"
using namespace std;

int main()
{
  ListeChainee *liste;

  //petit test de git
  liste = new ListeChainee();
  cout << "testeee: " << liste << endl; // prints !!!Hello World!!!
  //liste->ajouteEnFin(42.0);
  liste->ajouteAuDebut(42.0);
  liste->ajouteAuDebut(505.0);
  liste->ajouteAuDebut(99.0);
  liste->ajouteAuDebut(21.0);
  liste->AfficheDebug();
  liste->ajouteEnFin(999.0);
  liste->ajouteEnFin(800.0);
  liste->AfficheDebug();
  cout << "liste construite. " << endl; // prints !!!Hello World!!!
  cout << "echange: " << endl; // prints !!!Hello World!!!
  liste->echangesMaillons(liste->laChaineDeMaillons->suivant, liste->laChaineDeMaillons->suivant->suivant->suivant);
  liste->AfficheDebug();

  return 0;
}
