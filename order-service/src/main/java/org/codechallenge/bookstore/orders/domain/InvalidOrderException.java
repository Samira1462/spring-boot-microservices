package org.codechallenge.bookstore.orders.domain;


public class InvalidOrderException extends RuntimeException {

    public InvalidOrderException(String message) {
        super(message);
    }
}
