package david.dev.service;

import david.dev.model.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    void should_Calculate_Price_For_Single_Order_With_Discount() {

        PriceCalculator priceCalculator = new PriceCalculator(10.0, 0.50, 0.05);

        Order testOrder = new Order();

        testOrder.setCompanyName("GMC");
        testOrder.setCementQuantity(100);
        testOrder.setLocalTime(LocalTime.of(10, 0));

        List<Order> orders = List.of(testOrder);

        Map<String, Double> result = priceCalculator.calculatePrice(orders);
        assertTrue(result.containsKey("GMC"));
        assertEquals(500, result.get("GMC"), 0.001);
    }

    @Test
    void shouldDecreaseDiscountForSecondOrder() {

        PriceCalculator priceCalculator = new PriceCalculator(10.0, 0.50, 0.05);

        Order firstOrder = new Order();

        firstOrder.setCompanyName("GMC");
        firstOrder.setCementQuantity(100);
        firstOrder.setLocalTime(LocalTime.of(10, 0));

        Order secondOrder = new Order();

        secondOrder.setCompanyName("AMC");
        secondOrder.setCementQuantity(350);
        secondOrder.setLocalTime(LocalTime.of(11, 0));

        List<Order> orders = List.of(firstOrder, secondOrder);

        Map<String, Double> result = priceCalculator.calculatePrice(orders);

        assertEquals(500.0, result.get("GMC"), 0.001);
        assertEquals(1925.0, result.get("AMC"), 0.001);
    }

    @Test
    void should_Return_Empty_Map_When_Orders_List_Is_Empty() {
        PriceCalculator priceCalculator = new PriceCalculator(10.0, 0.50, 0.05);
        List<Order> orders = List.of();

        Map<String, Double> result = priceCalculator.calculatePrice(orders);

        assertTrue(result.isEmpty());
    }

}