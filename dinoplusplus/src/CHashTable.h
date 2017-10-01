/*
 * CHashTable.h
 *
 *  Created on: 1 oct. 2017
 *      Author: pm
 */

#ifndef CHASHTABLE_H_
#define CHASHTABLE_H_

#include <memory>
#include <vector>

class C2Links
{
  std::shared_ptr<C2Links> suivant;
  std::shared_ptr<C2Links> precedent;
  std::string donnee;
};

class CHashTable
{
private:
  std::vector<std::pair<C2Links*, C2Links*>> m_hashtable;
  int fonctionDeHashage(const std::string &);
  void ajouteAListe(std::pair<C2Links*, C2Links*> listeDouble, const std::string &mot);

public:
  CHashTable(unsigned VSize = 26);
  void push_front(const std::string &);
  //void push_back(const std::string &);
  //void add(const std::string &);


  //C2Links * Find (const std::string &);


  virtual ~CHashTable();
};

#endif /* CHASHTABLE_H_ */
