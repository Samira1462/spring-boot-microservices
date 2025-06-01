package org.codechallenge.bookstore.orders.api.controllers;

import org.codechallenge.bookstore.orders.AbstractTest;
import org.codechallenge.bookstore.orders.WithMockOAuth2User;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetOrdersTests extends AbstractTest {

    @Test
    @WithMockOAuth2User(username = "user")
    void shouldGetOrdersSuccessfully() throws Exception {
        mockMvc.perform(get("/api/orders")).andExpect(status().isOk());
    }
}
