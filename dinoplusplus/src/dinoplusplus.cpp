
#include <iostream>
#include "Maillon.h"
#include "ListeChainee.h"
using namespace std;

int main()
{
  ListeChainee *liste;

  liste = new ListeChainee();
  cout << "test: " << liste << endl; // prints !!!Hello World!!!
  return 0;
}
