package org.codechallenge.bookstore.orders.testdata;

import org.codechallenge.bookstore.orders.domain.models.Address;
import org.codechallenge.bookstore.orders.domain.models.CreateOrderRequest;
import org.codechallenge.bookstore.orders.domain.models.Customer;
import org.codechallenge.bookstore.orders.domain.models.OrderItem;
import org.instancio.Instancio;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.instancio.Select.field;

public class SampleDataProvider {

    static final List<String> VALID_COUNTIES = List.of("USA", "Germany");
    static final Set<OrderItem> VALID_ORDER_ITEMS =
            Set.of(new OrderItem("P100", "Product 1", new BigDecimal("25.50"), 1));

    public static CreateOrderRequest createOrderRequestWithInvalidCustomer() {
        return Instancio.of(CreateOrderRequest.class)
                .generate(field(Customer::email), gen -> gen.text().pattern("#c#c#c#c#d#d@mail.com"))
                .set(field(Customer::phone), "")
                .generate(field(Address::country), gen -> gen.oneOf(VALID_COUNTIES))
                .set(field(CreateOrderRequest::items), VALID_ORDER_ITEMS)
                .create();
    }

}
