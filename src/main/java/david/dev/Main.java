package david.dev;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputPath = "orders.txt";
        String outputPath = "results.txt";

        OrderReader reader = chooseReader(inputPath);

        List<Order> orders = reader.readOrders(inputPath);

        PriceCalculator calculator = new PriceCalculator();
        Map<String, Double> results = calculator.calculatePrice(orders);

        ResultWriter writer = new ResultWriter();
        writer.writeResults(results, outputPath);

    }

    private static OrderReader chooseReader(String filePath) {
        if (filePath.endsWith(".txt")) {
            return new TxtOrderReader();
        } else return new NoExtOrderReader();
    }
}
