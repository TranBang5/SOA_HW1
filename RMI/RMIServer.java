import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            OrderService service = new OrderServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("OrderService", service);
            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
