// Nueva clase para generar reportes de la orden
package useCase;

import modelo.Order;

public class OrderReport {

    public String generateReport(Order order) {
        return "Report for Order ID: " + order.getOrderId() + " with amount: " + order.getAmount();
    }
}