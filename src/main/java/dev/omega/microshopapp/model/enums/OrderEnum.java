package dev.omega.microshopapp.model.enums;


public class OrderEnum {
    public static enum Status {
        PENDING,
        PROCESSING,
        DELIVERED,
        CANCELED
    }
    public static enum Type {
        ONLINE,
        OFFLINE
    }
    public static enum Payment {
        CASH,
        CARD
    }
}
