/* 
 * File:   Service.h
 * Author: Hojjat
 *
 * Created on December 7, 2014, 1:50 PM
 */

#ifndef SERVICE_H
#define	SERVICE_H
#include <string>

using namespace std;

class Service {
public:
    friend class ServicesList;
    Service(string name);
    int priority();
    string getName();
    Service();
    void addSubService(string subServiceName);
    ~Service();
private:
    string name;
    string cars;
    string customerDescription;
    string branchDescription;
    string needingTime;
    string cost;
    Service *subServices;
    int references;

    Service *next;
    Service *previous;
    //true:data    false:reference
    bool hasData;
};

#endif	/* SERVICE_H */

