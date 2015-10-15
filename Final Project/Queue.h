/* 
 * File:   Queue.h
 * Author: Hojjat
 *
 * Created on December 11, 2014, 7:01 AM
 */

#ifndef QUEUE_H
#define	QUEUE_H

#include "Service.h"
#include "QueueElement.h"

class Queue {
public:
    Queue();
    void addRequest(QueueElement* request);
    void getRequests();
    void getRequests1();
    virtual ~Queue();
private:
    //    QueueElement *requests[20];
    //    bool isFull();
    //    int lastItem;


    QueueElement *first;
};

#endif	/* QUEUE_H */

