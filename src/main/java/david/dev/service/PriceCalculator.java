package david.dev.service;


import david.dev.model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceCalculator {

    private double cementPrice = 500;
    private final double pricePerKg;
    private final double initialDiscount;
    private final double discountStep;

    public PriceCalculator(double pricePerKg, double initialDiscount, double discountStep) {
        this.pricePerKg = pricePerKg;
        this.initialDiscount = initialDiscount;
        this.discountStep = discountStep;
    }

    public Map<String, Double> calculatePrice(List<Order> orders) {
        final double[] discountWrapper = {initialDiscount};
        return orders.stream().collect(Collectors.toMap(
                order -> order.getCompanyName(),
                order -> {
                    double basePrice = order.getCementQuantity() * pricePerKg;
                    double finalPrice = basePrice * (1 - discountWrapper[0]);
                    if (discountWrapper[0] > 0) {
                        discountWrapper[0] -= discountStep;
                    }

                    return finalPrice;

                }
        ));
    }
}
