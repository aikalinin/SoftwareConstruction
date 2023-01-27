package org.edu.hse.streamapi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public List<Order> findByOrderId(long orderId) {
        return new ArrayList<>() {{
            add(new Order(new BigDecimal(30)));
            add(new Order(10));
            add(new Order(50));
        }};
    }

    public List<Order> supplyOrders() {
        return new ArrayList<>() {{
            add(new Order(new BigDecimal(30)));
            add(new Order(10));
            add(new Order(50));
        }};
    }
}
