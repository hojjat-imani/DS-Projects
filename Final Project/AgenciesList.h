/* 
 * File:   AgenciesList.h
 * Author: Hojjat
 *
 * Created on December 11, 2014, 7:02 AM
 */

#ifndef AGENCIESLIST_H
#define	AGENCIESLIST_H
#include <string>
#include "Agency.h"
#include "ServicesList.h"
using namespace std;

class AgenciesList {
public:
    AgenciesList(ServicesList *servicse);
    void addAgency(string agencyName);
    void addRequest(string agencyName, string serviceName, string userName);
    void getReauests(string agencyName);
    void printAgencies();
    virtual ~AgenciesList();
private:
    Agency *first;
    ServicesList *services;
    void printAgencies(Agency *first);
    Agency *getAgency(string agencyName);
};

#endif	/* AGENCIESLIST_H */

