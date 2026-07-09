package david.dev.service;

import david.dev.io.*;
import david.dev.model.Order;

import java.util.List;
import java.util.Map;

public class SalesProcessor {


    public void processSales(String inputPath, String outputPath, double pricePerKg,
                             double initialDiscount, double discountStep) {


        OrderFileService fileService = new OrderFileService();

        List<Order> orders = fileService.readOrders(inputPath);

        PriceCalculator calculator = new PriceCalculator(pricePerKg, initialDiscount, discountStep);
        Map<String, Double> results = calculator.calculatePrice(orders);

        fileService.writeResults(results, outputPath);
    }
}