/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class HospitalClient {
    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            HealthMonitor stub = (HealthMonitor) registry.lookup("HealthMonitor");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter patient name: ");
                String name = scanner.nextLine();
                String status = stub.getPatientStatus(name);
                System.out.println("Patient status: " + status);
                System.out.print("Enter new status: ");
                String newStatus = scanner.nextLine();
                stub.updatePatientStatus(name, newStatus);
                System.out.println("Patient status updated successfully");
            }
        } catch (Exception e) {
            System.out.println("HospitalClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
