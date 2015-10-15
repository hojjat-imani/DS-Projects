/* 
 * File:   AgenciesList.cpp
 * Author: Hojjat
 * 
 * Created on December 11, 2014, 7:02 AM
 */

#include <iostream>

#include "AgenciesList.h"

AgenciesList::AgenciesList(ServicesList *services) {
    first = new Agency();
    this->services = services;
}

void AgenciesList::addAgency(string agencyName) {
    if (getAgency(agencyName) != NULL) {
        cout << "agency name is duplicated!";
        return;
    }
    Agency *a = new Agency(agencyName);
    a->next = first->next;
    first->next = a;
}

void AgenciesList::printAgencies() {
    cout << "\n-------- agencies ---------\n";
    printAgencies(first);
    cout << "---------------------------\n";
}

void AgenciesList::printAgencies(Agency* first) {
    if (!first)
        return;
    if (first != this->first)
        cout << "- " + first->name + "\n";
    printAgencies(first->next);
}

void AgenciesList::addRequest(string agencyName, string serviceName, string userName) {
    Agency * agency;
    Service * service;
    if ((agency = getAgency(agencyName)) == NULL) {
        cout << "agency not exist!\n";
        return;
    }
    if ((service = services->getService(serviceName)) == NULL) {
        cout << "service not exist!\n";
        return;
    }
    QueueElement * QE = new QueueElement(service, serviceName, userName);
    agency->addRequest(QE);
}

Agency * AgenciesList::getAgency(string agencyName) {
    Agency *p = first->next;
    while (p) {
        if (p->name.compare(agencyName) == 0) {
            return p;
        }
        p = p->next;
    }
    return NULL;
}

void AgenciesList::getReauests(string agencyName) {
    Agency *agency;
    if ((agency = getAgency(agencyName)) == NULL) {
        cout << "agency not exist!\n";
        return;
    }

    agency->getRequests();
}

AgenciesList::~AgenciesList() {
}

