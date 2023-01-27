package org.edu.hse.streamapi;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class StreamExamples {

    private final OrderRepository orderRepository = new OrderRepository();

    public BigDecimal getPriceClassic() {
        List<Order> lines = orderRepository.supplyOrders();
        Integer.parseInt("10");
        BigDecimal price = BigDecimal.ZERO;
        for (Order line : lines) {
            price = price.add(line.getPrice());
        }
        return price;
    }

    public BigDecimal getPriceStream() {
        List<Order> orders = orderRepository.supplyOrders();

        return orders.stream()
//                .map((order) -> order.getPrice())
                .map(Order::getPrice)
//                .filter(price -> price.compareTo(new BigDecimal(10)) < 0)
//                .reduce(BigDecimal.ZERO, (acc, next) -> acc.add(next));
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getPriceStreamNoOptional(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }

        List<Order> lines = orderRepository.findByOrderId(orderId);
        return lines.stream()
                .map(Order::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getPriceOptional(Long orderId) {
        return Optional.ofNullable(orderId)
                .map(orderRepository::findByOrderId)
                .flatMap(orders -> {
                    BigDecimal sum = orders.stream()
                            .map(Order::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    return Optional.of(sum);
                }).orElse(BigDecimal.ZERO);
    }

    public BigDecimal getPriceOptionalStream(Long orderId) {
        return Optional.ofNullable(orderId)
                .stream()
                .map(orderRepository::findByOrderId)
                .flatMap(Collection::stream)
                .map(Order::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
