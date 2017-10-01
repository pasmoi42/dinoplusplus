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
public:
  CHashTable(unsigned VSize = 26);
  virtual ~CHashTable();
};

#endif /* CHASHTABLE_H_ */
