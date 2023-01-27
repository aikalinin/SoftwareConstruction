package org.edu.hse.streamapi;

import java.math.BigDecimal;

public class Order {

    private BigDecimal price;

    public Order(BigDecimal price) {
        this.price = price;
    }

    public Order(int i) {
        this.price = new BigDecimal(i);
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
