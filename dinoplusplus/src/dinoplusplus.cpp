#include <iostream>
#include "Maillon.h"
#include "ListeChainee.h"
using namespace std;
int main()
{
#if(0)
	ListeChainee<double> liste;
	int ret;

  //petit test de git
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
  ret = liste->echangesMaillons(liste->laChaineDeMaillons, liste->laChaineDeMaillons->suivant->suivant->suivant);
  if (ret)
    cout << "erreur" << endl;
  else
    liste->AfficheDebug();
#endif


  return 0;
}
