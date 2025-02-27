package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator stub = (Calculator) registry.lookup("CalculatorService");
            System.out.println("Addition: " + stub.add(5, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}