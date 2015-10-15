/* 
 * File:   Agency.h
 * Author: Hojjat
 *
 * Created on December 10, 2014, 9:18 PM
 */

#ifndef AGENCY_H
#define	AGENCY_H
#include <string>

#include "Queue.h"
using namespace std;

class Agency {
public:
    friend class AgenciesList;
    Agency();
    Agency(string agencyName);
    void addRequest(QueueElement * QE);
    void getRequests();
    virtual ~Agency();
private:
    string name;
    Queue *requests;
    Agency *next;
};

#endif	/* AGENCY_H */