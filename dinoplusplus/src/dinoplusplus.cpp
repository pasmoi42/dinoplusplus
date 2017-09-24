#include <iostream>
#include "Maillon.h"
#include "ListeChainee.h"
using namespace std;

int main()
{
  ListeChainee *liste;

  //petit test de git aaa
  liste = new ListeChainee();
  cout << "testeee: " << liste << endl; // prints !!!Hello World!!!
  liste->AfficheDebug();
  return 0;
}
