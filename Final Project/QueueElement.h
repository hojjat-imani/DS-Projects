/* 
 * File:   QueueElement.h
 * Author: Hojjat
 *
 * Created on December 11, 2014, 7:17 AM
 */

#ifndef QUEUEELEMENT_H
#define	QUEUEELEMENT_H

#include "Service.h"


class QueueElement {
public:
    friend class Queue;
    QueueElement(Service* service, string serviceName, string userName);
    QueueElement();
    virtual ~QueueElement();
private:
    Service *service;
    string serviceName;
    string userName;
    QueueElement *next;
};

#endif	/* QUEUEELEMENT_H */

