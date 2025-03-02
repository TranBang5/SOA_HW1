import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

public class OrderServiceImpl extends UnicastRemoteObject implements OrderService {
    protected OrderServiceImpl() throws RemoteException {}

    @Override
    public double calculateTotal(String productId, int quantity) throws RemoteException {
        double price = 0;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "yourpassword")) {
            PreparedStatement stmt = conn.prepareStatement("SELECT price FROM products WHERE product_id = ?");
            stmt.setString(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price * quantity;
    }
}
