package org.edu.hse.streamapi;

import java.math.BigDecimal;

public class Orders {

    private BigDecimal price;

    public Orders(BigDecimal price) {
        this.price = price;
    }

    public Orders(int i) {
        this.price = new BigDecimal(i);
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
