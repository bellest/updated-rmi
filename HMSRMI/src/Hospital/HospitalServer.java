/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class HospitalServer {

    public static void main(String args[]) {
        try {
            HealthMonitorImpl obj = new HealthMonitorImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("HealthMonitor", obj);
            System.out.println("HospitalServer ready");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter patient name: ");
                String name = scanner.nextLine();
                System.out.print("Enter patient age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter patient condition: ");
                String condition = scanner.nextLine();
                obj.addPatient(name, age, condition);
                System.out.println("Patient added successfully");
                System.out.print("Enter patient name to update status: ");
                String patientName = scanner.nextLine();
                System.out.print("Enter new status: ");
                String newStatus = scanner.nextLine();
                obj.updatePatientStatus(patientName, newStatus);
                System.out.println("Patient status updated successfully");
            }
        } catch (Exception e) {
            System.out.println("HospitalServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
