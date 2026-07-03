package david.dev;

import java.util.List;

public interface OrderReader {
    List<Order> readOrders(String filePath);
}
