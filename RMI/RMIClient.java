import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("server-ip", 1099);
            OrderService service = (OrderService) registry.lookup("OrderService");

            String productId = "P10";
            int quantity = 5;
            double total = service.calculateTotal(productId, quantity);
            System.out.println("Total Price: $" + total);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
