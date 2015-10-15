/* 
 * File:   QueueElement.cpp
 * Author: Hojjat
 * 
 * Created on December 11, 2014, 7:17 AM
 */

#include "QueueElement.h"

QueueElement::QueueElement(Service* service, string serviceName, string userName){
    this->service = service;
    this->serviceName = serviceName;
    this->userName = userName;
    this->next = NULL;
}

QueueElement::QueueElement(){
    next = NULL;
}

QueueElement::~QueueElement() {
}