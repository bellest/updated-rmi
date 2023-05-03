/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HealthMonitor extends Remote {
    public void addPatient(String name, int age, String condition) throws RemoteException;
    public void removePatient(String name) throws RemoteException;
    public String getPatientStatus(String name) throws RemoteException;
    public void updatePatientStatus(String name, String newStatus) throws RemoteException;
}

