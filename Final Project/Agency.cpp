/* 
 * File:   Agency.cpp
 * Author: Hojjat
 * 
 * Created on December 10, 2014, 9:18 PM
 */

#include "Agency.h"
#include <string>
using namespace std;

Agency::Agency() {
}

Agency::Agency(string agencyName){
    name = agencyName;
    requests = new Queue();
}

void Agency::addRequest(QueueElement* QE){
    requests->addRequest(QE);
}
void Agency::getRequests(){
    requests->getRequests();
}
Agency::~Agency() {
}

