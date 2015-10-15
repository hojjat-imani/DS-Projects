/* 
 * File:   ServicesList.h
 * Author: Hojjat
 *
 * Created on December 7, 2014, 2:35 PM
 */

#ifndef SERVICESLIST_H
#define	SERVICESLIST_H
#include "Service.h"
#include <string>

using namespace std;

class ServicesList {
public:
    ServicesList();
    void addMainService(string serviceName);
    void addSubService(string parentServiceName, string serviceName);
    void addParent(string parentServiceName, string serviceName);
    void deleteService(string serviceName);
    void printMainServices();
    Service* getService(string serviceName);
    void printSubServices(string serviceName);
    ~ServicesList();
private:
    Service *first;
    void printMainServices(Service *first);
    //    void printAllServices(Service *first);
    void deleteServices(Service *first);
};

#endif	/* SERVICESLIST_H */

