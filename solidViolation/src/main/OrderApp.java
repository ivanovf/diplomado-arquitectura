package main;

import modelo.Order;
import useCase.OrderRepository;
import useCase.OrderReport;
import bd.DatabaseMysql;

public class OrderApp {
    public static void main(String[] args) {
        // Crear una orden con un ID y un monto
        Order order = new Order("ORD123", 250.75);

        // Guardar la orden en la base de datos
        DatabaseMysql database = new DatabaseMysql();
        OrderRepository orderRepository = new OrderRepository(database);
        OrderRepository.saveOrder(order);

        // Generar y mostrar el reporte de la orden
  	OrderReport orderReport = new OrderReport();
        String report = OrderReport.generateReport(order);
        System.out.println(report);
    }
}
