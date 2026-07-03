package david.dev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class TxtOrderReader implements OrderReader{
    @Override
    public List<Order> readOrders(String filePath) {
        List<Order> result;
        try {
            result = Files.lines(Paths.get(filePath)).skip(1).
                    map(line -> {
                                String[] parts = line.split("\\|");
                                Order order = new Order();
                                order.setLocalTime(LocalTime.parse(parts[0]));
                                order.setCompanyName(parts[1]);
                                order.setCementQuantity(Integer.parseInt(parts[2]));
                                return order;
                            }
                    ).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
