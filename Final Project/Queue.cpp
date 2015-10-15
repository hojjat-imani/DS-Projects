/* 
 * File:   Queue.cpp
 * Author: Hojjat
 * 
 * Created on December 11, 2014, 7:01 AM
 */

#include <iostream>

#include "Queue.h"
using namespace std;
//
//Queue::Queue() {
//    lastItem = -1;
//}
//
//void Queue::addRequest(QueueElement* request) {
//    if (isFull()) {
//        cout<< "this agency can not answer to any more request! (Full Queue)";
//        return;
//    }
//    lastItem++;
//    int i = lastItem;
//    while(true){
//        if(i == 0){
//            break;
//        }
//        if(request->service->priority() > requests[i/2]->service->priority()){
//            requests[i] = requests[i/2];
//        }else{
//            break;
//        }
//        i /=2;
//    }
//    requests[i] = request;
//}
//
//void Queue::getRequests(){
//    cout<< "\n----- requests ------\n" ;
//    for(int i = 0; i <= lastItem; i++)
//        cout<< requests[i]->service->getName() + "   USER: " + requests[i]->userName + "\n";
//    cout<< "---------------------\n" ;
//    lastItem = -1;
//    
//}
//
//
//bool Queue::isFull() {
//    if (lastItem == sizeof(requests)/sizeof(QueueElement *)) {
//        return true;
//    }
//    return false;
//}

Queue::Queue() {
    first = new QueueElement();
}

void Queue::addRequest(QueueElement* request) {
    QueueElement *p, *q;
    q = first;
    p = first->next;
    while (p && p->service->priority() < request->service->priority()) {
        q = p;
        p = p->next;
    }
    q->next = request;
    request->next = p;
}

void Queue::getRequests() {
    QueueElement *q, *p = first->next;
    cout << "\n----- Requests ----\n";
    while (p) {
            cout << "SERVICE: " + p->serviceName + "   USER: " + p->userName + "\n";
        q = p->next;
        delete p;
        p = q;
    }
    cout << "-------------------\n";
    first->next = NULL;
}

void Queue::getRequests1() {
    QueueElement *q, *p = first->next;
    while (p) {
        cout << p->service->getName() + "   USER: " + p->userName + "\n";
        p = p->next;
    }
}

Queue::~Queue() {
}

