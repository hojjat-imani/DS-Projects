/* 
 * File:   Service.cpp
 * Author: Hojjat
 * 
 * Created on December 7, 2014, 1:50 PM
 */

#include <stddef.h>
#include "Service.h"
#include <string>
#include <iostream>

using namespace std;

Service::Service(string name) {
    hasData = true;
    this->name = name;
}

Service::Service() {
    hasData = false;
    references = 1;
}

void Service::addSubService(string subServiceName) {
    if (subServices == NULL) {
        Service *extraNode = new Service();
        subServices = extraNode;
    }
    Service *newService = new Service(subServiceName);
    newService->next = subServices->next;
    if (subServices->next) {
        subServices->next->previous = newService;
    }
    newService->previous = subServices;
    subServices->next = newService;

}

int Service::priority() {
    int p = (int) name.at(0);
    return p;
}

string Service::getName() {
    return name;
}

Service::~Service() {
}