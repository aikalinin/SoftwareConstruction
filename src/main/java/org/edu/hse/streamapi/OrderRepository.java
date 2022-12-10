package org.edu.hse.streamapi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public List<Orders> findByOrderId(long orderId) {
        return new ArrayList<>() {{
            add(new Orders(new BigDecimal(30)));
            add(new Orders(10));
            add(new Orders(50));
        }};
    }

    public List<Orders> supplyOrders() {
        return new ArrayList<>() {{
            add(new Orders(new BigDecimal(30)));
            add(new Orders(10));
            add(new Orders(50));
        }};
    }
}
