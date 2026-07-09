package david.dev;


import david.dev.service.SalesProcessor;

public class Main {
    public static void main(String[] args) {
        String inputPath = "orders.txt";
        String outputPath = "results.txt";

        double pricePerKg = 10.0;
        double initialDiscount = 0.50;
        double discountStep = 0.05;

        SalesProcessor salesProcessor = new SalesProcessor();
        salesProcessor.processSales(inputPath, outputPath,
                pricePerKg, initialDiscount, discountStep);

    }

}
