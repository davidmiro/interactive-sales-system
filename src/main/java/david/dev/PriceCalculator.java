package david.dev;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceCalculator {

    private double cementPrice = 500;

    public Map<String, Double> calculatePrice(List<Order> orders) {
        final double[] discountWrapper = { 0.50 };
        return orders.stream().collect(Collectors.toMap(
                order -> order.getCompanyName(),
                order -> {
                    double basePrice = order.getCementQuantity() * 10;
                    double finalPrice = basePrice * (1 - discountWrapper[0]);
                    if (discountWrapper[0] > 0) {
                        discountWrapper[0] -=0.05;
                    }

                    return finalPrice;

                }
        ));
    }
}
