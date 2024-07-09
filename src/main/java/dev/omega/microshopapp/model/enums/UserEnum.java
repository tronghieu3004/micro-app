package dev.omega.microshopapp.model.enums;

public class UserEnum {
    public enum UserStatus {
        ACTIVE,
        INACTIVE,
        BANNED,
        PENDING
    }
    public enum UserRole {
        ADMIN,
        STAFF
    }
    public enum UserGender {
        MALE,
        FEMALE
    }
}
