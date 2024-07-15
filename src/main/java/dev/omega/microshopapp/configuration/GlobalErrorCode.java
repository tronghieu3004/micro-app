package dev.omega.microshopapp.configuration;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;

public class GlobalErrorCode {
    public static class GeneralCode{
        public static final String GENERAL_ERROR = "GENERAL_ERROR";
        public static final String NOT_FOUND = "NOT_FOUND";
        public static final String BAD_REQUEST = "BAD_REQUEST";
        public static final String UNAUTHORIZED = "UNAUTHORIZED";
        public static final String FORBIDDEN = "FORBIDDEN";
        public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    }
    @FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
    public static class UserCode{
        public static final String USER_ALREADY_EXIST = "USER_ALREADY_EXIST";
        public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
        public static final String USER_NOT_AUTHORIZED = "USER_NOT_AUTHORIZED";
        public static final String USER_NOT_ALLOW = "USER_NOT_ALLOW";
        public static final String USER_NOT_ACTIVE = "USER_NOT_ACTIVE";
        public static final String USER_PASSWORD_NOT_MATCH = "USER_PASSWORD_NOT_MATCH";
        public static final String USER_INVALID_PASSWORD = "USER_INVALID_PASSWORD";
        public static final String USER_INVALID_TOKEN = "USER_INVALID_TOKEN";
        public static final String USER_INVALID_REFRESH_TOKEN = "USER_INVALID_REFRESH_TOKEN";
        public static final String USER_UPDATE_FAILED = "USER_UPDATE_FAILED";
    }
}
