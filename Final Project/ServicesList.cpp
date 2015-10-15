/* 
 * File:   ServicesList.cpp
 * Author: Hojjat
 * 
 * Created on December 7, 2014, 2:35 PM
 */

#include <stddef.h>
#include <string>
#include <iostream>
#include "ServicesList.h"
using namespace std;

ServicesList::ServicesList() {
    Service *service = new Service();
    first = service;
}

void ServicesList::addMainService(string serviceName) {
    if (getService(serviceName) != NULL) {
        cout << "service name is duplicated!";
        return;
    }
    Service *service = new Service(serviceName);
    service->next = first->next;
    if (first->next) {
        first->next->previous = service;
    }
    service->previous = first;
    first->next = service;
}

void ServicesList::addSubService(string parentServiceName, string serviceName) {
    Service *parent;
    if ((parent = getService(parentServiceName)) == NULL) {
        cout << "parent service does not exist!";
        return;
    }
    if (getService(serviceName) != NULL) {
        cout << "service name is duplicated!";
        return;
    }
    parent->addSubService(serviceName);
}

void ServicesList::addParent(string parentServiceName, string serviceName) {
    Service *parent, *child;
    if ((parent = getService(parentServiceName)) == NULL)
        cout << "parent service does not exist!";
    else if (parent->subServices && parent->subServices->next)
        cout << "parent already has another child group!";
    else if ((child = getService(serviceName)) == NULL)
        cout << "child service does not exist!";
    else {
        while (child->previous)
            child = child->previous;
        child->references++;
        if (parent->subServices) {
            delete parent->subServices;
        }
        parent->subServices = child;
    }
}

Service* ServicesList::getService(string serviceName) {
    Service *p = first;
    Service *q;
    while (p) {
        if (p->hasData) {
            if (p->name.compare(serviceName) == 0)
                return p;
            q = p->subServices;
            while (q) {
                if (q->hasData && (q->name.compare(serviceName) == 0))
                    return q;
                q = q->next;
            }
        }
        p = p->next;
    }
    return NULL;
}

void ServicesList::deleteService(string serviceName) {
    Service *service = getService(serviceName);
    if (!service) {
        cout << "service does not exist!";
        return;
    }
    if (service->next)
        service->next->previous = service->previous;
    service->previous->next = service->next;
    deleteServices(service->subServices);
    delete service;
}

void ServicesList::deleteServices(Service* service) {
    if (!service) {
        return;
    }
    if (!service->hasData) {
        service->references--;
        if (service->references == 0) {
            deleteServices(service->next);
            delete service;
        } else {
            return;
        }
    } else {
        deleteServices(service->subServices);
        deleteServices(service->next);
        delete service;
    }

}

void ServicesList::printMainServices() {
    cout << "\n--- Main Services ---\n";
    printMainServices(first);
    cout << "---------------------\n";
}

void ServicesList::printMainServices(Service* service) {
    if (!service)
        return;
    if (service->hasData)
        cout << "- " + service->name + "\n";
    printMainServices(service->next);
}

void ServicesList::printSubServices(string serviceName) {
    Service *service = getService(serviceName);
    if (!service) {
        cout << "service does not exist!";
        return;
    }
    cout << "\n--- SubServices of " + serviceName + "---\n";
    printMainServices(service->subServices);
    cout << "------------------------------\n";

}
//
//void ServicesList::printAllServices(Service* service) {
//    if (!service)
//        return;
//    if (service->hasData) {
//        cout << "- " + service->name + "\n";
//    }
//}

ServicesList::~ServicesList() {

}