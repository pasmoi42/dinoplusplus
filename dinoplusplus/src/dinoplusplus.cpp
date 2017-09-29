#include <iostream>
#include "Maillon.h"
//#include "ListeChainee.h"
#include "ListeDoublementChainee.h"



void test1()
{
#if(0)
  //test bourrin pourris ...
#endif
}

void test2()
{
#if(0)
  ListeDoublementChainee<std::string> *liste;
  //liste = new ListeDoublementChainee<double>();
//  liste = new ListeDoublementChainee<std::string>();


  int ret;
  const string s = std::string("42.0");
  //cout << "testeee: " << liste << endl; // prints !!!Hello World!!!
  //liste->ajouteEnFin(42.0);
  //liste->ajouteAuDebut(s);
//  liste->ajouteAuDebut(std::string("42.0"));

  liste->ajouteAuDebut(505.0);
  liste->ajouteAuDebut(99.0);
  liste->ajouteAuDebut(21.0);
  liste->AfficheDebug();
  liste->ajouteEnFin(999.0);
  liste->ajouteEnFin(800.0);
  liste->AfficheDebug();
  cout << "liste construite. " << endl; // prints !!!Hello World!!!
  cout << "echange: " << endl; // prints !!!Hello World!!!
  shared_ptr<Maillon<double>> m1;
  shared_ptr<Maillon<double>> m2;
  m1 = liste->laChaineDoubleDeMaillons;
  m2 = liste->laChaineDoubleDeMaillons->suivant->suivant->suivant;
  ret = liste->echangesMaillons(m1, m2);
  if (ret)
    cout << "erreur" << endl;
  else
    liste->AfficheDebug();
#endif


}


#if(0)
void test3()
{
  Maillon<std::string> *m;

  m = new Maillon<std::string> (std::string("42.0"));

}
#endif

/**
 * test un maillon double
 */
void test4()
{
  Maillon<double> *m;

  m = new Maillon<double> (42.0l);
  std::cout << "un maillon: addr:"<< m <<" val:" << m->donnee << std::endl; // prints !!!Hello World!!!
}

/**
 * test un maillon shared_ptr
 */
void test5()
{
  std::shared_ptr<Maillon<double>> m;
  //Maillon<double> *m;

  m = std::make_shared<Maillon<double>>(42.0l);
  std::cout << "un maillon: addr:"<< m <<" val:" << m->donnee << std::endl; // prints !!!Hello World!!!
}


/**
 * Une liste double de Maillons
 */
void test6()
{
  std::shared_ptr<Maillon<double>> m;
  ListeDoublementChainee<double> liste;
  //Maillon<double> *m;

  m = std::make_shared<Maillon<double>>(42.0l);
  std::cout << "un maillon: addr:"<< m <<" val:" << m->donnee << std::endl; // prints !!!Hello World!!!


  liste.ajouteAuDebut(505.0l);
  liste.ajouteAuDebut(99.0);
  liste.ajouteAuDebut(21.0);
  liste.ajouteEnFin(999.0);
  liste.ajouteEnFin(800.0);
  liste.AfficheDebug(); // 21; 99; 505; 999; 800

}

/**
 * Une liste double de Maillons
 */
void test7()
{
  int ret;
  std::shared_ptr<Maillon<double>> m;
  ListeDoublementChainee<double> liste;
  //Maillon<double> *m;

  std::cout << "############" << std::endl;
  std::cout << "## TEST 7 ##" << std::endl;
  std::cout << "############" << std::endl;

  m = std::make_shared<Maillon<double>>(42.0l);
  std::cout << "un maillon: addr:"<< m <<" val:" << m->donnee << std::endl; // prints !!!Hello World!!!


  liste.ajouteAuDebut(505.0l);
  liste.ajouteAuDebut(99.0);
  liste.ajouteAuDebut(21.0);
  liste.ajouteEnFin(999.0);
  liste.ajouteEnFin(800.0);
  liste.AfficheDebug(); // 21; 99; 505; 999; 800
  std::cout << "Echange de 99 et 999: " << std::endl;

  std::shared_ptr<Maillon<double>> m1;
  std::shared_ptr<Maillon<double>> m2;
  m1 = liste.laChaineDoubleDeMaillons->suivant;
  m2 = liste.laChaineDoubleDeMaillons->suivant->suivant->suivant;
  ret = liste.echangesMaillons(m1, m2);
  if (ret)
    std::cout << "erreur" << std::endl;
  else
    liste.AfficheDebug();
}



/**
 * Une liste double de Maillons
 */
void test8()
{
  int ret;
  std::shared_ptr<Maillon<double>> m;
  ListeDoublementChainee<double> liste;
  //Maillon<double> *m;

  std::cout << "############" << std::endl;
  std::cout << "## TEST 8 ##" << std::endl;
  std::cout << "############" << std::endl;


  m = std::make_shared<Maillon<double>>(42.0l);
  std::cout << "un maillon: addr:"<< m <<" val:" << m->donnee << std::endl; // prints !!!Hello World!!!


  liste.ajouteAuDebut(505.0l);
  liste.ajouteAuDebut(99.0);
  liste.ajouteAuDebut(21.0);
  liste.ajouteEnFin(999.0);
  liste.ajouteEnFin(800.0);
  liste.AfficheDebug(); // 21; 99; 505; 999; 800
  std::cout << "Echange de 21 et 999: " << std::endl;

  std::shared_ptr<Maillon<double>> m1;
  std::shared_ptr<Maillon<double>> m2;
  m1 = liste.laChaineDoubleDeMaillons;
  m2 = liste.laChaineDoubleDeMaillons->suivant->suivant->suivant;
  ret = liste.echangesMaillons(m1, m2);
  if (ret)
    std::cout << "erreur" << std::endl;
  else
    liste.AfficheDebug();
}


using namespace std;
int main()
{
#if(0)
  test6();
  test7();
#endif

  test7();
  test8();

  return 0;
}
