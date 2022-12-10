package org.edu.hse.streamapi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class StreamExamples {

    private final OrderRepository orderRepository = new OrderRepository();


    public BigDecimal getPriceClassic() {
        List<Orders> lines = orderRepository.supplyOrders();
        BigDecimal price = BigDecimal.ZERO;
        for (Orders line : lines) {
            price = price.add(line.getPrice());
        }
        return price;
    }

    public BigDecimal getPriceStream() {
        List<Orders> lines = orderRepository.supplyOrders();
        return lines.stream()
                .map(Orders::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getPriceStreamNoOptional(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }

        List<Orders> lines = orderRepository.findByOrderId(orderId);
        return lines.stream()
                .map(Orders::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getPriceOptional(Long orderId) {
        return Optional.ofNullable(orderId)
                .map(orderRepository::findByOrderId)
                .flatMap(lines -> {
                    BigDecimal sum = lines.stream()
                            .map(Orders::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    return Optional.of(sum);
                }).orElse(BigDecimal.ZERO);
    }

    public BigDecimal getPriceOptionalStream(Long orderId) {
        return Optional.ofNullable(orderId)
                .stream()
                .map(orderRepository::findByOrderId)
                .flatMap(Collection::stream)
                .map(Orders::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
