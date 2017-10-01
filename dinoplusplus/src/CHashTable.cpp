/*
 * CHashTable.cpp
 *
 *  Created on: 1 oct. 2017
 *      Author: pm
 */

#include "CHashTable.h"

CHashTable::CHashTable(unsigned VSize)
{
  m_hashtable = *(new std::vector<std::pair<C2Links*, C2Links*>>(VSize));

}

CHashTable::~CHashTable()
{
  // TODO Auto-generated destructor stub
}

