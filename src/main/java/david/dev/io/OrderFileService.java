package david.dev.io;

import david.dev.model.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderFileService {
    public List<Order> readOrders(String filePath) {

        try {
            if (filePath.endsWith(".txt")) {
                return Files.lines(Paths.get(filePath)).skip(1).
                        map(line -> {
                                    String[] parts = line.split("\\|");
                                    Order order = new Order();
                                    order.setLocalTime(LocalTime.parse(parts[0]));
                                    order.setCompanyName(parts[1]);
                                    order.setCementQuantity(Integer.parseInt(parts[2]));
                                    return order;
                                }
                        ).collect(Collectors.toList());
            } else {
                return Files.lines(Paths.get(filePath)).skip(1).
                        map(line -> {
                                    String[] parts = line.split("#");
                                    Order order = new Order();
                                    order.setLocalTime(LocalTime.parse(parts[0]));
                                    order.setCompanyName(parts[1]);
                                    order.setCementQuantity(Integer.parseInt(parts[2]));
                                    return order;

                                }
                        ).collect(Collectors.toList());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeResults(Map<String, Double> results, String filePath) {

        try {
            List<String> lines = results.entrySet().stream()
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
                    .collect(Collectors.toList());
            Files.write(Path.of(filePath), lines);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}