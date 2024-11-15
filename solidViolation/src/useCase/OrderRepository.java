// Nueva clase para persistir la orden
package useCase;

import bd.Database;
import modelo.Order;

public class OrderRepository {

    private Database database;

    public OrderRepository(Database database) {
        this.database = database;
    }

    public void saveOrder(Order order) {
        System.out.println("Saving order: " + order.getOrderId());
        database.guardar();
    }
}
