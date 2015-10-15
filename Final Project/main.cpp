/* 
 * File:   main.cpp
 * Author: Hojjat
 *
 * Created on December 6, 2014, 11:04 PM
 */

#include <cstdlib>
#include <iostream>
#include <string>
#include "ServicesList.h"
#include "Agency.h"
#include "AgenciesList.h"


using namespace std;

/*
 * 
 */
ServicesList *services = new ServicesList();
AgenciesList *agencies = new AgenciesList(services);

int main(int argc, char** argv) {

    cout << "[1] add service\n[2] add sub service to existing service\n[3] add parent\n[4] delete service\n[5] add agency\n[6] agencies list\n[7] main services list\n[8] sub services of a service\n[9] add request\n[10] get requests of an agency\n[0] show options menu\n\n";
    string command;
    while (true) {
        cout << "\n\nchoose an option ->";
        cin >> command;
        if (command.compare("1") == 0) {
            string serviceName;
            cout << "Enter service name->";
            cin >> serviceName;
            services->addMainService(serviceName);
        } else if (command.compare("2") == 0) {
            string sub;
            string parent;
            cout << "Enter sub service name->";
            cin >> sub;
            cout << "Enter parent service name->";
            cin >> parent;
            services->addSubService(parent, sub);
        } else if (command.compare("3")== 0) {
            string sub;
            string parent;
            cout << "Enter sub service name->";
            cin >> sub;
            cout << "Enter parent service name->";
            cin >> parent;
            services->addParent(parent, sub);
        } else if (command.compare("4")== 0) {
            string serviceName;
            cout << "Enter service name->";
            cin >> serviceName;
            services->deleteService(serviceName);
        } else if (command.compare("5")== 0) {
            string agencyName;
            cout << "Enter agency name->";
            cin >> agencyName;
            agencies->addAgency(agencyName);
        } else if (command.compare("6")== 0) {
            agencies->printAgencies();
        } else if (command.compare("7")== 0) {
            services->printMainServices();
        } else if (command.compare("8")== 0) {
            string serviceName;
            cout << "Enter service name->";
            cin >> serviceName;
            services->printSubServices(serviceName);
        } else if (command.compare("9")== 0) {
            string agency;
            string service;
            string user;
            cout << "Enter agency name->";
            cin >> agency;
            cout << "Enter service name->";
            cin >> service;
            cout << "Enter user name->";
            cin >> user;
            agencies->addRequest(agency, service, user);
        } else if (command.compare("10")== 0) {
            string agency;
            cout << "Enter agency name->";
            cin >> agency;
            agencies->getReauests(agency);
        } else if (command.compare("0")== 0) {
            cout << "[1] add service\n[2] add subservice to existing service\n[3] add parent\n[4] delete service\n[5] add agency\n[6] agencies list\n[7] main services list\n[8] sub services of a service\n[9] add request\n[10] get requests of an agency\n[0] show options menu\n\n";
        } else {
            cout << "invalid command!\n";
        }
    }
    return 0;
}