/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class HealthMonitorImpl extends UnicastRemoteObject implements HealthMonitor {

    private Map<String, Patient> patients;

    public HealthMonitorImpl() throws RemoteException {
        super();
        patients = new HashMap<String, Patient>();
    }

    public void addPatient(String name, int age, String condition) throws RemoteException {
        Patient patient = new Patient(name, age, condition);
        patients.put(name, patient);
    }

    public void removePatient(String name) throws RemoteException {
        patients.remove(name);
    }

    public String getPatientStatus(String name) throws RemoteException {
        Patient patient = patients.get(name);
        if (patient != null) {
            return patient.getCondition();
        } else {
            return "Unknown";
        }
    }

    public void updatePatientStatus(String name, String newStatus) throws RemoteException {
        Patient patient = patients.get(name);
        if (patient != null) {
            patient.setCondition(newStatus);
            patients.put(name, patient);
        }
    }
}
